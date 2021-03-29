package point2

import java.util.concurrent.Semaphore

fun main() {
    val s = Semaphore(1)

    val t1 = Thread(Runnable
    {
        s.acquireUninterruptibly()
        print("t1")
        Thread.sleep(1000)
        println(".")
        s.release()
    })

    val t2 = Thread(Runnable
    {
        s.acquireUninterruptibly()
        print("t2")
        Thread.sleep(1000)
        println(".")
        s.release()
    })

    val t3 = Thread(Runnable
    {
        s.acquireUninterruptibly()
        print("t3")
        Thread.sleep(1000)
        println(".")
        s.release()
    })

    val t4 = Thread(Runnable
    {
        s.acquireUninterruptibly()
        print("t4")
        Thread.sleep(1000)
        println(".")
        s.release()
    })


    t1.start()
    t2.start()
    t3.start()
    t4.start()
}