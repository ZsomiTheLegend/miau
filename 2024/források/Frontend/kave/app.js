const express = require('express');
const kaveRouter = require('./routes/kv.Routes');

const app = express();

app.use(express.json());


app.use((req, res, next) => {
  req.requestTime = new Date().toISOString();
  next();
});

// 3) ROUTES
app.use('/api/v1/kvs', kaveRouter);

module.exports = app;
