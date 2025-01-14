package pageObjects.orangehrm.pim.employee;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.orangehrm.DashboardPO;
import pageObjects.orangehrm.PageGenerator;
import pageUIs.orangeHRM.DashboardPUI;
import pageUIs.orangeHRM.pim.employee.SideBarTabsPUI;

public class SideBarTabsPO extends EmployeeTabsPO {
    private WebDriver driver;

    public SideBarTabsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Click to PIM page")
    public EmployeeListPO openToPIMPage() {
        waitForElementClickable(driver, DashboardPUI.PIM_LINK);
        clickToElement(driver, DashboardPUI.PIM_LINK);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getEmployeeListPage(driver);
    }

    @Step("Open Dashboard page")
    public DashboardPO openDashboardPage() {
        waitForElementVisible(driver, SideBarTabsPUI.DASHBOARD_LINK);
        clickToElement(driver, SideBarTabsPUI.DASHBOARD_LINK);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getDashboardPage(driver);
    }
}