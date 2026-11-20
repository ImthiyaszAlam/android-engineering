function printPalindromeTriangle(n) {
    for (let i = 1; i <= n; i++) {
      let pattern = ' '.repeat(n - i);
      for (let j = 1; j <= i; j++) {
        pattern += j;
      }
      for (let j = i - 1; j >= 1; j--) {
        pattern += j;
      }
      console.log(pattern);
    }
  }
  
  printPalindromeTriangle(5);
  