package point3

fun String.wordCount(c: Char) : Int{
    if (c == 'c') {
        throw IllegalArgumentException("Wrong char")
    }
   return count { char -> char == c}
}

