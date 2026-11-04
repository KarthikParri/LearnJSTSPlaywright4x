typeof missingName;

// var missingName= "undefined";
console.log(typeof missingName);

// missingName hasn’t been declared. Normally, using an undeclared variable causes a ReferenceError,
// but typeof is a special case: for an undeclared name, it returns the string "undefined".

// The first line evaluates to "undefined" but doesn’t print it. The second line logs it: