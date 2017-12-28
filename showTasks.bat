call runCrudApp.bat
if "%ERRORLEVEL%" == "0" goto runChrome
echo.
echo runCrudApp.bat has some errors, go to runCrudApp,bat for more information.
goto end

:runChrome
start chrome "http://localhost:8080/crud-app/v1/task/getTasks"
if "%ERRORLEVEL%" == "0" goto if "%ERRORLEVEL%" == "0" goto allGood
echo.
echo Unable to start Chrome browser.
goto end

:allGood
echo.
echo All good with "runCrudApp.bat" and the other shit is done as well :) :D

:end
echo.
echo complete!