call gradlew build
if "%ERRORLEVEL%" == "0" goto rename
echo.
echo GRADLEW BUILD has errors - breaking deploy action
goto fail

:rename
del build\libs\crud-app.war
ren build\libs\crud-app-0.0.1-SNAPSHOT.war crud-app.war
if "%ERRORLEVEL%" == "0" goto stoptomcat
echo Unable to rename the .war file
goto fail

:stoptomcat
call %CATALINA_HOME%\bin\shutdown.bat
echo Tomcat is now offline...

:copyfile
copy build\libs\crud-app.war %CATALINA_HOME%\webapps
if "%ERRORLEVEL%" == "0" goto runtomcat
echo Unable to copy the crud-app.war file
goto fail

:runtomcat
call %CATALINA_HOME%\bin\startup.bat
goto end

:fail
echo.
echo All good with "gradlew.build" and the other shit is done as well :) :D

:end
echo.
echo complete!