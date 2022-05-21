import  java.util.Scanner
// classes

class Car {
    var brand = ""
    var model = ""
    var year = 0

    constructor(brand: String, model: String, year: Int) {
        this.brand = brand
        this.model = model
        this.year = year
    }


}


// open keyword signifies that this is a parent class
open class ParentClass {
    val x = 5
}

class ChildClass: ParentClass() {
    fun childFunction() {
        println(x)
    }
}

/*class UserInput {
    fun input() {
        userIn = Scanner(System.`in`)\
    }
}*/

fun input(): String? {
   val ui = Scanner(System.`in`)
   return ui.next()
}

fun main() {
    val c1 = Car("ford", "Mustang", 1969)
    /*c1.brand = "Ford"
    c1.model = "Mustang"
    c1.year = 1969*/

    println(c1.brand + c1.model)
    println(c1.year)
    print("Enter your name: ")
    val name = input()
    println("Your name is $name")

}