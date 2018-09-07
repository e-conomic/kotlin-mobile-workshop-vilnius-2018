import org.apache.commons.lang3.SerializationUtils
import java.io.Serializable

open class Base : Serializable {
    var baseParam: String? = null
}

data class A(var name: String) : Base(), Serializable
data class B(var aClass: A)


val defaultA = A("test1").apply { baseParam = "base1" }
val defaultACopy = defaultA.copy()
val defaultAClone = SerializationUtils.clone(defaultA)


var defaultB = B(defaultA)
val defaultBCopy = defaultB.copy()

fun printDataClass(instance: A) {
    println(instance.toString() + "\n")
    println(instance.baseParam.toString() + "\n")
}


