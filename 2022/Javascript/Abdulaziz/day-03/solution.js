const { readFileSync } = require("fs");

function syncReadFile() {
    const filename =
        "/Users/abdulaziz/Coding/advent_of_code_uz/2022/Javascript/Abdulaziz/day-03/input.txt";
    const contents = readFileSync(filename, "utf-8");
    const arr = contents.split(/\r?\n/);
    return arr;
}

const input = syncReadFile();

function Part1() {
    commonCharacters = []; // 1
    score = 0; // 1

    [...input].forEach((i) => {
        // n
        const [half1, half2] = [
            i.slice(0, i.length / 2),
            i.slice(i.length / 2, i.length),
        ]; // 1

        // m / 2
        for (let i in half1) {
            if (half2.includes(half1[i])) {
                commonCharacters.push(half1[i]);
                return;
            }
        }
    });

    // n
    commonCharacters.forEach((i) => {
        const ascii = i.charCodeAt(0);
        if (ascii > 96 && ascii < 123) {
            score += ascii - 96;
        } else {
            score += ascii - 38;
        }
    });

    return score;
}

// 1 + 1 + n(m/2) + n = 2 + nm/2 + n = O(n * m/2) // time complexity
// O(n) // space complexity

// console.log(Part1());

function Part2() {
    let score = 0;
    let common = [];

    for (let i = 0; i < input.length; i += 3) {
        const [text1, text2, text3] = [input[i], input[i + 1], input[i + 2]];
        for (let l in text1) {
            if (text2.includes(text1[l]) && text3.includes(text1[l])) {
                common.push(text1[l]);
                break;
            }
        }
    }

    for (let i = 0; i < common.length; i++) {
        const ascii = common[i].charCodeAt(0);
        if (ascii > 96 && ascii < 123) {
            score += ascii - 96;
        } else {
            score += ascii - 38;
        }
    }

    return score;
}

// n / 3 + n / 3 = 2 * n/3 = O(n/3)
// O(n/3)

console.log(Part2());