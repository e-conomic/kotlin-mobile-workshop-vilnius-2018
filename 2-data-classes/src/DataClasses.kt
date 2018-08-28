open class Base {
    var baseParam: String? = null
}

data class A(val name: String) : Base()

val test1 = A("test1").apply { baseParam = "base1" }
val test2 = test1.copy(name = "test2")

fun print(instance: A) {
    println(instance.toString() + "\n")
    println(instance.baseParam.toString() + "\n")
}
