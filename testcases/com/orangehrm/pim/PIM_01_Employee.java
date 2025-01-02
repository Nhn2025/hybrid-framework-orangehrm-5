package com.orangehrm.pim;

import commons.BaseTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
    private String employeeID, firstName, lastName;
    private String avatarImageName = "avatar.PNG";

    @Description("Login to application")
    @Severity(SeverityLevel.MINOR)
    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        loginPage = PageGenerator.getLoginPage(driver);

        firstName = "John";
        lastName = "Wick";

        loginPage.enterToUsernameTextbox();
        loginPage.enterToPasswordTextbox();
        dashboardPage = loginPage.clickToLoginButton();
    }

    @Description("Add new employee")
    @Test
    public void Employee_01_Add_New_Employee() {
        employeeListPage = dashboardPage.clickToPIMPage();

        addNewEmployeePage = employeeListPage.clickToAddEmployeeButton();

        addNewEmployeePage.enterToFirstNameTextbox(firstName);
        addNewEmployeePage.enterToLastNameTextbox(lastName);
        employeeID = addNewEmployeePage.getEmployeeID();

        personalDetailsPage = addNewEmployeePage.clickToSaveButtonAtEmployeeContainer();
    }

    @Description("Upload avatar")
    @Test
    public void Employee_02_Upload_Avatar() {
        personalDetailsPage.clickToEmployeeAvatarImage();

        // Lấy ra height/ width của element (avatar) => A
        Dimension beforeUpload = personalDetailsPage.getAvatarSize();
        // Dimension beforeUpload = driver.findElement(By.cssSelector("")).getSize().height;

        personalDetailsPage.uploadMultipleFiles(driver, avatarImageName);

        personalDetailsPage.clickToSaveButtonAtProfileContainer();

        // 1
        personalDetailsPage.isSuccessMessageDisplayed("Successfully Updated");
        //div[contains(@class, 'oxd-toast-content')]/p[text()='Successfully Updated']

        // 2
        personalDetailsPage.waitForIconLoadingInvisible(driver);

        // 3
        Assert.assertTrue(personalDetailsPage.isProfileAvatarUpdateSuccess());
    }

    @Description("Personal details")
    @Test
    public void Employee_03_Personal_Details() {

    }

    @Description("Contact details")
    @Test
    public void Employee_04_Contact_Details() {

    }

    @Description("Emergency details")
    @Test
    public void Employee_05_Emergency_Details() {

    }

    @Description("Assigned dependents")
    @Test
    public void Employee_06_Assigned_Dependents() {

    }

    @Description("Edit view job")
    @Test
    public void Employee_07_Edit_View_Job() {

    }

    @Description("Edit view salary")
    @Test
    public void Employee_08_Edit_View_Salary() {

    }

    @Description("Edit view tax")
    @Test
    public void Employee_09_Edit_View_Tax() {

    }

    @Description("Qualifications")
    @Test
    public void Employee_10_Qualifications() {

    }

    @Description("Search employee")
    @Test
    public void Employee_11_Search_Employee() {

    }

    @AfterClass
    public void afterClass() {
        closeBrowser();
    }
}