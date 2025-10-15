@ECHO OFF

SET DIRNAME=%~dp0
IF "%DIRNAME%"=="" SET DIRNAME=.
SET APP_BASE_NAME=%~n0
SET APP_HOME=%DIRNAME%

SET DEFAULT_JVM_OPTS=-Xmx64m -Xms64m

IF NOT "%JAVA_HOME%"=="" GOTO findJavaFromJavaHome

SET JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
IF "%ERRORLEVEL%" == "0" GOTO init

echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.&goto end

:findJavaFromJavaHome
SET JAVA_EXE=%JAVA_HOME%\bin\java.exe
IF EXIST "%JAVA_EXE%" GOTO init

echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%&goto end

:init
SET CLASSPATH=%APP_HOME%\gradle\wrapper\gradle-wrapper.jar

SET CMD_LINE_ARGS=
:argsLoop
IF "%1"=="" GOTO execute
SET CMD_LINE_ARGS=%CMD_LINE_ARGS% %1
SHIFT
GOTO argsLoop

:execute
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %GRADLE_OPTS% -classpath "%CLASSPATH%" org.gradle.wrapper.GradleWrapperMain %CMD_LINE_ARGS%

:end
EXIT /B %ERRORLEVEL%
