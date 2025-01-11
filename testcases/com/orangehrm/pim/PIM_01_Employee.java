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
import pageObjects.orangehrm.pim.employee.*;

@Epic("Regression Tests")
@Feature("Login Tests")
public class PIM_01_Employee extends BaseTest {
    private WebDriver driver;
    private LoginPO loginPage;
    private DashboardPO dashboardPage;
    private EmployeeListPO employeeListPage;
    private PersonalDetailsPO personalDetailsPage;
    private AddNewEmployeePO addNewEmployeePage;
    private ContactDetailsPO contactDetailsPO;
    private EmergencyContactsPO emergencyContactsPO;
    private String employeeID, firstName, lastName, editFirstName, editLastName;
    private String driverLicenseNumber, driverLicenseExpiryDate, nationality, maritalStatus, dateOfBirth, gender;
    private String streetName, cityName, provinceName, postalCode, countryName, phoneNumber, email;
    private String nameEmergency, relationship, homeTelephone;
    private String avatarImageName = "doraemon.png";
    private String attachmentsImageName = "nobita.png";

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
        postalCode = "900000";

        streetName = "30/04 Street";
        cityName = "Can Tho";
        provinceName = "Ninh Kieu";
        countryName = "Viet Nam";
        phoneNumber = "0388653728";
        email = getEmailRandom();

        nameEmergency = "Duong Van An";
        relationship = "Brother";
        homeTelephone = "03667820298";

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

        Assert.assertTrue(personalDetailsPage.isUpdateSuccessMessageDisplayed(driver));

        personalDetailsPage.waitAllLoadingIconInvisible(driver);

        Assert.assertTrue(personalDetailsPage.isProfileAvatarUpdatedSuccess(beforeUpload));
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

        Assert.assertTrue(personalDetailsPage.isUpdateSuccessMessageDisplayed(driver));
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
        contactDetailsPO = personalDetailsPage.openContactDetailsPage();

        contactDetailsPO.enterToStreetTextbox(streetName);
        contactDetailsPO.enterToCityTextbox(cityName);
        contactDetailsPO.enterToProvinceTextbox(provinceName);
        contactDetailsPO.enterToPostalCodeTextbox(postalCode);
        contactDetailsPO.selectCountryDropdown(countryName);
        contactDetailsPO.enterToHomeTelephoneTextbox(phoneNumber);
        contactDetailsPO.enterToWorkEmailTextbox(email);
        contactDetailsPO.clickSaveButtonAtContactDetailContainer();

        Assert.assertTrue(contactDetailsPO.isUpdateSuccessMessageDisplayed(driver));
        contactDetailsPO.waitAllLoadingIconInvisible(driver);

        Assert.assertEquals(contactDetailsPO.getStreetTextboxValue(), streetName);
        Assert.assertEquals(contactDetailsPO.getCityTextboxValue(), cityName);
        Assert.assertEquals(contactDetailsPO.getProvinceTextboxValue(), provinceName);
        Assert.assertEquals(contactDetailsPO.getPostalCodeTextboxValue(), postalCode);
        Assert.assertEquals(contactDetailsPO.getCountryDropdownValue(), countryName);
        Assert.assertEquals(contactDetailsPO.getHomeTelephoneTextboxValue(), phoneNumber);
        Assert.assertEquals(contactDetailsPO.getWorkEmailTextbox(), email);
    }

    @Description("Emergency details")
    @Test
    public void Employee_05_Emergency_Details() {
        emergencyContactsPO = contactDetailsPO.openEmergencyContactsPage();

        emergencyContactsPO.clickAddButtonAtAssignedEmergencyContacts();
        emergencyContactsPO.enterToNameTextbox(nameEmergency);
        emergencyContactsPO.enterToRelationshipTextbox(relationship);
        emergencyContactsPO.enterToHomeTelephoneTextbox(homeTelephone);
        emergencyContactsPO.clickToSaveButtonAtEmergencyDetailsContainer();

        Assert.assertTrue(emergencyContactsPO.isSaveSuccessMessageDisplayed(driver));
        emergencyContactsPO.waitAllLoadingIconInvisible(driver);

        Assert.assertTrue(emergencyContactsPO.isNameTextboxUpdatedSuccess(homeTelephone));
        Assert.assertTrue(emergencyContactsPO.isRelationshipTextboxUpdatedSuccess(relationship));
        Assert.assertTrue(emergencyContactsPO.isHomeTelephoneTextboxUpdatedSuccess(homeTelephone));

        emergencyContactsPO.clickAddButtonAtAttachments();
        emergencyContactsPO.uploadMultipleFiles(driver, attachmentsImageName);

        emergencyContactsPO.clickToSaveButtonAtEmergencyDetailsContainer();

        Assert.assertTrue(emergencyContactsPO.isSaveSuccessMessageDisplayed(driver));
        emergencyContactsPO.waitAllLoadingIconInvisible(driver);

        Assert.assertTrue(emergencyContactsPO.isAttachmentsImageUpdatedSuccess(attachmentsImageName));
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