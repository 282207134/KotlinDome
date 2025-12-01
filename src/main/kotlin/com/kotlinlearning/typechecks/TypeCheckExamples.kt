package com.kotlinlearning.typechecks

/**
 * 类型检查与自动转换示例
 * 参考官方文档：https://kotlinlang.org/docs/basic-syntax.html#type-checks-and-automatic-casts
 */

/**
 * 运行类型检查示例
 */
fun runTypeCheckExamples() {
    println("1. is 与 !is 类型检查")
    typeCheckWithIs()
    println()
    
    println("2. 智能类型转换（Smart Cast）")
    smartCastExample()
    println()
    
    println("3. 安全类型转换 as? 和非空断言 as")
    safeCastExample()
    println()
    
    println("4. when 与类型判断结合使用")
    whenWithTypeExample()
    println()
    
    println("5. 自定义类型检查逻辑")
    customCheckExample(Person("Alice", 28))
    customCheckExample(Person("Bob", null))
    println()
}

/**
 * 定义基础类层次
 */
open class Shape
class Circle(val radius: Double): Shape()
class Rectangle(val width: Double, val height: Double): Shape()

/**
 * is 和 !is 的基本使用
 */
fun typeCheckWithIs() {
    val shape: Shape = Circle(5.0)
    
    // is：判断对象是否为某类型
    if (shape is Circle) {
        println("  shape 是圆形，半径 = ${shape.radius}")
    } else if (shape is Rectangle) {
        println("  shape 是矩形，宽=${shape.width}, 高=${shape.height}")
    }
    
    // !is：判断对象不是某类型
    if (shape !is Rectangle) {
        println("  shape 不是矩形")
    }
}

/**
 * 智能类型转换：Kotlin 会在类型检查后自动转换
 */
fun smartCastExample() {
    val shape: Shape = Rectangle(3.0, 4.0)
    
    // 当编译器知道在某个分支中对象一定是某类型时，可以直接访问特定属性
    if (shape is Rectangle) {
        // 这里 shape 自动转换为 Rectangle，无需强制转换
        val area = shape.width * shape.height
        println("  矩形面积 = $area")
    }
    
    // 智能转换也适用于 when 表达式
    val description = when (shape) {
        is Circle -> "圆形，半径 = ${shape.radius}"
        is Rectangle -> "矩形，宽=${shape.width}, 高=${shape.height}"
        else -> "未知形状"
    }
    println("  根据类型生成描述：$description")
}

/**
 * as? 安全转换：失败时返回 null
 * as 强制转换：失败时抛出异常
 */
fun safeCastExample() {
    val shape: Shape = Circle(2.5)
    
    // 安全转换（推荐在不确定类型时使用）
    val circle: Circle? = shape as? Circle
    println("  使用 as? 转换结果：${circle?.radius}")
    
    // as 强制转换仅在非常确定类型时使用
    val rectangle: Rectangle? = shape as? Rectangle
    println("  强制转换 rectangle 结果：$rectangle")
    
    // 如果使用 as 进行错误的转换会抛出 ClassCastException
    // val forceRectangle = shape as Rectangle  // 不安全，示例中注释掉
}

/**
 * 高阶 when 表达式与类型判断结合
 */
fun whenWithTypeExample() {
    fun describe(input: Any): String = when (input) {
        is Int -> "整数，值 = $input"
        is String -> "字符串，长度 = ${input.length}"
        is List<*> -> "列表，长度 = ${input.size}"
        is Shape -> when (input) {
            is Circle -> "圆形，半径 = ${input.radius}"
            is Rectangle -> "矩形面积 = ${input.width * input.height}"
            else -> "未知形状"
        }
        else -> "无法识别的类型"
    }
    
    println("  describe(42) => ${describe(42)}")
    println("  describe(\"Hello\") => ${describe("Hello")}")
    println("  describe(listOf(1, 2, 3)) => ${describe(listOf(1, 2, 3))}")
    println("  describe(Rectangle(2.0, 6.0)) => ${describe(Rectangle(2.0, 6.0))}")
}

/**
 * 自定义校验逻辑结合 smart cast
 */
fun customCheckExample(person: Person) {
    if (person.age != null && person.age >= 18) {
        println("  ${person.name} 是成年人，年龄 ${person.age}")
    } else {
        println("  ${person.name} 的年龄未知或未成年")
    }
}

data class Person(val name: String, val age: Int?)
