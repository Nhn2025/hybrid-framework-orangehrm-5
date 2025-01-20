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
public class Employee_06_Update_Contact_Details extends BaseTest {
    private WebDriver driver;
    private LoginPO loginPage;
    private DashboardPO dashboardPage;
    private EmployeeListPO employeeListPage;
    private PersonalDetailsPO personalDetailsPage;
    private AddNewEmployeePO addNewEmployeePage;
    private ContactDetailsPO contactDetailsPage;
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

    @Description("Update contact detail")
    @Test
    public void Employee_06_Update_Contact_Detail() throws FileNotFoundException {
        contactDetailsPage = personalDetailsPage.openContactDetailsPage();

        contactDetailsPage.enterToStreetTextbox(getDataTest("contact", "streetName"));
        contactDetailsPage.enterToCityTextbox(getDataTest("contact", "cityName"));
        contactDetailsPage.enterToProvinceTextbox(getDataTest("contact", "provinceName"));
        contactDetailsPage.enterToPostalCodeTextbox(getDataTest("contact", "postalCode"));
        contactDetailsPage.selectCountryDropdown(getDataTest("contact", "countryName"));
        contactDetailsPage.enterToHomeTelephoneTextbox(getDataTest("contact", "phoneNumber"));
        contactDetailsPage.enterToWorkEmailTextbox(getDataTest("contact", "email"));
        contactDetailsPage.clickSaveButtonAtContactDetailContainer();

        Assert.assertTrue(contactDetailsPage.isUpdateSuccessMessageDisplayed(driver));
        contactDetailsPage.waitAllLoadingIconInvisible(driver);
        Assert.assertEquals(contactDetailsPage.getStreetTextboxValue(), getDataTest("contact", "streetName"));
        Assert.assertEquals(contactDetailsPage.getCityTextboxValue(), getDataTest("contact", "cityName"));
        Assert.assertEquals(contactDetailsPage.getProvinceTextboxValue(), getDataTest("contact", "provinceName"));
        Assert.assertEquals(contactDetailsPage.getPostalCodeTextboxValue(), getDataTest("contact", "postalCode"));
        Assert.assertEquals(contactDetailsPage.getCountryDropdownValue(), getDataTest("contact", "countryName"));
        Assert.assertEquals(contactDetailsPage.getHomeTelephoneTextboxValue(), getDataTest("contact", "phoneNumber"));
        Assert.assertEquals(contactDetailsPage.getWorkEmailTextbox(), getDataTest("contact", "email"));
    }

    @AfterClass
    public void afterClass() {
        // Delete employee
        employeeListPage = contactDetailsPage.openToPIMPage();

        employeeListPage.clickToNewRecordCheckbox(employeeID);
        employeeListPage.clickToDeleteRecordButton(employeeID);
        employeeListPage.clickToAcceptDeleteButton();

        Assert.assertTrue(employeeListPage.isEmployeeDeleted(employeeID));

        closeBrowser();
    }
}