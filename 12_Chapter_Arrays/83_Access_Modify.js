// Accessing & Modifying

let statuses = ["pass", "fail", "skip"];

// Accessing    
console.log(statuses[0]); // "pass"
console.log(statuses[2]); // "skip"

console.log(statuses.at(-1)); // "skip"
console.log(statuses.at(-2)); // "fail"
console.log(statuses.at(-4)); // undefined

// Modify
statuses[1] = "blocked";
console.log(statuses); // ["pass", "blocked", "skip"]

console.log(statuses.length); // 3