function printButterflyPattern(n) {
  for (let i = 1; i <= n; i++) {
    let pattern = "";

    for (let j = 1; j <= i; j++) {
      pattern += "* ";
    }

    for (let j = 1; j <= 2 * (n - i); j++) {
      pattern += "  ";
    }

    for (let j = 1; j <= i; j++) {
      pattern += "* ";
    }

    console.log(pattern);
  }

  for (let i = n; i >= 1; i--) {
    let pattern = "";

    for (let j = 1; j <= i; j++) {
      pattern += "* ";
    }

    for (let j = 1; j <= 2 * (n - i); j++) {
      pattern += "  ";
    }

    for (let j = 1; j <= i; j++) {
      pattern += "* ";
    }

    console.log(pattern);
  }
}

const n = 5;
printButterflyPattern(n);
