package pageObjects.orangehrm.pim.employee;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.orangehrm.PageGenerator;
import pageUIs.orangeHRM.pim.employee.EmployeeListPUI;

public class EmployeeListPO extends EmployeeTabs {
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
}