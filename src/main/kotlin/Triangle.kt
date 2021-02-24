import kotlin.math.sqrt

class Triangle(override val name: String = "Triangle №${counter + 1}",
               override val color: String,
               private val sideA: Double,
               private val sideB: Double = sideA,
               private val sideC: Double = sideA) : Figure {

    private val isosceles: Boolean
    private val id: Int

    companion object {
        var counter: Int = 0
    }

    init {
        counter++
        id = counter
        isosceles = sideA == sideB && sideA == sideC
    }

    private fun area(): Double {
        val p: Double = (sideA + sideB + sideC) / 2
        return sqrt(p * (p - sideA) * (p - sideB) * (p - sideC)) //Формула Герона
    }

    fun myArea() = println("I am $name, my area is ${area()}")

    override fun draw() = println("Drawing the triangle $name, color: $color, isosceles: $isosceles, id: $id")

    override fun erase() = println("Erase the triangle $name, id: $id")

    fun showId() = println("My id is $id")
    fun showId(showQuantity: Boolean) {
        if (showQuantity) println("My id is $id. Our quantity is $counter")
        else println("My id is $id. I don't say our quantity")
    }
}