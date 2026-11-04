function startBrowser() {
    let name = "edge";

    function installBrowser() {
        console.log(name);
    }

    return installBrowser;
}

const runTc = startBrowser();
runTc();

// startBrowser creates a local variable: name, and an inner function: installBrowser().

// startBrowser() runs and sets name to "edge".
// It returns the inner function itself—not the result of calling it.
// runTc now refers to installBrowser.
// runTc() calls that function, which logs name.
// Even though startBrowser() has finished, installBrowser remembers the surrounding scope where it was created.
// That behavior is a closure.