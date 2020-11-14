const express = require('express');
const router = express.Router();

const cbuild = require('./cbuild');

router.use('/cbuild', cbuild);

module.exports = router;