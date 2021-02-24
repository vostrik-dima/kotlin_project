open class Rectangle(override val name: String = "Rectangle №${counter + 1}",
                     override val color: String,
                     open val width: Double,
                     private val height: Double) : Figure {

    private val id: Int

    companion object {
        var counter: Int = 0
    }

    init {
        counter++
        id = counter
    }

    open fun perimeter() : Double = 2 * width + 2 * height

    open fun myPerimeter() = println("I am $name, my perimeter is ${perimeter()}")

    override fun draw() = println("Drawing the rectangle $name, color: $color, width: $width, height: $height, id: $id")

    override fun erase() = println("Erase the rectangle $name, id: $id")

    fun showName() = println("My name is $name")
    fun showName(nickname: String) = println("My name is $name and my nickname is $nickname")
    fun showName(showColor: Boolean) {
        if (showColor) println("My name is $name and my color is $color")
        else println("My name is $name and i don't want show my color")
    }
}