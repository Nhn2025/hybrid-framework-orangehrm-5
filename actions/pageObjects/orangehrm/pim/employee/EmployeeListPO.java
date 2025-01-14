package pageObjects.orangehrm.pim.employee;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.orangehrm.PageGenerator;
import pageUIs.orangeHRM.pim.employee.EmployeeListPUI;

public class EmployeeListPO extends EmployeeTabsPO {
    private WebDriver driver;

    public EmployeeListPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Click to add employee button")
    public AddNewEmployeePO clickToAddEmployeeButton() {
        waitForElementClickable(driver, EmployeeListPUI.EMPLOYEE_NAV_LINK);
        clickToElement(driver, EmployeeListPUI.EMPLOYEE_NAV_LINK);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getAddNewEmployeePage(driver);
    }

    @Step("Click to checkbox new record")
    public void clickToNewRecordCheckbox(String employeeID) {
        checkToCheckboxRadio(driver, EmployeeListPUI.NEW_RECORD_CHECKBOX, employeeID);
    }

    @Step("Click to delete record button")
    public void clickToDeleteRecordButton(String employeeID) {
        waitForElementClickable(driver, EmployeeListPUI.DELETE_RECORD_BUTTON, employeeID);
        clickToElement(driver, EmployeeListPUI.DELETE_RECORD_BUTTON, employeeID);
    }

    @Step("Click to accept delete button")
    public void clickToAcceptDeleteButton() {
        waitForElementClickable(driver, EmployeeListPUI.ACCEPT_DELETE_BUTTON);
        clickToElement(driver, EmployeeListPUI.ACCEPT_DELETE_BUTTON);
    }
}