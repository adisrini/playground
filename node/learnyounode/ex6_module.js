var fs = require('fs');
var path = require('path');

var result = [];

module.exports = function(dir, ext, callback) {
  fs.readdir(dir, function(err, list) {
    if(err) {
      return callback(err, result);
    }
    for(var i = 0; i < list.length; i++) {
      if(path.extname(list[i]) === ("." + ext)) {
        result.push(list[i]);
      }
    }
    return callback(null, result);
  });
};
