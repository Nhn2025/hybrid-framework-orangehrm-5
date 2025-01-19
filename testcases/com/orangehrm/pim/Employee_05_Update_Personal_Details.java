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
public class Employee_05_Update_Personal_Details extends BaseTest {
    private WebDriver driver;
    private LoginPO loginPage;
    private DashboardPO dashboardPage;
    private EmployeeListPO employeeListPage;
    private PersonalDetailsPO personalDetailsPage;
    private AddNewEmployeePO addNewEmployeePage;
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

    @Description("Update personal detail")
    @Test
    public void Employee_04_Update_Personal_Detail() throws FileNotFoundException {
        personalDetailsPage.openPersonalDetailPage();

        personalDetailsPage.enterToFirstNameTextbox(getDataTest("info", "editFirstName"));
        personalDetailsPage.enterToLastNameTextbox(getDataTest("info", "editLastName"));

        Assert.assertEquals(personalDetailsPage.getEmployeeID(), employeeID);

        personalDetailsPage.enterToDriverLicenseTextbox(getDataTest("license", "driverLicenseNumber"));
        personalDetailsPage.enterToExpiryDateLicenseTextbox(getDataTest("license", "driverLicenseExpiryDate"));
        personalDetailsPage.selectNationalityDropdown(getDataTest("info", "nationality"));
        personalDetailsPage.selectMaritalStatusDropdown(getDataTest("info", "maritalStatus"));
        personalDetailsPage.enterToDateOfBirthTextbox(getDataTest("info", "dateOfBirth"));
        personalDetailsPage.selectGenderMaleRadioButton(getDataTest("info", "gender"));
        personalDetailsPage.clickSaveButtonAtPersonalDetailContainer();

        Assert.assertTrue(personalDetailsPage.isUpdateSuccessMessageDisplayed(driver));
        personalDetailsPage.waitAllLoadingIconInvisible(driver);
        Assert.assertEquals(personalDetailsPage.getFirstNameTextboxValue(), getDataTest("info", "editFirstName"));
        Assert.assertEquals(personalDetailsPage.getLastNameTextboxValue(), getDataTest("info", "editLastName"));
        Assert.assertEquals(personalDetailsPage.getEmployeeID(), employeeID);
        Assert.assertEquals(personalDetailsPage.getExpiryDateLicenseTextboxValue(), getDataTest("license", "driverLicenseExpiryDate"));
        Assert.assertEquals(personalDetailsPage.getNationalityDropdownValue(), getDataTest("info", "nationality"));
        Assert.assertEquals(personalDetailsPage.getMaritalStatusDropdownValue(), getDataTest("info", "maritalStatus"));
        Assert.assertEquals(personalDetailsPage.getDateOfBirthTextboxValue(), getDataTest("info", "dateOfBirth"));
        Assert.assertTrue(personalDetailsPage.isGenderMaleRadioSelected(getDataTest("info", "gender")));
    }

    @AfterClass
    public void afterClass() {
        // Delete employee
        employeeListPage = personalDetailsPage.openToPIMPage();

        employeeListPage.clickToNewRecordCheckbox(employeeID);
        employeeListPage.clickToDeleteRecordButton(employeeID);
        employeeListPage.clickToAcceptDeleteButton();

        Assert.assertTrue(employeeListPage.isEmployeeDeleted(employeeID));

        closeBrowser();
    }
}
