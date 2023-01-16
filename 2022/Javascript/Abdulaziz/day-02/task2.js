//----------- 2022/02: Rock Paper Scissors -------------

const {input} = require("./task1");

let score = 0;
/* 
Big O analysis

Time complexity: O(n)
Space complexity: O(1)
*/
input.forEach(i => {
  const [player, status] = i.split(" ")
  if(player === "A") { 
    if(status === "X") {
      score += 3;
    }else if(status === "Y"){ 
      score += 4;
    }else {
      score += 8;
    }
  }else if(player === "B") { 
    if(status === "X") {
      score += 1;
    }else if(status === "Y"){
      score += 5;
    }else {
      score += 9;
    }
  }else { 
    if(status === "X") {
      score += 2;
    }else if(status === "Y"){
      score += 6;
    }else {
      score += 7;
    }
  }
})

console.log(score);