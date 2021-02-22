fun main() {

    val circle1: Circle = Circle("mr red", "red", 7.5)
    val circle2: Circle = Circle( color = "red", radius = 10.5)
    val circle3: Circle = Circle( color = "purple", radius = 15.3)

    circle1.myCircumference()
    circle2.myCircumference()
    circle3.myCircumference()


    val triangle1: Triangle = Triangle("mr brown", "brown", 2.0, 3.0, 4.0)
    val triangle2: Triangle = Triangle(color = "brown", sideA =  2.0)

    triangle1.myArea()
    triangle2.myArea()

    val rectangle1: Rectangle = Rectangle("mr yellow,", "yellow", 4.0, 2.0)
    val rectangle2: Rectangle = Rectangle(color =  "yellow", width = 6.0, height = 3.0)

    rectangle1.myPerimeter()
    rectangle2.myPerimeter()

    val square1: Square = Square("mr black", "black", 5.0)
    val square2: Square = Square(color =  "black", width = 10.0)

    square1.myPerimeter()
    square2.myPerimeter()

    println()

    val figures = listOf(circle1, circle2, triangle1, triangle2, rectangle1, rectangle2, square1, square2, circle3)

    figures.forEach {
        it.draw()
        it.erase()
        println()
    }

}