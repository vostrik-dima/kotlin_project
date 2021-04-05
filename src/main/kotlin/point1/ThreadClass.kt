package point1

class ThreadClass: Thread() {
    override fun run() {
        println("${Thread.currentThread()} has run.")
    }
}