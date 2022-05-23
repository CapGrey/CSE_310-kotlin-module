# Overview


I created a go fish game. In it, the user plays against the program's AI to get pairs of cards from one another. This is done by implementing several different classes: Player class, InputService, DisplayService, and a Score class. Two player objects were created: one for the human and one for the AI. Each had a Score object. The InputService object recieved input from the user, while the DisplayService object displayed the game information back to the user.

The purpose I had in writing this software was to gain an understanding of the basics of Kotlin. I wanted to learn how the OOP worked for this language. I also wanted to learn how to use the different collections. I Used both arrayLists and sets for this software.


[Software Demo Video](https://youtu.be/OrVYV1SMtaU)

# Development Environment

I used the IDE IntelliJ IDEA for the compiler
18 Oracle OpenJDK version 18.0.1 for the JDK


The language is Kotlin.
I used the java.util.Scanner library

# Useful Websites

* [w3schools](https://www.w3schools.com/kotlin)
* [Kotlin Lang](https://kotlinlang.org)
* [geeks for geeks](https://www.geeksforgeeks.org)

# Future Work

* Main.kt is orginized and understandable, but needs functions to 
    clean it up
* user input is never validated. This won't crash the game, but it 
    does ruin turn order.
* Turn it into a game with GUIs instead of in the terminal