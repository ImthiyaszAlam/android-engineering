function printAlphabetPyramid(n) {
    const startChar = 'A'.charCodeAt(0);
    for (let i = 1; i <= n; i++) {
      let pattern = ' '.repeat(n - i);
      const currentChar = String.fromCharCode(startChar + i - 1);
      for (let j = 1; j <= i; j++) {
        pattern += currentChar + ' ';
      }
      console.log(pattern);
    }
  }
  
  printAlphabetPyramid(5);
  