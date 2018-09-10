/**
 * Created by tudorgk on 03/09/2018.
 * Copyright (C) 2018 Visma e-conomic A/S
 */

sealed class FilterExpr

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

data class Predicate(val property: String, val operator: Operator, val value: String) : FilterExpr()
data class Affine(val expression: FilterExpr) : FilterExpr()
data class And(val lhs: FilterExpr, val rhs: FilterExpr) : FilterExpr()
data class Or(val lhs: FilterExpr, val rhs: FilterExpr) : FilterExpr()

fun FilterExpr.evaluate(): String = when (this) {
    is Predicate -> this.property + this.operator.op + this.value
    is Affine -> "(" + this.expression.evaluate() + ")"
    is And -> this.lhs.evaluate() + Operator.And.op + this.rhs.evaluate()
    is Or -> this.lhs.evaluate() + Operator.Or.op + this.rhs.evaluate()
}

infix fun FilterExpr.and(expression: FilterExpr): FilterExpr =
    And(this, expression)

infix fun FilterExpr.or(expression: FilterExpr): FilterExpr =
    Or(this, expression)

infix fun String.filterLike(rhs: String): Predicate =
    Predicate(this, Operator.Like, rhs)

infix fun String.filterEquals(rhs: String): Predicate =
    Predicate(this, Operator.Equals, rhs)

infix fun String.filterGreaterThan(rhs: String): Predicate =
    Predicate(this, Operator.GreaterThan, rhs)

val filter = "name" filterEquals "Joe" and Affine("city" filterLike "*port" or ("age" filterGreaterThan "50"))
