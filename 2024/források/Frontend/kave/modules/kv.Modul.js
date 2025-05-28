const mongoose = require('mongoose');

const kaveSchema = new mongoose.Schema({
    nev:{
        type:String,
        required:[true,'Muszály meg adni'],
        unique:true
    },
    suly:{
        type:Number,
        default:4.5
    },
    ar:{
        type:Number,
        required:[true,'Meg kell adni']
    },
    szhely:{
        type:String,
    },
    db:{
        type:Number,
        default:1
    }
});
const Kave = mongoose.model('Kave',kaveSchema);

module.exports=Kave;