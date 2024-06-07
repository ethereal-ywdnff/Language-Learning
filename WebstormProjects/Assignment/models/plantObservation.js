const mongoose = require('mongoose');

const plantObservationSchema = new mongoose.Schema({
    date: Date,
    location: String,
    description: String,
    height: Number,
    width: Number,
    features: String
});

module.exports = mongoose.model('PlantObservation', plantObservationSchema);
