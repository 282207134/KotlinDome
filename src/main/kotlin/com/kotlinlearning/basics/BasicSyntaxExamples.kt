package com.kotlinlearning.basics

/**
 * Kotlin 基础语法示例
 * 包含变量定义、函数、控制流等基本语法
 */

/**
 * 运行基础语法示例
 */
fun runBasicSyntaxExamples() {
    variablesExample()
    functionsExample()
    controlFlowExample()
    nullSafetyExample()
}

/**
 * 变量和常量示例
 */
fun variablesExample() {
    println("1. 变量和常量")
    
    // val：只读变量（类似 Java 的 final）
    val readOnly: Int = 10
    println("  只读变量 readOnly = $readOnly")
    
    // var：可变变量
    var mutable: Int = 20
    println("  可变变量 mutable = $mutable")
    mutable = 30
    println("  修改后 mutable = $mutable")
    
    // 类型推断
    val inferredInt = 42  // 自动推断为 Int 类型
    val inferredString = "Hello, Kotlin!"  // 自动推断为 String 类型
    println("  类型推断：inferredInt = $inferredInt, inferredString = $inferredString")
    
    // 字符串模板
    val name = "张三"
    val age = 25
    println("  字符串模板：$name 今年 $age 岁，明年 ${age + 1} 岁")
    println()
}

/**
 * 函数示例
 */
fun functionsExample() {
    println("2. 函数")
    
    // 调用带返回值的函数
    val sum = add(5, 3)
    println("  5 + 3 = $sum")
    
    // 调用表达式体函数
    val product = multiply(4, 7)
    println("  4 * 7 = $product")
    
    // 默认参数和命名参数
    greet()  // 使用默认参数
    greet(name = "李四")
    greet(name = "王五", greeting = "晚上好")
    
    // 可变参数
    val numbers = sumOf(1, 2, 3, 4, 5)
    println("  1 到 5 的和 = $numbers")
    println()
}

/**
 * 带返回值的函数
 */
fun add(a: Int, b: Int): Int {
    return a + b
}

/**
 * 表达式体函数（单行函数）
 */
fun multiply(a: Int, b: Int): Int = a * b

/**
 * 默认参数和命名参数
 */
fun greet(name: String = "访客", greeting: String = "你好") {
    println("  $greeting, $name!")
}

/**
 * 可变参数函数
 */
fun sumOf(vararg numbers: Int): Int {
    var total = 0
    for (num in numbers) {
        total += num
    }
    return total
}

/**
 * 控制流示例
 */
fun controlFlowExample() {
    println("3. 控制流")
    
    // if 表达式
    val max = if (10 > 5) 10 else 5
    println("  max(10, 5) = $max")
    
    // when 表达式（类似其他语言的 switch）
    val grade = 'B'
    val description = when (grade) {
        'A' -> "优秀"
        'B' -> "良好"
        'C' -> "及格"
        'D', 'E' -> "不及格"
        else -> "未知等级"
    }
    println("  等级 $grade 对应：$description")
    
    // when 用于范围检查
    val score = 85
    val level = when (score) {
        in 90..100 -> "优秀"
        in 80..89 -> "良好"
        in 60..79 -> "及格"
        else -> "不及格"
    }
    println("  分数 $score 对应：$level")
    
    // for 循环
    print("  for 循环遍历范围 1..5: ")
    for (i in 1..5) {
        print("$i ")
    }
    println()
    
    // 带步长的循环
    print("  for 循环遍历范围 0..10 步长为 2: ")
    for (i in 0..10 step 2) {
        print("$i ")
    }
    println()
    
    // 倒序循环
    print("  for 循环倒序 5 downTo 1: ")
    for (i in 5 downTo 1) {
        print("$i ")
    }
    println()
    
    // 遍历集合
    val fruits = listOf("苹果", "香蕉", "橙子")
    print("  遍历水果列表: ")
    for (fruit in fruits) {
        print("$fruit ")
    }
    println()
    
    // while 循环
    var count = 0
    print("  while 循环: ")
    while (count < 3) {
        print("$count ")
        count++
    }
    println()
    println()
}

/**
 * 空安全示例
 */
fun nullSafetyExample() {
    println("4. 空安全（Null Safety）")
    
    // 可空类型
    var nullableString: String? = "Hello"
    println("  可空字符串：$nullableString")
    nullableString = null
    println("  设置为 null：$nullableString")
    
    // 安全调用操作符 ?.
    val length = nullableString?.length
    println("  使用 ?. 安全调用：length = $length")
    
    // Elvis 操作符 ?:
    val lengthOrDefault = nullableString?.length ?: 0
    println("  使用 ?: Elvis 操作符：lengthOrDefault = $lengthOrDefault")
    
    // 非空断言 !!（示例：强制当作非空处理）
    nullableString = "Not Null"
    @Suppress("UNNECESSARY_NOT_NULL_ASSERTION")
    val definitelyNotNull = nullableString!!.length
    println("  使用 !! 非空断言：length = $definitelyNotNull")
    
    // let 函数处理可空值
    val testString: String? = null
    testString?.let {
        println("  使用 let 处理非空值：字符串是 '$it'")
    }
    if (testString == null) {
        println("  可空值为 null，let 代码块被跳过")
    }
    val validString: String? = "Kotlin"
    validString?.let {
        println("  再次使用 let：字符串是 '$it'")
    }
    println()
}
