const debug = require('debug')('cbuild_controller');
const fs = require('fs');
var Docker = require('dockerode');
var socket = process.env.DOCKER_SOCKET || '/var/run/docker.sock';
var docker = new Docker({ socketPath: socket});

function runExec(container) {

  var options = {
    Cmd: ['bash', '-c', 'echo test $VAR'],
    Env: ['VAR=ttslkfjsdalkfj'],
    AttachStdout: true,
    AttachStderr: true
  };

  container.exec(options, function(err, exec) {
    if (err) return;
    exec.start(function(err, stream) {
      if (err) return;

      container.modem.demuxStream(stream, process.stdout, process.stderr);

      exec.inspect(function(err, data) {
        if (err) return;
        console.log(data);
      });
    });
  });
}

exports.build = (req, res, next) => {
    var code = req.body.code;   // client에서 보낸 코드
    const source = code.split(/\r\n|\r\n/).join("\n");    // 개행 처리
    var errData = '';
    const date = Date.now();
    const file = date + '.c';
    var removeFileList = [];

    // 파일로 코드 저장
    fs.writeFile(file,source,'utf8',function(error) {
        debug("make file: " + file);
    });

    docker.createContainer({
        Image: 'Ubuntu',
        Tty: true,
        Cmd: ['/bin/bash'],
        Volumes: {},
        VolumesFrom: []
    }, (err, container) => {
       container.start({}, (err, data) => {
           runExec(container);
       }) 
    });
}

exports.test = (req, res, next) => {
    return res.status(200).send('Arrived');
}