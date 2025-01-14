package pageObjects.orangehrm.pim.employee;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.orangehrm.PageGenerator;
import pageUIs.orangeHRM.pim.employee.EmployeeTabsPUI;

public class EmployeeTabsPO extends BasePage {
    private WebDriver driver;

    public EmployeeTabsPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Open personal details page")
    public PersonalDetailsPO openPersonalDetailPage() {
        waitForElementVisible(driver, EmployeeTabsPUI.PERSONAL_DETAILS_LINK);
        clickToElement(driver, EmployeeTabsPUI.PERSONAL_DETAILS_LINK);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getPersonalDetailsPage(driver);
    }

    @Step("Open contact details page")
    public ContactDetailsPO openContactDetailsPage() {
        waitForElementVisible(driver, EmployeeTabsPUI.CONTACT_DETAILS_LINK);
        clickToElement(driver, EmployeeTabsPUI.CONTACT_DETAILS_LINK);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getContactDetailsPage(driver);
    }

    @Step("Open emergency contacts page")
    public EmergencyContactsPO openEmergencyContactsPage() {
        waitForElementVisible(driver, EmployeeTabsPUI.EMERGENCY_CONTACTS_LINK);
        clickToElement(driver, EmployeeTabsPUI.EMERGENCY_CONTACTS_LINK);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getEmergencyContactsPage(driver);
    }

    @Step("Open assigned dependents page")
    public AssignedDependentsPO openAssignedDependentsPage() {
        waitForElementVisible(driver, EmployeeTabsPUI.ASSIGNED_DEPENDENTS_LINK);
        clickToElement(driver, EmployeeTabsPUI.ASSIGNED_DEPENDENTS_LINK);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getAssignedDependentsPage(driver);
    }

    @Step("Open job page")
    public JobPO openJobPage() {
        waitForElementVisible(driver, EmployeeTabsPUI.JOB_LINK);
        clickToElement(driver, EmployeeTabsPUI.JOB_LINK);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getJobPage(driver);
    }

    @Step("Open job page")
    public SalaryPO openSalaryPage() {
        waitForElementVisible(driver, EmployeeTabsPUI.SALARY_LINK);
        clickToElement(driver, EmployeeTabsPUI.SALARY_LINK);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getSalaryPage(driver);
    }

    @Step("Open report to page")
    public ReportToPO openReportToPage() {
        waitForElementVisible(driver, EmployeeTabsPUI.REPORT_TO_LINK);
        clickToElement(driver, EmployeeTabsPUI.REPORT_TO_LINK);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getReportToPage(driver);
    }

    @Step("Open qualifications page")
    public QualificationsPO openQualificationsPage() {
        waitForElementVisible(driver, EmployeeTabsPUI.QUALIFICATIONS_LINK);
        clickToElement(driver, EmployeeTabsPUI.QUALIFICATIONS_LINK);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getQualificationsPage(driver);
    }
}