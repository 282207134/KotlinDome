package com.kotlinlearning.cli

import com.kotlinlearning.basics.*
import com.kotlinlearning.typechecks.*
import com.kotlinlearning.stdlib.*
import com.kotlinlearning.advanced.*

/**
 * Kotlin 学习命令行工具
 * 
 * 这是一个交互式的命令行工具，提供用户友好的界面来学习 Kotlin
 * 可以选择不同的主题进行学习和练习
 */
object KotlinCliTool {
    
    private var running = true
    
    /**
     * 启动 CLI 工具
     */
    fun start() {
        println("🎉 欢迎使用 Kotlin 学习命令行工具！")
        println()
        
        while (running) {
            showMainMenu()
            val choice = readUserInput()
            processUserChoice(choice)
            println()
        }
    }
    
    /**
     * 显示主菜单
     */
    private fun showMainMenu() {
        println("=".repeat(40))
        println("📚 请选择要学习的主题：")
        println("=".repeat(40))
        println("1️⃣  基础语法")
        println("2️⃣  类型检查和自动转换")
        println("3️⃣  标准库函数")
        println("4️⃣  高级特性")
        println("5️⃣  自定义练习")
        println("6️⃣  帮助信息")
        println("0️⃣  退出程序")
        println("-".repeat(40))
        print("请输入您的选择 (0-6): ")
    }
    
    /**
     * 读取用户输入
     */
    private fun readUserInput(): String {
        return readlnOrNull() ?: ""
    }
    
    /**
     * 处理用户选择
     */
    private fun processUserChoice(choice: String) {
        when (choice) {
            "1" -> runBasicSyntaxExamples()
            "2" -> runTypeCheckExamples()
            "3" -> runStandardLibraryExamples()
            "4" -> runAdvancedExamples()
            "5" -> runCustomExamples()
            "6" -> showHelp()
            "0" -> {
                println("👋 感谢使用 Kotlin 学习工具！再见！")
                running = false
            }
            else -> println("❌ 无效选择，请输入 0-6 之间的数字")
        }
    }
    
    /**
     * 自定义练习示例
     */
    private fun runCustomExamples() {
        println("=".repeat(50))
        println("🛠️  自定义练习示例")
        println("=".repeat(50))
        
        println("\n📝 变量和常量练习：")
        val practiceVariable = "Kotlin"
        val practiceConstant = 2024
        println("编程语言: $practiceVariable, 年份: $practiceConstant")
        
        println("\n🔢 条件判断练习：")
        val number = 42
        val result = if (number > 0) "正数" else "非正数"
        println("数字 $number 是: $result")
        
        println("\n📋 列表操作练习：")
        val numbers = listOf(1, 2, 3, 4, 5)
        val doubled = numbers.map { it * 2 }
        println("原列表: $numbers")
        println("翻倍后: $doubled")
        
        println("\n🎯 函数定义练习：")
        fun greet(name: String) = "你好, $name!"
        println(greet("Kotlin 开发者"))
        
        println("\n✅ 自定义练习完成！")
    }
    
    /**
     * 显示帮助信息
     */
    private fun showHelp() {
        println("=".repeat(50))
        println("❓ 帮助信息")
        println("=".repeat(50))
        
        println("""
🛠️ 工具说明：
这是一个交互式的 Kotlin 学习工具，帮助您逐步学习 Kotlin 语言。

📖 使用方法：
1. 从主菜单选择您感兴趣的主题
2. 查看相关示例代码和输出结果
3. 可以反复选择不同主题进行学习

💡 学习建议：
• 建议按照顺序学习：基础语法 → 类型检查 → 标准库 → 高级特性
• 每个主题都有丰富的示例，请仔细观察输出结果
• 可以结合源代码深入理解每个概念

🚀 进阶学习：
• 查看源码目录下的具体实现文件
• 尝试修改代码并观察结果变化
• 创建自己的练习示例

📚 更多资源：
• Kotlin 官方文档: https://kotlinlang.org/docs/
• Kotlin Koans: https://play.kotlinlang.org/koans
        """.trimIndent())
    }
}