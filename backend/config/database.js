const { Sequelize } = require('sequelize');

const sequelize = new Sequelize('kave', 'root', '', {
    host: 'localhost',
    dialect: 'mysql'
});

module.exports = sequelize;