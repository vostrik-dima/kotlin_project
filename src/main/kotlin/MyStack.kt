class MyStack<T> {
    private val elements: MutableList<T> = mutableListOf()

    private fun isEmpty() = elements.isEmpty()
    fun push(item: T) = elements.add(item)
    fun pop() : T? = elements.removeLastOrNull()

    override fun toString(): String = elements.toString()
}