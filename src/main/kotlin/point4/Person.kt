package point4

class Person(
    var name: String? = null,
    var age: Int? = null
) {

    fun getPerson(): String = "$name, age: $age"
}