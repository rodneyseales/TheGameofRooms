class Room(val name: String, var description: String) {
    var exits: Array<Room?>
    var exitStrings: Array<String>
    enum class DIRECTION {NORTH, EAST, SOUTH, WEST}

    init {
        exits = arrayOfNulls(4)
        exitStrings = arrayOf( "North", "East", "South", "West")
    }

    fun printRoom() {
        println("You are in the $name.")
        println("$description.")
        printExits()
    }
    fun printExits() {
        var exit = ""
        for(i in 0 until 4) {
            if(exits[i] != null) {
                exit += "${exitStrings[i]}, "
            }
        }
        if(exit.length == 0) {
            println("There are no exits.")
        }
        else {
            exit.trim()
            exit = exit.substring(0, exit.length-2)

            if(exit.indexOf(',')!= -1) {
                var temp = exit.substring(0, exit.lastIndexOf(',') + 1)
                temp += " and"
                temp += exit.substring(exit.lastIndexOf(',') + 1)
                exit = temp
            }
            println("There are exits to the $exit.")
        }
    }

    fun setExits(dir: DIRECTION, room: Room) {
        exits[dir.ordinal] = room
    }

    fun go(dir: DIRECTION): Room? {
        return exits[dir.ordinal]
    }

}