#!/usr/bin/env bat

@if "%DEBUG%"=="" @echo off
@rem ##########################################################################
@rem
@rem  Gradle startup script for Windows
@rem
@rem ##########################################################################

@setlocal enabledelayedexpansion

set DIRNAME=%~dp0
if "%DIRNAME:~-1%"=="\" set "DIRNAME=%DIRNAME:~0,-1%"
set APP_HOME=%DIRNAME%..

set CLASSPATH=%APP_HOME%\gradle\wrapper\gradle-wrapper.jar

findstr /M ".*" "%APP_HOME%" >nul
if errorlevel 1 (
    echo Error: JAVA_HOME is not set and no 'java' command could be found in your PATH.
    echo.
    echo Please set the JAVA_HOME variable in your environment.
    exit /b 1
)

"%JAVA_HOME%\bin\java" -Dorg.gradle.appname=gradlew -cp "%CLASSPATH%" org.gradle.wrapper.GradleWrapperMain %*
