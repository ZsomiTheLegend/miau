const express = require('express');
const router = express.Router();
const controller = require('../controllers/kave.controller');

router.get('/', controller.getAllKave);
router.post('/', controller.addKave);
router.delete('/:id', controller.deleteKave);

module.exports = router;