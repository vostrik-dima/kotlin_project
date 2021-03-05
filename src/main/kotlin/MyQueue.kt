class MyQueue<T> {
    private val elements: MutableList<T> = mutableListOf()

    private fun isEmpty() = elements.isEmpty()
    fun enqueue(item: T) = elements.add(item)
    fun dequeue() = elements.removeFirstOrNull()

    override fun toString(): String = elements.toString()
}