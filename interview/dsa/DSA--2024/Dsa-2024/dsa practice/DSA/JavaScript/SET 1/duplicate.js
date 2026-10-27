function duplicate(arr){
    return arr.concat(arr);
}
var darray = duplicate([1,2,3,4,5]);
console.log(darray.reverse());