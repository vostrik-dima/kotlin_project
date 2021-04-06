package service

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*
import model.Text

class TextService {
    private val data = listOf(
        Text(0, 0, "Title 0", "text-0"),
        Text(1, 1, "Title 1", "text-1"),
        Text(2, 2, "Title 2", "text-2"),
        Text(3, 0, "Title 3", "text-3"),
        Text(4, 1, "Title 4", "text-4"),
        Text(5, 2, "Title 5", "text-5"),
        Text(6, 0, "Title 6", "text-6"),
    )
    private var count = data.size

    private val subscriptions = mutableMapOf<Int, MutableList<Channel<Text>>>()

    suspend fun getByAuthorId(id: Int): List<Text> {
        delay(3000L)
        return data.filter { it.authorId == id }
    }

    fun subscribe(id: Int): Channel<Text> {
        val channel = Channel<Text>()
        if (!subscriptions.containsKey(id))
            subscriptions[id] = mutableListOf(channel)
        else
            subscriptions[id]?.add(channel)
        return channel
    }


    suspend fun startNewsGenerator() {
        println("Generator started")
        while (true) {
            subscriptions.forEach { (authorId, channels) ->
                val textId = count
                count++
                val article =
                    Text(textId, authorId, "Title of text $textId", "text - $textId")
                println("Generated: $article")
                for (channel in channels) {
                    runBlocking { channel.send(article) }
                }
            }
            delay(3000L)
        }
    }
}