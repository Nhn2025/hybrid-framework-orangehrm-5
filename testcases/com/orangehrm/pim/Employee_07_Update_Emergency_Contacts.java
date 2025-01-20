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
public class Employee_07_Update_Emergency_Contacts extends BaseTest {
    private WebDriver driver;
    private LoginPO loginPage;
    private DashboardPO dashboardPage;
    private EmployeeListPO employeeListPage;
    private PersonalDetailsPO personalDetailsPage;
    private AddNewEmployeePO addNewEmployeePage;
    private EmergencyContactsPO emergencyContactsPage;
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

    @Description("Update emergency contacts")
    @Test
    public void Employee_07_Update_Emergency_Contacts() throws FileNotFoundException {
        emergencyContactsPage = personalDetailsPage.openEmergencyContactsPage();

        emergencyContactsPage.clickAddButtonAtAssignedEmergencyContacts();
        emergencyContactsPage.enterToNameTextbox(getDataTest("emergency", "emergencyName"));
        emergencyContactsPage.enterToRelationshipTextbox(getDataTest("emergency", "emergencyRelationship"));
        emergencyContactsPage.enterToHomeTelephoneTextbox(getDataTest("emergency", "emergencyHomeTelephone"));
        emergencyContactsPage.clickToSaveButtonAtEmergencyDetailsContainer();

        Assert.assertTrue(emergencyContactsPage.isSaveSuccessMessageDisplayed(driver));
        emergencyContactsPage.waitAllLoadingIconInvisible(driver);
        Assert.assertTrue(emergencyContactsPage.isNameUpdatedSuccess(getDataTest("emergency", "emergencyName")));
        Assert.assertTrue(emergencyContactsPage.isRelationshipUpdatedSuccess(getDataTest("emergency", "emergencyRelationship")));
        Assert.assertTrue(emergencyContactsPage.isHomeTelephoneUpdatedSuccess(getDataTest("emergency", "emergencyHomeTelephone")));

        emergencyContactsPage.clickAddButtonAtAttachments();
        emergencyContactsPage.uploadMultipleFiles(driver, getDataTest("image", "emergencyAttachmentsImageName"));
        emergencyContactsPage.clickToSaveButtonAtEmergencyDetailsContainer();

        Assert.assertTrue(emergencyContactsPage.isSaveSuccessMessageDisplayed(driver));
        emergencyContactsPage.waitAllLoadingIconInvisible(driver);
        Assert.assertTrue(emergencyContactsPage.isAttachmentsImageUpdatedSuccess(getDataTest("image", "emergencyAttachmentsImageName")));
    }

    @AfterClass
    public void afterClass() {
        // Delete employee
        employeeListPage = emergencyContactsPage.openToPIMPage();

        employeeListPage.clickToNewRecordCheckbox(employeeID);
        employeeListPage.clickToDeleteRecordButton(employeeID);
        employeeListPage.clickToAcceptDeleteButton();

        Assert.assertTrue(employeeListPage.isEmployeeDeleted(employeeID));

        closeBrowser();
    }
}