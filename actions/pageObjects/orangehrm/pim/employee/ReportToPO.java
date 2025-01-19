package pageObjects.orangehrm.pim.employee;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.orangeHRM.pim.employee.ReportToPUI;

public class ReportToPO extends SideBarTabsPO {
    private WebDriver driver;

    public ReportToPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Click add assigned supervisor button")
    public void clickAddAssignedSupervisorsButton() {
        waitForElementClickable(driver, ReportToPUI.ADD_ASSIGNED_SUPERVISORS_BUTTON);
        clickToElement(driver, ReportToPUI.ADD_ASSIGNED_SUPERVISORS_BUTTON);
    }

    @Step("Enter to name supervisors textbox")
    public void enterToNameSupervisorsTextBox(String supervisorsName) {
        waitForElementVisible(driver, ReportToPUI.NAME_SUPERVISORS_TEXTBOX);
        sendKeyToElement(driver, ReportToPUI.NAME_SUPERVISORS_TEXTBOX, supervisorsName);
    }

    @Step("Select reporting method supervisors dropdown")
    public void selectReportingMethodSupervisorsDropdown(String reportingMethodSupervisors) {
        waitForElementClickable(driver, ReportToPUI.REPORTING_METHOD_SUPERVISORS_DROPDOWN_PARENT, reportingMethodSupervisors);
        selectItemInCustomDropdown(driver, ReportToPUI.REPORTING_METHOD_SUPERVISORS_DROPDOWN_PARENT, ReportToPUI.REPORTING_METHOD_SUPERVISORS_DROPDOWN_CHILD, reportingMethodSupervisors);
    }

    @Step("Click save button at report to container")
    public void clickSaveButtonAtReportToContainer() {
        waitForElementClickable(driver, ReportToPUI.SAVE_BUTTON_AT_REPORT_TO_CONTAINER);
        clickToElement(driver, ReportToPUI.SAVE_BUTTON_AT_REPORT_TO_CONTAINER);
    }

    @Step("Reporting method supervisor is updated success")
    public boolean isReportingMethodSupervisorsUpdatedSuccess(String reportingMethodSupervisors) {
        waitForElementVisible(driver, ReportToPUI.REPORTING_METHOD_SUPERVISORS_COLUMN, reportingMethodSupervisors);
        return isElementDisplayed(driver, ReportToPUI.REPORTING_METHOD_SUPERVISORS_COLUMN, reportingMethodSupervisors);
    }

    @Step("Name supervisor is updated success")
    public boolean isNameSupervisorsUpdatedSuccess(String supervisorsName) {
        waitForElementVisible(driver, ReportToPUI.NAME_SUPERVISORS_COLUMN, supervisorsName);
        return isElementDisplayed(driver, ReportToPUI.NAME_SUPERVISORS_COLUMN, supervisorsName);
    }

    @Step("Click add assigned subordinates button")
    public void clickAddAssignedSubordinatesButton() {
        waitForElementClickable(driver, ReportToPUI.ADD_ASSIGNED_SUBORDINATE_BUTTON);
        clickToElement(driver, ReportToPUI.ADD_ASSIGNED_SUBORDINATE_BUTTON);
    }

    @Step("Enter to name subordinates textbox")
    public void enterToNameSubordinatesTextBox(String subordinatesName) {
        waitForElementVisible(driver, ReportToPUI.NAME_SUBORDINATE_TEXTBOX);
        sendKeyToElement(driver, ReportToPUI.NAME_SUBORDINATE_TEXTBOX, subordinatesName);
    }

    @Step("Select reporting method subordinates dropdown")
    public void selectReportingMethodSubordinatesDropdown(String reportingMethodSubordinates) {
        waitForElementClickable(driver, ReportToPUI.REPORTING_METHOD_SUBORDINATE_DROPDOWN_PARENT, reportingMethodSubordinates);
        selectItemInCustomDropdown(driver, ReportToPUI.REPORTING_METHOD_SUBORDINATE_DROPDOWN_PARENT, ReportToPUI.REPORTING_METHOD_SUBORDINATE_DROPDOWN_CHILD, reportingMethodSubordinates);
    }

    @Step("Name subordinates is updated success")
    public boolean isNameSubordinatesUpdatedSuccess(String subordinatesName) {
        waitForElementVisible(driver, ReportToPUI.NAME_SUBORDINATE_COLUMN, subordinatesName);
        return isElementDisplayed(driver, ReportToPUI.NAME_SUBORDINATE_COLUMN, subordinatesName);
    }

    @Step("Reporting method subordinates is updated success")
    public boolean isReportingMethodSubordinatesUpdatedSuccess(String reportingMethodSubordinates) {
        waitForElementVisible(driver, ReportToPUI.REPORTING_METHOD_SUBORDINATE_COLUMN, reportingMethodSubordinates);
        return isElementDisplayed(driver, ReportToPUI.REPORTING_METHOD_SUBORDINATE_COLUMN, reportingMethodSubordinates);
    }

    @Step("Select name supervisors dropdown")
    public void selectNameSupervisorsDropdown() {
        waitForElementClickable(driver, ReportToPUI.NAME_SUPERVISORS_DROPDOWN_CHILD);
        clickToElement(driver, ReportToPUI.NAME_SUPERVISORS_DROPDOWN_CHILD);
    }

    @Step("Select name subordinates dropdown")
    public void selectNameSubordinatesDropdown() {
        waitForElementClickable(driver, ReportToPUI.NAME_SUBORDINATE_DROPDOWN_CHILD);
        clickToElement(driver, ReportToPUI.NAME_SUBORDINATE_DROPDOWN_CHILD);
    }
}