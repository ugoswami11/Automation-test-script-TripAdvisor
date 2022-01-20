# Automation-test-script-TripAdvisor
This repository contains the automation test script of some scenarios for tripadvisor web application along with documentation.

# About
TripAdvisor is a travel booking platform. The website offers online hotel reservations and bookings for transportation, lodging, travel experiences, and restaurants. The automation script is about searching holiday homes in the provided location, adding filters to the results and collecting info on top 3 listed hotels and their per night prices. Another scenario is also added where from the holiday homes page you will be navigated to the cruises page where the provided results are displayed and the info is captured.

# Pre-Requisite
- Minimum jdk version 8 is required.
- Maven configuration should be done.
- TestNG extension should be downloaded for the respective IDE.

# Steps to configure the project
- Import the project as existing maven project.
- Update the project to download all the dependecies.
- Update the webdriver version according the browser your are using.
- Modify the projectConfig.properties file in src/test/resource/testData with the browser you will be using. chrome || firefox || edge
- Run the project as maven test.

# Key Points
Make sure to use the driver as per you browser version and paste it in the Drivers directory. Check in the below links for the drivers.

- [Chromedriver] (https://chromedriver.chromium.org/downloads) - Chrome browser
- [Geckodriver] (https://github.com/mozilla/geckodriver/releases) - Firefox browser
- [Edgedriver] (https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/) - MIcrosoft edge browser

If the script doesn't work properly make sure to have a look at the xpaths. Check in src/test/java/testObjectRepository for the xpaths provided seperately for each page and in src/test/java/userDeifinedLibraries/Datepicker class to update the calendar xpaths for the holiday homes page.

