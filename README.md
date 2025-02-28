# Hybrid Framework OrangeHRM 5

## Introduction

Hybrid Framework for UI Automation Testing on **OrangeHRM Ver5** system. The project applies the Page Object Model (POM) combined with Data-Driven and Keyword-Driven Testing.

## Technologies Used

- **Java** – Main programming language.
- **Selenium WebDriver** – UI automation.
- **TestNG** – Test management framework.
- **Allure Report** – Test reporting.
- **SnakeYAML** – Reads YAML configuration files.

## Installation

1. Clone the repository:
   ```sh
   git clone https://github.com/Nhn2025/hybrid-framework-orangehrm-5.git
   ```
2. Install and set up **OrangeHRM locally**:
   - Download the **OrangeHRM** open-source version from [https://www.orangehrm.com/](https://www.orangehrm.com/).
   - Install it on a local web server (e.g., **XAMPP, WAMP, or Docker**).
   - Start the server and ensure the application is accessible.
3. Open the project in IntelliJ IDEA or Eclipse.
4. Ensure required libraries are added to the project manually:
   - **Selenium WebDriver** (`selenium-java-4.23.1.jar`)
   - **TestNG** (`testng-6.14.3.jar`)
   - **Allure Report** (`allure-2.29.0.jar`)
   - **SnakeYAML** (`snakeyaml-2.3.jar`)
5. Add the JAR files to the project's classpath.
   ```sh
   java -cp "libs/*;bin" org.testng.TestNG -d test-output testng.xml
   ```

## Running Tests Using testng.xml

To execute tests using the TestNG XML file, follow these steps:

1. Open `testng.xml` and define the test suite and test classes.
2. Run tests using one of the following methods:
   - **IntelliJ IDEA:**
     - Right-click `testng.xml` and select **Run 'testng.xml'**.
   - **Eclipse:**
     - Right-click `testng.xml` → **Run As** → **TestNG Suite**.

## Folder Structure

- **actions/** – Contains classes handling UI actions.
- **testcases/** – Contains main test scripts.
- **resources/** – Configuration & test data.
- **allure-report/** – Test reports using Allure.
- **uploadFiles/** – Files used for upload testing.
- **libs/** – Contains required JAR files.

## Test Reports

After running tests, open the Allure report using the command:

```sh
allure serve allure-results
``
