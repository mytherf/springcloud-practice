@echo off
rem /**
rem  * Copyright &copy; 2016-2017   All rights reserved.
rem  *
rem  */
echo.
echo [info] generate jar file.
echo.
pause
echo.

call mvn clean package -Dmaven.test.skip=true

pause