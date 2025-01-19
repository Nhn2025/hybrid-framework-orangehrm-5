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
    private AssignedDependentsPO assignedDependentsPO;
    private ReportToPO reportToPO;
    private SalaryPO salaryPO;
    private JobPO jobPO;
    private QualificationsPO qualificationsPO;
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
        contactDetailsPO = personalDetailsPage.openContactDetailsPage();

        contactDetailsPO.enterToStreetTextbox(getDataTest("contact", "streetName"));
        contactDetailsPO.enterToCityTextbox(getDataTest("contact", "cityName"));
        contactDetailsPO.enterToProvinceTextbox(getDataTest("contact", "provinceName"));
        contactDetailsPO.enterToPostalCodeTextbox(getDataTest("contact", "postalCode"));
        contactDetailsPO.selectCountryDropdown(getDataTest("contact", "countryName"));
        contactDetailsPO.enterToHomeTelephoneTextbox(getDataTest("contact", "phoneNumber"));
        contactDetailsPO.enterToWorkEmailTextbox(getDataTest("contact", "email"));
        contactDetailsPO.clickSaveButtonAtContactDetailContainer();

        Assert.assertTrue(contactDetailsPO.isUpdateSuccessMessageDisplayed(driver));
        contactDetailsPO.waitAllLoadingIconInvisible(driver);
        Assert.assertEquals(contactDetailsPO.getStreetTextboxValue(), getDataTest("contact", "streetName"));
        Assert.assertEquals(contactDetailsPO.getCityTextboxValue(), getDataTest("contact", "cityName"));
        Assert.assertEquals(contactDetailsPO.getProvinceTextboxValue(), getDataTest("contact", "provinceName"));
        Assert.assertEquals(contactDetailsPO.getPostalCodeTextboxValue(), getDataTest("contact", "postalCode"));
        Assert.assertEquals(contactDetailsPO.getCountryDropdownValue(), getDataTest("contact", "countryName"));
        Assert.assertEquals(contactDetailsPO.getHomeTelephoneTextboxValue(), getDataTest("contact", "phoneNumber"));
        Assert.assertEquals(contactDetailsPO.getWorkEmailTextbox(), getDataTest("contact", "email"));
    }

    @Description("Emergency details")
    @Test
    public void Employee_05_Emergency_Details() throws FileNotFoundException {
        emergencyContactsPO = contactDetailsPO.openEmergencyContactsPage();

        emergencyContactsPO.clickAddButtonAtAssignedEmergencyContacts();
        emergencyContactsPO.enterToNameTextbox(getDataTest("emergency", "emergencyName"));
        emergencyContactsPO.enterToRelationshipTextbox(getDataTest("emergency", "emergencyRelationship"));
        emergencyContactsPO.enterToHomeTelephoneTextbox(getDataTest("emergency", "emergencyHomeTelephone"));
        emergencyContactsPO.clickToSaveButtonAtEmergencyDetailsContainer();

        Assert.assertTrue(emergencyContactsPO.isSaveSuccessMessageDisplayed(driver));
        emergencyContactsPO.waitAllLoadingIconInvisible(driver);
        Assert.assertTrue(emergencyContactsPO.isNameUpdatedSuccess(getDataTest("emergency", "emergencyName")));
        Assert.assertTrue(emergencyContactsPO.isRelationshipUpdatedSuccess(getDataTest("emergency", "emergencyRelationship")));
        Assert.assertTrue(emergencyContactsPO.isHomeTelephoneUpdatedSuccess(getDataTest("emergency", "emergencyHomeTelephone")));

        emergencyContactsPO.clickAddButtonAtAttachments();
        emergencyContactsPO.uploadMultipleFiles(driver, getDataTest("image", "emergencyAttachmentsImageName"));
        emergencyContactsPO.clickToSaveButtonAtEmergencyDetailsContainer();

        Assert.assertTrue(emergencyContactsPO.isSaveSuccessMessageDisplayed(driver));
        emergencyContactsPO.waitAllLoadingIconInvisible(driver);
        Assert.assertTrue(emergencyContactsPO.isAttachmentsImageUpdatedSuccess(getDataTest("image", "emergencyAttachmentsImageName")));
    }

    @Description("Assigned dependents")
    @Test
    public void Employee_06_Assigned_Dependents() throws FileNotFoundException {
        assignedDependentsPO = emergencyContactsPO.openAssignedDependentsPage();

        assignedDependentsPO.clickAddButtonAtAssignedDependents();
        assignedDependentsPO.enterToNameTextbox(getDataTest("dependents", "dependentsName"));
        assignedDependentsPO.selectRelationshipDropdown(getDataTest("dependents", "dependentsRelationship"));
        assignedDependentsPO.enterToDateOfBirthTextbox(getDataTest("dependents", "dependentsDateOfBirth"));
        assignedDependentsPO.clickToSaveButtonAtAssignedDependentsContainer();

        Assert.assertTrue(assignedDependentsPO.isSaveSuccessMessageDisplayed(driver));
        assignedDependentsPO.waitAllLoadingIconInvisible(driver);
        Assert.assertTrue(assignedDependentsPO.isNameUpdatedSuccess(getDataTest("dependents", "dependentsName")));
        Assert.assertTrue(assignedDependentsPO.isRelationshipUpdatedSuccess(getDataTest("dependents", "dependentsRelationship")));
        Assert.assertTrue(assignedDependentsPO.isDateOfBirthUpdatedSuccess(getDataTest("dependents", "dependentsDateOfBirth")));

        assignedDependentsPO.clickAddButtonAtAttachments();
        assignedDependentsPO.uploadMultipleFiles(driver, getDataTest("image", "dependentsAttachmentsImageName"));
        assignedDependentsPO.clickToSaveButtonAtAssignedDependentsContainer();

        Assert.assertTrue(assignedDependentsPO.isSaveSuccessMessageDisplayed(driver));
        assignedDependentsPO.waitAllLoadingIconInvisible(driver);
        Assert.assertTrue(assignedDependentsPO.isAttachmentsImageUpdatedSuccess(getDataTest("image", "dependentsAttachmentsImageName")));
    }

    @Description("Edit view job")
    @Test
    public void Employee_07_Edit_View_Job() throws FileNotFoundException {
        jobPO = assignedDependentsPO.openJobPage();

        jobPO.enterToJoinedDateTextbox(getDataTest("job", "joinedDate"));
        jobPO.selectJobTitleDropdown(getDataTest("job", "jobTitle"));
        jobPO.selectJobCategoryDropdown(getDataTest("job", "jobCategory"));
        jobPO.selectLocationDropdown(getDataTest("job", "location"));
        jobPO.selectEmploymentStatusDropdown(getDataTest("job", "employmentStatus"));
        jobPO.clickSaveButtonAtJobContainer();

        Assert.assertTrue(jobPO.isUpdateSuccessMessageDisplayed(driver));
        jobPO.waitAllLoadingIconInvisible(driver);
        Assert.assertEquals(jobPO.getTextJoinedDateTextbox(), getDataTest("job", "joinedDate"));
        Assert.assertEquals(jobPO.getJobTitleDropdownValue(), getDataTest("job", "jobTitle"));
        Assert.assertEquals(jobPO.getJobCategoryDropdownValue(), getDataTest("job", "jobCategory"));
        Assert.assertEquals(jobPO.getLocationDropdownValue(), getDataTest("job", "location"));
        Assert.assertEquals(jobPO.getEmploymentStatusDropdownValue(), getDataTest("job", "employmentStatus"));
    }

    @Description("Edit view salary")
    @Test
    public void Employee_08_Edit_View_Salary() throws FileNotFoundException {
        salaryPO = emergencyContactsPO.openSalaryPage();

        salaryPO.clickAddButtonAtAddSalaryComponent();
        salaryPO.enterToSalaryComponentTextbox(getDataTest("salary", "salaryComponentName"));
        salaryPO.selectPayGradeDropdown(getDataTest("salary", "payGradeName"));

        salaryPO.selectPayFrequencyDropdown(getDataTest("salary", "payFrequencyName"));
        salaryPO.selectCurrencyDropdown(getDataTest("salary", "currencyName"));
        salaryPO.enterToAmountTextbox(getDataTest("salary", "salaryAmount"));
        salaryPO.clickToSaveButtonAtSalaryContainer();

        Assert.assertTrue(salaryPO.isSaveSuccessMessageDisplayed(driver));
        salaryPO.waitAllLoadingIconInvisible(driver);
        Assert.assertTrue(salaryPO.isSalaryComponentUpdatedSuccess(getDataTest("salary", "salaryComponentName")));
        Assert.assertTrue(salaryPO.isPayFrequencyUpdatedSuccess(getDataTest("salary", "payFrequencyName")));
        Assert.assertTrue(salaryPO.isCurrencyUpdatedSuccess(getDataTest("salary", "currencyName")));
        Assert.assertTrue(salaryPO.isAmountUpdatedSuccess(getDataTest("salary", "salaryAmount")));
    }

    @Description("Edit view Report-to")
    @Test
    public void Employee_09_Edit_View_Report_To() throws FileNotFoundException {
        reportToPO = salaryPO.openReportToPage();

        reportToPO.clickAddAssignedSupervisorsButton();
        reportToPO.enterToNameSupervisorsTextBox(getDataTest("supervisors", "supervisorsName"));
        reportToPO.selectNameSupervisorsDropdown();
        reportToPO.selectReportingMethodSupervisorsDropdown(getDataTest("supervisors", "reportingMethodSupervisors"));
        reportToPO.clickSaveButtonAtReportToContainer();

        Assert.assertTrue(reportToPO.isSaveSuccessMessageDisplayed(driver));
        reportToPO.waitAllLoadingIconInvisible(driver);
        Assert.assertTrue(reportToPO.isNameSupervisorsUpdatedSuccess(getDataTest("supervisors", "supervisorsName")));
        Assert.assertTrue(reportToPO.isReportingMethodSupervisorsUpdatedSuccess(getDataTest("supervisors", "reportingMethodSupervisors")));

        reportToPO.clickAddAssignedSubordinatesButton();
        reportToPO.enterToNameSubordinatesTextBox(getDataTest("supervisors", "subordinatesName"));
        reportToPO.selectNameSubordinatesDropdown();
        reportToPO.selectReportingMethodSubordinatesDropdown(getDataTest("supervisors", "reportingMethodSubordinates"));
        reportToPO.clickSaveButtonAtReportToContainer();

        Assert.assertTrue(reportToPO.isSaveSuccessMessageDisplayed(driver));
        reportToPO.waitAllLoadingIconInvisible(driver);
        Assert.assertTrue(reportToPO.isNameSubordinatesUpdatedSuccess(getDataTest("supervisors", "subordinatesName")));
        Assert.assertTrue(reportToPO.isReportingMethodSubordinatesUpdatedSuccess(getDataTest("supervisors", "reportingMethodSubordinates")));
    }

    @Description("Qualifications")
    @Test
    public void Employee_10_Qualifications() throws FileNotFoundException {
        qualificationsPO = reportToPO.openQualificationsPage();

        qualificationsPO.clickToAddWorkExperienceButton();
        qualificationsPO.enterToCompanyTextbox(getDataTest("experience", "companyName"));
        qualificationsPO.enterToJobTitleTextbox(getDataTest("experience", "jobTitleExperience"));
        qualificationsPO.enterToStartDateOfWorkTextbox(getDataTest("experience", "startDateOfWork"));
        qualificationsPO.enterToEndDateOfWorkTextbox(getDataTest("experience", "endDateOfWork"));

        qualificationsPO.clickSaveButtonAtQualificationContainer();
        qualificationsPO.waitAllLoadingIconInvisible(driver);

        Assert.assertTrue(qualificationsPO.isCompanyUpdatedSuccess(getDataTest("experience", "companyName")));
        Assert.assertTrue(qualificationsPO.isJobTitleUpdatedSuccess(getDataTest("experience", "jobTitleExperience")));
        Assert.assertTrue(qualificationsPO.isStartDateOfWorkUpdatedSuccess(getDataTest("experience", "jobTitleExperience")));
        Assert.assertTrue(qualificationsPO.isEndDateOfWorkUpdatedSuccess(getDataTest("experience", "endDateOfWork")));

        qualificationsPO.clickToAddEducationButton();
        qualificationsPO.selectEducationLevelDropdown(getDataTest("education", "educationLevel"));
        qualificationsPO.enterToInstituteTextbox(getDataTest("education", "institute"));
        qualificationsPO.enterToYearTextbox(getDataTest("education", "yearEducation"));
        qualificationsPO.enterToMajorTextbox(getDataTest("education", "major"));
        qualificationsPO.enterToScoreTextbox(getDataTest("education", "score"));
        qualificationsPO.enterToStartDateEducationTextbox(getDataTest("education", "startDateEducation"));
        qualificationsPO.enterToEndDateEducationTextbox(getDataTest("education", "endDateEducation"));

        qualificationsPO.clickSaveButtonAtQualificationContainer();
        qualificationsPO.waitAllLoadingIconInvisible(driver);

        Assert.assertTrue(qualificationsPO.isEducationLevelUpdatedSuccess(getDataTest("education", "educationLevel")));
        Assert.assertTrue(qualificationsPO.isYearUpdatedSuccess(getDataTest("education", "yearEducation")));
        Assert.assertTrue(qualificationsPO.isScoreUpdatedSuccess(getDataTest("education", "score")));

        qualificationsPO.clickToAddSkillsButton();
        qualificationsPO.selectSkillDropdown(getDataTest("skill", "skillName"));
        qualificationsPO.enterToYearOfExperienceTextbox(getDataTest("skill", "yearOfExperience"));

        qualificationsPO.clickSaveButtonAtQualificationContainer();
        qualificationsPO.waitAllLoadingIconInvisible(driver);

        Assert.assertTrue(qualificationsPO.isSkillUpdatedSuccess(getDataTest("skill", "skillName")));
        Assert.assertTrue(qualificationsPO.isYearOfExperienceUpdatedSuccess(getDataTest("skill", "yearOfExperience")));

        qualificationsPO.clickToAddLanguageButton();
        qualificationsPO.selectLanguageDropdown(getDataTest("skill", "language"));
        qualificationsPO.selectFluencyDropdown(getDataTest("skill", "fluency"));
        qualificationsPO.selectCompetencyDropdown(getDataTest("skill", "competency"));

        qualificationsPO.clickSaveButtonAtQualificationContainer();
        qualificationsPO.waitAllLoadingIconInvisible(driver);

        Assert.assertTrue(qualificationsPO.isLanguageUpdatedSuccess(getDataTest("skill", "language")));
        Assert.assertTrue(qualificationsPO.isFluencyUpdatedSuccess(getDataTest("skill", "fluency")));
        Assert.assertTrue(qualificationsPO.isCompetencyUpdatedSuccess(getDataTest("skill", "competency")));

        qualificationsPO.clickToAddLicenseButton();
        qualificationsPO.selectLicenseTypeDropdown(getDataTest("license", "licenseName"));
        qualificationsPO.enterToLicenseNumberTextbox(getDataTest("license", "licenseNumber"));
        qualificationsPO.enterToStartDateLicenseTextbox(getDataTest("license", "startDateLicense"));
        qualificationsPO.enterToEndDateLicenseTextbox(getDataTest("license", "endDateLicense"));

        qualificationsPO.clickSaveButtonAtQualificationContainer();
        qualificationsPO.waitAllLoadingIconInvisible(driver);

        Assert.assertTrue(qualificationsPO.isLicenseTypeUpdatedSuccess(getDataTest("license", "licenseName")));
        Assert.assertTrue(qualificationsPO.isStartDateLicenseUpdatedSuccess(getDataTest("license", "startDateLicense")));
        Assert.assertTrue(qualificationsPO.isEndDateLicenseUpdatedSuccess(getDataTest("license", "endDateLicense")));
    }

    @AfterClass
    public void afterClass() {
        employeeListPage = qualificationsPO.openToPIMPage();

        employeeListPage.clickToNewRecordCheckbox(employeeID);
        employeeListPage.clickToDeleteRecordButton(employeeID);
        employeeListPage.clickToAcceptDeleteButton();

        Assert.assertTrue(employeeListPage.isEmployeeDeleted(employeeID));

        closeBrowser();
    }
}