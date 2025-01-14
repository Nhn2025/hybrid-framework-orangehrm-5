package pageObjects.orangehrm.pim.employee;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.orangeHRM.pim.employee.QualificationsPUI;

public class QualificationsPO extends SideBarTabsPO {
    private WebDriver driver;

    public QualificationsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Click to add work experience button")
    public void clickToAddWorkExperienceButton() {
        waitForElementClickable(driver, QualificationsPUI.ADD_WORK_EXPERIENCE_BUTTON);
        clickToElement(driver, QualificationsPUI.ADD_WORK_EXPERIENCE_BUTTON);
    }

    @Step("Enter to company textbox")
    public void enterToCompanyTextbox(String companyName) {
        waitForElementVisible(driver, QualificationsPUI.COMPANY_TEXTBOX);
        sendKeyToElement(driver, QualificationsPUI.COMPANY_TEXTBOX, companyName);
    }

    @Step("Enter to job title textbox")
    public void enterToJobTitleTextbox(String jobTitleExperience) {
        waitForElementVisible(driver, QualificationsPUI.JOB_TITLE_TEXTBOX);
        sendKeyToElement(driver, QualificationsPUI.JOB_TITLE_TEXTBOX, jobTitleExperience);
    }

    @Step("Enter to start date of work textbox")
    public void enterToStartDateOfWorkTextbox(String startDateOfWork) {
        waitForElementVisible(driver, QualificationsPUI.START_DATE_OF_WORK_TEXTBOX);
        sendKeyToElement(driver, QualificationsPUI.START_DATE_OF_WORK_TEXTBOX, startDateOfWork);
    }

    @Step("Enter to end date of work textbox")
    public void enterToEndDateOfWorkTextbox(String endDateOfWork) {
        waitForElementVisible(driver, QualificationsPUI.END_DATE_OF_WORK_TEXTBOX);
        sendKeyToElement(driver, QualificationsPUI.END_DATE_OF_WORK_TEXTBOX, endDateOfWork);
    }

    @Step("Company is updated success")
    public boolean isCompanyUpdatedSuccess(String companyName) {
        waitForElementVisible(driver, QualificationsPUI.COMPANY_NAME_COLUMN, companyName);
        return isElementDisplayed(driver, QualificationsPUI.COMPANY_NAME_COLUMN, companyName);
    }

    @Step("Job title is updated success")
    public boolean isJobTitleUpdatedSuccess(String jobTitleExperience) {
        waitForElementVisible(driver, QualificationsPUI.JOB_TITLE_COLUMN, jobTitleExperience);
        return isElementDisplayed(driver, QualificationsPUI.JOB_TITLE_COLUMN, jobTitleExperience);
    }

    @Step("Start date of work is updated")
    public boolean isStartDateOfWorkUpdatedSuccess(String startDateOfWork) {
        waitForElementVisible(driver, QualificationsPUI.START_DATE_OF_WORK_COLUMN, startDateOfWork);
        return isElementDisplayed(driver, QualificationsPUI.START_DATE_OF_WORK_COLUMN, startDateOfWork);
    }

    @Step("End date of work is updated success")
    public boolean isEndDateOfWorkUpdatedSuccess(String endDateOfWork) {
        waitForElementVisible(driver, QualificationsPUI.END_DATE_OF_WORK_COLUMN, endDateOfWork);
        return isElementDisplayed(driver, QualificationsPUI.END_DATE_OF_WORK_COLUMN, endDateOfWork);
    }

    @Step("Click to add education button")
    public void clickToAddEducationButton() {
        waitForElementClickable(driver, QualificationsPUI.ADD_EDUCATION_BUTTON);
        clickToElement(driver, QualificationsPUI.ADD_EDUCATION_BUTTON);
    }

    @Step("Select education level dropdown")
    public void selectEducationLevelDropdown(String educationLevel) {
        waitForElementClickable(driver, QualificationsPUI.LEVEL_DROPDOWN_PARENT);
        selectItemInCustomDropdown(driver, QualificationsPUI.LEVEL_DROPDOWN_PARENT, QualificationsPUI.LEVEL_DROPDOWN_CHILD, educationLevel);
    }

    @Step("Enter to institute textbox")
    public void enterToInstituteTextbox(String institute) {
        waitForElementVisible(driver, QualificationsPUI.INSTITUTE_TEXTBOX);
        sendKeyToElement(driver, QualificationsPUI.INSTITUTE_TEXTBOX, institute);
    }

    @Step("Enter to year textbox")
    public void enterToYearTextbox(String yearEducation) {
        waitForElementVisible(driver, QualificationsPUI.YEAR_TEXTBOX);
        sendKeyToElement(driver, QualificationsPUI.YEAR_TEXTBOX, yearEducation);
    }

