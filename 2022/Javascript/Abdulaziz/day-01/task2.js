const { input } = require("./task1");

/* 
Big O
Time complexity: O(n)
Space complexity: O(1)
*/

/* 
  1. Store all calories in the array
  2. Sort and reverse
  3. Sum of first three elements 
*/
const sumOfThreeHighest = () => {
  let arr = [0, 0, 0];
  let sum = 0;

  for (let i of input) {
    if (i !== "") {
      sum += Number(i);
    } else {
      if (sum > arr[0]) {
        arr.shift();
        arr.push(sum);
        arr.sort((a, b) => {
          return a - b;
        });
      }
      sum = 0;
    }
  }
  console.log(arr);
  return arr[0] + arr[1] + arr[2];
};

console.log(sumOfThreeHighest());
