function printInvertedPyramidPattern(n) {
    for (let i = n; i >= 1; i--) {
      let pattern = '';
      for (let j = 1; j <= n - i; j++) {
        pattern += ' ';
      }
      for (let j = 1; j <= i; j++) {
        pattern += '* ';
      }
      console.log(pattern);
    }
  }
  
  printInvertedPyramidPattern(5);
  