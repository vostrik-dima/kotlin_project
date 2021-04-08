package models

class Person(val name: String, val age: Int) {

    var id: Int
    
    companion object {
        var counter: Int = 0
    }

    init {
        counter++
        id = counter
    }
    
}