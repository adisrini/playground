var person = new Object();
person.name = "Johnny";
person.age = 40;
person.setAge = function(newAge) {
  person.age = newAge;
};
console.log(person.name + " is " + person.age);
person.setAge(person.age + 1);
console.log(person.name + " is " + person.age);
