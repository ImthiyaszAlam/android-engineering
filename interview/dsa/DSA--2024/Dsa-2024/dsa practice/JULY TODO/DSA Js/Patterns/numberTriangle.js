function printNumberTriangle(n) {
    for (let i = 1; i <= n; i++) {
      let pattern = '';
      for (let j = 1; j <= i; j++) {
        pattern += j + ' ';
      }
      console.log(pattern);
    }
  }
  
  printNumberTriangle(5);
  