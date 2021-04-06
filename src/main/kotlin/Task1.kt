import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import service.PersonService
import service.TextService
import java.util.concurrent.TimeUnit

fun main() = runBlocking {
    val personService = PersonService()
    val textService = TextService()
    val testId = 2

    val startTime = System.nanoTime()

    val personDeferred = async { personService.getById(testId) }
    val textDeferred = async { textService.getByAuthorId(testId) }

    val person = personDeferred.await() // 100 ms
    val texts = textDeferred.await() // 3000 ms
    if (person != null) {
        println("User #${person.id}: ${person.name} ${person.surname} (${person.email}")
        for (text in texts)
            println("\"${text.title}\" (${text.id}): ${text.text}")
    } else {
        println("No user with id $testId")
    }

    val endTime = System.nanoTime()
    val execTime = TimeUnit.MILLISECONDS.convert(endTime - startTime, TimeUnit.NANOSECONDS)

    println("Everything took $execTime ms")
}