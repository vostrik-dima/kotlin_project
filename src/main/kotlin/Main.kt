fun main() {
    val queueString = MyQueue<String>()
    queueString.enqueue("first string")
    queueString.enqueue("second string")
    queueString.enqueue("third string")
    println(queueString.toString())
    println(queueString.dequeue())
    println(queueString.toString())

    println()

    val queueInt = MyQueue<Int>()
    queueInt.enqueue(1)
    queueInt.enqueue(2)
    queueInt.enqueue(3)
    println(queueInt.toString())
    println(queueInt.dequeue())
    println(queueInt.toString())

    println()

    val stackString = MyStack<String>()
    stackString.push("first string")
    stackString.push("second string")
    stackString.push("third string")
    println(stackString.toString())
    println(stackString.pop())
    println(stackString.toString())

    println()

    val stackInt = MyStack<Int>()
    stackInt.push(1)
    stackInt.push(2)
    stackInt.push(3)
    println(stackInt.toString())
    println(stackInt.pop())
    println(stackInt.toString())
}