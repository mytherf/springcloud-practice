@echo off
rem /**
rem  * Copyright &copy; 2018-2019  All rights reserved.
rem  *
rem  */
echo.
echo [info] generate jar file.
echo.
pause
echo.

call mvn clean package -Dmaven.test.skip=true

pause