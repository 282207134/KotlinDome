#!/bin/bash

# Kotlin 学习 CLI 工具启动脚本

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
JAR_FILE="$SCRIPT_DIR/build/libs/kotlin-learning-1.0.0-cli.jar"

# 检查 jar 文件是否存在，如果不存在则构建
if [ ! -f "$JAR_FILE" ]; then
    echo "🔨 正在构建 CLI 工具..."
    cd "$SCRIPT_DIR"
    ./gradlew cliJar
fi

# 检查构建是否成功
if [ ! -f "$JAR_FILE" ]; then
    echo "❌ 构建失败，请检查错误信息"
    exit 1
fi

echo "🚀 启动 Kotlin 学习 CLI 工具..."
java -jar "$JAR_FILE" "$@"