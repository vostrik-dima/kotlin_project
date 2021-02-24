class Square(name: String = "Rectangle №${counter + 1}",
             color: String, width: Double,
             height: Double = width) : Rectangle(name, color, width, height) {

    private val id: Int

    companion object {
        var counter: Int = 0
    }

    init {
        counter++
        id = counter
    }

    override fun perimeter(): Double = 4 * width

    override fun draw() = println("Drawing the square $name, color: $color, width: $width, id: $id")

    override fun erase() = println("Erase the square $name, id: $id")
}