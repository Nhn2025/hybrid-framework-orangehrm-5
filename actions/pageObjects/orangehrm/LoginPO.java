package pageObjects.orangehrm;

import commons.BasePage;
import commons.GlobalConstants;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.orangeHRM.LoginPUI;

public class LoginPO extends BasePage {
    private WebDriver driver;

    public LoginPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Enter username to textbox")
    public void enterToUsernameTextbox() {
        waitForElementVisible(driver, LoginPUI.USERNAME_TEXTBOX);
        sendKeyToElement(driver, LoginPUI.USERNAME_TEXTBOX, GlobalConstants.DEV_ADMIN_USERNAME);
    }

    @Step("Enter password to textbox")
    public void enterToPasswordTextbox() {
        waitForElementVisible(driver, LoginPUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, LoginPUI.PASSWORD_TEXTBOX, GlobalConstants.DEV_ADMIN_PASSWORD);
    }

    @Step("CLick login button")
    public DashboardPO clickToLoginButton() {
        waitForElementClickable(driver, LoginPUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPUI.LOGIN_BUTTON);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getDashboardPage(driver);
    }
}