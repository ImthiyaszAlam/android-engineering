function printHollowSquare(n) {
    for (let i = 1; i <= n; i++) {
      let pattern = '';
      for (let j = 1; j <= n; j++) {
        if (i === 1 || i === n || j === 1 || j === n) {
          pattern += '* ';
        } else {
          pattern += '  ';
        }
      }
      console.log(pattern);
    }
  }
  
  printHollowSquare(5);
  