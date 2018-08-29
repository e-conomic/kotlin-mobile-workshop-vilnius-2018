import org.apache.commons.lang3.SerializationUtils
import java.io.Serializable

open class Base : Serializable {
    var baseParam: String? = null
}

data class A(var name: String) : Base(), Serializable

data class B(var aClass: A)


val test1 = A("test1").apply { baseParam = "base1" }
val test2 = test1.copy(name = "test2")
val test3 = SerializationUtils.clone(test1)


var test4 = B(test1)
val test5 = test4.copy()

fun print(instance: A) {
    println(instance.toString() + "\n")
    println(instance.baseParam.toString() + "\n")
}


