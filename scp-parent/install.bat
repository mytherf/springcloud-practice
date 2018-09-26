@echo off
rem /**
rem  * Copyright &copy; 2016-2017 All rights reserved.
rem  *
rem  */
echo.
echo [info] install parent jar file without test.
echo.
pause
echo.

call mvn clean install -Dmaven.test.skip=true -e

pause