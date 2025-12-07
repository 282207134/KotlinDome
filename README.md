# Kotlin 学习项目

欢迎使用 Kotlin 学习项目！本项目旨在通过完整的代码示例和详细的中文注释，帮助开发者快速掌握 Kotlin 编程语言的核心概念和标准库的使用。

## 📚 项目简介

本项目基于 [Kotlin 官方文档](https://kotlinlang.org/docs/)，涵盖了以下主要内容：

- **基础语法**：变量、函数、控制流、空安全
- **类型检查与自动转换**：is/!is、智能转换、安全转换
- **标准库函数**：集合操作、作用域函数、字符串处理、序列等
- **高级特性**：数据类、密封类、扩展函数、高阶函数等

## 🚀 快速开始

### 前置要求

- Java JDK 11 或更高版本
- Gradle 8.0+（项目已包含 Gradle Wrapper，无需单独安装）

### 一分钟上手

```bash
# 1. 克隆或下载项目后，进入项目目录
cd kotlin-learning

# 2. 运行所有示例（首次运行会自动下载依赖）
./gradlew run

# Windows 用户使用
gradlew.bat run
```

🎯 **第一次使用？** 请查看 [快速入门指南](docs/快速入门.md)，5 分钟带您了解项目！

### 构建项目

```bash
# 编译项目
./gradlew build

# 清理构建文件
./gradlew clean
```

👉 更详细的环境配置、IDE 使用方式以及学习路线，请参阅 [docs/使用文档.md](docs/使用文档.md)。

## 📖 项目结构

```
kotlin-learning/
├── build.gradle.kts           # Gradle 构建配置
├── settings.gradle.kts        # Gradle 设置文件
├── README.md                  # 项目说明文档（本文件）
├── docs/                      # 详细学习文档
│   ├── 快速入门.md
│   ├── 使用文档.md
│   ├── 01-基础语法.md
│   ├── 02-类型检查与转换.md
│   ├── 03-标准库函数.md
│   └── 04-高级特性.md
└── src/
    └── main/
        └── kotlin/
            └── com/
                └── kotlinlearning/
                    ├── Main.kt                      # 主程序入口
                    ├── basics/                      # 基础语法模块
                    │   └── BasicSyntaxExamples.kt
                    ├── typechecks/                  # 类型检查模块
                    │   └── TypeCheckExamples.kt
                    ├── stdlib/                      # 标准库模块
                    │   └── StandardLibraryExamples.kt
                    └── advanced/                    # 高级特性模块
                        └── AdvancedExamples.kt
```

## 📝 学习模块

### 1. 基础语法

**文件**: `src/main/kotlin/com/kotlinlearning/basics/BasicSyntaxExamples.kt`  
**文档**: [docs/01-基础语法.md](docs/01-基础语法.md)

学习内容：
- 变量与常量（val、var）
- 类型推断
- 函数定义（普通函数、表达式体函数、默认参数、命名参数）
- 控制流（if、when、for、while）
- 空安全（可空类型、?.、?:、!!）

### 2. 类型检查与自动转换

**文件**: `src/main/kotlin/com/kotlinlearning/typechecks/TypeCheckExamples.kt`  
**文档**: [docs/02-类型检查与转换.md](docs/02-类型检查与转换.md)

学习内容：
- is 与 !is 操作符
- 智能类型转换（Smart Cast）
- 安全转换 as?
- 强制转换 as
- when 表达式中的类型判断

### 3. 标准库函数

**文件**: `src/main/kotlin/com/kotlinlearning/stdlib/StandardLibraryExamples.kt`  
**文档**: [docs/03-标准库函数.md](docs/03-标准库函数.md)

学习内容：
- 集合操作（map、filter、reduce、fold 等）
- 作用域函数（let、run、with、apply、also）
- 字符串处理
- 序列（Sequences）
- 范围与进度（Ranges and Progressions）

### 4. 高级特性

**文件**: `src/main/kotlin/com/kotlinlearning/advanced/AdvancedExamples.kt`  
**文档**: [docs/04-高级特性.md](docs/04-高级特性.md)

学习内容：
- 数据类与解构
- 密封类
- 扩展函数与扩展属性
- 高阶函数与内联函数
- 协程概念简介

## 🔗 参考资源

- [Kotlin 官方文档](https://kotlinlang.org/docs/)
- [Kotlin 基础语法](https://kotlinlang.org/docs/basic-syntax.html)
- [Kotlin 标准库 API](https://kotlinlang.org/api/core/kotlin-stdlib/)
- [Kotlin 中文站](https://www.kotlincn.net/)

## 💡 使用建议

1. **按顺序学习**：建议从基础语法开始，逐步深入到高级特性
2. **阅读代码**：每个文件都包含详细的中文注释，仔细阅读代码和注释
3. **运行示例**：通过 `./gradlew run` 运行所有示例，观察输出结果
4. **动手实践**：在理解示例的基础上，尝试修改代码或编写自己的示例
5. **查阅文档**：配合 `docs/` 目录下的详细文档，加深理解

## 📄 许可证

本项目采用 MIT 许可证，可自由用于学习和参考。

## 🤝 贡献

欢迎提交 Issue 和 Pull Request 来改进这个学习项目！

---

祝学习愉快！🎉
