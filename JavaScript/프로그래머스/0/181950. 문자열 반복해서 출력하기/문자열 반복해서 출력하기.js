const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = [];

rl.on('line', function (line) {
    input = line.split(' ');
}).on('close', function () {
    const str = input[0];
    const cnt = parseInt(input[1]);
    
    const result = [];
    for (let i = 0; i < cnt; i++) {
        result.push(str);
    }

    console.log(result.join(''));
});
