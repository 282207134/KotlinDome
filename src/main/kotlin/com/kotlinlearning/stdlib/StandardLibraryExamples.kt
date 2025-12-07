package com.kotlinlearning.stdlib

/**
 * Kotlin 标准库示例
 * 参考官方文档：https://kotlinlang.org/api/core/kotlin-stdlib/
 */

/**
 * 运行标准库示例
 */
fun runStandardLibraryExamples() {
    println("1. 集合操作")
    collectionsExample()
    println()
    
    println("2. 作用域函数（Scope Functions）")
    scopeFunctionsExample()
    println()
    
    println("3. 字符串处理")
    stringOperationsExample()
    println()
    
    println("4. 序列（Sequences）")
    sequencesExample()
    println()
    
    println("5. 范围和进度（Ranges and Progressions）")
    rangesExample()
    println()
}

/**
 * 集合操作示例
 */
fun collectionsExample() {
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    
    // map：转换集合元素
    val squared = numbers.map { it * it }
    println("  原数组: $numbers")
    println("  平方后: $squared")
    
    // filter：过滤集合元素
    val evenNumbers = numbers.filter { it % 2 == 0 }
    println("  偶数: $evenNumbers")
    
    // find：查找第一个满足条件的元素
    val firstGreaterThanFive = numbers.find { it > 5 }
    println("  第一个大于 5 的数: $firstGreaterThanFive")
    
    // any, all, none：判断集合
    println("  是否有偶数: ${numbers.any { it % 2 == 0 }}")
    println("  是否全是正数: ${numbers.all { it > 0 }}")
    println("  是否没有负数: ${numbers.none { it < 0 }}")
    
    // groupBy：分组
    val grouped = numbers.groupBy { if (it % 2 == 0) "偶数" else "奇数" }
    println("  按奇偶分组: $grouped")
    
    // reduce, fold：归约操作
    val sum = numbers.reduce { acc, num -> acc + num }
    val product = numbers.fold(1) { acc, num -> acc * num }
    println("  求和: $sum")
    println("  求积: $product")
    
    // zip：合并两个集合
    val letters = listOf('A', 'B', 'C')
    val zipped = numbers.take(3).zip(letters)
    println("  合并结果: $zipped")
    
    // partition：将集合分为两部分
    val (even, odd) = numbers.partition { it % 2 == 0 }
    println("  分割后 - 偶数: $even, 奇数: $odd")
}

/**
 * 作用域函数示例
 * let, run, with, apply, also
 */
fun scopeFunctionsExample() {
    // let：常用于可空对象处理
    val nullableValue: String? = "Hello"
    nullableValue?.let { value ->
        println("  let: 值为 '$value', 长度为 ${value.length}")
    }
    
    // run：执行一个代码块并返回结果
    val result = "Kotlin".run {
        println("  run: 在字符串上下文中，this = $this")
        length  // 返回值
    }
    println("  run 返回值: $result")
    
    // with：不是扩展函数，将对象作为参数
    val numbers = mutableListOf(1, 2, 3)
    with(numbers) {
        println("  with: 当前列表大小 = $size")
        add(4)
        add(5)
        println("  with: 添加元素后 = $this")
    }
    
    // apply：配置对象，返回对象本身
    val person = Person().apply {
        name = "张三"
        age = 30
        city = "北京"
    }
    println("  apply: 创建的人员对象 = $person")
    
    // also：附加操作，返回对象本身
    val finalList = mutableListOf(1, 2, 3).also {
        println("  also: 原始列表 = $it")
    }.also {
        it.add(4)
        println("  also: 添加元素后 = $it")
    }
    println("  also: 最终列表 = $finalList")
}

data class Person(
    var name: String = "",
    var age: Int = 0,
    var city: String = ""
)

/**
 * 字符串处理示例
 */
fun stringOperationsExample() {
    val text = "  Kotlin 是一门现代编程语言  "
    
    // 去除空格
    println("  原始: '$text'")
    println("  trim: '${text.trim()}'")
    
    // 字符串分割
    val fruits = "苹果,香蕉,橙子,葡萄"
    val fruitList = fruits.split(",")
    println("  分割: $fruitList")
    
    // 字符串拼接
    val joined = fruitList.joinToString(" | ")
    println("  拼接: $joined")
    
    // 字符串替换
    val replaced = text.replace("Kotlin", "Java")
    println("  替换: '$replaced'")
    
    // 判断字符串内容
    println("  包含 'Kotlin': ${text.contains("Kotlin")}")
    println("  以空格开头: ${text.startsWith(" ")}")
    println("  以空格结尾: ${text.endsWith(" ")}")
    
    // 字符串模板和多行字符串
    val multiline = """
        这是一个多行字符串
        可以包含多行内容
        不需要转义字符
    """.trimIndent()
    println("  多行字符串:\n$multiline")
    
    // take, drop 操作
    val sample = "ABCDEFGH"
    println("  take(3): ${sample.take(3)}")
    println("  drop(3): ${sample.drop(3)}")
    println("  takeLast(3): ${sample.takeLast(3)}")
}

/**
 * 序列示例（惰性求值）
 */
fun sequencesExample() {
    // 序列是惰性求值的，只有在需要时才计算
    val sequence = sequenceOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    
    // 序列操作不会立即执行
    val result = sequence
        .filter { 
            println("    过滤 $it")
            it % 2 == 0 
        }
        .map { 
            println("    映射 $it")
            it * it 
        }
        .take(3)
        .toList()  // 终端操作：触发求值
    
    println("  序列最终结果: $result")
    
    // 使用 generateSequence 生成无限序列
    val fibonacci = generateSequence(Pair(0, 1)) { Pair(it.second, it.first + it.second) }
        .map { it.first }
        .take(10)
        .toList()
    println("  斐波那契数列前 10 项: $fibonacci")
}

/**
 * 范围和进度示例
 */
fun rangesExample() {
    // 范围表达式
    val range1 = 1..10  // 包含 1 到 10
    println("  1..10 包含 5: ${5 in range1}")
    println("  1..10 包含 11: ${11 in range1}")
    
    // until：不包含结束值
    val range2 = 1 until 10  // 包含 1 到 9
    println("  1 until 10 包含 10: ${10 in range2}")
    
    // 字符范围
    val charRange = 'a'..'z'
    println("  'a'..'z' 包含 'm': ${'m' in charRange}")
    
    // 倒序范围
    val countdown = 10 downTo 1
    print("  倒数: ")
    countdown.take(5).forEach { print("$it ") }
    println()
    
    // 带步长的范围
    val stepped = 0..20 step 5
    println("  0..20 step 5: ${stepped.toList()}")
    
    // 检查范围
    when (50) {
        in 1..49 -> println("  50 在 1..49 范围内")
        in 50..100 -> println("  50 在 50..100 范围内")
        else -> println("  50 不在任何范围内")
    }
}
