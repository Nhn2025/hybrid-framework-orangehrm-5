package pageObjects.orangehrm.pim.employee;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class ContactDetailsPO extends BasePage {
    private WebDriver driver;

    public ContactDetailsPO(WebDriver driver) {
        this.driver = driver;
    }
}