function printHollowPyramid(n) {
    // Upper part
    for (let i = 1; i <= n; i++) {
      let pattern = ' '.repeat(n - i);
      if (i === 1) {
        pattern += '*';
      } else {
        pattern += '*';
        pattern += ' '.repeat(2 * i - 3);
        pattern += '*';
      }
      console.log(pattern);
    }
  }
  
  printHollowPyramid(5);
  