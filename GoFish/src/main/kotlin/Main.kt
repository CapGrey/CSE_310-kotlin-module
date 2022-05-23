fun main() {
    // create the deck
    val cards = arrayListOf("2", "2", "3", "3", "4", "4", "5", "5", "6", "6",
    "7", "7", "8", "8", "9", "9", "0", "0", "J", "J", "Q", "Q", "K", "K",
    "A", "A")
    val indices = arrayListOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
        14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25)
    val deck: ArrayList<String> = arrayListOf()

    // randomize the deck
    var i = 0
    while (i < 26) {
        val randIndex = indices.random()
        indices.remove(indices.size - 1)
        val nextCard = cards.removeAt(randIndex)
        deck.add(nextCard)
        i++
    }
    // create the players
    val ai = Player()
    ai.setPlayerType("ai")
    val human = Player()
    val display = DisplayService()

    // deal out 5 cards to each player
    i = 0
    while (i < 10) {
        val nextCard = deck.removeAt(0)
        if (i % 2 == 0) {

            if (nextCard !in ai.hand) {
                ai.addToHand(nextCard)
            }
            else {
                ai.score.updateScore()
                ai.removeFromHand(nextCard)
            }
        }
        else {
            if (nextCard !in human.hand) {
                human.addToHand(nextCard)
            }
            else {
                human.score.updateScore()
                human.removeFromHand(nextCard)
            }
        }
        i++
    }

    // create game loop
    var gameOver = false
    var turn = 0
    while (!gameOver) {
        val deckSize = deck.size
        val handSize: Int

        // take turn
        if (turn % 2 == 0) {

            // determine hand size for available guesses
            handSize = ai.hand.size
            if (handSize != 0) {
                ai.makeGuess()
                display.output("Do you have any ${ai.guess}'s?")

                // check AI's guess
                if (ai.guess in human.hand) {
                    ai.removeFromHand(ai.guess)
                    human.removeFromHand(ai.guess)
                    ai.score.updateScore()
                } else {

                    // check if deck is available to draw from
                    if (deckSize > 0) {
                        val nextCard = deck.removeAt(0)
                        if (nextCard !in ai.hand) {
                            ai.addToHand(nextCard)
                        } else {
                            ai.score.updateScore()
                            ai.removeFromHand(nextCard)
                        }
                    }
                }
            }
            // if hand is empty, draw from deck
            else {
                if (deckSize > 0) {
                    val nextCard = deck.removeAt(0)
                    if (nextCard !in ai.hand) {
                        ai.addToHand(nextCard)
                    } else {
                        ai.score.updateScore()
                        ai.removeFromHand(nextCard)
                    }
                    // if hand and deck are empty, game ends
                }
                else gameOver = true
            }
        }

        else {
            // display scores and hand
            handSize = human.hand.size
            display.outHand(human.hand)
            display.output("Your Score: ${human.score.getPoints()}")
            display.output("AI's Score: ${ai.score.getPoints()}")

            // determine hand size is not 0
            if (handSize != 0) {
                human.makeGuess()

                // check guess
                if (human.guess in ai.hand) {
                    ai.removeFromHand(human.guess)
                    human.removeFromHand(human.guess)
                    human.score.updateScore()
                } else {
                    // if wrong, draw from deck if available
                    if (deckSize > 0) {
                        val nextCard = deck.removeAt(0)
                        display.output("You drew a $nextCard")
                        if (nextCard !in human.hand) {
                            human.addToHand(nextCard)
                        } else {
                            human.score.updateScore()
                            human.removeFromHand(nextCard)
                        }
                    }
                }
            }
            // draw from deck for empty hand
            else {
                if (deckSize > 0) {
                    val nextCard = deck.removeAt(0)
                    if (nextCard !in ai.hand) {
                        human.addToHand(nextCard)
                    } else {
                        human.score.updateScore()
                        human.removeFromHand(nextCard)
                    }
                }
                // if deck and hand are empty, game is over
                else{
                    gameOver = true
                }
            }
        }

        turn++
    }
    display.output("Your Score: ${human.score.getPoints()}")
    display.output("AI's Score: ${ai.score.getPoints()}")
}