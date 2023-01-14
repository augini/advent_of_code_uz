const { readFileSync } = require("fs");
const input = syncReadFile();

/* 
Big O
Time complexity: O(n)
Space complexity: O(1)
*/
function getHighestCalories() {
  let sum = 0;
  let the_highest_calories = 0;
  
  input.forEach((i) => {
    // Adds up callories until space is matched
    if (i !== "") {
      sum += Number(i); 
    } 
    // Once space is matched, it checks if current sum is bigger than previous one
    else {
      sum > the_highest_calories && (the_highest_calories = sum); // updates highest value
      sum = 0;
    }
  });
  return the_highest_calories
}

console.log(getHighestCalories());

// Fetching input data
function syncReadFile() {
  const filename =
    "/Users/abdulaziz/Coding/advent_of_code_uz/2022/Javascript/Abdulaziz/day-01/input.txt";
  const contents = readFileSync(filename, "utf-8");
  const arr = contents.split(/\r?\n/);
  return arr;
}

module.exports = { input };