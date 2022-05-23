class Player {
    var hand = mutableSetOf<String>()
    var score = Score()
    private var playerType = "human"
    private val display = DisplayService()
    private val ui = InputService()
    var guess = ""

    fun addToHand(card: String) {
        hand.add(card)
    }

    fun removeFromHand(card: String) {
        hand.remove(card)
    }

    fun setPlayerType(playerType: String) {
        this.playerType = playerType
    }

    fun makeGuess() {
        if (playerType == "human") {
            display.output("Guess: ")
            ui.input()
            guess = ui.userIn
        }
        else if (playerType == "ai") {
            guess = hand.random()

        }
    }
}