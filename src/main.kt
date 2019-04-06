
fun main() {
    println("This is how it always begins...")
    val wr = Room("Weapon room", "A room full of weapons")
    val dr = Room("Dining Room", "A room for dining")
    val rr = Room("Rest Room", "A room for... well... you know.")
    val ar = Room("Armor Room", "A room full of armor")

    val potion = Item("Potion", "A small healing potion")
    val elixir = Consumable("Elixir", "A potion that cures all", 100, 100)
    var helmet = Armor("Rusty Helmet", "A helmet that may cause injuries", 5, -3)
    var sword = Weapon("Short Sword", "A small tiny sword", 10, 0)



    potion.displayItem()
    elixir.displayItem()
    helmet.displayItem()
    sword.displayItem()

    println("---------------------------------------------------")

    var item: List<Item> = listOf(potion, elixir, helmet, sword)

    for (i in item) {
        i.displayItem()
    }

    println("---------------------------------------------------")

    for (i in item) {
        if( i is Armor) {
            i.displayItem()
        }
    }
    println("---------------------------------------------------")

    for (i in item) {
        if( i is Weapon || i is Consumable) {
            i.displayItem()
        }
    }


    wr.setExits(Room.DIRECTION.NORTH, dr)
    wr.setExits(Room.DIRECTION.WEST, rr)
    wr.setExits(Room.DIRECTION.SOUTH, ar)

    ar.setExits(Room.DIRECTION.NORTH, wr)
    dr.setExits(Room.DIRECTION.SOUTH, wr)
    rr.setExits(Room.DIRECTION.EAST, wr)

}