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
   git clone <repo-url>
   ```
2. Open the project in IntelliJ IDEA or Eclipse.
3. Ensure required libraries are added to the project manually:
   - **Selenium WebDriver** (`selenium-java-4.23.1.jar`)
   - **TestNG** (`testng-6.14.3.jar`)
   - **Allure Report** (`allure-2.29.0.jar`)
   - **SnakeYAML** (`snakeyaml-2.3.jar`)
4. Add the JAR files to the project's classpath.
5. Run tests:
   ```sh
   java -cp "libs/*;bin" org.testng.TestNG testng.xml
   ```

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
```

## Contact
If you have any questions or would like to contribute, please create an issue or email [your-email@example.com].
