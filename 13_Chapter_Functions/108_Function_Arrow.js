function greet(name){
    return `Hello, ${name}`;
}

const greet1 = function(name){
    return `Hello, ${name}`;
}

// Arrow Fn
// If you want to make a normal function to arrow function. 
// Remove the keyword function, remove the keyword return, remove the curly braces, and use the =>
const greet2 = (name2) => `Hello, ${name2}`;

let op = greet2("Amit"); 
console.log(op);// Output: Hello, Amit

let op2 = greet("Karthik"); // Output: Hello, Karthik
console.log(op2);

let op3 = greet1("Sangeetha"); // Output: Hello, Sangeetha
console.log(op3);