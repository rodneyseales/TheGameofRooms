fun main() {

    var ih = InterfaceHandler()

    ih.loadLevel("levels/level1.txt", "levels/connections1.txt")

    while(true) {
        ih.baseMenu()
    }
    println("---------------------------------------------------")



}

