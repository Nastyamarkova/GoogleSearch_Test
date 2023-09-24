@echo off

rem Set the GeckoDriver path (update with your actual path)
set GECKO_DRIVER_PATH="C:/selenium-webdriver/FirefoxDriver/geckodriver.exe"

rem Set the search phrase
set SEARCH_PHRASE="Web Development course in Berlin"

rem Start the Selenium test
echo Running Selenium test...
java -cp "path\to\your\test-jar.jar;path\to\your\selenium-jars\*" Test_task_Selenium_AM.GoogleSearchTest %GECKO_DRIVER_PATH% %SEARCH_PHRASE%