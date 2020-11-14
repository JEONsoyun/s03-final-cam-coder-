const debug = require('debug')('app');
const logger = require('morgan');
const express = require('express');
const path = require('path')
const errors = require('./middlewares/errors');
const app = express();
const http = require('http');
const fs = require('fs');

// static file 등록
const publicPath = path.join(__dirname, "./client");
app.use(express.static(publicPath));

app.get('/', (request, response) => {
  fs.readFile("/index.html", (error, data) => {
    response.writeHead(200, { 'Content-Type': 'text/html' });
    response.end(data);
  });
})

// router 등록
const routes = require('./routes');
app.use('/', routes);

// body-parser
app.use(express.json());

// error & logger 등록
app.use(logger('dev'));
app.use(errors.error404());
app.use(errors.error());

const server = http.createServer(app);

debug('App is initiated');

module.exports = server;