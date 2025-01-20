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
public class Employee_10_Update_Salary_Details extends BaseTest {
    private WebDriver driver;
    private LoginPO loginPage;
    private DashboardPO dashboardPage;
    private EmployeeListPO employeeListPage;
    private PersonalDetailsPO personalDetailsPage;
    private AddNewEmployeePO addNewEmployeePage;
    private SalaryPO salaryPage;
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

    @Description("Update salary details")
    @Test
    public void Employee_10_Update_Salary_Details() throws FileNotFoundException {
        salaryPage = personalDetailsPage.openSalaryPage();

        salaryPage.clickAddButtonAtAddSalaryComponent();
        salaryPage.enterToSalaryComponentTextbox(getDataTest("salary", "salaryComponentName"));
        salaryPage.selectPayGradeDropdown(getDataTest("salary", "payGradeName"));

        salaryPage.selectPayFrequencyDropdown(getDataTest("salary", "payFrequencyName"));
        salaryPage.selectCurrencyDropdown(getDataTest("salary", "currencyName"));
        salaryPage.enterToAmountTextbox(getDataTest("salary", "salaryAmount"));
        salaryPage.clickToSaveButtonAtSalaryContainer();

        Assert.assertTrue(salaryPage.isSaveSuccessMessageDisplayed(driver));
        salaryPage.waitAllLoadingIconInvisible(driver);
        Assert.assertTrue(salaryPage.isSalaryComponentUpdatedSuccess(getDataTest("salary", "salaryComponentName")));
        Assert.assertTrue(salaryPage.isPayFrequencyUpdatedSuccess(getDataTest("salary", "payFrequencyName")));
        Assert.assertTrue(salaryPage.isCurrencyUpdatedSuccess(getDataTest("salary", "currencyName")));
        Assert.assertTrue(salaryPage.isAmountUpdatedSuccess(getDataTest("salary", "salaryAmount")));
    }

    @AfterClass
    public void afterClass() {
        // Delete employee
        employeeListPage = salaryPage.openToPIMPage();

        employeeListPage.clickToNewRecordCheckbox(employeeID);
        employeeListPage.clickToDeleteRecordButton(employeeID);
        employeeListPage.clickToAcceptDeleteButton();

        Assert.assertTrue(employeeListPage.isEmployeeDeleted(employeeID));

        closeBrowser();
    }
}