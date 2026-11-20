function reverseNum(num){
     var rev = 0;
    while(num>0){
        var rem = num%10;
        rev = rev*10+rem;
        num  = Math.floor(num/10);
    }
    return rev;
}
console.log(reverseNum(87906473));