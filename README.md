# Overview


I created a go fish game. In it, the user plays against the program's 
AI to get pairs of cards from one another. This is done by implementing several different classes: 
Player class, a Score class and the MainActivity class. 
Two player objects were created: one for the human and one for the AI. Each had a Score object. 
The MainActivity object received input from the user and displayed the game information back to the user.
This was all integrated into an Android app.

The purpose I had in writing this software was to gain an understanding of the basics of app development. 
I wanted to learn how function calls, loops, and classes worked in an app environment. I Used both arrayLists and sets for this software.

To use the app, enter your guess into the Guess tab at the top of the screen. Then push the enter button.
The game ends once no more cards are left, and will display a game over message once this happens.


[Software Demo Video](https://youtu.be/9kr-KJExaw8)

# Development Environment

I used the IDE IntelliJ IDEA Android Studio for the compiler
18 Oracle OpenJDK version 18.0.1 for the JDK


The language is Kotlin.

# Useful Websites

* [w3schools](https://www.w3schools.com/kotlin)
* [Kotlin Lang](https://kotlinlang.org)
* [geeks for geeks](https://www.geeksforgeeks.org)
* [Android Courses ](https://developer.android.com/courses/)

# Future Work

* The AI's guess is displayed after the cards are moved.
* user input is never validated. This won't crash the game, but it 
    does ruin turn order.
* The system of getting the user input is a bit clunky, It would be much better to have buttons for each card.