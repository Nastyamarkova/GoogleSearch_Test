#!/bin/bash

# Set the GeckoDriver path (update with your actual path)
GECKO_DRIVER_PATH="C:/selenium-webdriver/FirefoxDriver/geckodriver.exe"

# Set the search phrase
SEARCH_PHRASE="Web Development course in Berlin"

# Start the Selenium test
echo "Running Selenium test..."
java -cp "C:\Users\Asus\eclipse-workspace\GoogleSearch_Test:C:\selenium-webdriver\selenium-server-4.12.1.jar" Test_task_Selenium_AM.GoogleSearchTest "$GECKO_DRIVER_PATH" "$SEARCH_PHRASE"