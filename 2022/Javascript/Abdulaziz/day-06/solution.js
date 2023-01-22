const { input } = require('./input');

function Part1() {
  for (let i = 4; i < input.length; i++) {
    if (isDifferent(input.substring(i - 4, i))) {
      return i;
    }
  }
}

function isDifferent(str) {
  const uniqueChars = new Set([...str]);
  return str === [...uniqueChars].join('');
}

console.log(Part1());

function Part2() {
  for (let i = 14; i < input.length; i++) {
    if (isDifferent(input.substring(i - 14, i))) {
      return i;
    }
  }
}

console.log(Part2())