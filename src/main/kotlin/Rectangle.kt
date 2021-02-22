open class Rectangle(override val name: String = "Rectangle №${counter + 1}", override val color: String,
                     open val width: Double, private val height: Double) : Figure {

    private val id: Int

    companion object {
        var counter: Int = 0

        fun counter(): Int {
            return counter
        }
    }

    init {
        counter++
        id = counter
    }


    open fun perimeter() : Double = 2 * width + 2 * height;

    open fun myPerimeter() = println("I am $name, my perimeter is ${perimeter()}")

    override fun draw() = println("Drawing the rectangle $name, color: $color, width: $width, height: $height, id: $id")

    override fun erase() = println("Erase the rectangle $name, id: $id")
}