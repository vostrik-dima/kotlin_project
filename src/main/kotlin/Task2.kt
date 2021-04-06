import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import service.TextService

fun main() = runBlocking {
    val textService = TextService()

    launch {
        textService.startNewsGenerator()
    }

    repeat(3) { getterId ->
        launch {
            val channel = textService.subscribe(getterId)
            println("Creating the subscription $getterId to $getterId")
            while (true) {
                val text =
                    withContext(Dispatchers.Default) { channel.receive() }
                println("[Getter-$getterId] Received new text from person $getterId: ${text.title}")
            }
        }
    }
}