import point1.RunnableClass
import point1.ThreadClass
import kotlin.concurrent.thread

fun main() {
    val thread = ThreadClass()
    thread.start()

    val runnable = Thread(RunnableClass())
    runnable.start()

    val thread1 = Thread {
        println("${Thread.currentThread()} has run.")
    }
    thread1.start()

    thread(start = true) {
        println("${Thread.currentThread()} has run.")
    }

    val daemonThread = Thread{
        println("${Thread.currentThread()} has run.")
    }
    daemonThread.isDaemon = true
    println(daemonThread.isDaemon)
    daemonThread.start()

    val prThread = Thread{
        println("${Thread.currentThread()} has run.")
    }
    prThread.priority = Thread.MIN_PRIORITY
    prThread.start()

    val prThread1 = Thread{
        println("${Thread.currentThread()} has run.")
    }
    prThread1.priority = Thread.MAX_PRIORITY
    prThread1.start()
}