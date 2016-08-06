var http = require('http');
var url = require('url');

var server = http.createServer(function(req, res) {
  res.writeHead(200, { 'Content-Type': 'application/json' });

  var requestObject = url.parse(req.url, true);
  var pathName = requestObject.pathname;
  var queryObject = requestObject.query;
  var date = Date.parse(queryObject['iso']);
  var ret = new Object();

  if(pathName === '/api/parsetime') {
    var d = new Date(date);
    var hours = d.getHours();
    var minutes = d.getMinutes();
    var seconds = d.getSeconds();

    ret.hour = hours;
    ret.minute = minutes;
    ret.second = seconds;

    res.write(JSON.stringify(ret));

  } else if(pathName === '/api/unixtime') {
    ret.unixtime = date;
    res.write(JSON.stringify(ret));
  }

  res.end();
})

server.listen(process.argv[2]);
