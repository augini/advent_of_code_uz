const { readFileSync } = require("fs");

function syncReadFile() {
  const filename =
    "/Users/abdulaziz/Coding/advent_of_code_uz/2022/Javascript/Abdulaziz/day-04/input.txt";
  const contents = readFileSync(filename, "utf-8");
  const arr = contents.split(/\r?\n/);
  return arr;
}

const input = syncReadFile();

/* 
Space complexity: O(1)
Time complexity: O(n)
*/
function Part1() {
  let numberOfCases = 0;
  [...input].forEach((i) => {
    const [e1, e2] = i.split(",");
    const [e1Start, e1End] = e1.split("-");
    const [e2Start, e2End] = e2.split("-");
    if (
      (e1Start - e2Start <= 0 && e1End - e2End >= 0) ||
      (e2Start - e1Start <= 0 && e2End - e1End >= 0)
    ) {
      numberOfCases += 1;
    }
  });
  return numberOfCases;
}

// console.log(Part1());

/* 
Space complexity: O(1)
Time complexity: O(n)
*/
function Part2() {
  let total = input.length;

  [...input].forEach((i) => {
    const [e1, e2] = i.split(",");
    const [e1Start, e1End] = e1.split("-");
    const [e2Start, e2End] = e2.split("-");
    if (Number(e1End) < Number(e2Start) || Number(e2End) < Number(e1Start)) {
      total -= 1;
    }
  });
  return total;
}

console.log(Part2());