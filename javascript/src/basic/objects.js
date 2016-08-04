var objLiteral = {
  name: "John",
  age: 42
}

var objByConstructor = new Object();
objByConstructor.name = "Jane";
objByConstructor.age = 31;

var objects = [objLiteral, objByConstructor];

for(var i = 0; i < objects.length; i++) {
  console.log(objects[i].name + " is " + objects[i].age + " years old.")
}
