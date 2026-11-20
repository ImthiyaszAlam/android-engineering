function printLeftAngledTriangle(n) {
    for (let i = 1; i <= n; i++) {
      let pattern = '';
  
      // Print leading spaces
      for (let j = 1; j <= n - i; j++) {
        pattern += ' ';
      }
  
      // Print stars
      for (let j = 1; j <= i; j++) {
        pattern += '*';
      }
  
      console.log(pattern);
    }
  }
  
  const n = 5;
  printLeftAngledTriangle(n);
  