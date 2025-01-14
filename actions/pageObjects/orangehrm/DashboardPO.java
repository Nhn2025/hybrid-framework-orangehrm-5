package pageObjects.orangehrm;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.orangehrm.pim.employee.EmployeeListPO;
import pageObjects.orangehrm.pim.employee.SideBarTabsPO;
import pageUIs.orangeHRM.DashboardPUI;

public class DashboardPO extends SideBarTabsPO {
    private WebDriver driver;

    public DashboardPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}