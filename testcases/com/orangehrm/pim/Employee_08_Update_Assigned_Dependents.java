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
public class Employee_08_Update_Assigned_Dependents extends BaseTest {
    private WebDriver driver;
    private LoginPO loginPage;
    private DashboardPO dashboardPage;
    private EmployeeListPO employeeListPage;
    private PersonalDetailsPO personalDetailsPage;
    private AddNewEmployeePO addNewEmployeePage;
    private AssignedDependentsPO assignedDependentsPage;
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

    @Description("Update assigned dependents")
    @Test
    public void Employee_08_Update_Assigned_Dependents() throws FileNotFoundException {
        assignedDependentsPage = personalDetailsPage.openAssignedDependentsPage();

        assignedDependentsPage.clickAddButtonAtAssignedDependents();
        assignedDependentsPage.enterToNameTextbox(getDataTest("dependents", "dependentsName"));
        assignedDependentsPage.selectRelationshipDropdown(getDataTest("dependents", "dependentsRelationship"));
        assignedDependentsPage.enterToDateOfBirthTextbox(getDataTest("dependents", "dependentsDateOfBirth"));
        assignedDependentsPage.clickToSaveButtonAtAssignedDependentsContainer();

        Assert.assertTrue(assignedDependentsPage.isSaveSuccessMessageDisplayed(driver));
        assignedDependentsPage.waitAllLoadingIconInvisible(driver);
        Assert.assertTrue(assignedDependentsPage.isNameUpdatedSuccess(getDataTest("dependents", "dependentsName")));
        Assert.assertTrue(assignedDependentsPage.isRelationshipUpdatedSuccess(getDataTest("dependents", "dependentsRelationship")));
        Assert.assertTrue(assignedDependentsPage.isDateOfBirthUpdatedSuccess(getDataTest("dependents", "dependentsDateOfBirth")));

        assignedDependentsPage.clickAddButtonAtAttachments();
        assignedDependentsPage.uploadMultipleFiles(driver, getDataTest("image", "dependentsAttachmentsImageName"));
        assignedDependentsPage.clickToSaveButtonAtAssignedDependentsContainer();

        Assert.assertTrue(assignedDependentsPage.isSaveSuccessMessageDisplayed(driver));
        assignedDependentsPage.waitAllLoadingIconInvisible(driver);
        Assert.assertTrue(assignedDependentsPage.isAttachmentsImageUpdatedSuccess(getDataTest("image", "dependentsAttachmentsImageName")));
    }

    @AfterClass
    public void afterClass() {
        // Delete employee
        employeeListPage = assignedDependentsPage.openToPIMPage();

        employeeListPage.clickToNewRecordCheckbox(employeeID);
        employeeListPage.clickToDeleteRecordButton(employeeID);
        employeeListPage.clickToAcceptDeleteButton();

        Assert.assertTrue(employeeListPage.isEmployeeDeleted(employeeID));

        closeBrowser();
    }
}