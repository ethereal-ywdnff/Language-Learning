// var createError = require('http-errors');
// var express = require('express');
// var path = require('path');
// var cookieParser = require('cookie-parser');
// var logger = require('morgan');
//
// var indexRouter = require('./routes/index');
// var usersRouter = require('./routes/users');
//
// var app = express();
//
// // view engine setup
// app.set('views', path.join(__dirname, 'views'));
// app.set('view engine', 'ejs');
//
// app.use(logger('dev'));
// app.use(express.json());
// app.use(express.urlencoded({ extended: false }));
// app.use(cookieParser());
// app.use(express.static(path.join(__dirname, 'public')));
//
// app.use('/', indexRouter);
// app.use('/users', usersRouter);
//
// // catch 404 and forward to error handler
// app.use(function(req, res, next) {
//   next(createError(404));
// });
//
// // error handler
// app.use(function(err, req, res, next) {
//   // set locals, only providing error in development
//   res.locals.message = err.message;
//   res.locals.error = req.app.get('env') === 'development' ? err : {};
//
//   // render the error page
//   res.status(err.status || 500);
//   res.render('error');
// });
//
// module.exports = app;

var express = require('express');
var mongoose = require('mongoose');
var bodyParser = require('body-parser');
var socketIo = require('socket.io');
var http = require('http');

var app = express();
var server = http.createServer(app);
var io = socketIo(server);
const config = require('./config');
const path = require("path");


mongoose.connect(config.mongodbUri, { useNewUrlParser: true, useUnifiedTopology: true })
    .then(() => console.log('MongoDB connecting'))
    .catch(err => console.error('Failed to connect MongoDB', err));

app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'ejs');
// 中间件
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));
app.use(express.static(path.join(__dirname, 'public')));

// app.set('view engine', 'ejs');

app.use('/', require('./routes/index'));
app.use('/plants', require('./routes/plants'));

// socket.io
io.on('connection', (socket) => {
  console.log('A user is connecting');

  socket.on('disconnect', () => {
    console.log('The user has been disconnected');
  });

  socket.on('sendMessage', (message) => {
    io.emit('message', message);
  });
});

// var PORT = process.env.PORT || 3000;
// server.listen(PORT, () => console.log(`The server is running on the port ${PORT}`));

module.exports = app;