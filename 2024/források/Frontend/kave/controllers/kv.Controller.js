const Kave = require('./../modules/kv.Modul')

exports.getAllkaves = async (req, res) => {
  try {
    const kaves = await Kave.find();

    res.status(200).json({
    status: 'success',
    data: {
      kaves
    }
  });
  }  catch (err) {
    res.status(400).json({
      status:'fail',
      message:'Nem valós adat lett küldve'
    });
  }
};

exports.getkave = async(req, res) => {
 try {
    const kaves = await Kave.findById(req.params.id);

    res.status(200).json({
    status: 'success',
    data: {
      kaves
    }
  });
  }  catch (err) {
    res.status(400).json({
      status:'fail',
      message:'Nem valós adat lett küldve'
    });
    
  };
};

exports.createkave = async(req, res) => {
  try {

    const newkave = await Kave.create(req.body);

    res.status(201).json({
    status: 'success',
    data: {
      kave: newkave
    }
  });
  } catch (err) {
    res.status(400).json({
      status:'fail',
      message:'Nem valós adat lett küldve'
    });
    
  }
 
};

exports.updatekave = async (req, res) => {
  try {
    const kave = await Kave.findByIdAndUpdate(req.params.id, req.body, {
      new:true,
      runValidators:true
    });
    res.status(200).json({
    status: 'success',
    data: {
      kave
    }
  });
  } catch (err) {
    res.status(400).json({
      status:'fail',
      message:'Nem valós adat lett küldve'
    });
  } 
};

exports.deletekave = async (req, res) => {

  try {
    await Kave.findByIdAndDelete(req.params.id);

    res.status(204).json({
    status: 'success',
    data:null
  });
  } catch (err) {
    res.status(400).json({
      status:'fail',
      message:'Nem valós adat lett küldve'
    });
  } 
};
