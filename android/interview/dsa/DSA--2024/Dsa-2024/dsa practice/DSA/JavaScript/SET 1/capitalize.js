function capitalize(str) {
  var allWords = str.split(" ").map(function (word) {
    return word.charAt(0).toUpperCase() + word.substring(1);
  });
  return allWords.join(" ")
}
console.log(capitalize("yeh mera skill hai"));
