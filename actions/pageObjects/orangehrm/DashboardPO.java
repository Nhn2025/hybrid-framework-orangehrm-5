package pageObjects.orangehrm;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.orangehrm.pim.employee.EmployeeListPO;
import pageUIs.orangeHRM.DashboardPUI;

public class DashboardPO extends BasePage {
    private WebDriver driver;

    public DashboardPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click to PIM page")
    public EmployeeListPO clickToPIMPage() {
        waitForElementClickable(driver, DashboardPUI.PIM_LINK);
        clickToElement(driver, DashboardPUI.PIM_LINK);
        waitForIconLoadingInvisible(driver);
        return PageGenerator.getEmployeeListPage(driver);
    }
}