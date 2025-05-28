const Kave = require('../models/kave.model');

exports.getAllKave = async (req, res) => {
    const kavék = await Kave.findAll();
    res.json(kavék);
};

exports.addKave = async (req, res) => {
    try {
        const { nev, ar, suly, szarmazasiHely, darabSzam } = req.body;
        if (!nev) {
            return res.status(400).json({ uzenet: 'Hiányos adatok' });
        }
        const uj = await Kave.create({ nev, ar, suly, szarmazasiHely, darabSzam });
        res.status(201).json({ id: uj.id });
    } catch (err) {
        res.status(500).json({ uzenet: 'Szerverhiba' });
    }
};

exports.deleteKave = async (req, res) => {
    const id = req.params.id;
    const kave = await Kave.findByPk(id);
    if (!kave) {
        return res.status(404).json({ uzenet: 'Ingatlan nem létezik' });
    }
    await kave.destroy();
    res.status(204).send();
};