    @Step("Enter to major textbox")
    public void enterToMajorTextbox(String major) {
        waitForElementVisible(driver, QualificationsPUI.MAJOR_TEXTBOX);
        sendKeyToElement(driver, QualificationsPUI.MAJOR_TEXTBOX, major);
    }

    @Step("Enter to score textbox")
    public void enterToScoreTextbox(String score) {
        waitForElementVisible(driver, QualificationsPUI.SCORE_TEXTBOX);
        sendKeyToElement(driver, QualificationsPUI.SCORE_TEXTBOX, score);
    }

    @Step("Enter to start date education textbox")
    public void enterToStartDateEducationTextbox(String startDateEducation) {
        waitForElementVisible(driver, QualificationsPUI.START_DATE_OF_EDUCATION_TEXTBOX);
        sendKeyToElement(driver, QualificationsPUI.START_DATE_OF_EDUCATION_TEXTBOX, startDateEducation);
    }

    @Step("Enter to end date education textbox")
    public void enterToEndDateEducationTextbox(String endDateEducation) {
        waitForElementVisible(driver, QualificationsPUI.END_DATE_OF_EDUCATION_TEXTBOX);
        sendKeyToElement(driver, QualificationsPUI.END_DATE_OF_EDUCATION_TEXTBOX, endDateEducation);
    }

    @Step("Education level is updated success")
    public boolean isEducationLevelUpdatedSuccess(String educationLevel) {
        waitForElementVisible(driver, QualificationsPUI.LEVEL_COLUMN, educationLevel);
        return isElementDisplayed(driver, QualificationsPUI.LEVEL_COLUMN, educationLevel);
    }

    @Step("Year is updated success")
    public boolean isYearUpdatedSuccess(String yearEducation) {
        waitForElementVisible(driver, QualificationsPUI.YEAR_COLUMN, yearEducation);
        return isElementDisplayed(driver, QualificationsPUI.YEAR_COLUMN, yearEducation);
    }

    @Step("Score is updated success")
    public boolean isScoreUpdatedSuccess(String score) {
        waitForElementVisible(driver, QualificationsPUI.SCORE_COLUMN, score);
        return isElementDisplayed(driver, QualificationsPUI.SCORE_COLUMN, score);
    }

    @Step("Click to add skill button")
    public void clickToAddSkillsButton() {
        waitForElementClickable(driver, QualificationsPUI.ADD_SKILLS_BUTTON);
        clickToElement(driver, QualificationsPUI.ADD_SKILLS_BUTTON);
    }

    @Step("Select skill dropdown")
    public void selectSkillDropdown(String skillName) {
        waitForElementClickable(driver, QualificationsPUI.SKILL_DROPDOWN_PARENT);
        selectItemInCustomDropdown(driver, QualificationsPUI.SKILL_DROPDOWN_PARENT, QualificationsPUI.SKILL_DROPDOWN_CHILD, skillName);
    }

    @Step("Enter to year of experience textbox")
    public void enterToYearOfExperienceTextbox(String yearOfExperience) {
        waitForElementVisible(driver, QualificationsPUI.YEAR_OF_EXPERIENCE_TEXTBOX);
        sendKeyToElement(driver, QualificationsPUI.YEAR_OF_EXPERIENCE_TEXTBOX, yearOfExperience);
    }

    @Step("Skill is updated success")
    public boolean isSkillUpdatedSuccess(String skillName) {
        waitForElementVisible(driver, QualificationsPUI.SKILL_COLUMN, skillName);
        return isElementDisplayed(driver, QualificationsPUI.SKILL_COLUMN, skillName);
    }

    @Step("Year of experience is updated success")
    public boolean isYearOfExperienceUpdatedSuccess(String yearOfExperience) {
        waitForElementVisible(driver, QualificationsPUI.YEAR_COLUMN, yearOfExperience);
        return isElementDisplayed(driver, QualificationsPUI.YEAR_COLUMN, yearOfExperience);
    }

    @Step("Click to add language button")
    public void clickToAddLanguageButton() {
        waitForElementClickable(driver, QualificationsPUI.ADD_LANGUAGES_BUTTON);
        clickToElement(driver, QualificationsPUI.ADD_LANGUAGES_BUTTON);
    }

    @Step("Select language dropdown")
    public void selectLanguageDropdown(String language) {
        waitAllLoadingIconInvisible(driver);
        waitForElementClickable(driver, QualificationsPUI.LANGUAGE_DROPDOWN_PARENT);
        selectItemInCustomDropdown(driver, QualificationsPUI.LANGUAGE_DROPDOWN_PARENT, QualificationsPUI.LANGUAGE_DROPDOWN_CHILD, language);
    }

    @Step("Select fluency dropdown")
    public void selectFluencyDropdown(String fluency) {
        waitForElementClickable(driver, QualificationsPUI.FLUENCY_DROPDOWN_PARENT);
        selectItemInCustomDropdown(driver, QualificationsPUI.FLUENCY_DROPDOWN_PARENT, QualificationsPUI.FLUENCY_DROPDOWN_CHILD, fluency);
    }

