import kotlin.system.exitProcess

class InterfaceHandler() {
    var level = Level()
    var currentRoom: Room? = null

    fun loadLevel(roomFile: String, connectionFile: String) {
        level.loadRooms(roomFile)
        level.loadConnections(connectionFile)
        currentRoom = level.getCurrentRoom()
    }

    fun directionMenu() {
        currentRoom?.printRoom()
        println("Which direction would you like to move?")
        println("N)orth")
        println("E)ast")
        println("S)outh")
        println("W)est")

        var answer = readLine()?.let {
            if( it?.isNotBlank()) {
                it.capitalize()
            }
            else {
                "`"
            }.get(0)
        }

        when (answer) {
            'N' -> {
                if(currentRoom?.go(Room.DIRECTION.NORTH) != null )
                    currentRoom = currentRoom?.go(Room.DIRECTION.NORTH)
            }
            'E' -> {
                if(currentRoom?.go(Room.DIRECTION.EAST) != null )
                    currentRoom = currentRoom?.go(Room.DIRECTION.EAST)
            }
            'S' -> {
                if(currentRoom?.go(Room.DIRECTION.SOUTH) != null )
                    currentRoom = currentRoom?.go(Room.DIRECTION.SOUTH)
            }
            'W' -> {
                if(currentRoom?.go(Room.DIRECTION.WEST) != null )
                    currentRoom = currentRoom?.go(Room.DIRECTION.WEST)
            }
            'Q' -> {
                println("Thank you for playing!")
                exitProcess(0)
            }
            else -> {
                println("Sorry, that was an invalid response.")
            }
        }

    }

    fun baseMenu() {

        println("What would you like to do?")
        println("M)ove")
        println("I)nventory")
        println("L)ook Around")
        println("V)iew Stats")

        var answer = readLine()?.let {
            if( it?.isNotBlank()) {
                it.capitalize()
            }
            else {
                "`"
            }.get(0)
        }

        when (answer) {
            'M' -> {
                directionMenu()
            }
            'I' -> { //Show Inventory
                //Not implemented yet
            }
            'L' -> { //Look around room
                //Not Implemented yet
            }
            'V' -> { //View Character Stats
                //Not implemented yet
            }
            'Q' -> { //Quit Game
                println("Thank you for playing!")
                exitProcess(0)
            }
            else -> {
                println("Sorry, that was an invalid response.")
            }
        }

    }
}