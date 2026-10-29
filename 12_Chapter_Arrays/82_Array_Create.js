let browsers = ["Chrome", "Firefox", "Safari"];
console.log(browsers); // ["Chrome", "Firefox", "Safari"]

let scores = new Array(3);  
console.log(scores); // creates with length 3 and without values: [ <3 empty items> ]
scores[0] = "1";
console.log(scores); // creates with length 3 and value at index 0: [ '1', <2 empty items> ] 

let scores2 = new Array(1, 2, 3);
console.log(scores2); // [1, 2, 3]

let numbers = new Array(100, 200, 300, 400);
console.log(numbers); // [100, 200, 300, 400]


let test = Array.of(10, 20, 30, 40, 50);
console.log(test); // [10, 20, 30, 40, 50]

// Array.from()
let chars = Array.from("hello");
console.log(chars); // ["h", "e", "l", "l", "o"]
