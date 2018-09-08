import kotlin.math.pow

/**
 * Created by tudorgk on 29/08/2018.
 * Copyright (C) 2018 Visma e-conomic A/S
 */

object Standard {

    fun testUnwrap() {
        val strABC: String? = "abc"
        strABC?.let { unwrappedStr: String ->
            println("Unwrapped ABC: $unwrappedStr\n")
        }

        val strNull: String? = null
        strNull?.let { unwrappedStr: String ->
            println("Unwrapped Null: $unwrappedStr\n")
        }
    }

    fun testLet() {
        val str: String? = "abc"

        val result = str?.let { unwrappedStr ->
            println("Receiver: $this\n")
            println("Argument: $unwrappedStr\n")

            13
        }
        print("Result: $result\n")
    }

    fun testAlso() {
        val str: String? = "abc"

        val result = str?.also {
            println("Receiver: $this\n")
            println("Argument: $it\n")

            13
        }
        print("Result: $result\n")
    }

    // val defaultA = A("test1").apply { baseParam = "base1" }
    fun testApply() {
        val list = mutableListOf("A", "B", "C")

        val result = list.apply {
            println("Receiver: $this\n")

            add("D")

            13
        }
        print("Result: $result\n")
        print("Original: $list\n")
        print("Same object?: ${result === list}")
    }

    fun testWith() {
        val list = mutableListOf("A", "B", "C")

        val result = with(list) {

            println("Receiver: $this\n")

            add("D")

            13
        }
        print("Result: $result\n")
        print("Original: $list\n")
    }

    fun testChaining() {
        val number: Double? = null

        number?.pow(2)?.let { print("$it\n") }?.let { print("$number\n") }
    }
}
