const server = require('./app');
const io = require('socket.io')(server);

//global.commandNameSpace = io.of('/command');

require('./src/socket/rtcSocket')(io);