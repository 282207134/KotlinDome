package com.kotlinlearning.advanced

/**
 * Kotlin 高级特性示例
 */

/**
 * 运行高级特性示例
 */
fun runAdvancedExamples() {
    println("1. 数据类和解构")
    dataClassExample()
    println()
    
    println("2. 密封类与模式匹配")
    sealedClassExample()
    println()
    
    println("3. 扩展函数和扩展属性")
    extensionExample()
    println()
    
    println("4. 高阶函数和内联函数")
    highOrderFunctionExample()
    println()
    
    println("5. 协程基础示例（概念演示）")
    coroutineConceptExample()
    println()
}

/**
 * 数据类示例
 */
data class User(val name: String, val age: Int)

data class Order(val id: String, val amount: Double)

fun dataClassExample() {
    val user = User("Alice", 25)
    println("  用户信息: $user")
    
    // 解构声明
    val (name, age) = user
    println("  解构后: name=$name, age=$age")
    
    // copy 函数
    val olderUser = user.copy(age = 30)
    println("  使用 copy: $olderUser")
    
    // Pair 和 Triple
    val pair = Pair("苹果", 10.5)
    val triple = Triple("香蕉", 20.0, true)
    println("  Pair 示例: ${pair.first}, ${pair.second}")
    println("  Triple 示例: ${triple.first}, ${triple.second}, ${triple.third}")
}

/**
 * 密封类示例
 */
sealed class ApiResult {
    data class Success(val data: String): ApiResult()
    data class Error(val code: Int, val message: String): ApiResult()
    object Loading: ApiResult()
}

fun sealedClassExample() {
    fun handleResult(result: ApiResult): String = when (result) {
        is ApiResult.Success -> "请求成功，数据 = ${result.data}"
        is ApiResult.Error -> "请求失败，错误码 = ${result.code}, 信息 = ${result.message}"
        ApiResult.Loading -> "请求进行中..."
    }
    
    println("  handleResult(Success): ${handleResult(ApiResult.Success("OK"))}")
    println("  handleResult(Error): ${handleResult(ApiResult.Error(404, "Not Found"))}")
    println("  handleResult(Loading): ${handleResult(ApiResult.Loading)}")
}

/**
 * 扩展函数示例
 */
fun String.withBrackets(): String = "[$this]"

val String.firstLetter: Char
    get() = this.first()

fun extensionExample() {
    val text = "Kotlin"
    println("  扩展函数: ${text.withBrackets()}")
    println("  扩展属性: ${text.firstLetter}")
    
    // MutableList 扩展函数
    fun MutableList<Int>.swap(i: Int, j: Int) {
        val temp = this[i]
        this[i] = this[j]
        this[j] = temp
    }
    val list = mutableListOf(1, 2, 3, 4)
    list.swap(0, 3)
    println("  扩展函数 swap 结果: $list")
}

/**
 * 高阶函数示例
 */
inline fun <T> timeCost(block: () -> T): T {
    val start = System.nanoTime()
    val result = block()
    val end = System.nanoTime()
    println("  代码块耗时: ${end - start} ns")
    return result
}

fun highOrderFunctionExample() {
    val names = listOf("Anna", "Bob", "Charlie")
    timeCost {
        val uppercase = names.map { it.uppercase() }
        println("  转大写: $uppercase")
    }
    
    // 函数引用
    val lengthSum = names.sumOf(String::length)
    println("  名字长度总和: $lengthSum")
    
    // 自定义高阶函数
    fun <T> operate(data: List<T>, block: (T) -> Unit) {
        for (item in data) {
            block(item)
        }
    }
    operate(names) {
        println("  operate 输出: $it")
    }
}

/**
 * 协程基础示例（伪代码演示）
 */
fun coroutineConceptExample() {
    println("  注意：此示例为概念演示，未引入 kotlinx-coroutines 依赖")
    println("  Kotlin 协程可以轻松实现异步和并发，在实际项目中可引入 kotlinx-coroutines 库")
    println("  示例：\n    suspend fun fetchData(): String { /* 网络请求 */ }\n    val result = withContext(Dispatchers.IO) { fetchData() }")
}
