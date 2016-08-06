var http = require('http');
var bl = require('bl');

http.get(process.argv[2], function(response) {
  response.pipe(bl(print));
});

var print = function(err, data) {
  if(err) {
    console.error(err);
  } else {
    console.log(data.toString().length);
    console.log(data.toString());
  }
}
