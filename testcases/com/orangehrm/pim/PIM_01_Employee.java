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
    private AssignedDependentsPO assignedDependentsPO;
    private ReportToPO reportToPO;
    private SalaryPO salaryPO;
    private JobPO jobPO;
    private QualificationsPO qualificationsPO;
    private String employeeID, firstName, lastName, editFirstName, editLastName;
    private String driverLicenseNumber, driverLicenseExpiryDate, nationality, maritalStatus, dateOfBirth, gender;
    private String streetName, cityName, provinceName, postalCode, countryName, phoneNumber, email;
    private String emergencyName, emergencyRelationship, emergencyHomeTelephone;
    private String dependentsName, dependentsRelationship, dependentsDateOfBirth;
    private String joinedDate, jobTitle, jobCategory, location, employmentStatus;
    private String salaryComponentName, payGradeName, payFrequencyName, currencyName, salaryAmount;
    private String supervisorsName, reportingMethodSupervisors, subordinatesName, reportingMethodSubordinates;
    private String companyName, jobTitleExperience, startDateOfWork, endDateOfWork, educationLevel, institute, major, score;
    private String yearEducation, startDateEducation, endDateEducation, skillName, yearOfExperience, language, fluency;
    private String competency, licenseName, licenseNumber, startDateLicense, endDateLicense;
    private String avatarImageName = "doraemon.png";
    private String emergencyAttachmentsImageName = "nobita.png";
    private String dependentsAttachmentsImageName = "dorami.png";

    @Description("Login to application")
    @Severity(SeverityLevel.MINOR)
    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        driver.manage().window().maximize();
        loginPage = PageGenerator.getLoginPage(driver);

        // Thông tin cá nhân
        firstName = "Thu";
        lastName = "Duong";
        editFirstName = "Dung";
        editLastName = "Duong";
        dateOfBirth = "1995-09-10";
        gender = "Male";
        nationality = "Vietnamese";
        maritalStatus = "Single";

        // Thông tin liên lạc
        postalCode = "900000";
        streetName = "30/04 Street";
        cityName = "Can Tho";
        provinceName = "Ninh Kieu";
        countryName = "Viet Nam";
        phoneNumber = "0388653728";
        email = getEmailRandom();

        // Thông tin khẩn cấp
        emergencyName = "Duong Van An";
        emergencyRelationship = "Brother";
        emergencyHomeTelephone = "03667820298";

        // Thông tin người phụ thuộc
        dependentsName = "Vo Thanh Hoa";
        dependentsRelationship = "Child";
        dependentsDateOfBirth = "2010-09-10";

        // Thông tin công việc
        joinedDate = "2020-10-11";
        jobTitle = "Automation Tester";
        jobCategory = "Technicians";
        location = "Can Tho Branch";
        employmentStatus = "Fulltime Employee";

        // Thông tin lương
        salaryComponentName = "Bonus Salary";
        payGradeName = "Junior";
        payFrequencyName = "Hourly";
        currencyName = "Vietnamese Dong";
        salaryAmount = "10000000";

        // Thông tin giám sát và cấp dưới
        supervisorsName = "Vo Han";
        reportingMethodSupervisors = "Direct";
        subordinatesName = "Nguyen Lan";
        reportingMethodSubordinates = "Indirect";

        // Thông tin kinh nghiệm làm việc
        companyName = "FPT Software";
        jobTitleExperience = "Auto Tester";
        startDateOfWork = "2024-10-11";
        endDateOfWork = "2025-02-03";

        // Thông tin học vấn
        educationLevel = "Dai hoc Can Tho - CT";
        institute = "CNTT";
        major = "He thong thong tin";
        score = "3.8";
        yearEducation = "4";
        startDateEducation = "2021-10-10";
        endDateEducation = "2025-12-12";

        // Thông tin kỹ năng
        skillName = "Java";
        yearOfExperience = "2";
        language = "English";
        fluency = "Writing";
        competency = "Basic";

        // Thông tin chứng chỉ
        licenseName = "ISTQB Advanced";
        licenseNumber = "9201723";
        startDateLicense = "2022-10-11";
        endDateLicense = "2023-10-09";
        driverLicenseNumber = "012345667";
        driverLicenseExpiryDate = "2023-09-10";

        loginPage.enterToUsernameTextbox();
        loginPage.enterToPasswordTextbox();
        dashboardPage = loginPage.clickToLoginButton();
    }

    @Description("Add new employee")
    @Test
    public void Employee_01_Add_New_Employee() {
        employeeListPage = dashboardPage.openToPIMPage();

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
        emergencyContactsPO.enterToNameTextbox(emergencyName);
        emergencyContactsPO.enterToRelationshipTextbox(emergencyRelationship);
        emergencyContactsPO.enterToHomeTelephoneTextbox(emergencyHomeTelephone);
        emergencyContactsPO.clickToSaveButtonAtEmergencyDetailsContainer();

        Assert.assertTrue(emergencyContactsPO.isSaveSuccessMessageDisplayed(driver));
        emergencyContactsPO.waitAllLoadingIconInvisible(driver);
        Assert.assertTrue(emergencyContactsPO.isNameUpdatedSuccess(emergencyName));
        Assert.assertTrue(emergencyContactsPO.isRelationshipUpdatedSuccess(emergencyRelationship));
        Assert.assertTrue(emergencyContactsPO.isHomeTelephoneUpdatedSuccess(emergencyHomeTelephone));

        emergencyContactsPO.clickAddButtonAtAttachments();
        emergencyContactsPO.uploadMultipleFiles(driver, emergencyAttachmentsImageName);
        emergencyContactsPO.clickToSaveButtonAtEmergencyDetailsContainer();

        Assert.assertTrue(emergencyContactsPO.isSaveSuccessMessageDisplayed(driver));
        emergencyContactsPO.waitAllLoadingIconInvisible(driver);
        Assert.assertTrue(emergencyContactsPO.isAttachmentsImageUpdatedSuccess(emergencyAttachmentsImageName));
    }

    @Description("Assigned dependents")
    @Test
    public void Employee_06_Assigned_Dependents() {
        assignedDependentsPO = emergencyContactsPO.openAssignedDependentsPage();

        assignedDependentsPO.clickAddButtonAtAssignedDependents();
        assignedDependentsPO.enterToNameTextbox(dependentsName);
        assignedDependentsPO.selectRelationshipDropdown(dependentsRelationship);
        assignedDependentsPO.enterToDateOfBirthTextbox(dependentsDateOfBirth);
        assignedDependentsPO.clickToSaveButtonAtAssignedDependentsContainer();

        Assert.assertTrue(assignedDependentsPO.isSaveSuccessMessageDisplayed(driver));
        assignedDependentsPO.waitAllLoadingIconInvisible(driver);
        Assert.assertTrue(assignedDependentsPO.isNameUpdatedSuccess(dependentsName));
        Assert.assertTrue(assignedDependentsPO.isRelationshipUpdatedSuccess(dependentsRelationship));
        Assert.assertTrue(assignedDependentsPO.isDateOfBirthUpdatedSuccess(dependentsDateOfBirth));

        assignedDependentsPO.clickAddButtonAtAttachments();
        assignedDependentsPO.uploadMultipleFiles(driver, dependentsAttachmentsImageName);
        assignedDependentsPO.clickToSaveButtonAtAssignedDependentsContainer();

        Assert.assertTrue(assignedDependentsPO.isSaveSuccessMessageDisplayed(driver));
        assignedDependentsPO.waitAllLoadingIconInvisible(driver);
        Assert.assertTrue(assignedDependentsPO.isAttachmentsImageUpdatedSuccess(dependentsAttachmentsImageName));
    }

    @Description("Edit view job")
    @Test
    public void Employee_07_Edit_View_Job() {
        jobPO = assignedDependentsPO.openJobPage();

        jobPO.enterToJoinedDateTextbox(joinedDate);
        jobPO.selectJobTitleDropdown(jobTitle);
        jobPO.selectJobCategoryDropdown(jobCategory);
        jobPO.selectLocationDropdown(location);
        jobPO.selectEmploymentStatusDropdown(employmentStatus);
        jobPO.clickSaveButtonAtJobContainer();

        Assert.assertTrue(jobPO.isUpdateSuccessMessageDisplayed(driver));
        jobPO.waitAllLoadingIconInvisible(driver);
        Assert.assertEquals(jobPO.getTextJoinedDateTextbox(), joinedDate);
        Assert.assertEquals(jobPO.getJobTitleDropdownValue(), jobTitle);
        Assert.assertEquals(jobPO.getJobCategoryDropdownValue(), jobCategory);
        Assert.assertEquals(jobPO.getLocationDropdownValue(), location);
        Assert.assertEquals(jobPO.getEmploymentStatusDropdownValue(), employmentStatus);
    }

    @Description("Edit view salary")
    @Test
    public void Employee_08_Edit_View_Salary() {
        salaryPO = emergencyContactsPO.openSalaryPage();

        salaryPO.clickAddButtonAtAddSalaryComponent();
        salaryPO.enterToSalaryComponentTextbox(salaryComponentName);
        salaryPO.selectPayGradeDropdown(payGradeName);

        salaryPO.selectPayFrequencyDropdown(payFrequencyName);
        salaryPO.selectCurrencyDropdown(currencyName);
        salaryPO.enterToAmountTextbox(salaryAmount);
        salaryPO.clickToSaveButtonAtSalaryContainer();

        Assert.assertTrue(salaryPO.isSaveSuccessMessageDisplayed(driver));
        salaryPO.waitAllLoadingIconInvisible(driver);
        Assert.assertTrue(salaryPO.isSalaryComponentUpdatedSuccess(salaryComponentName));
        Assert.assertTrue(salaryPO.isPayFrequencyUpdatedSuccess(payFrequencyName));
        Assert.assertTrue(salaryPO.isCurrencyUpdatedSuccess(currencyName));
        Assert.assertTrue(salaryPO.isAmountUpdatedSuccess(salaryAmount));
    }

    @Description("Edit view Report-to")
    @Test
    public void Employee_09_Edit_View_Report_To() {
        reportToPO = salaryPO.openReportToPage();

        reportToPO.clickAddAssignedSupervisorsButton();
        reportToPO.enterToNameSupervisorsTextBox(supervisorsName);
        reportToPO.selectNameSupervisorsDropdown();
        reportToPO.selectReportingMethodSupervisorsDropdown(reportingMethodSupervisors);
        reportToPO.clickSaveButtonAtReportToContainer();

        Assert.assertTrue(reportToPO.isSaveSuccessMessageDisplayed(driver));
        reportToPO.waitAllLoadingIconInvisible(driver);
        Assert.assertTrue(reportToPO.isNameSupervisorsUpdatedSuccess(supervisorsName));
        Assert.assertTrue(reportToPO.isReportingMethodSupervisorsUpdatedSuccess(reportingMethodSupervisors));

        reportToPO.clickAddAssignedSubordinatesButton();
        reportToPO.enterToNameSubordinatesTextBox(subordinatesName);
        reportToPO.selectNameSubordinatesDropdown();
        reportToPO.selectReportingMethodSubordinatesDropdown(reportingMethodSubordinates);
        reportToPO.clickSaveButtonAtReportToContainer();

        Assert.assertTrue(reportToPO.isSaveSuccessMessageDisplayed(driver));
        reportToPO.waitAllLoadingIconInvisible(driver);
        Assert.assertTrue(reportToPO.isNameSubordinatesUpdatedSuccess(subordinatesName));
        Assert.assertTrue(reportToPO.isReportingMethodSubordinatesUpdatedSuccess(reportingMethodSubordinates));
    }

    @Description("Qualifications")
    @Test
    public void Employee_10_Qualifications() {
        qualificationsPO = reportToPO.openQualificationsPage();

        qualificationsPO.clickToAddWorkExperienceButton();
        qualificationsPO.enterToCompanyTextbox(companyName);
        qualificationsPO.enterToJobTitleTextbox(jobTitleExperience);
        qualificationsPO.enterToStartDateOfWorkTextbox(startDateOfWork);
        qualificationsPO.enterToEndDateOfWorkTextbox(endDateOfWork);

        qualificationsPO.clickSaveButtonAtQualificationContainer();
        qualificationsPO.waitAllLoadingIconInvisible(driver);

        Assert.assertTrue(qualificationsPO.isCompanyUpdatedSuccess(companyName));
        Assert.assertTrue(qualificationsPO.isJobTitleUpdatedSuccess(jobTitleExperience));
        Assert.assertTrue(qualificationsPO.isStartDateOfWorkUpdatedSuccess(startDateOfWork));
        Assert.assertTrue(qualificationsPO.isEndDateOfWorkUpdatedSuccess(endDateOfWork));

        qualificationsPO.clickToAddEducationButton();
        qualificationsPO.selectEducationLevelDropdown(educationLevel);
        qualificationsPO.enterToInstituteTextbox(institute);
        qualificationsPO.enterToYearTextbox(yearEducation);
        qualificationsPO.enterToMajorTextbox(major);
        qualificationsPO.enterToScoreTextbox(score);
        qualificationsPO.enterToStartDateEducationTextbox(startDateEducation);
        qualificationsPO.enterToEndDateEducationTextbox(endDateEducation);

        qualificationsPO.clickSaveButtonAtQualificationContainer();
        qualificationsPO.waitAllLoadingIconInvisible(driver);

        Assert.assertTrue(qualificationsPO.isEducationLevelUpdatedSuccess(educationLevel));
        Assert.assertTrue(qualificationsPO.isYearUpdatedSuccess(yearEducation));
        Assert.assertTrue(qualificationsPO.isScoreUpdatedSuccess(score));

        qualificationsPO.clickToAddSkillsButton();
        qualificationsPO.selectSkillDropdown(skillName);
        qualificationsPO.enterToYearOfExperienceTextbox(yearOfExperience);

        qualificationsPO.clickSaveButtonAtQualificationContainer();
        qualificationsPO.waitAllLoadingIconInvisible(driver);

        Assert.assertTrue(qualificationsPO.isSkillUpdatedSuccess(skillName));
        Assert.assertTrue(qualificationsPO.isYearOfExperienceUpdatedSuccess(yearOfExperience));

        qualificationsPO.clickToAddLanguageButton();
        qualificationsPO.selectLanguageDropdown(language);
        qualificationsPO.selectFluencyDropdown(fluency);
        qualificationsPO.selectCompetencyDropdown(competency);

        qualificationsPO.clickSaveButtonAtQualificationContainer();
        qualificationsPO.waitAllLoadingIconInvisible(driver);

        Assert.assertTrue(qualificationsPO.isLanguageUpdatedSuccess(language));
        Assert.assertTrue(qualificationsPO.isFluencyUpdatedSuccess(fluency));
        Assert.assertTrue(qualificationsPO.isCompetencyUpdatedSuccess(competency));

        qualificationsPO.clickToAddLicenseButton();
        qualificationsPO.selectLicenseTypeDropdown(licenseName);
        qualificationsPO.enterToLicenseNumberTextbox(licenseNumber);
        qualificationsPO.enterToStartDateLicenseTextbox(startDateLicense);
        qualificationsPO.enterToEndDateLicenseTextbox(endDateLicense);

        qualificationsPO.clickSaveButtonAtQualificationContainer();
        qualificationsPO.waitAllLoadingIconInvisible(driver);

        Assert.assertTrue(qualificationsPO.isLicenseTypeUpdatedSuccess(licenseName));
        Assert.assertTrue(qualificationsPO.isStartDateLicenseUpdatedSuccess(startDateLicense));
        Assert.assertTrue(qualificationsPO.isEndDateLicenseUpdatedSuccess(endDateLicense));
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