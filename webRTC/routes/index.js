const express = require('express');
const router = express.Router();
const fs = require('fs');
//const conference = require('./conference');
//router.use('/conference', conference);


router.get('/conference', (req, res) => {
    console.log('hello')
    fs.readFile("/conference/index.html", (error, data) => {
        res.writeHead(200, { 'Content-Type': 'text/html' });
        res.end(data);
        console.log(data);
    });;
})
module.exports = router;