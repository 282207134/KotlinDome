# Kotlin 学习 CLI 工具

## 📖 简介

这是一个交互式的 Kotlin 学习命令行工具，提供用户友好的界面来学习 Kotlin 语言的各种特性。

## 🚀 快速开始

### 方法一：使用启动脚本（推荐）

```bash
# 给脚本添加执行权限
chmod +x kotlin-cli.sh

# 运行 CLI 工具
./kotlin-cli.sh
```

### 方法二：手动构建和运行

```bash
# 构建 CLI 工具
./gradlew cliJar

# 运行 CLI 工具
java -jar build/libs/kotlin-learning-1.0.0-cli.jar
```

### 方法三：使用 Gradle 直接运行

```bash
./gradlew :run --args="--main-class=com.kotlinlearning.CliMainKt"
```

## 🎯 功能特性

- 📚 **交互式菜单**：用户友好的界面，支持键盘导航
- 🎓 **分类学习**：按照不同主题组织学习内容
- 💡 **实时示例**：运行时展示代码示例和输出结果
- 🔧 **自定义练习**：提供额外的练习题目
- ❓ **帮助系统**：内置使用说明和学习建议

## 📋 学习内容

1. **基础语法** - 变量、函数、控制流等基础概念
2. **类型检查和自动转换** - 智能类型系统
3. **标准库函数** - 常用标准库API的使用
4. **高级特性** - 协程、扩展函数等高级概念
5. **自定义练习** - 动手实践和巩固

## 🛠️ 技术实现

- **语言**：Kotlin 1.9.21
- **构建工具**：Gradle 8.5
- **JVM版本**：Java 17
- **打包方式**：可执行 JAR 文件

## 📁 项目结构

```
src/main/kotlin/com/kotlinlearning/
├── Main.kt              # 原始主程序
├── CliMain.kt           # CLI工具入口
├── cli/
│   └── KotlinCliTool.kt # CLI工具核心逻辑
├── basics/              # 基础语法示例
├── typechecks/          # 类型检查示例
├── stdlib/              # 标准库示例
└── advanced/            # 高级特性示例
```

## 💡 使用提示

- 建议按照菜单顺序进行学习
- 每个主题都可以重复选择和查看
- 可以随时查看帮助信息获取学习建议
- 结合源代码理解示例的实现原理

## 🔧 开发说明

### 构建 CLI 工具

```bash
./gradlew cliJar
```

构建完成后，可执行文件位于：
`build/libs/kotlin-learning-1.0.0-cli.jar`

### 自定义扩展

要添加新的学习主题：

1. 在相应的包中创建新的示例文件
2. 在 `KotlinCliTool.kt` 中添加新的菜单选项
3. 实现对应的处理函数

## 📚 更多资源

- [Kotlin 官方文档](https://kotlinlang.org/docs/)
- [Kotlin Koans](https://play.kotlinlang.org/koans)
- [项目源码](src/main/kotlin/com/kotlinlearning/)

## 🎉 享受学习之旅！

希望这个交互式工具能帮助您更好地学习和掌握 Kotlin 语言！