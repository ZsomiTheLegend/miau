const express = require('express');
const app = express();
const db = require('./config/database');
const kaveRoutes = require('./routes/kave.routes');

app.use(express.json());
app.use('/api/v1/kave', kaveRoutes);

const PORT = 3000;
db.sync().then(() => {
    console.log('Adatbázis szinkronizálva');
    app.listen(PORT, () => {
        console.log(`Szerver fut a ${PORT}-es porton`);
    });
});