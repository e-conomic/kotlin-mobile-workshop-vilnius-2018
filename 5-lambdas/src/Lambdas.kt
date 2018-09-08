import kotlin.math.pow

/**
 * Created by tudorgk on 31/08/2018.
 * Copyright (C) 2018 Visma e-conomic A/S
 */

object Lambdas {

    fun demo1() =
        (1..10)
            .map { element -> element * 3 }
            .filter { it.rem(2) == 0 }
            .forEach { println(it.toString() + " ") }

    fun demo2() {
        val function: (String, MutableList<String>) -> Unit =
            { s, list -> list.add(s) }

        val list1 = listOf("A", "B", "C")
        val list2 = mutableListOf("X", "Y", "Z")


        list1.forEach {
            function.invoke(it, list2)
        }

        println(list2)
    }

    fun demo3() {

        val function: (Int, Int) -> Int =
            { a, b -> a + b }

        (1..5)
            .zipWithNext(function)
            .forEach { println(it.toString() + " ") }
    }

    fun demo4() {

        val function: (Float, (Float) -> Float) -> Float =
            { value, func -> func(value) }

        val powerFunction: (Float) -> Float = {
            it.pow(2)
        }

        val list1 = listOf(1f, 2f, 3f, 4f)

        val result = list1.map {
            function(it, powerFunction)
        }

        println(result)
    }
}
