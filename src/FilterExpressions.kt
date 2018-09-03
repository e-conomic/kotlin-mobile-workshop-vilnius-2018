/**
 * Created by tudorgk on 03/09/2018.
 * Copyright (C) 2018 Visma e-conomic A/S
 */

sealed class FilterExpression

enum class Operator(val op: String) {
    And("\$and:"),
    Or("\$or:"),
    Equals("\$eq:"),
    NotEquals("\$neq:"),
    GreaterThan("\$gt:"),
    GreaterThanOrEqual("\$gte:"),
    LessThan("\$lt:"),
    LessThanOrEqual("\$lte:"),
    Like("\$like:"),
    In("\$in:"),
    NotIn("\$nin:")
}

data class Predicate(val property: String, val operator: Operator, val value: String) :
    FilterExpression()

data class Affine(val filterExpression: FilterExpression) : FilterExpression()
data class And(val filterExpression1: FilterExpression, val filterExpression2: FilterExpression) :
    FilterExpression()

data class Or(val filterExpression1: FilterExpression, val filterExpression2: FilterExpression) :
    FilterExpression()

fun FilterExpression.evaluate(): String = when (this) {
    is Predicate -> this.property + this.operator.op + this.value
    is Affine -> "(" + this.filterExpression.evaluate() + ")"
    is And -> this.filterExpression1.evaluate() + Operator.And.op + this.filterExpression2.evaluate()
    is Or -> this.filterExpression1.evaluate() + Operator.Or.op + this.filterExpression2.evaluate()
}

infix fun FilterExpression?.and(expression: FilterExpression): FilterExpression {
    if (this == null) {
        return expression
    }

    return And(this, expression)
}

infix fun FilterExpression?.or(expression: FilterExpression): FilterExpression {
    if (this == null) {
        return expression
    }

    return Or(this, expression)
}

fun FilterExpression?.toMap(): Map<String, String> {
    if (this == null) {
        return mapOf()
    }

    return mapOf("filter" to this.evaluate())
}

// TODO: Add more functions when we need them
infix fun String.filterLike(rhs: String): Predicate {
    return Predicate(this, Operator.Like, rhs)
}

infix fun String.filterEquals(rhs: String): Predicate {
    return Predicate(this, Operator.Equals, rhs)
}

infix fun String.filterGreaterThan(rhs: String): Predicate {
    return Predicate(this, Operator.GreaterThan, rhs)
}
