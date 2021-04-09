package point4

class Person(
    val name: String? = null,
    val age: Int? = null
) {
    fun getPerson(): String = "$name, age: $age"
}