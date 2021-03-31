package point3

import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

fun main() {
    val results = mutableListOf<Pair<Long, Int>>()
    val poolSizes = listOf(10, 20, 30)

    for (size in poolSizes) {
        val pool = Executors.newFixedThreadPool(size)

        val startTime = System.nanoTime()
        var count = 0

        repeat(size) {
            pool.submit {
                synchronized(count) {
                    while (count < 1_000_000) {
                        count++
                    }
                }
            }
        }
        pool.shutdown()
        val endTime = System.nanoTime()

        results.add(Pair<Long, Int>(endTime - startTime, size))
    }

    results.sortBy { it.first }
    for (res in results) {
        println("Pool of size ${res.second} with result ${TimeUnit.MILLISECONDS.convert(res.first, TimeUnit.NANOSECONDS)} ms")
    }
}