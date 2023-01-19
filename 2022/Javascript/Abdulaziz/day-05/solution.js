const { readFileSync } = require('fs');

function syncReadFile() {
  const filename =
    '/Users/abdulaziz/Coding/advent-of-code/years/2022/day_05/input.txt';
  const contents = readFileSync(filename, 'utf-8');
  const arr = contents.split(/\r?\n/);
  return arr;
}

const rawMoves = syncReadFile();
const crates = [
  ['W', 'B', 'D', 'N', 'C', 'F', 'J'],
  ['P', 'Z', 'V', 'Q', 'L', 'S', 'T'],
  ['P', 'Z', 'B', 'G', 'J', 'T'],
  ['D', 'T', 'L', 'J', 'Z', 'B', 'H', 'C'],
  ['G', 'V', 'B', 'J', 'S'],
  ['P', 'S', 'Q'],
  ['B', 'V', 'D', 'F', 'L', 'M', 'P', 'N'],
  ['P', 'S', 'M', 'F', 'B', 'D', 'L', 'R'],
  ['V', 'D', 'T', 'R'],
];

function Moves() {
  const moves = rawMoves.map((move) => {
    let [, a, b, c] = /move (\d+) from (\d+) to (\d+)/.exec(move);
    return [Number(a), Number(b), Number(c)];
  });
  return moves;
}

function Part1() {
  const moves = Moves();
  moves.forEach(([numOfCrates, from, to]) => {  // O(n)
    for (let move = 0; move < numOfCrates; move++) { // O(1)
      let crate = crates[from - 1].pop();
      crates[to - 1].push(crate);
    }
  });

  return crates 
    .map((c) => { // O(1)
      return c[c.length - 1];
    })
    .join('');
}

// console.log(Part1());


/* 
Time complexity: O(n)
Space complexity: O(1)
*/

/* ----------------------------------------- */

function Part2() {
  const moves = Moves();
  moves.forEach(([numOfCrates, from, to]) => { // O(n)
    const moving = crates[from - 1].splice(
      crates[from - 1].length - numOfCrates,
      numOfCrates
    );
    crates[to - 1].push(...moving);
  });

  return crates // O(1)
    .map((c) => {
      return c[c.length - 1];
    })
    .join('');
}

console.log(Part2());

/* 
Time complexity: O(n)
Space complexity: O(1)
*/