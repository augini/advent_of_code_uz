import { readFileSync } from "node:fs";

const lines = readFileSync("input.txt", { encoding: "utf-8" })
  .replace(/\r/g, "")
  .trim()
  .split("\n");

function getInput() {
  console.log([...lines]);
}

function part1() {
  const input = getInput();
}

function part2() {
  const input = getInput();
}

part1();
part2();