package pageObjects.orangehrm.pim.employee;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.orangehrm.PageGenerator;
import pageUIs.orangeHRM.pim.employee.EmployeeTabsPUI;

public class EmployeeTabs extends BasePage {
    private WebDriver driver;

    public EmployeeTabs(WebDriver driver) {
        this.driver = driver;
    }

    public PersonalDetailsPO openPersonalDetailPage() {
        waitForElementVisible(driver, EmployeeTabsPUI.PERSONAL_DETAILS_LINK);
        clickToElement(driver, EmployeeTabsPUI.PERSONAL_DETAILS_LINK);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getPersonalDetailsPage(driver);
    }

    public ContactDetailsPO openContactDetailsPage() {
        waitForElementVisible(driver, EmployeeTabsPUI.CONTACT_DETAILS_LINK);
        clickToElement(driver, EmployeeTabsPUI.CONTACT_DETAILS_LINK);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getContactDetailsPage(driver);
    }

    public EmergencyContactsPO openEmergencyContactsPage() {
        waitForElementVisible(driver, EmployeeTabsPUI.EMERGENCY_DETAILS_LINK);
        clickToElement(driver, EmployeeTabsPUI.EMERGENCY_DETAILS_LINK);
        waitAllLoadingIconInvisible(driver);
        return PageGenerator.getEmergencyContactsPage(driver);
    }
}
