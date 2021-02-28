class MyStack<T> {
    private val elements: MutableList<T> = mutableListOf()

    private fun isEmpty() = elements.isEmpty()
    fun push(item: T) = elements.add(item)
    fun pop() : T? {
        val item = elements.lastOrNull()
        if (!isEmpty()){
            elements.removeAt(elements.size -1)
        }
        return item
    }

    override fun toString(): String = elements.toString()
}