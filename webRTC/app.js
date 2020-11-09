const debug = require('debug')('app');
const logger = require('morgan');
const express = require('express');
const errors = require('./middlewares/errors');
const app = express();
const path = require('path');
const http = require('http');
const fs = require('fs');

// static file 등록
// const publicPath = path.join(__dirname, "./client");

// app.use(express.static(publicPath + '/js'));
// app.use(express.static(publicPath + '/views'));

// app.get('/rtc/getVideo', (request, response) => {
//   fs.readFile(path.join(__dirname, "client/views/getVideo/index.html"), (error, data) => {
//     response.writeHead(200, { 'Content-Type': 'text/html' });
//     response.end(data);
//   });
// })

// app.get('/webRTC/conference', (request, response) => {
//   fs.readFile(path.join(__dirname, "client/views/conference/index.html"), (error, data) => {
//     response.writeHead(200, { 'Content-Type': 'text/html' });
//     response.end(data);
//   });
// })

// router 등록
// const routes = require('./routes');
// app.use('/webRTC', routes);

// body-parser
app.use(express.json());

// error & logger 등록
app.use(logger('dev'));
app.use(errors.error404());
app.use(errors.error());

//const server = https.createServer(sslOptions, app);
const server = http.createServer(app);

debug('App is initiated');

module.exports = server;
