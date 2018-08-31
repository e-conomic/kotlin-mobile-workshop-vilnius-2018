/**
 * Created by tudorgk on 30/08/2018.
 * Copyright (C) 2018 Visma e-conomic A/S
 */

interface Base1 {

    fun generateInt(): Int

}

class BaseImplementation(val param: Int) : Base1 {

    override fun generateInt(): Int = param * 2

}

class Derived(base: Base1) : Base1 by base

fun testDelegation() {
    val base = BaseImplementation(2)
    val derived = Derived(base)

    println(derived.generateInt())
}

class DerivedOverride(base: Base1) : Base1 by base {
    override fun generateInt(): Int = 1000
}

fun testDelegationOverride() {
    val base = BaseImplementation(2)
    val derived = DerivedOverride(base)

    println(derived.generateInt())
}

interface Base2 {

    val param: Int
    fun print()

}

class Base2Implementation(override val param: Int) : Base2 {
    override fun print() {
        println(param)
    }
}

class Derived2(val base: Base2) : Base2 by base {
    override val param: Int = 1000
}

fun testDelegationOverride2() {
    val base = Base2Implementation(2)
    val derived = Derived2(base)

    derived.print()
    println("\n${derived.param}")
    println("\n${derived.base.param}")
}


interface Base3 {

    val param: Int
    fun print(x: Int = param)

}

class Base3Implementation(override val param: Int) : Base3 {
    override fun print(x: Int) {
        println(x)
    }
}

class Derived3(val base: Base3) : Base3 by base {
    override val param: Int = 1000
}

fun testDelegationOverride3() {
    val base = Base3Implementation(2)
    val derived = Derived3(base)

    derived.print()
    println("\n${derived.param}")
    println("\n${derived.base.param}")
}
