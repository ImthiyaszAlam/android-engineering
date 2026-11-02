function printHollowRhombusPattern(n) {
    for (let i = 1; i <= n; i++) {
      let pattern = '';
      for (let j = 1; j <= n - i; j++) {
        pattern += ' ';
      }
      for (let j = 1; j <= n; j++) {
        if (i === 1 || i === n || j === 1 || j === n) {
          pattern += '*';
        } else {
          pattern += ' ';
        }
      }
      console.log(pattern);
    }
  }
  
  printHollowRhombusPattern(5);
  