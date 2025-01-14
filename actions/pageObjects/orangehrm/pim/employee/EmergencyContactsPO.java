package pageObjects.orangehrm.pim.employee;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.orangeHRM.pim.employee.EmergencyContactsPUI;

public class EmergencyContactsPO extends EmployeeTabsPO {
    private WebDriver driver;

    public EmergencyContactsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Click add button at assigned emergency contacts")
    public void clickAddButtonAtAssignedEmergencyContacts() {
        waitForElementClickable(driver, EmergencyContactsPUI.ADD_EMERGENCY_CONTACTS_BUTTON);
        clickToElement(driver, EmergencyContactsPUI.ADD_EMERGENCY_CONTACTS_BUTTON);
    }

    @Step("Enter to name textbox")
    public void enterToNameTextbox(String nameEmergency) {
        waitForElementVisible(driver, EmergencyContactsPUI.EMERGENCY_NAME_TEXTBOX);
        sendKeyToElement(driver, EmergencyContactsPUI.EMERGENCY_NAME_TEXTBOX, nameEmergency);
    }

    @Step("Enter to relationship textbox")
    public void enterToRelationshipTextbox(String relationship) {
        waitForElementVisible(driver, EmergencyContactsPUI.EMERGENCY_RELATIONSHIP_TEXTBOX);
        sendKeyToElement(driver, EmergencyContactsPUI.EMERGENCY_RELATIONSHIP_TEXTBOX, relationship);
    }

    @Step("Enter to home telephone textbox")
    public void enterToHomeTelephoneTextbox(String homeTelephone) {
        waitForElementVisible(driver, EmergencyContactsPUI.EMERGENCY_HOME_TELEPHONE_TEXTBOX);
        sendKeyToElement(driver, EmergencyContactsPUI.EMERGENCY_HOME_TELEPHONE_TEXTBOX, homeTelephone);
    }

    @Step("Click save button at emergency details container")
    public void clickToSaveButtonAtEmergencyDetailsContainer() {
        waitForElementVisible(driver, EmergencyContactsPUI.SAVE_BUTTON_AT_EMERGENCY_CONTACTS_CONTAINER);
        clickToElement(driver, EmergencyContactsPUI.SAVE_BUTTON_AT_EMERGENCY_CONTACTS_CONTAINER);
    }

    @Step("Name textbox is updated success")
    public boolean isNameUpdatedSuccess(String homeTelephone) {
        waitForElementVisible(driver, EmergencyContactsPUI.EMERGENCY_NAME_COLUMN, homeTelephone);
        return isElementDisplayed(driver, EmergencyContactsPUI.EMERGENCY_NAME_COLUMN, homeTelephone);
    }

    @Step("Relationship textbox is updated success")
    public boolean isRelationshipUpdatedSuccess(String relationship) {
        waitForElementVisible(driver, EmergencyContactsPUI.EMERGENCY_RELATIONSHIP_COLUMN, relationship);
        return isElementDisplayed(driver, EmergencyContactsPUI.EMERGENCY_RELATIONSHIP_COLUMN, relationship);
    }

    @Step("Home telephone textbox is updated success")
    public boolean isHomeTelephoneUpdatedSuccess(String homeTelephone) {
        waitForElementVisible(driver, EmergencyContactsPUI.EMERGENCY_HOME_TELEPHONE_COLUMN, homeTelephone);
        return isElementDisplayed(driver, EmergencyContactsPUI.EMERGENCY_HOME_TELEPHONE_COLUMN, homeTelephone);
    }

    @Step("Click add button at attachments")
    public void clickAddButtonAtAttachments() {
        waitForElementClickable(driver, EmergencyContactsPUI.EMERGENCY_ADD_ATTACHMENTS_BUTTON);
        clickToElement(driver, EmergencyContactsPUI.EMERGENCY_ADD_ATTACHMENTS_BUTTON);
    }

    @Step("Attachments image is updated success")
    public boolean isAttachmentsImageUpdatedSuccess(String attachmentsImageName) {
        waitForElementVisible(driver, EmergencyContactsPUI.EMERGENCY_ATTACHMENTS_FILE_NAME_COLUMN, attachmentsImageName);
        return isElementDisplayed(driver, EmergencyContactsPUI.EMERGENCY_ATTACHMENTS_FILE_NAME_COLUMN, attachmentsImageName);
    }
}
