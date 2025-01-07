package pageObjects.orangehrm.pim.employee;

import io.qameta.allure.Step;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import pageUIs.orangeHRM.pim.employee.PersonalDetailsPUI;

public class PersonalDetailsPO extends EmployeeTabs {
    private WebDriver driver;

    public PersonalDetailsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Click to save button at profile container")
    public void clickToSaveButtonAtProfileContainer() {
        waitForElementClickable(driver, PersonalDetailsPUI.SAVE_BUTTON_AT_CHANGE_PROFILE_CONTAINER);
        clickToElement(driver, PersonalDetailsPUI.SAVE_BUTTON_AT_CHANGE_PROFILE_CONTAINER);
    }

    @Step("Click to Employee avatar image")
    public void clickToEmployeeAvatarImage() {
        waitForElementClickable(driver, PersonalDetailsPUI.EMPLOYEE_IMAGE);
        clickToElement(driver, PersonalDetailsPUI.EMPLOYEE_IMAGE);
    }

    @Step("Profile avatar is updated successfully")
    public boolean isProfileAvatarUpdateSuccess(Dimension beforeUpload) {
        waitForElementVisible(driver, PersonalDetailsPUI.EMPLOYEE_IMAGE);
        Dimension afterUpload = getAvatarSize();
        return !(beforeUpload.equals(afterUpload));
    }

    @Step("Get avatar size")
    public Dimension getAvatarSize() {
        waitForElementVisible(driver, PersonalDetailsPUI.EMPLOYEE_IMAGE);
        return getElementSize(driver, PersonalDetailsPUI.EMPLOYEE_IMAGE);
    }

    @Step("Get employee ID")
    public String getEmployeeID() {
        waitForElementVisible(driver, PersonalDetailsPUI.EMPLOYEE_ID_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailsPUI.EMPLOYEE_ID_TEXTBOX, "value");
    }

    @Step("Enter to first name textbox")
    public void enterToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, PersonalDetailsPUI.FIRSTNAME_TEXTBOX);
        sendKeyToElementBackSpace(driver, PersonalDetailsPUI.FIRSTNAME_TEXTBOX, firstName);
    }

    @Step("Enter to last name textbox")
    public void enterToLastNameTextbox(String lastName) {
        waitForElementVisible(driver, PersonalDetailsPUI.LASTNAME_TEXTBOX);
        sendKeyToElementBackSpace(driver, PersonalDetailsPUI.LASTNAME_TEXTBOX, lastName);
    }

    @Step("Enter to driver license textbox")
    public void enterToDriverLicenseTextbox(String driverLicense) {
        waitForElementVisible(driver, PersonalDetailsPUI.DRIVER_LICENSE_TEXTBOX);
        sendKeyToElement(driver, PersonalDetailsPUI.DRIVER_LICENSE_TEXTBOX, driverLicense);
    }

    @Step("Enter to expiry date license textbox")
    public void enterToExpiryDateLicenseTextbox(String expiryDateLicense) {
        waitForElementVisible(driver, PersonalDetailsPUI.EXPIRY_DATE_LICENSE_TEXTBOX);
        sendKeyToElement(driver, PersonalDetailsPUI.EXPIRY_DATE_LICENSE_TEXTBOX, expiryDateLicense);
    }

    @Step("Select nationality dropdown")
    public void selectNationalityDropdown(String nationality) {
        waitForElementClickable(driver, PersonalDetailsPUI.NATIONALITY_DROPDOWN_PARENT);
        selectItemInCustomDropdown(driver, PersonalDetailsPUI.NATIONALITY_DROPDOWN_PARENT, PersonalDetailsPUI.NATIONALITY_DROPDOWN_CHILD, nationality);
    }

    @Step("Select marital status dropdown")
    public void selectMaritalStatusDropdown(String maritalStatus) {
        waitForElementClickable(driver, PersonalDetailsPUI.MARITAL_STATUS_DROPDOWN_PARENT);
        selectItemInCustomDropdown(driver, PersonalDetailsPUI.MARITAL_STATUS_DROPDOWN_PARENT, PersonalDetailsPUI.MARITAL_STATUS_DROPDOWN_CHILD, maritalStatus);
    }

    @Step("Enter to date of birthday textbox")
    public void enterToDateOfBirthTextbox(String dateOfBirth) {
        waitForElementVisible(driver, PersonalDetailsPUI.DATE_OF_BIRTH_TEXTBOX);
        sendKeyToElement(driver, PersonalDetailsPUI.DATE_OF_BIRTH_TEXTBOX, dateOfBirth);
    }

    @Step("Select gender male radio button")
    public void selectGenderMaleRadioButton(String genderMale) {
        clickToElementByJS(driver, PersonalDetailsPUI.GENDER_RADIO_BUTTON, genderMale);
    }

    @Step("Click save button at personal detail container")
    public void clickSaveButtonAtPersonalDetailContainer() {
        waitForElementClickable(driver, PersonalDetailsPUI.SAVE_BUTTON_AT_DETAIL_PERSONAL_CONTAINER);
        clickToElement(driver, PersonalDetailsPUI.SAVE_BUTTON_AT_DETAIL_PERSONAL_CONTAINER);
    }

    @Step("Get first name textbox value")
    public String getFirstNameTextboxValue() {
        waitForElementVisible(driver, PersonalDetailsPUI.FIRSTNAME_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailsPUI.FIRSTNAME_TEXTBOX, "value");
    }

    @Step("Get last name textbox value")
    public String getLastNameTextboxValue() {
        waitForElementVisible(driver, PersonalDetailsPUI.LASTNAME_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailsPUI.LASTNAME_TEXTBOX, "value");
    }

    @Step("Get license textbox value")
    public String getDriverLicenseTextboxValue() {
        waitForElementVisible(driver, PersonalDetailsPUI.DRIVER_LICENSE_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailsPUI.DRIVER_LICENSE_TEXTBOX, "value");
    }

    @Step("Get expiry date license textbox value")
    public String getExpiryDateLicenseTextboxValue() {
        waitForElementVisible(driver, PersonalDetailsPUI.EXPIRY_DATE_LICENSE_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailsPUI.EXPIRY_DATE_LICENSE_TEXTBOX, "value");
    }

    @Step("Get nationality Dropdown value")
    public String getNationalityDropdownValue() {
        waitForElementVisible(driver, PersonalDetailsPUI.NATIONALITY_DROPDOWN_ITEM_SELECTED);
        return getElementText(driver, PersonalDetailsPUI.NATIONALITY_DROPDOWN_ITEM_SELECTED);
    }

    @Step("Get marital status dropdown value")
    public String getMaritalStatusDropdownValue() {
        waitForElementVisible(driver, PersonalDetailsPUI.MARITAL_STATUS_DROPDOWN_ITEM_SELECTED);
        return getElementText(driver, PersonalDetailsPUI.MARITAL_STATUS_DROPDOWN_ITEM_SELECTED);
    }

    @Step("Get date of birth textbox value")
    public String getDateOfBirthTextboxValue() {
        waitForElementVisible(driver, PersonalDetailsPUI.DATE_OF_BIRTH_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailsPUI.DATE_OF_BIRTH_TEXTBOX, "value");
    }

    @Step("Gender male radio is selected")
    public boolean isGenderMaleRadioSelected(String gender) {
        waitForElementSelected(driver, PersonalDetailsPUI.GENDER_RADIO_BUTTON, gender);
        return isElementSelected(driver, PersonalDetailsPUI.GENDER_RADIO_BUTTON, gender);
    }
}