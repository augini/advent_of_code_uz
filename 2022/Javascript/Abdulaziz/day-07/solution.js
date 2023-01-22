import { readFileSync } from 'node:fs';

const lines = readFileSync(
  '/Users/abdulaziz/Coding/advent_of_code_uz/2022/Javascript/Abdulaziz/day-07/input.txt',
  { encoding: 'utf-8' }
)
  .replace(/\r/g, '')
  .trim()
  .split('\n');

let currentDir = '';
let dirs = {};

function part1() {
  const input = [...lines];
  input.forEach((line) => checkLine(line));
}

function checkLine(line) {
  const isDollar = line[0] === '$';

  if (isDollar) {
    checkCommand(line);
    return;
  }

  checkLineInFolder(line);
}




function part2() {
  const input = getInput();
}

part1();
// part2();
