function setIntervalX(callback, delay, repetitions) {
    let x = 0;

    let intervalID = setInterval(() => {
        console.log(`Executing ${x} times`)
        callback();

        if (++x === repetitions) {
            clearInterval(intervalID);
            trackTemplatEvent(`setIntervalX`, `Executed in ${x} iterations`);

        }
    }, delay)
}