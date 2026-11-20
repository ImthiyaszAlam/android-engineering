fun main() {
    val s = "aaggglam"
    val result = firstUniqueChar(s)
    print(result)
}

fun firstUniqueChar(s: String): Int {
    val map = HashMap<Char, Int>()

    for (c in s) {
        map[c] = map.getOrDefault(c, 0) + 1
    }

    for (i in s.indices) {
        if (map[s[i]] == 1) {
            print("char-->"+s[i] +" & index->")   
            return i      
        }
    }

    return -1
}
