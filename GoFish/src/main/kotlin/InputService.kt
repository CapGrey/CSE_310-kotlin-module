import java.util.Scanner

class InputService {
    var userIn = ""
    private val options = arrayOf("2", "3", "4", "5", "6", "7", "8", "9", "10",
                        "J", "Q", "K", "A")

    fun input() {
        val ui = Scanner(System.`in`)
        userIn = ui.next().uppercase()
    }

    fun confirmInput(): Boolean {
        if (userIn.length != 1) {
            return false
        }
        if (userIn !in options) {
            return false
        }
        return true
    }

}