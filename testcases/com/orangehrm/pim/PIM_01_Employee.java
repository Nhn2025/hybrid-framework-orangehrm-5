package com.orangehrm.pim;

import commons.BaseTest;
import commons.GlobalConstants;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.orangehrm.DashboardPO;
import pageObjects.orangehrm.LoginPO;
import pageObjects.orangehrm.PageGenerator;
import pageObjects.orangehrm.pim.employee.AddNewEmployeePO;
import pageObjects.orangehrm.pim.employee.EmployeeListPO;
import pageObjects.orangehrm.pim.employee.PersonalDetailsPO;

public class PIM_01_Employee extends BaseTest {
    private WebDriver driver;
    private LoginPO loginPage;
    private DashboardPO dashboardPage;
    private EmployeeListPO employeeListPage;
    private PersonalDetailsPO personalDetailsPage;
    private AddNewEmployeePO addNewEmployeePage;
    private String employeeID;

    @Description("Login to application")
    @Severity(SeverityLevel.MINOR)
    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);

        loginPage = PageGenerator.getLoginPage(driver);

        loginPage.enterToUsernameTextbox();
        loginPage.enterToPasswordTextbox();
        dashboardPage = loginPage.clickToLoginButton();
    }

    //@Test
    public void Employee_01_Add_New_Employee() {
        employeeListPage = dashboardPage.clickToPIMPage();

        addNewEmployeePage = employeeListPage.clickToAddEmployeeButton();

        addNewEmployeePage.enterToFirstNameTextbox();
        addNewEmployeePage.enterToLastNameTextbox();
        employeeID = addNewEmployeePage.getEmployeeID();

        personalDetailsPage = addNewEmployeePage.clickToSaveButton();
    }

    @Test
    public void Employee_02_Upload_Avatar() {

    }

    @Test
    public void Employee_03_Personal_Details() {

    }

    @Test
    public void Employee_04_Contact_Details() {

    }

    @Test
    public void Employee_05_Emergency_Details() {

    }

    @Test
    public void Employee_06_Assigned_Dependents() {

    }

    @Test
    public void Employee_07_Edit_View_Job() {

    }

    @Test
    public void Employee_08_Edit_View_Salary() {

    }

    @Test
    public void Employee_09_Edit_View_Tax() {

    }

    @Test
    public void Employee_10_Qualifications() {

    }

    @Test
    public void Employee_11_Search_Employee() {

    }

    @AfterClass
    public void afterClass() {
        closeBrowser();
    }
}