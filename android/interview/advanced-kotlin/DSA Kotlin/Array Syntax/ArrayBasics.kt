 fun main(args: Array<String>) {

    val result = IntArray(5)

    val numbers = IntArray(5)
    for (i in numbers.indices) {
        numbers[i] = (i * 10)
          result[i] = numbers[i]
    }

    for(i in numbers.indices){
        print("${numbers[i]}")
    }
  

    print("Numbers:${numbers.joinToString()}")
    print("Result:${result.joinToString()}")
    
}