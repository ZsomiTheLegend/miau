const { DataTypes } = require('sequelize');
const sequelize = require('../config/database');

const Kave = sequelize.define('Kave', {
    nev: {
        type: DataTypes.STRING,
        allowNull: false
    },
    ar: {
        type: DataTypes.INTEGER
    },
    suly: {
        type: DataTypes.STRING
    },
    szarmazasiHely: {
        type: DataTypes.STRING
    },
    darabSzam: {
        type: DataTypes.INTEGER,
        defaultValue: 1
    }
});

module.exports = Kave;