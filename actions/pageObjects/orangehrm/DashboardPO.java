package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;
import pageObjects.orangehrm.pim.employee.SideBarTabsPO;
import pageUIs.orangeHRM.DashboardPUI;

public class DashboardPO extends SideBarTabsPO {
    private WebDriver driver;

    public DashboardPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isDashboardTextDisplayed() {
        waitForElementVisible(driver, DashboardPUI.DASHBOARD_TEXT);
        return isElementDisplayed(driver, DashboardPUI.DASHBOARD_TEXT);
    }
}