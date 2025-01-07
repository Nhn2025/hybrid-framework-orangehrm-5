package com.orangehrm.pim;

import commons.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
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

@Epic("Regression Tests")
@Feature("Login Tests")
public class PIM_01_Employee extends BaseTest {
    private WebDriver driver;
    private LoginPO loginPage;
    private DashboardPO dashboardPage;
    private EmployeeListPO employeeListPage;
    private PersonalDetailsPO personalDetailsPage;
    private AddNewEmployeePO addNewEmployeePage;
    private String employeeID, firstName, lastName, editFirstName, editLastName;
    private String driverLicenseNumber, driverLicenseExpiryDate, nationality, maritalStatus, dateOfBirth, gender;
    private String avatarImageName = "avatar.png";

    @Description("Login to application")
    @Severity(SeverityLevel.MINOR)
    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        driver.manage().window().maximize();
        loginPage = PageGenerator.getLoginPage(driver);

        firstName = "John";
        lastName = "Wick";

        editFirstName = "Donal";
        editLastName = "Trump";
        driverLicenseNumber = "012345667";
        driverLicenseExpiryDate = "2023-09-10";
        nationality = "Vietnamese";
        maritalStatus = "Single";
        dateOfBirth = "2003-09-10";
        gender = "Male";

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

        Dimension beforeUpload = personalDetailsPage.getAvatarSize();

        personalDetailsPage.uploadMultipleFiles(driver, avatarImageName);

        personalDetailsPage.clickToSaveButtonAtProfileContainer();

        Assert.assertTrue(personalDetailsPage.isSuccessMessageDisplayed(driver));

        personalDetailsPage.waitAllLoadingIconInvisible(driver);

        Assert.assertTrue(personalDetailsPage.isProfileAvatarUpdateSuccess(beforeUpload));
    }

    @Description("Personal details")
    @Test
    public void Employee_03_Personal_Details() throws InterruptedException {
        personalDetailsPage.openPersonalDetailPage();

        personalDetailsPage.enterToFirstNameTextbox(editFirstName);
        personalDetailsPage.enterToLastNameTextbox(editLastName);

        Assert.assertEquals(personalDetailsPage.getEmployeeID(), employeeID);

        personalDetailsPage.enterToDriverLicenseTextbox(driverLicenseNumber);
        personalDetailsPage.enterToExpiryDateLicenseTextbox(driverLicenseExpiryDate);
        personalDetailsPage.selectNationalityDropdown(nationality);
        personalDetailsPage.selectMaritalStatusDropdown(maritalStatus);
        personalDetailsPage.enterToDateOfBirthTextbox(dateOfBirth);
        personalDetailsPage.selectGenderMaleRadioButton(gender);
        personalDetailsPage.clickSaveButtonAtPersonalDetailContainer();

        Assert.assertTrue(personalDetailsPage.isSuccessMessageDisplayed(driver));
        personalDetailsPage.waitAllLoadingIconInvisible(driver);

        Assert.assertEquals(personalDetailsPage.getFirstNameTextboxValue(), editFirstName);
        Assert.assertEquals(personalDetailsPage.getLastNameTextboxValue(), editLastName);
        Assert.assertEquals(personalDetailsPage.getEmployeeID(), employeeID);
        Assert.assertEquals(personalDetailsPage.getDriverLicenseTextboxValue(), driverLicenseNumber);
        Assert.assertEquals(personalDetailsPage.getExpiryDateLicenseTextboxValue(), driverLicenseExpiryDate);
        Assert.assertEquals(personalDetailsPage.getNationalityDropdownValue(), nationality);
        Assert.assertEquals(personalDetailsPage.getMaritalStatusDropdownValue(), maritalStatus);
        Assert.assertEquals(personalDetailsPage.getDateOfBirthTextboxValue(), dateOfBirth);
        Assert.assertTrue(personalDetailsPage.isGenderMaleRadioSelected(gender));
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