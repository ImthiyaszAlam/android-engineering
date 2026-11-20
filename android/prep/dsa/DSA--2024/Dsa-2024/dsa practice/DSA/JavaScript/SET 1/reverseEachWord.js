var str = "sare jahan se achha hindustan hamara";
 var stringArray = str.split(" ").map(function(word){
    return word.split("").reverse().join("");
 })
 console.log(stringArray.join(" "));
