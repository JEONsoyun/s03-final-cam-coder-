const debug = require('debug')('cbuild_controller');
const fs = require('fs');
const spawn = require('child_process').spawn;
const Docker = require('dockerode');
const util = require('util');
const writeFile = util.promisify(fs.writeFile);
const readFile = util.promisify(fs.readFile);

var socket = process.env.DOCKER_SOCKET || '/var/run/docker.sock';
var docker = new Docker({ socketPath: socket});
var stream = require('stream');

const buildFilePath ='/home/ubuntu/dist';

var options = {
	'Volumes': {
		'/home/dist/': {}
	},
	'HostConfig': {
		'Binds': [buildFilePath + ':/home/dist']
	},
    'AttachStdout': true,
	'AttachStderr': true
};

exports.build = (req, res, next) => {
	var code = req.body.code;   // client에서 보낸 코드
	var lang = req.body.lang;
	var source = code.split(/\r\n|\r\n/).join("\n");    // 개행 처리
	const date = Date.now();
	var file = date + "";
	var filePath = "/home/dist/";
	const outfile = date + ".txt";
	const outfilePath = "/home/dist/" + outfile;
	var command = "";
	var image = "";
	
	if(lang == "c"){
		file += ".c";
		filePath += file;
		image = "gcc:latest";
		command = "(gcc -o myapp " + filePath + " > " + outfilePath + " 2>&1 )  && ./myapp > " + outfilePath;
	}
	else if(lang == "cpp"){
		file += ".cpp";
		filePath += file;
		image = "gcc:latest";
		command = "(g++ -o myapp " + filePath + " > " + outfilePath + " 2>&1 )  && ./myapp > " + outfilePath;
	}
	else if(lang == "java"){
		file = "d" + file + ".java";
		filePath += file;
		image = "openjdk:16-jdk-slim";
		source = changeCode(source, "d"+date);
	}
	else if(lang == "python37"){
		file += ".py";
		filePath += file;
		image = "python:3.7-alpine";
		command = "python " + filePath + " > " + outfilePath + " 2>&1";
	}

	// 파일로 코드 저장
	writeFile(filePath, source)
		.then( () => {
			// 이미지를 바탕으로 컨테이너를 띄우고
			// 컨테이너에서 빌드한 결과를 파일로 저장
			docker.run(image, ['sh', '-c', command], process.stdout, options)
				.then( (data) => {
					var output = data[0]; // {Error: '', StatusCode: ''}
					var container = data[1];
					var statusCode = output.StatusCode;

					// 정상 컴파일
					readFile(outfilePath, "utf-8")
						.then( file => {
							var responseData = {'output': file};
							res.json(responseData);
						})
						.catch( err => {
							console.log(err);
						});

					return container.remove();
				}).then( (data) => {
					// file 삭제
					var remove = spawn('rm', [filePath, outfilePath]);
					remove.stdout.on('data', (data) => {
						debug("rm stdout: " + String(data));
					});
					remove.stderr.on('data', (data) => {
						debug("rm stderr: " + String(data));
					});
					remove.on('close', (code) => {
						if(code == 0)
							debug("Success: remove process");
						else
							debug("Err: remove process");
					});

					debug('container removed');
				}).catch( (err) => {
					debug("Err: ", err);
				});
		})
		.catch(err => {
			console.log(err);
		});
}

exports.test = (req, res, next) => {
    return res.status(200).send('Arrived');
}

function changeCode(code, name) {
    let rexPackage = new RegExp('package');
    let rexClass = new RegExp('class .*');
    let rexPsvm = new RegExp('public static void main');
    let classStack = [];
    let lines = code.trim().split('\n');
    if (rexPackage.test(lines[0])) {
        lines = lines.slice(1, lines.length)
    }
    for (let i = 0; i < lines.length; i++) {
        if (rexPsvm.test(lines[i])) {
            let line = classStack[0].line;
            while (!rexClass.test(lines[line])) {
                line--;
            }
            let checkClass = false
            let arr = lines[line].split(' ');
            for (let idx = 0; idx < arr.length; idx++) {
                if (checkClass) {
                    if (arr[idx][arr[idx].length - 1] === '{') {
                        name += ' {'
                    }
                    arr[idx] = name;
                    break
                } else if (arr[idx] === 'class') {
                    checkClass = true
                }
            }
            lines[line] = arr.join(' ');
            break;
        }
        let chars = lines[i].split('');
        for (let char of chars) {
            if (char === '{') {
                if (classStack.length === 0) {
                    classStack.push({ 'line': i, 'count': 1 })
                } else {
                    classStack[classStack.length - 1].count++
                }
            } else if (char === '}') {
                if (classStack[classStack.length - 1].count === 1) {
                    classStack.pop()
                } else {
                    classStack[classStack.length - 1].count--
                }
            }
        }
    }
    return lines.join('\n').trim()
}
