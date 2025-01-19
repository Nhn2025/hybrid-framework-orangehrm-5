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

import java.io.FileNotFoundException;

@Epic("Regression Tests")
@Feature("Employee Tests")
public class PIM_Employee extends BaseTest {
    private WebDriver driver;
    private LoginPO loginPage;
    private DashboardPO dashboardPage;
    private EmployeeListPO employeeListPage;
    private PersonalDetailsPO personalDetailsPage;
    private AddNewEmployeePO addNewEmployeePage;
    private ContactDetailsPO contactDetailsPage;
    private EmergencyContactsPO emergencyContactsPage;
    private AssignedDependentsPO assignedDependentsPage;
    private ReportToPO reportToPage;
    private SalaryPO salaryPage;
    private JobPO jobPage;
    private QualificationsPO qualificationsPage;
    private String employeeID;

    @Description("Login to application")
    @Severity(SeverityLevel.MINOR)
    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        driver.manage().window().maximize();
        loginPage = PageGenerator.getLoginPage(driver);

        loginPage.enterToUsernameTextbox();
        loginPage.enterToPasswordTextbox();
        dashboardPage = loginPage.clickToLoginButton();

        Assert.assertTrue(dashboardPage.isDashboardTextDisplayed());
    }

    @Description("Add new employee")
    @Test
    public void Employee_01_Add_New_Employee() throws FileNotFoundException {
        employeeListPage = dashboardPage.openToPIMPage();

        addNewEmployeePage = employeeListPage.clickToAddEmployeeButton();

        addNewEmployeePage.enterToFirstNameTextbox(getDataTest("info", "firstName"));
        addNewEmployeePage.enterToLastNameTextbox(getDataTest("info", "lastName"));

        employeeID = addNewEmployeePage.getEmployeeID();
        personalDetailsPage = addNewEmployeePage.clickToSaveButtonAtEmployeeContainer();
    }

    @Description("Upload avatar")
    @Test
    public void Employee_02_Upload_Avatar() throws FileNotFoundException {
        personalDetailsPage.clickToEmployeeAvatarImage();

        Dimension beforeUpload = personalDetailsPage.getAvatarSize();
        personalDetailsPage.uploadMultipleFiles(driver, getDataTest("image", "avatarImageName"));
        personalDetailsPage.clickToSaveButtonAtProfileContainer();

        Assert.assertTrue(personalDetailsPage.isUpdateSuccessMessageDisplayed(driver));
        personalDetailsPage.waitAllLoadingIconInvisible(driver);
        Assert.assertTrue(personalDetailsPage.isProfileAvatarUpdatedSuccess(beforeUpload));
    }

    @Description("Personal details")
    @Test
    public void Employee_03_Personal_Details() throws InterruptedException, FileNotFoundException {
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

    @Description("Contact details")
    @Test
    public void Employee_04_Contact_Details() throws FileNotFoundException {
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

    @Description("Emergency details")
    @Test
    public void Employee_05_Emergency_Details() throws FileNotFoundException {
        emergencyContactsPage = contactDetailsPage.openEmergencyContactsPage();

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

    @Description("Assigned dependents")
    @Test
    public void Employee_06_Assigned_Dependents() throws FileNotFoundException {
        assignedDependentsPage = emergencyContactsPage.openAssignedDependentsPage();

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

    @Description("Edit view job")
    @Test
    public void Employee_07_Edit_View_Job() throws FileNotFoundException {
        jobPage = assignedDependentsPage.openJobPage();

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

    @Description("Edit view salary")
    @Test
    public void Employee_08_Edit_View_Salary() throws FileNotFoundException {
        salaryPage = emergencyContactsPage.openSalaryPage();

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

    @Description("Edit view Report-to")
    @Test
    public void Employee_09_Edit_View_Report_To() throws FileNotFoundException {
        reportToPage = salaryPage.openReportToPage();

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

    @Description("Qualifications")
    @Test
    public void Employee_10_Qualifications() throws FileNotFoundException {
        qualificationsPage = reportToPage.openQualificationsPage();

        qualificationsPage.clickToAddWorkExperienceButton();
        qualificationsPage.enterToCompanyTextbox(getDataTest("experience", "companyName"));
        qualificationsPage.enterToJobTitleTextbox(getDataTest("experience", "jobTitleExperience"));
        qualificationsPage.enterToStartDateOfWorkTextbox(getDataTest("experience", "startDateOfWork"));
        qualificationsPage.enterToEndDateOfWorkTextbox(getDataTest("experience", "endDateOfWork"));

        qualificationsPage.clickSaveButtonAtQualificationContainer();
        qualificationsPage.waitAllLoadingIconInvisible(driver);

        Assert.assertTrue(qualificationsPage.isCompanyUpdatedSuccess(getDataTest("experience", "companyName")));
        Assert.assertTrue(qualificationsPage.isJobTitleUpdatedSuccess(getDataTest("experience", "jobTitleExperience")));
        Assert.assertTrue(qualificationsPage.isStartDateOfWorkUpdatedSuccess(getDataTest("experience", "jobTitleExperience")));
        Assert.assertTrue(qualificationsPage.isEndDateOfWorkUpdatedSuccess(getDataTest("experience", "endDateOfWork")));

        qualificationsPage.clickToAddEducationButton();
        qualificationsPage.selectEducationLevelDropdown(getDataTest("education", "educationLevel"));
        qualificationsPage.enterToInstituteTextbox(getDataTest("education", "institute"));
        qualificationsPage.enterToYearTextbox(getDataTest("education", "yearEducation"));
        qualificationsPage.enterToMajorTextbox(getDataTest("education", "major"));
        qualificationsPage.enterToScoreTextbox(getDataTest("education", "score"));
        qualificationsPage.enterToStartDateEducationTextbox(getDataTest("education", "startDateEducation"));
        qualificationsPage.enterToEndDateEducationTextbox(getDataTest("education", "endDateEducation"));

        qualificationsPage.clickSaveButtonAtQualificationContainer();
        qualificationsPage.waitAllLoadingIconInvisible(driver);

        Assert.assertTrue(qualificationsPage.isEducationLevelUpdatedSuccess(getDataTest("education", "educationLevel")));
        Assert.assertTrue(qualificationsPage.isYearUpdatedSuccess(getDataTest("education", "yearEducation")));
        Assert.assertTrue(qualificationsPage.isScoreUpdatedSuccess(getDataTest("education", "score")));

        qualificationsPage.clickToAddSkillsButton();
        qualificationsPage.selectSkillDropdown(getDataTest("skill", "skillName"));
        qualificationsPage.enterToYearOfExperienceTextbox(getDataTest("skill", "yearOfExperience"));

        qualificationsPage.clickSaveButtonAtQualificationContainer();
        qualificationsPage.waitAllLoadingIconInvisible(driver);

        Assert.assertTrue(qualificationsPage.isSkillUpdatedSuccess(getDataTest("skill", "skillName")));
        Assert.assertTrue(qualificationsPage.isYearOfExperienceUpdatedSuccess(getDataTest("skill", "yearOfExperience")));

        qualificationsPage.clickToAddLanguageButton();
        qualificationsPage.selectLanguageDropdown(getDataTest("skill", "language"));
        qualificationsPage.selectFluencyDropdown(getDataTest("skill", "fluency"));
        qualificationsPage.selectCompetencyDropdown(getDataTest("skill", "competency"));

        qualificationsPage.clickSaveButtonAtQualificationContainer();
        qualificationsPage.waitAllLoadingIconInvisible(driver);

        Assert.assertTrue(qualificationsPage.isLanguageUpdatedSuccess(getDataTest("skill", "language")));
        Assert.assertTrue(qualificationsPage.isFluencyUpdatedSuccess(getDataTest("skill", "fluency")));
        Assert.assertTrue(qualificationsPage.isCompetencyUpdatedSuccess(getDataTest("skill", "competency")));

        qualificationsPage.clickToAddLicenseButton();
        qualificationsPage.selectLicenseTypeDropdown(getDataTest("license", "licenseName"));
        qualificationsPage.enterToLicenseNumberTextbox(getDataTest("license", "licenseNumber"));
        qualificationsPage.enterToStartDateLicenseTextbox(getDataTest("license", "startDateLicense"));
        qualificationsPage.enterToEndDateLicenseTextbox(getDataTest("license", "endDateLicense"));

        qualificationsPage.clickSaveButtonAtQualificationContainer();
        qualificationsPage.waitAllLoadingIconInvisible(driver);

        Assert.assertTrue(qualificationsPage.isLicenseTypeUpdatedSuccess(getDataTest("license", "licenseName")));
        Assert.assertTrue(qualificationsPage.isStartDateLicenseUpdatedSuccess(getDataTest("license", "startDateLicense")));
        Assert.assertTrue(qualificationsPage.isEndDateLicenseUpdatedSuccess(getDataTest("license", "endDateLicense")));
    }

    @AfterClass
    public void afterClass() {
        employeeListPage = qualificationsPage.openToPIMPage();

        employeeListPage.clickToNewRecordCheckbox(employeeID);
        employeeListPage.clickToDeleteRecordButton(employeeID);
        employeeListPage.clickToAcceptDeleteButton();

        Assert.assertTrue(employeeListPage.isEmployeeDeleted(employeeID));

        closeBrowser();
    }
}