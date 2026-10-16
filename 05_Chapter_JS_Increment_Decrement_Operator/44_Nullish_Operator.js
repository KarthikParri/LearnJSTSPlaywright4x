// Nullish Coalescing Operator (??) is a logical operator that returns its right-hand side operand when its left-hand side operand is null or undefined, and otherwise returns its left-hand side operand.

let amul = null;
let val = amul ?? "NANDANI Milk"; // Here amul is null ,val will be assigned "NANDANI Milk".
console.log(val);


let api_response = null;
let responsedata = api_response ?? "{}"; // Here api_response is null ,responsedata will be assigned "{}".  
console.log(responsedata);

let api_response1 = "Karthik";
let responsedata1 = api_response1 ?? "{}"; // Here api_response1 is not null ,responsedata1 will be assigned "Karthik".
console.log(responsedata1);