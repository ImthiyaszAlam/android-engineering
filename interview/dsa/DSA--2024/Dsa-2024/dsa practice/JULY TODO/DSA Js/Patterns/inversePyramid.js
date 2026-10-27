function printInvertedEquilateralTriangle(n) {
    for (let i = n; i >= 1; i--) {
      let pattern = '';
  
      // Print leading spaces
      for (let j = 1; j <= n - i; j++) {
        pattern += ' ';
      }
  
      // Print stars
      for (let j = 1; j <= i; j++) {
        pattern += '* ';
      }
  
      console.log(pattern);
    }
  }
  
  const n = 5;
  printInvertedEquilateralTriangle(n);
  