#!/usr/bin/env bat
@echo off
set DIRNAME=%~dp0
if "%DIRNAME:~-1%"=="\" set "DIRNAME=%DIRNAME:~0,-1%"
set APP_HOME=%DIRNAME%..
set CLASSPATH=%APP_HOME%\gradle\wrapper\gradle-wrapper.jar
"%JAVA_HOME%\bin\java" -Dorg.gradle.appname=gradlew -cp "%CLASSPATH%" org.gradle.wrapper.GradleWrapperMain %*
