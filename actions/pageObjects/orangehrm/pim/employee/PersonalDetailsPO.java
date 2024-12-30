package pageObjects.orangehrm.pim.employee;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class PersonalDetailsPO extends BasePage {
    private WebDriver driver;

    public PersonalDetailsPO(WebDriver driver) {
        this.driver = driver;
    }
}