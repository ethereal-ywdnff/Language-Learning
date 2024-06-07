const express = require('express');
const router = express.Router();
const PlantObservation = require('../models/plantObservation'); // 引入模型

// 获取所有植物观察记录
router.get('/', async (req, res) => {
    const observations = await PlantObservation.find();
    res.render('plant-list', { observations });
});

// 添加新的植物观察记录页面
router.get('/add', (req, res) => {
    res.render('add-plant');
});

// 提交新的植物观察记录
router.post('/add', async (req, res) => {
    const { date, location, description, height, width, features } = req.body;
    let observation = new PlantObservation({ date, location, description, height, width, features });
    await observation.save();
    res.redirect('/plants');
});

// 删除植物观察记录
router.get('/delete/:id', async (req, res) => {
    try {
        await PlantObservation.findOneAndDelete({ _id: req.params.id });
        res.redirect('/plants');
    } catch (error) {
        console.error(error);
        res.status(500).send("Error deleting the observation");
    }
});

// 获取编辑植物记录的表单
router.get('/edit/:id', async (req, res) => {
    const observation = await PlantObservation.findById(req.params.id);
    res.render('edit-plant', { observation });
});
// 更新植物记录
router.post('/edit/:id', async (req, res) => {
    const { date, location, description, height, width, features } = req.body;
    await PlantObservation.findByIdAndUpdate(req.params.id, { date, location, description, height, width, features });
    res.redirect('/plants');
});



module.exports = router;
