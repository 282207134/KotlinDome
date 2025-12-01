package com.kotlinlearning

import com.kotlinlearning.basics.*
import com.kotlinlearning.typechecks.*
import com.kotlinlearning.stdlib.*
import com.kotlinlearning.advanced.*

/**
 * Kotlin 学习项目主程序
 * 
 * 这个项目包含了 Kotlin 语言的核心概念和标准库的使用示例
 * 包括：基础语法、类型检查与自动转换、标准库函数等
 */
fun main() {
    println("=" .repeat(60))
    println("欢迎来到 Kotlin 学习项目！")
    println("=" .repeat(60))
    println()
    
    // 1. 基础语法示例
    println("【第一部分：基础语法】")
    println("-" .repeat(60))
    runBasicSyntaxExamples()
    println()
    
    // 2. 类型检查和自动转换
    println("【第二部分：类型检查和自动转换】")
    println("-" .repeat(60))
    runTypeCheckExamples()
    println()
    
    // 3. 标准库函数示例
    println("【第三部分：标准库函数】")
    println("-" .repeat(60))
    runStandardLibraryExamples()
    println()
    
    // 4. 高级特性
    println("【第四部分：高级特性】")
    println("-" .repeat(60))
    runAdvancedExamples()
    println()
    
    println("=" .repeat(60))
    println("所有示例运行完毕！")
    println("=" .repeat(60))
}
