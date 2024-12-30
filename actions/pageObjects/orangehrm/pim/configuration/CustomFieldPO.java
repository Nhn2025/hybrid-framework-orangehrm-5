package pageObjects.orangehrm.pim.configuration;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class CustomFieldPO extends BasePage {
    private WebDriver driver;

    public CustomFieldPO(WebDriver driver) {
        this.driver = driver;
    }
}