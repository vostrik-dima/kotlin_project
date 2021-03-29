package point1

class RunnableClass : Runnable {
    override fun run() {
        println("${Thread.currentThread()} has run.")
    }
}