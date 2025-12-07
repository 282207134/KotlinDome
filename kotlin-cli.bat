@echo off
REM Kotlin 学习 CLI 工具启动脚本 (Windows)

set SCRIPT_DIR=%~dp0
set JAR_FILE=%SCRIPT_DIR%build\libs\kotlin-learning-1.0.0-cli.jar

REM 检查 jar 文件是否存在，如果不存在则构建
if not exist "%JAR_FILE%" (
    echo 🔨 正在构建 CLI 工具...
    cd /d "%SCRIPT_DIR%"
    call gradlew.bat cliJar
)

REM 检查构建是否成功
if not exist "%JAR_FILE%" (
    echo ❌ 构建失败，请检查错误信息
    exit /b 1
)

echo 🚀 启动 Kotlin 学习 CLI 工具...
java -jar "%JAR_FILE%" %*