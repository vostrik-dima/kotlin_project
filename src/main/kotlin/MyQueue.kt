class MyQueue<T> {
    private val elements: MutableList<T> = mutableListOf()

    private fun isEmpty() = elements.isEmpty()
    fun enqueue(item: T) = elements.add(item)
    fun dequeue() = if (!isEmpty()) elements.removeAt(0) else null

    override fun toString(): String = elements.toString()
}