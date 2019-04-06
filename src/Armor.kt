class Armor(_name: String, _description: String, var defBonus: Int, var dexBonus: Int) : Item(_name, _description) {

    override fun displayItem() {
        super.displayItem()
        println("Defense Bonus: $defBonus")
        println("Dexterity Bonus: $dexBonus")
    }
}