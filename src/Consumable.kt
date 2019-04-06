

class Consumable(_name: String, _description: String, var hpBonus: Int, var mpBonus: Int) : Item(_name, _description) {


    override fun displayItem() {
        super.displayItem()
        println("HP Bonus: $hpBonus")
        println("MP Bonus: $mpBonus")
    }
}