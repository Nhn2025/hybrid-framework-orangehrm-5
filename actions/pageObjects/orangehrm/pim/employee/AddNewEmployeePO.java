package pageObjects.orangehrm.pim.employee;

import commons.BasePage;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.page.Page;
import pageObjects.orangehrm.PageGenerator;
import pageUIs.orangeHRM.LoginPUI;

public class AddNewEmployeePO extends BasePage {
    private WebDriver driver;

    public AddNewEmployeePO(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToFirstNameTextbox() {

    }

    public void enterToLastNameTextbox() {

    }

    public String getEmployeeID() {
        return null;
    }

    public PersonalDetailsPO clickToSaveButton() {
        return PageGenerator.getPersonalDetailsPage(driver);
    }
}