const debug = require('debug')('cbuild_controller');
const fs = require('fs');
const spawn = require('child_process').spawn;
//const bodyParser = require('body-parser');

exports.build = (req, res, next) => {
    var code = req.body.code;   // client에서 보낸 코드
    var source = code.split(/\r\n|\r\n/).join("\n");    // 개행 처리
    var file='test.c';
    var errData = '';

    // 파일로 코드 저장
    fs.writeFile(file,source,'utf8',function(error) {
        console.log('write end');
    });

    // gcc를 이용해 compile
    var compile = spawn('gcc',[file]);
    compile.stdout.on('data', (data) => {
        console.log('stdout: '+ data);
    });
    compile.stderr.on('data', (data) => {
        console.log("Error: ", String(data));
        errData += String(data);
    });

    // 결과 값 받기(프로세스 종료)
    compile.on('close', (code) => {
        // code == 0은 process 정상 종료
        if(code == 0) {
            // 컴파일 결과 나온 실행파일을 실행시켜 나오는 결과값을 전달
            var run = spawn('./a.exe',[]);
            run.stdout.on('data', (output) => { 
                console.log('컴파일 완료');
                var responseData = {'result':'ok','output': output.toString('utf8')};
                console.log(responseData);
                res.json(responseData);
            });
            run.stderr.on('data', (output) => {
                console.log(String(output));
            });
            run.on('close', (output) => {
                console.log('stdout: ' + output);
            });
        }
        else{
            var responseData = {'result': 'error', 'output':errData.toString('utf-8')};
            res.json(responseData);
            console.log('process error');
        }

        var remove = spawn('rm',['a.exe', 'test.c']);
        remove.stdout.on('data', (output) => { 
            console.log('컴파일 완료');
            var responseData = {'result':'ok','output': output.toString('utf8')};
            console.log(responseData);
            res.json(responseData);
        });
        remove.stderr.on('data', (output) => {
            console.log(String(output));
        });
        remove.on('close', (output) => {
            console.log('stdout: ' + output);
        }); 
    });
}

exports.test = (req, res, next) => {
    return res.status(200).send('Arrived');
}