
fun main() {
    println("This is how it always begins...")
    val wr = Room("Weapon room", "A room full of weapons")
    val dr = Room("Dining Room", "A room for dining")
    val rr = Room("Rest Room", "A room for... well... you know.")
    val ar = Room("Armor Room", "A room full of armor")

    val potion = Item("Potion", "A small healing potion")
    val elixir = Consumable("Elixir", "A potion that cures all", 100, 100)

    potion.displayItem()
    elixir.displayItem()

    wr.setExits(Room.DIRECTION.NORTH, dr)
    wr.setExits(Room.DIRECTION.WEST, rr)
    wr.setExits(Room.DIRECTION.SOUTH, ar)

    ar.setExits(Room.DIRECTION.NORTH, wr)
    dr.setExits(Room.DIRECTION.SOUTH, wr)
    rr.setExits(Room.DIRECTION.EAST, wr)

}