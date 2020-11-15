const express = require('express');
const router = express.Router();
const controller = require('./cbuild.controller');
const bodyParser = require('body-parser');
//const cors = require('cors');

router.use(bodyParser.json());
router.use(bodyParser.urlencoded({extended: true}));
//router.use(cors({origin:true, credentials:true}));

router.post('/', controller.build);
router.get('/', controller.test);

module.exports = router;