class Inventory() {
    var inventory = HashMap<Item, Int>()

    fun printInventory() {
        for ( i in inventory) {
            println("${i.key.name} qty: ${i.value}")
        }
    }

    fun printWeaponInventory() {
        for ( i in inventory) {
            if( i.key is Weapon ) {
                println("${i.key.name} qty: ${i.value}")
            }
        }
    }
    fun printConsumableInventory() {
        for ( i in inventory) {
            if( i.key is Consumable ) {
                println("${i.key.name} qty: ${i.value}")
            }
        }
    }
    fun printArmorInventory() {
        for ( i in inventory) {
            if( i.key is Armor ) {
                println("${i.key.name} qty: ${i.value}")
            }
        }
    }
    fun addItem(item: Item) {
        if(inventory.containsKey(item)) {
            var temp = inventory.getValue(item) + 1
            inventory[item] = temp
        }
        else {
            inventory.put(item, 1)
        }
    }
    fun removeItem(item: Item) {
        if(inventory.containsKey(item)) {
            var temp = inventory.getValue(item)
            if(temp <= 1) {
                inventory.remove(item)
            }
            else {
                temp--
                inventory[item] = temp
            }

        }
    }

}