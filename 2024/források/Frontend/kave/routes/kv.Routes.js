const express = require('express');
const kvController = require('./../controllers/kv.Controller');

const router = express.Router();

router
  .route('/')
  .get(kvController.getAllkaves)
  .post(kvController.createkave);

router
  .route('/:id')
  .get(kvController.getkave)
  .patch(kvController.updatekave)
  .delete(kvController.deletekave);

module.exports = router;
