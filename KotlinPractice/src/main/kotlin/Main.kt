

fun main() {
    println("Hello World")

    // variable declaration
    var name = "John"  // var signifies mutable
    val age = 32       // val signifies immutable/constant

    println(name)
    println(age)

    // data types do not need to be declared, but can be
    var newName: String = "Johnny"
    val newAge: Int = 199

    // to declare but not initialize a variable, you need the data type
    var newerName: String
    // var newerName  alone does not work

    // to change a numeric data type, use the built-in function
    var integer: Int = 5
    var floating: Float = integer.toFloat()

    // to access the characters in a string, use brackets
    var text = "Text"
    println(text[0]) // prints 'T'
    println(text[3]) // prints 't'

    // strings are objects, not primitive data types
    println(text.length)  // displays the length of text

    // the compareTo(string) function returns true of both strings are equal
    println(text.compareTo("Text"))  // output of 0 means true

    // to reference variables in a string, use $ before the variable name
    println("My name is $name")

    // booleans
    val x = 10
    val y = 9
    println(x > y) // should return true

    // conditionals
    //if ... else
        // if(condition)
    if (20 > 18) {
        println("20 is greater than 18")

    }else if (20 < 18) {
        println("This is a mistake")

    } else {
        println("Oops, shouldn't be here")
    }

    // when using if in an expression, you must have an else
    val greeting = if (name == "John") {
        "My name is John"
    } else {
        "My name is not John"
    }

    // when can be used for conditionals. It can work like switch-case
    val day = 4
    val result = when (day) {
        1 -> "Monday"
        2 -> "Tuesday"
        3 -> "Wednesday"
        4 -> "Thursday"
        else -> "Weekend"
    }

    // loops
    var i = 0
    while (i < 5) {
        println(i)
        i++
    }

    i = 0
    do {
        println(i)
        i++
    }
        while (i < 5)

    // there is no traditional for loop in Kotlin

    // arrays use arrayOf
    val cars = arrayOf("Volvo", "BMW", "Ford")
    println(cars[0])
    cars[0] = "Opel" // changes array value at index 0

    println(cars.size) //size returns number of elements in the array

    // 'in' works the same as in python
    // the for loop iterates through an array, ranges, and other containers
    for (x in cars) {
        println(x)
    }

    // using ranges
    for (chars in 'a'..'x') {
        println(chars)
    }

    for (nums in 5..15) {
        println(nums)
    }

    myFunction("John")
}

// parameters must have a data type
fun myFunction(fname: String) {
    println("I am myFunction")
    println(fname)
}