    @Step("Select competency dropdown")
    public void selectCompetencyDropdown(String competency) {
        waitForElementClickable(driver, QualificationsPUI.COMPETENCY_DROPDOWN_PARENT);
        selectItemInCustomDropdown(driver, QualificationsPUI.COMPETENCY_DROPDOWN_PARENT, QualificationsPUI.COMPETENCY_DROPDOWN_CHILD, competency);
    }

    @Step("Language is updated success")
    public boolean isLanguageUpdatedSuccess(String language) {
        waitForElementVisible(driver, QualificationsPUI.LANGUAGE_COLUMN, language);
        return isElementDisplayed(driver, QualificationsPUI.LANGUAGE_COLUMN, language);
    }

    @Step("Fluency is updated success")
    public boolean isFluencyUpdatedSuccess(String fluency) {
        waitForElementVisible(driver, QualificationsPUI.FLUENCY_COLUMN, fluency);
        return isElementDisplayed(driver, QualificationsPUI.FLUENCY_COLUMN, fluency);
    }

    @Step("Competency is updated success")
    public boolean isCompetencyUpdatedSuccess(String competency) {
        waitForElementVisible(driver, QualificationsPUI.COMPETENCY_COLUMN, competency);
        return isElementDisplayed(driver, QualificationsPUI.COMPETENCY_COLUMN, competency);
    }

    @Step("Click to add license button")
    public void clickToAddLicenseButton() {
        waitForElementClickable(driver, QualificationsPUI.ADD_LICENSE_BUTTON);
        clickToElement(driver, QualificationsPUI.ADD_LICENSE_BUTTON);
    }

    @Step("Select license type dropdown")
    public void selectLicenseTypeDropdown(String licenseName) {
        waitForElementClickable(driver, QualificationsPUI.LICENSE_TYPE_DROPDOWN_PARENT);
        selectItemInCustomDropdown(driver, QualificationsPUI.LICENSE_TYPE_DROPDOWN_PARENT, QualificationsPUI.LICENSE_TYPE_DROPDOWN_CHILD, licenseName);
    }

    @Step("Enter to license number textbox")
    public void enterToLicenseNumberTextbox(String licenseNumber) {
        waitForElementVisible(driver, QualificationsPUI.LICENSE_NUMBER_TEXTBOX);
        sendKeyToElement(driver, QualificationsPUI.LICENSE_NUMBER_TEXTBOX, licenseNumber);
    }

    @Step("Enter to start date license textbox")
    public void enterToStartDateLicenseTextbox(String startDateLicense) {
        waitForElementVisible(driver, QualificationsPUI.START_DATE_OF_LICENSE_TEXTBOX);
        sendKeyToElement(driver, QualificationsPUI.START_DATE_OF_LICENSE_TEXTBOX, startDateLicense);
    }

    @Step("Enter to end date license textbox")
    public void enterToEndDateLicenseTextbox(String endDateLicense) {
        waitForElementVisible(driver, QualificationsPUI.END_DATE_OF_LICENSE_TEXTBOX);
        sendKeyToElement(driver, QualificationsPUI.END_DATE_OF_LICENSE_TEXTBOX, endDateLicense);
    }

    @Step("License is updated success")
    public boolean isLicenseTypeUpdatedSuccess(String licenseName) {
        waitForElementVisible(driver, QualificationsPUI.LICENSE_COLUMN, licenseName);
        return isElementDisplayed(driver, QualificationsPUI.LICENSE_COLUMN, licenseName);
    }

    @Step("Start date license updated success")
    public boolean isStartDateLicenseUpdatedSuccess(String startDateLicense) {
        waitForElementVisible(driver, QualificationsPUI.START_DATE_OF_LICENSE_COLUMN, startDateLicense);
        return isElementDisplayed(driver, QualificationsPUI.START_DATE_OF_LICENSE_COLUMN, startDateLicense);
    }

    @Step("End date license is updated success")
    public boolean isEndDateLicenseUpdatedSuccess(String endDateLicense) {
        waitForElementVisible(driver, QualificationsPUI.END_DATE_OF_LICENSE_COLUMN, endDateLicense);
        return isElementDisplayed(driver, QualificationsPUI.END_DATE_OF_LICENSE_COLUMN, endDateLicense);
    }

    @Step("Click save button at qualification container")
    public void clickSaveButtonAtQualificationContainer() {
        waitForElementClickable(driver, QualificationsPUI.SAVE_BUTTON_AT_QUALIFICATIONS_CONTAINER);
        clickToElement(driver, QualificationsPUI.SAVE_BUTTON_AT_QUALIFICATIONS_CONTAINER);
    }
}