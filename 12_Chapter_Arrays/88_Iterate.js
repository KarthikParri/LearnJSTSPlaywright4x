let tests = ["login", "checkout", "search"];

for (let i = 0; i < tests.length; i++) {
    console.log(i, tests[i]);
}

console.log( " ---------for...of---------------");
// for...of (cleanest for values)
for (let test of tests) {
    console.log(test) // values
}

console.log( " -------forEach Below -----------------");

// forEach (no return value)
tests.forEach((test, index) => {

    console.log(`${index}: ${test}`);
});


console.log( " ---------entries()---------------");

// entries() — index + value

for (let [i, test] of tests.entries()) {
    console.log(i, test);
}


console.log( " ---------for...in---------------");
// for...in (index only)
let students = ["methis", "senthil", "ajay", "rahul"];

for (let student in students) {
    console.log(student, " -> ", students[student]); // index = in
}