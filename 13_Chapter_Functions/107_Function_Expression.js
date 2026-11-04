// Function as Expression

function greet(name){
    return `Hello, ${name}`;
}

// Anonymous Fn - Fn without name.
const greet1 = function (name){
    return `Hello, ${name}`;
}

// Named Fn - Fn with name.
const greet2 = function greet(name) {
  return `Hello, ${name}`;
};

console.log(greet("Amit"));
console.log(greet1("Amit"));
console.log(greet2("Amit"));
