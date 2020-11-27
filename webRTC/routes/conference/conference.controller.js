const debug = require('debug')('conference_controller');
const fs = require('fs');

exports.getConferencePage = (req, res, next) => {
    res.render('conference/index.html', {
        title: '화상 회의'
    });
}