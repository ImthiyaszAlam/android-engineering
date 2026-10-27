function printInvertedHollowDiamond(n) {
    for (let i = n; i >= 1; i--) {
      let pattern = ' '.repeat(n - i) + '*';
      if (i > 1) {
        pattern += ' '.repeat(2 * (i - 1) - 1) + '*';
      }
      console.log(pattern);
    }
  }
  
  printInvertedHollowDiamond(5);
  