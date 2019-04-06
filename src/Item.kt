

open class Item(var name: String, var description: String) {
    open fun displayItem() {
        println("$name: $description.")
    }
}