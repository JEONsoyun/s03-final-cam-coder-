const debug = require('debug')('cbuild_controller');
const fs = require('fs');
var Docker = require('dockerode');
var socket = process.env.DOCKER_SOCKET || '/var/run/docker.sock';
var docker = new Docker({ socketPath: socket});

var options = {
	'Volumes': {
		'/home/test/': {}
	},
	'HostConfig': {
		'Binds': ['/home/ubuntu/test:/home/test']
	},
    'AttachStdout': true,
	'AttachStderr': true
};

exports.test = (req, res, next) => {
//var code = req.body.code;   // client에서 보낸 코드
//const source = code.split(/\r\n|\r\n/).join("\n");    // 개행 처리
//var errData = '';
//const date = Date.now();
//const file = date + '.c';
//var removeFileList = [];

    // 파일로 코드 저장
    //fs.writeFile(file,source,'utf8',function(error) {
    //    debug("make file: " + file);
    //});
    console.log("hello get /cbuild");
	// 이미지를 바탕으로 컨테이너를 띄우고
	// 파일로 저장하고 그 파일을 container와 연결한다!!
	docker.run('gcc:latest', ['sh', '-c', 'gcc -o myapp /home/test/test.c && ./myapp'], process.stdout, options).then( (data) => {
		var output = data[0];
		var container = data[1];
		console.log("statuscode: ", output.StatusCode);
		console.log("output: ", output);
		return container.remove();
	}).then( (data) => {
		console.log('container removed');
	}).catch( (err) => {
		console.log("Err: ", err);
	});
}

exports.build = (req, res, next) => {
    return res.status(200).send('Arrived');
}
