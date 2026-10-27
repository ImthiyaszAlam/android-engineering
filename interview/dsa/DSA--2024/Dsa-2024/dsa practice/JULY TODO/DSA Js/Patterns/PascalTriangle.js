function printPascalsTriangle(n) {
    let triangle = [];
    for (let i = 0; i < n; i++) {
      triangle[i] = new Array(i + 1);
      for (let j = 0; j <= i; j++) {
        if (j === 0 || j === i) {
          triangle[i][j] = 1;
        } else {
          triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
        }
      }
    }
    
    for (let i = 0; i < n; i++) {
      let pattern = ' '.repeat(n - i);
      for (let j = 0; j <= i; j++) {
        pattern += triangle[i][j] + ' ';
      }
      console.log(pattern);
    }
  }
  
  printPascalsTriangle(5);
  