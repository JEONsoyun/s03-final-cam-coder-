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

const buildFilePath ='/home/ubuntu/test';

var options = {
	'Volumes': {
		'/home/test/': {}
	},
	'HostConfig': {
		'Binds': [buildFilePath + ':/home/test']
	},
    'AttachStdout': true,
	'AttachStderr': true
};

exports.build = (req, res, next) => {
	var code = req.body.code;   // client에서 보낸 코드
	const source = code.split(/\r\n|\r\n/).join("\n");    // 개행 처리
	const date = Date.now();
	const cfile = date + ".c";
	const outfile = date  + ".txt";
	const cfilePath = "/home/test/" + cfile;
	const outfilePath = "/home/test/" + outfile;
	const command = "(gcc -o myapp " + cfilePath + " > " + outfilePath + " 2>&1 )  && ./myapp > " + outfilePath;
	//var removeFileList = [];
	
    console.log("hello post /cbuild");
    // 파일로 코드 저장
    writeFile("/home/test/" + cfile, source)
		.then( () => {
			// 이미지를 바탕으로 컨테이너를 띄우고
			// 컨테이너에서 빌드한 결과를 파일로 저장
			docker.run('gcc:latest', ['sh', '-c', command], process.stdout, options).then( (data) => {
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
				var remove = spawn('rm', [cfilePath, outfilePath]);
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
