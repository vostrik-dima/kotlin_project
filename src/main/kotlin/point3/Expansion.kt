package point3

fun String.wordCount(c: Char) : Int{
    if (c == 'c') {
        throw IllegalArgumentException("Wrong char")
    }
    var count = 0
    for(n in 0 until this.count()){
        if(this[n] == c) count++
    }
    return count
}