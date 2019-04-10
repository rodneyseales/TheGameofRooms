import java.math.BigInteger
import kotlin.math.absoluteValue

fun main() {
    println("This is how it always begins...")
    val wr = Room("Weapon room", "A room full of weapons")
    val dr = Room("Dining Room", "A room for dining")
    val rr = Room("Rest Room", "A room for... well... you know.")
    val ar = Room("Armor Room", "A room full of armor")

    val potion = Consumable("Potion", "A small healing potion", 10, 10)
    val elixir = Consumable("Elixir", "A potion that cures all", 100, 100)
    var helmet = Armor("Rusty Helmet", "A helmet that may cause injuries", 5, -3)
    var sword = Weapon("Short Sword", "A small tiny sword", 10, 0)

    var item = Inventory()

    var ih = InterfaceHandler()

    ih.directionMenu()




    println("---------------------------------------------------")

    //var item = HashMap<Item, Int>()

    item.addItem(potion)
    item.addItem(potion)
    item.addItem(potion)
    item.addItem(elixir)
    item.addItem(sword)
    item.addItem(helmet)




    wr.setExits(Room.DIRECTION.NORTH, dr)
    wr.setExits(Room.DIRECTION.WEST, rr)
    wr.setExits(Room.DIRECTION.SOUTH, ar)

    ar.setExits(Room.DIRECTION.NORTH, wr)
    dr.setExits(Room.DIRECTION.SOUTH, wr)
    rr.setExits(Room.DIRECTION.EAST, wr)

}

