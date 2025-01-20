package pageObjects.orangehrm;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.orangehrm.pim.employee.SideBarTabsPO;
import pageUIs.orangeHRM.DashboardPUI;

public class DashboardPO extends SideBarTabsPO {
    private WebDriver driver;

    public DashboardPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Dashboard text is displayed")
    public boolean isDashboardTextDisplayed() {
        waitForElementVisible(driver, DashboardPUI.DASHBOARD_TEXT);
        return isElementDisplayed(driver, DashboardPUI.DASHBOARD_TEXT);
    }
}