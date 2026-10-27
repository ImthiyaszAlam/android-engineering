function printInvertedRightAngledTriangle(n) {
    for (let i = n; i >= 1; i--) {
      let pattern = '';
      for (let j = 1; j <= i; j++) {
        pattern += '* ';
      }
      console.log(pattern);
    }
  }
  
  const n = 5;
  printInvertedRightAngledTriangle(n);
  