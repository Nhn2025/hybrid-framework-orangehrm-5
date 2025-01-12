package pageObjects.orangehrm.pim.employee;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.orangeHRM.pim.employee.JobPUI;

public class JobPO extends EmployeeTabs{
    private WebDriver driver;

    public JobPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Enter to joined date textbox")
    public void enterToJoinedDateTextbox(String joinedDate) {
        waitForElementVisible(driver, JobPUI.JOINED_DATE_TEXT_BOX);
        sendKeyToElement(driver, JobPUI.JOINED_DATE_TEXT_BOX, joinedDate);
    }

    @Step("Select job title dropdown")
    public void selectJobTitleDropdown(String jobTitle) {
        waitForElementClickable(driver, JobPUI.JOB_TITLE_DROPDOWN_PARENT);
        selectItemInCustomDropdown(driver, JobPUI.JOB_TITLE_DROPDOWN_PARENT, JobPUI.JOB_TITLE_DROPDOWN_CHILD, jobTitle);
    }

    @Step("Select job category")
    public void selectJobCategoryDropdown(String jobCategory) {
        waitForElementClickable(driver, JobPUI.JOB_CATEGORY_DROPDOWN_PARENT);
        selectItemInCustomDropdown(driver, JobPUI.JOB_CATEGORY_DROPDOWN_PARENT, JobPUI.JOB_CATEGORY_DROPDOWN_CHILD, jobCategory);
    }

    @Step("Select location dropdown")
    public void selectLocationDropdown(String location) {
        waitForElementClickable(driver, JobPUI.LOCATION_DROPDOWN_PARENT);
        selectItemInCustomDropdown(driver, JobPUI.LOCATION_DROPDOWN_PARENT, JobPUI.LOCATION_DROPDOWN_CHILD, location);
    }

    @Step("Select employment status dropdown")
    public void selectEmploymentStatusDropdown(String employmentStatus) {
        waitForElementClickable(driver, JobPUI.EMPLOYMENT_STATUS_DROPDOWN_PARENT);
        selectItemInCustomDropdown(driver, JobPUI.EMPLOYMENT_STATUS_DROPDOWN_PARENT, JobPUI.EMPLOYMENT_STATUS_DROPDOWN_CHILD, employmentStatus);
    }

    @Step("Click save button at job container")
    public void clickSaveButtonAtJobContainer() {
        waitForElementVisible(driver, JobPUI.SAVE_BUTTON_AT_JOB_CONTAINER);
        clickToElement(driver, JobPUI.SAVE_BUTTON_AT_JOB_CONTAINER);
    }

    @Step("Joined Dated is updated success")
    public String getTextJoinedDateTextbox() {
        waitForElementVisible(driver, JobPUI.JOINED_DATE_TEXT_BOX);
        return getElementAttribute(driver, JobPUI.JOINED_DATE_TEXT_BOX, "value");
    }

    @Step("Job title is updated success")
    public String getJobTitleDropdownValue() {
        waitForElementVisible(driver, JobPUI.JOB_TITLE_DROPDOWN_ITEM_SELECTED);
        return getElementText(driver, JobPUI.JOB_TITLE_DROPDOWN_ITEM_SELECTED);
    }

    @Step("Job category is updated success")
    public String getJobCategoryDropdownValue() {
        waitForElementVisible(driver, JobPUI.JOB_CATEGORY_DROPDOWN_ITEM_SELECTED);
        return getElementText(driver, JobPUI.JOB_CATEGORY_DROPDOWN_ITEM_SELECTED);
    }

    @Step("Location is updated success")
    public String getLocationDropdownValue() {
        waitForElementVisible(driver, JobPUI.LOCATION_DROPDOWN_ITEM_SELECTED);
        return getElementText(driver, JobPUI.LOCATION_DROPDOWN_ITEM_SELECTED);
    }

    @Step("Employment status is updated success")
    public String getEmploymentStatusDropdownValue() {
        waitForElementVisible(driver, JobPUI.EMPLOYMENT_STATUS_DROPDOWN_ITEM_SELECTED);
        return getElementText(driver, JobPUI.EMPLOYMENT_STATUS_DROPDOWN_ITEM_SELECTED);
    }
}