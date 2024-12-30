package pageObjects.orangehrm.pim.employee;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class EmployeeListPO extends BasePage {
    private WebDriver driver;

    public EmployeeListPO(WebDriver driver) {
        this.driver = driver;
    }

    public AddNewEmployeePO clickToAddEmployeeButton() {
        return null;
    }
}