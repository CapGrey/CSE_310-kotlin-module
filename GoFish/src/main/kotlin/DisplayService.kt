class DisplayService {
    private var value = " "
    private var visDesign = arrayOf("*---*", "|   |", "| ", value, " |",
        "|   |", "*---*")

    fun output(message: String) {
        println(message)
    }

    fun outHand(hand: MutableSet<String>) {
        for (i in 0..4) {
            for (card in hand) {
                if (i == 2) {
                    value = card
                    print(visDesign[i] + value + visDesign[i+2] + " ")
                }
                else if (i > 2) {
                    print("${visDesign[i + 2]} ")
                }
                else {
                    print("${visDesign[i]} ")
                }
            }
            println("")
        }
    }
}
