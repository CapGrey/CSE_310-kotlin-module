package com.example.gofishapp

class Player {
    var hand = mutableSetOf<String>()
    var score = Score()
    private var playerType = "human"
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

    fun makeGuess(userGuess: String) {
        if (playerType == "human") {
            guess = userGuess
        }
        else if (playerType == "ai") {
            guess = hand.random()

        }
    }
}