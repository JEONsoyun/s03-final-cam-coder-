const express = require('express');
const router = express.Router();
const controller = require('./conference.controller');
const bodyParser = require('body-parser');
const cors = require('cors');

router.use(bodyParser.json());
router.use(bodyParser.urlencoded({extended: true}));
router.use(cors({origin:true, credentials:true}));

router.get('/', controller.getConferencePage);

module.exports = router;