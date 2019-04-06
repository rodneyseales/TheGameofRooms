class Weapon(_name: String, _description: String, var strBonus: Int, var defBonus: Int) : Item(_name, _description) {

    override fun displayItem() {
        super.displayItem()
        println("Strenth Bonus: $strBonus")
        println("Defense Bonus: $defBonus")
    }
}