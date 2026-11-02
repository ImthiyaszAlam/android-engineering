function printZigZag(n) {
    for (let i = 1; i <= 3; i++) {
      let pattern = '';
      for (let j = 1; j <= n; j++) {
        if ((i + j) % 4 === 0 || (i === 2 && j % 4 === 0)) {
          pattern += '* ';
        } else {
          pattern += '  ';
        }
      }
      console.log(pattern);
    }
  }
  
  printZigZag(9);
  