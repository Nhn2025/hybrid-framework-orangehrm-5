package com.orangehrm.pim;

import commons.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.orangehrm.DashboardPO;
import pageObjects.orangehrm.LoginPO;
import pageObjects.orangehrm.PageGenerator;
import pageObjects.orangehrm.pim.employee.*;

import java.io.FileNotFoundException;

@Epic("Regression Tests")
@Feature("Employee Tests")
public class Employee_11_Update_Report_To extends BaseTest {
    private WebDriver driver;
    private LoginPO loginPage;
    private DashboardPO dashboardPage;
    private EmployeeListPO employeeListPage;
    private PersonalDetailsPO personalDetailsPage;
    private AddNewEmployeePO addNewEmployeePage;
    private ReportToPO reportToPage;
    private String employeeID;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) throws FileNotFoundException {
        driver = getBrowserDriver(browserName, url);
        driver.manage().window().maximize();

        // Login
        loginPage = PageGenerator.getLoginPage(driver);

        loginPage.enterToUsernameTextbox();
        loginPage.enterToPasswordTextbox();
        dashboardPage = loginPage.clickToLoginButton();

        Assert.assertTrue(dashboardPage.isDashboardTextDisplayed());

        // Add new Employee
        employeeListPage = dashboardPage.openToPIMPage();

        addNewEmployeePage = employeeListPage.clickToAddEmployeeButton();

        addNewEmployeePage.enterToFirstNameTextbox(getDataTest("info", "firstName"));
        addNewEmployeePage.enterToLastNameTextbox(getDataTest("info", "lastName"));

        employeeID = addNewEmployeePage.getEmployeeID();
        personalDetailsPage = addNewEmployeePage.clickToSaveButtonAtEmployeeContainer();
    }

    @Description("Update report to")
    @Test
    public void Employee_10_Update_Report_To() throws FileNotFoundException {
        reportToPage = personalDetailsPage.openReportToPage();

        reportToPage.clickAddAssignedSupervisorsButton();
        reportToPage.enterToNameSupervisorsTextBox(getDataTest("supervisors", "supervisorsName"));
        reportToPage.selectNameSupervisorsDropdown();
        reportToPage.selectReportingMethodSupervisorsDropdown(getDataTest("supervisors", "reportingMethodSupervisors"));
        reportToPage.clickSaveButtonAtReportToContainer();

        Assert.assertTrue(reportToPage.isSaveSuccessMessageDisplayed(driver));
        reportToPage.waitAllLoadingIconInvisible(driver);
        Assert.assertTrue(reportToPage.isNameSupervisorsUpdatedSuccess(getDataTest("supervisors", "supervisorsName")));
        Assert.assertTrue(reportToPage.isReportingMethodSupervisorsUpdatedSuccess(getDataTest("supervisors", "reportingMethodSupervisors")));

        reportToPage.clickAddAssignedSubordinatesButton();
        reportToPage.enterToNameSubordinatesTextBox(getDataTest("supervisors", "subordinatesName"));
        reportToPage.selectNameSubordinatesDropdown();
        reportToPage.selectReportingMethodSubordinatesDropdown(getDataTest("supervisors", "reportingMethodSubordinates"));
        reportToPage.clickSaveButtonAtReportToContainer();

        Assert.assertTrue(reportToPage.isSaveSuccessMessageDisplayed(driver));
        reportToPage.waitAllLoadingIconInvisible(driver);
        Assert.assertTrue(reportToPage.isNameSubordinatesUpdatedSuccess(getDataTest("supervisors", "subordinatesName")));
        Assert.assertTrue(reportToPage.isReportingMethodSubordinatesUpdatedSuccess(getDataTest("supervisors", "reportingMethodSubordinates")));
    }

    @AfterClass
    public void afterClass() {
        // Delete employee
        employeeListPage = reportToPage.openToPIMPage();

        employeeListPage.clickToNewRecordCheckbox(employeeID);
        employeeListPage.clickToDeleteRecordButton(employeeID);
        employeeListPage.clickToAcceptDeleteButton();

        Assert.assertTrue(employeeListPage.isEmployeeDeleted(employeeID));

        closeBrowser();
    }
}