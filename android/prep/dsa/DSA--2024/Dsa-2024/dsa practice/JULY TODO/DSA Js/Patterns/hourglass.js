function printHourglass(n) {
    // Upper part
    for (let i = n; i >= 1; i--) {
      let pattern = ' '.repeat(n - i);
      pattern += '*'.repeat(2 * i - 1);
      console.log(pattern);
    }
  
    // Lower part
    for (let i = 2; i <= n; i++) {
      let pattern = ' '.repeat(n - i);
      pattern += '*'.repeat(2 * i - 1);
      console.log(pattern);
    }
  }
  
  printHourglass(5);
  