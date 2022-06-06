package com.example.gofishapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
        outHand(human.hand)
        findViewById<TextView>(R.id.human_score).text = "Your Score: " + human.score.getPoints()
        findViewById<TextView>(R.id.ai_score).text = "AI's Score: ${ai.score.getPoints()}"
        outputMessage("Do you have any ${ai.guess}'s?")


        val enterButton: Button = findViewById(R.id.button)
        enterButton.setOnClickListener{

            // take turns
            takeHumanTurn(human, ai, deck)
            takeAiTurn(human, ai, deck)

            // update screen after AI guess
            outHand(human.hand)
            findViewById<TextView>(R.id.human_score).text = "Your Score: " + human.score.getPoints()
            findViewById<TextView>(R.id.ai_score).text = "AI's Score: ${ai.score.getPoints()}"
        }

    }


    private fun outHand(hand: MutableSet<String>) {
        var cardLocation = 1
        // reset board
        findViewById<TextView>(R.id.card1).text = ""
        findViewById<TextView>(R.id.card2).text = ""
        findViewById<TextView>(R.id.card3).text = ""
        findViewById<TextView>(R.id.card4).text = ""
        findViewById<TextView>(R.id.card5).text = ""
        findViewById<TextView>(R.id.card6).text = ""
        findViewById<TextView>(R.id.card7).text = ""
        findViewById<TextView>(R.id.card8).text = ""
        findViewById<TextView>(R.id.card9).text = ""
        findViewById<TextView>(R.id.card10).text = ""
        findViewById<TextView>(R.id.card11).text = ""
        findViewById<TextView>(R.id.card12).text = ""
        findViewById<TextView>(R.id.card13).text = ""

        // update display
        for (value in hand) {
            when (cardLocation) {
                1 -> findViewById<TextView>(R.id.card1).text = value
                2 -> findViewById<TextView>(R.id.card2).text = value
                3 -> findViewById<TextView>(R.id.card3).text = value
                4 -> findViewById<TextView>(R.id.card4).text = value
                5 -> findViewById<TextView>(R.id.card5).text = value
                6 -> findViewById<TextView>(R.id.card6).text = value
                7 -> findViewById<TextView>(R.id.card7).text = value
                8 -> findViewById<TextView>(R.id.card8).text = value
                9 -> findViewById<TextView>(R.id.card9).text = value
                10 -> findViewById<TextView>(R.id.card10).text = value
                11 -> findViewById<TextView>(R.id.card11).text = value
                12 -> findViewById<TextView>(R.id.card12).text = value
                13 -> findViewById<TextView>(R.id.card13).text = value
            }
            cardLocation++
        }
    }

    private fun outputMessage(message: String) {

        val messageText: TextView = findViewById(R.id.message)
        messageText.text = message
    }


    private fun input(): String {
        val inputField: TextView = findViewById(R.id.input_field)
        var userIn = inputField.text.toString()
        userIn = userIn.uppercase()
        return userIn
    }

    private fun takeHumanTurn(human: Player, ai: Player, deck: ArrayList<String>) {
        val handSize = human.hand.size
        val deckSize = deck.size

        // determine hand size is not 0
        if (handSize != 0) {
            val userGuess = input()
            human.makeGuess(userGuess)

            // check guess
            if (human.guess in ai.hand) {
                ai.removeFromHand(human.guess)
                human.removeFromHand(human.guess)
                human.score.updateScore()
            } else {
                // if wrong, draw from deck if available
                if (deckSize > 0) {
                    val nextCard = deck.removeAt(0)
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
            } else outputMessage("Game Over")
        }
    }

    private fun takeAiTurn(human: Player, ai: Player, deck: ArrayList<String>) {
        // determine hand size for available guesses
        val handSize = ai.hand.size
        val deckSize = deck.size

        if (handSize != 0) {
            ai.makeGuess("")
            outputMessage("Do you have any ${ai.guess}'s?")

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
            } else outputMessage("Game Over")
        }
    }
}