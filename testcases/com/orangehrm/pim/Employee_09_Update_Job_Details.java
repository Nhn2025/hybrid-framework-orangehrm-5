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
public class Employee_09_Update_Job_Details extends BaseTest {
    private WebDriver driver;
    private LoginPO loginPage;
    private DashboardPO dashboardPage;
    private EmployeeListPO employeeListPage;
    private PersonalDetailsPO personalDetailsPage;
    private AddNewEmployeePO addNewEmployeePage;
    private JobPO jobPage;
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

    @Description("Update job details")
    @Test
    public void Employee_08_Update_Job_Details() throws FileNotFoundException {
        jobPage = personalDetailsPage.openJobPage();

        jobPage.enterToJoinedDateTextbox(getDataTest("job", "joinedDate"));
        jobPage.selectJobTitleDropdown(getDataTest("job", "jobTitle"));
        jobPage.selectJobCategoryDropdown(getDataTest("job", "jobCategory"));
        jobPage.selectLocationDropdown(getDataTest("job", "location"));
        jobPage.selectEmploymentStatusDropdown(getDataTest("job", "employmentStatus"));
        jobPage.clickSaveButtonAtJobContainer();

        Assert.assertTrue(jobPage.isUpdateSuccessMessageDisplayed(driver));
        jobPage.waitAllLoadingIconInvisible(driver);
        Assert.assertEquals(jobPage.getTextJoinedDateTextbox(), getDataTest("job", "joinedDate"));
        Assert.assertEquals(jobPage.getJobTitleDropdownValue(), getDataTest("job", "jobTitle"));
        Assert.assertEquals(jobPage.getJobCategoryDropdownValue(), getDataTest("job", "jobCategory"));
        Assert.assertEquals(jobPage.getLocationDropdownValue(), getDataTest("job", "location"));
        Assert.assertEquals(jobPage.getEmploymentStatusDropdownValue(), getDataTest("job", "employmentStatus"));
    }

    @AfterClass
    public void afterClass() {
        // Delete employee
        employeeListPage = jobPage.openToPIMPage();

        employeeListPage.clickToNewRecordCheckbox(employeeID);
        employeeListPage.clickToDeleteRecordButton(employeeID);
        employeeListPage.clickToAcceptDeleteButton();

        Assert.assertTrue(employeeListPage.isEmployeeDeleted(employeeID));

        closeBrowser();
    }
}