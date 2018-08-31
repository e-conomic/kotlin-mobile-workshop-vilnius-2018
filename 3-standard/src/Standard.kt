/**
 * Created by tudorgk on 29/08/2018.
 * Copyright (C) 2018 Visma e-conomic A/S
 */

object Standard {
    fun testLet() {
        val str: String = "string"

        val result = str.let {
            println("Receiver: $this\n")
            println("Argument: $it\n")

            13
        }
        print("Result: $result\n")
    }

    fun testAlso() {
        val str: String = "string"

        val result = str.also {
            println("Receiver: $this\n")
            println("Argument: $it\n")

            13
        }
        print("Result: $result\n")
    }

    fun testRun1() {
        val str: String = "string"

        val result = run {
            println("Receiver: $this\n")

            13
        }
        print("Result: $result\n")
    }

    fun testRun2() {
        val str: String = "string"

        val result = str.run {
            println("Receiver: $this\n")

            13
        }
        print("Result: $result\n")
    }

    fun testApply() {
        val list: MutableList<String> = mutableListOf("A", "B", "C")

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

        data class DemoDataClass(var param1: Int = 1, var param2: String = "demo")

        val demo = DemoDataClass()

        val result = with(demo) {
            println("Receiver: $this\n")
            println("Param1: $param1\n")
            println("Param2: $param2\n")

            param1 = 2
            param2 = "test"

            13
        }
        print("Result: $result\n")
        print("Original: $demo\n")
    }
}
