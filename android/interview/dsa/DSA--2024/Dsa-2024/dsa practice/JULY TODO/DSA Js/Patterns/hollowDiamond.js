function printHollowDiamond(n) {
    for (let i = 1; i <= n; i++) {
      let pattern = ' '.repeat(n - i) + '*';
      if (i > 1) {
        pattern += ' '.repeat(2 * (i - 1) - 1) + '*';
      }
      console.log(pattern);
    }
    for (let i = n - 1; i >= 1; i--) {
      let pattern = ' '.repeat(n - i) + '*';
      if (i > 1) {
        pattern += ' '.repeat(2 * (i - 1) - 1) + '*';
      }
      console.log(pattern);
    }
  }
  
  printHollowDiamond(5);
  