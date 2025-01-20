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
public class Employee_12_Update_Qualifications extends BaseTest {
    private WebDriver driver;
    private LoginPO loginPage;
    private DashboardPO dashboardPage;
    private EmployeeListPO employeeListPage;
    private PersonalDetailsPO personalDetailsPage;
    private AddNewEmployeePO addNewEmployeePage;
    private QualificationsPO qualificationsPage;
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

    @Description("Update qualifications")
    @Test
    public void Employee_12_Update_Qualifications() throws FileNotFoundException {
        qualificationsPage = personalDetailsPage.openQualificationsPage();

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
        // Delete employee
        employeeListPage = qualificationsPage.openToPIMPage();

        employeeListPage.clickToNewRecordCheckbox(employeeID);
        employeeListPage.clickToDeleteRecordButton(employeeID);
        employeeListPage.clickToAcceptDeleteButton();

        Assert.assertTrue(employeeListPage.isEmployeeDeleted(employeeID));

        closeBrowser();
    }
}