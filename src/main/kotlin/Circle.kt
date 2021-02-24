class Circle(override val name: String = "Circle №${counter + 1}",
             override val color: String,
             private val radius: Double) : Figure {

    private val id: Int

    companion object {
        var counter: Int = 0
    }

    init {
        counter++
        id = counter
    }

    private fun circumference(): Double = 2 * Math.PI * radius

    fun myCircumference() = println("I am $name, my circumference is ${circumference()}")

    override fun draw() = println("Drawing the circle $name, color: $color, radius: $radius, id: $id")

    override fun erase() = println("Erase the circle $name, id: $id")



}