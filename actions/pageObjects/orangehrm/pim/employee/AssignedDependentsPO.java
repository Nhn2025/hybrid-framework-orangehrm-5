package pageObjects.orangehrm.pim.employee;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.orangeHRM.pim.employee.AssignedDependentsPUI;

public class AssignedDependentsPO extends EmployeeTabsPO {
    private WebDriver driver;

    public AssignedDependentsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Click add button at assigned dependents")
    public void clickAddButtonAtAssignedDependents() {
        waitForElementClickable(driver, AssignedDependentsPUI.ADD_ASSIGNED_DEPENDENTS_BUTTON);
        clickToElement(driver, AssignedDependentsPUI.ADD_ASSIGNED_DEPENDENTS_BUTTON);
    }

    @Step("Enter to name textbox")
    public void enterToNameTextbox(String dependentsName) {
        waitForElementVisible(driver, AssignedDependentsPUI.DEPENDENTS_NAME_TEXTBOX);
        sendKeyToElement(driver, AssignedDependentsPUI.DEPENDENTS_NAME_TEXTBOX, dependentsName);
    }

    @Step("Select relationship dropdown")
    public void selectRelationshipDropdown(String dependentsRelationship) {
        waitForElementClickable(driver, AssignedDependentsPUI.DEPENDENTS_RELATIONSHIP_DROPDOWN_PARENT);
        selectItemInCustomDropdown(driver, AssignedDependentsPUI.DEPENDENTS_RELATIONSHIP_DROPDOWN_PARENT, AssignedDependentsPUI.DEPENDENTS_RELATIONSHIP_DROPDOWN_CHILD, dependentsRelationship);
    }

    @Step("Enter to data of birth textbox")
    public void enterToDateOfBirthTextbox(String dependentsDateOfBirth) {
        waitForElementVisible(driver, AssignedDependentsPUI.DEPENDENTS_DATE_OF_BIRTH_TEXTBOX);
        sendKeyToElement(driver, AssignedDependentsPUI.DEPENDENTS_DATE_OF_BIRTH_TEXTBOX, dependentsDateOfBirth);
    }

    @Step("Click to save button at assigned dependents container")
    public void clickToSaveButtonAtAssignedDependentsContainer() {
        waitForElementClickable(driver, AssignedDependentsPUI.SAVE_BUTTON_AT_ASSIGNED_DEPENDENTS_CONTAINER);
        clickToElement(driver, AssignedDependentsPUI.SAVE_BUTTON_AT_ASSIGNED_DEPENDENTS_CONTAINER);
    }

    @Step("Name textbox is updated success")
    public boolean isNameUpdatedSuccess(String dependentsName) {
        waitForElementVisible(driver, AssignedDependentsPUI.DEPENDENTS_NAME_COLUMN, dependentsName);
        return isElementDisplayed(driver, AssignedDependentsPUI.DEPENDENTS_NAME_COLUMN, dependentsName);
    }

    @Step("Relationship textbox is updated success")
    public boolean isRelationshipUpdatedSuccess(String dependentsRelationship) {
        waitForElementVisible(driver, AssignedDependentsPUI.DEPENDENTS_RELATIONSHIP_COLUMN, dependentsRelationship);
        return isElementDisplayed(driver, AssignedDependentsPUI.DEPENDENTS_RELATIONSHIP_COLUMN, dependentsRelationship);
    }

    @Step("Date of birth textbox is updated success")
    public boolean isDateOfBirthUpdatedSuccess(String dependentsDateOfBirth) {
        waitForElementVisible(driver, AssignedDependentsPUI.DEPENDENTS_DATE_OF_BIRTH_COLUMN, dependentsDateOfBirth);
        return isElementDisplayed(driver, AssignedDependentsPUI.DEPENDENTS_DATE_OF_BIRTH_COLUMN, dependentsDateOfBirth);
    }

    @Step("Click add button at attachments")
    public void clickAddButtonAtAttachments() {
        waitForElementClickable(driver, AssignedDependentsPUI.ADD_DEPENDENTS_ATTACHMENTS_BUTTON);
        clickToElement(driver, AssignedDependentsPUI.ADD_DEPENDENTS_ATTACHMENTS_BUTTON);
    }

    @Step("Attachment image is updated success")
    public boolean isAttachmentsImageUpdatedSuccess(String dependentsAttachmentsImageName) {
        waitForElementVisible(driver, AssignedDependentsPUI.DEPENDENTS_ATTACHMENTS_FILE_NAME_COLUMN, dependentsAttachmentsImageName);
        return isElementDisplayed(driver, AssignedDependentsPUI.DEPENDENTS_ATTACHMENTS_FILE_NAME_COLUMN, dependentsAttachmentsImageName);
    }
}
