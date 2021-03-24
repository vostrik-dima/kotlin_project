package point4

fun person(block: Person.() -> Unit): Person = Person().apply(block)