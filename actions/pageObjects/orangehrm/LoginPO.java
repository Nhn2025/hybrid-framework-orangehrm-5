package pageObjects.orangehrm;

import commons.BasePage;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.page.Page;
import pageUIs.orangeHRM.LoginPUI;

public class LoginPO extends BasePage {
    private WebDriver driver;

    public LoginPO(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToUsernameTextbox() {
        waitForElementVisible(driver, LoginPUI.USERNAME_TEXTBOX);
        sendKeyToElement(driver, LoginPUI.USERNAME_TEXTBOX, GlobalConstants.DEV_ADMIN_USERNAME);
    }

    public void enterToPasswordTextbox() {
        waitForElementVisible(driver, LoginPUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, LoginPUI.PASSWORD_TEXTBOX, GlobalConstants.DEV_ADMIN_PASSWORD);
    }

    public DashboardPO clickToLoginButton() {
        waitForElementClickable(driver, LoginPUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPUI.LOGIN_BUTTON);
        return PageGenerator.getDashboardPage(driver);
    }
}