import java.io.File

class Level {
    var roomList = ArrayList<Room>()

    fun addRoom(room: Room) {
        roomList.add(room)
    }

    fun loadRooms(filename: String) {
        try {
            val bufferedReader = File(filename).bufferedReader()
            val lineList = mutableListOf<String>()

            bufferedReader.useLines { lines ->
                lines.forEach {
                    lineList.add(it)
                }
            }
            lineList.forEach {
                var name = it.split(":".toRegex()).first()
                var description = it.split(":".toRegex()).last()

                addRoom(Room(name, description))

            }

            bufferedReader.close()
        }catch (e: Exception) { e.printStackTrace() }
    }

    fun loadConnections(filename: String) {
        try {
            val bufferedReader = File(filename).bufferedReader()

            bufferedReader.useLines { lines ->
                lines.forEach {

                    val strs = it.split(":").toTypedArray()

                    var room1 = getRoom(strs[0])
                    var room2 = getRoom(strs[2])

                    if (room1 == null || room2 == null) {
                        println("$it Attacked by nulls!!!")
                        return@forEach
                    }
                    when(strs[1]) {
                        "N", "n" -> {
                            room1.setExits(Room.DIRECTION.NORTH, room2)
                            room2.setExits(Room.DIRECTION.SOUTH, room1)
                            return@forEach
                        }
                        "E", "e" -> {
                            room1.setExits(Room.DIRECTION.EAST, room2)
                            room2.setExits(Room.DIRECTION.WEST, room1)
                            return@forEach
                        }
                        "S", "s" -> {
                            room1.setExits(Room.DIRECTION.SOUTH, room2)
                            room2.setExits(Room.DIRECTION.NORTH, room1)
                            return@forEach
                        }
                        "W", "w" -> {
                            room1.setExits(Room.DIRECTION.WEST, room2)
                            room2.setExits(Room.DIRECTION.EAST, room1)
                            return@forEach
                        }
                        else -> {
                            return@forEach
                        }
                    }
                }
            }
            bufferedReader.close()
        } catch(e: Exception) {
            e.printStackTrace()
        }
    }

    fun displayLevel() {
        roomList.forEach {
            it.printRoom()
        }
    }

    fun getRoom(name: String): Room? {
        roomList.forEach {
            if (it.name == name)
                return it
        }
        return null
    }

    fun getCurrentRoom(): Room {
        return roomList[0]
    }
}