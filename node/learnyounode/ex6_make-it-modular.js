var mymodule = require('./ex6_module');

var path = process.argv[2];
var ext = process.argv[3];

mymodule(path, ext, function(err, value) {
  for(var i = 0; i < value.length; i++) {
    console.log(value[i]);
  }
})
