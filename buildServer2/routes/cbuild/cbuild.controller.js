const debug = require('debug')('cbuild_controller');
const fs = require('fs');
const spawn = require('child_process').spawn;
const Docker = require('dockerode');
const util = require('util');
const writeFile = util.promisify(fs.writeFile);

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
	const command = "gcc -o myapp " + "/home/test/" + cfile + " && ./myapp > /home/test/" + outfile;
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
				console.log('status: ', statusCode);
	
			// 정상	
			/*
			if(statusCode == 0){
				var responseData = {'result': 'ok', 'output': data.toString('utf8')};
				res.json(responseData);
			}
			*/
	
			// c code file 읽기
			/*
			fs.readFile('/home/test/' + cfile, (err, data) => {
				if(err) throw err;
				console.log(data);
	
				var responseData = {'result': 'ok', 'output': data.toString('utf8')};
				res.json(responseData);
			});
			*/
				return container.remove();
				}).then( (data) => {
					console.log('container removed');
				}).catch( (err) => {
					console.log("Err: ", err);
				});
		})
		.catch(err => {
			console.log(err);
		});

	// 결과파일 읽기

	// file 삭제
}

exports.test = (req, res, next) => {
    return res.status(200).send('Arrived');
}
