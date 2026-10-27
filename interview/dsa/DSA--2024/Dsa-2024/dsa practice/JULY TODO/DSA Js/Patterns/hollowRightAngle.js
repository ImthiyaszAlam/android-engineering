function printHollowRightAngledTriangle(n) {
    for (let i = 1; i <= n; i++) {
      let pattern = '';
      for (let j = 1; j <= i; j++) {
        if (j === 1 || j === i || i === n) {
          pattern += '* ';
        } else {
          pattern += '  ';
        }
      }
      console.log(pattern);
    }
  }
  
  printHollowRightAngledTriangle(5);
  