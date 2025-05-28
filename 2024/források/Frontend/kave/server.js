const mongoose = require('mongoose');

const app = require('./app');

const DB =  'mongodb://127.0.0.1:27017/kv-db';

mongoose
  .connect(DB, {
    useNewUrlParser: true
  })
  .then(() => console.log('Az adatbázi kapcsolat sikeres'));

const port =3000;
app.listen(port, () => {
  console.log(`Az aplikáció ezen a porton fut: ${port}...`);
});
