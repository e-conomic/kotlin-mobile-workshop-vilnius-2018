import kotlin.concurrent.thread

var a: String? = null

fun changeForever() {
    thread {
        while (true) {
            randomVariableSetter()
        }
    }
}

@Synchronized
fun randomVariableSetter() {
    a = if (listOf(true, false).shuffled().first()) {
        "test"
    } else {
        null
    }
}

@Synchronized
fun variableChecker() {
    if (a != null) {
        println("Variable a has value $a\n")
    } else {
        println("NULL!\n")
    }
}

fun unwrappedVariableChecker() {
    a?.also {
        println("Variable a has value $it\n")
    } ?: println("NULL!\n")
}




