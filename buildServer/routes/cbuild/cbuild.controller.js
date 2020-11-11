const debug = require('debug')('cbuild_controller');
const fs = require('fs');
const spawn = require('child_process').spawn;
//const bodyParser = require('body-parser');

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

    // gcc를 이용해 compile
    var compile = spawn('gcc',[file]);
    compile.stdout.on('data', (data) => {
        debug("stdout: " + data);
    });
    compile.stderr.on('data', (data) => {
        debug("stderr: " + data);
        errData += String(data);
    });

    // 결과 값 받기(프로세스 종료)
    compile.on('close', (code) => {
        // code == 0은 process 정상 종료
        if(code == 0) {
            // 컴파일 결과 나온 실행파일을 실행시켜 나오는 결과값을 전달
            var run = spawn('./a.exe',[]);
            run.stdout.on('data', (data) => { 
                var responseData = {'result':'ok','output': data.toString('utf8')};
                res.json(responseData);
            });
            run.stderr.on('data', (data) => {
                console.log(String(data));
            });
            run.on('close', (code) => {
                debug("compile process exited with code ${code}")
            });
            removeFileList.push(file, 'a.exe');
        }
        else{
            var responseData = {'result': 'error', 'output':errData.toString('utf-8')};
            res.json(responseData);
            debug("run Process Error");
            removeFileList.push(file);
        }

        // 무조건 파일 제거
        var remove = spawn('rm', removeFileList);
        remove.stdout.on('data', (data) => { 
            debug("rm stdout: " + data)
        });
        remove.stderr.on('data', (data) => {
            debug("rm stderr: " + String(data))
        });
        remove.on('close', (code) => {
            if(code == 0)
                debug("Success: " + file + " removed")
            else
                debug("Err: remove process");
        });
    });
}

exports.test = (req, res, next) => {
    return res.status(200).send('Arrived');
}