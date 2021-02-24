fun main() {

    val circle1: Circle = Circle("mr red", "red", 7.5)
    val circle2: Circle = Circle( color = "red", radius = 10.5)
    val circle3: Circle = Circle( color = "purple", radius = 15.3)

    circle1.myCircumference()
    circle1.arcLength()
    circle2.myCircumference()
    circle2.arcLength(2.0)
    circle3.myCircumference()

    val triangle1: Triangle = Triangle("mr brown", "brown", 2.0, 3.0, 4.0)
    val triangle2: Triangle = Triangle(color = "brown", sideA =  2.0)

    triangle1.myArea()
    triangle1.showId()
    triangle2.myArea()
    triangle2.showId(true)

    val rectangle1: Rectangle = Rectangle("mr yellow", "yellow", 4.0, 2.0)
    val rectangle2: Rectangle = Rectangle(color =  "yellow", width = 6.0, height = 3.0)

    rectangle1.myPerimeter()
    rectangle1.showName()
    rectangle2.myPerimeter()
    rectangle2.showName(false)

    val square1: Square = Square("mr black", "black", 5.0)
    val square2: Square = Square(color =  "black", width = 10.0)

    square1.myPerimeter()
    square1.showSide()
    square2.myPerimeter()
    square2.showSide(false)

    println()

    val figures = listOf(circle1, circle2, triangle1, triangle2, rectangle1, rectangle2, square1, square2, circle3)

    figures.forEach {
        it.draw()
        it.erase()
        println()
    }

}