//----------- 2022/02: Rock Paper Scissors -------------

const { readFileSync } = require("fs");

function syncReadFile() {
  const filename =
    "/Users/abdulaziz/Coding/advent_of_code_uz/2022/Javascript/Abdulaziz/day-02/input.txt";
  const contents = readFileSync(filename, "utf-8");
  const arr = contents.split(/\r?\n/);
  return arr;
}

const input = syncReadFile();

let score = 0;

/* 
Big O analysis

Time complexity: O(n)
Space complexity: O(1)
*/
input.forEach((i) => {
  /* 
  Each line in text input is considered as "i". The first and the second values in each line is assigned to "player" and "me"respectavely */
  const [player, me] = i.split(" ");
  if (player === "A") {
    if (me === "X") {
      score += 4;
    } else if (me === "Y") {
      score += 8;
    } else {
      score += 3;
    }
  } else if (player === "B") {
    if (me === "X") {
      score += 1;
    } else if (me === "Y") {
      score += 5;
    } else {
      score += 9;
    }
  } else {
    if (me === "X") {
      score += 7;
    } else if (me === "Y") {
      score += 2;
    } else {
      score += 6;
    }
  }
});

console.log(score);

module.exports = { input };
