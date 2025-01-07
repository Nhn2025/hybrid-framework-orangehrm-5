package pageObjects.orangehrm.pim.employee;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.orangehrm.PageGenerator;
import pageUIs.orangeHRM.pim.employee.AddNewEmployeePUI;

public class AddNewEmployeePO extends BasePage {
    private WebDriver driver;

    public AddNewEmployeePO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Enter to first name text box with value: {0}")
    public void enterToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, AddNewEmployeePUI.FIRSTNAME_TEXTBOX);
        sendKeyToElement(driver, AddNewEmployeePUI.FIRSTNAME_TEXTBOX, firstName);
    }

    @Step("Enter to last name text box with value: {0}")
    public void enterToLastNameTextbox(String lastName) {
        waitForElementVisible(driver, AddNewEmployeePUI.LASTNAME_TEXTBOX);
        sendKeyToElement(driver, AddNewEmployeePUI.LASTNAME_TEXTBOX, lastName);
    }

    @Step("Get employeeID")
    public String getEmployeeID() {
        return getElementAttribute(driver, AddNewEmployeePUI.EMPLOYEE_ID, "value");
    }

    @Step("CLick to save button")
    public PersonalDetailsPO clickToSaveButtonAtEmployeeContainer() {
        waitForElementVisible(driver, AddNewEmployeePUI.SAVE_BUTTON_AT_ADD_EMPLOYEE_CONTAINER);
        clickToElement(driver, AddNewEmployeePUI.SAVE_BUTTON_AT_ADD_EMPLOYEE_CONTAINER);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getPersonalDetailsPage(driver);
    }
}