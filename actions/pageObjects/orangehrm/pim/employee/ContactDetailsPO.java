package pageObjects.orangehrm.pim.employee;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.orangeHRM.pim.employee.ContactDetailsPUI;

public class ContactDetailsPO extends EmployeeTabsPO {
    private WebDriver driver;

    public ContactDetailsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Enter to street textbox")
    public void enterToStreetTextbox(String streetName) {
        waitForElementVisible(driver, ContactDetailsPUI.STREET_TEXTBOX);
        sendKeyToElement(driver, ContactDetailsPUI.STREET_TEXTBOX, streetName);
    }

    @Step("Enter to city textbox")
    public void enterToCityTextbox(String cityName) {
        waitForElementVisible(driver, ContactDetailsPUI.CITY_TEXTBOX);
        sendKeyToElement(driver, ContactDetailsPUI.CITY_TEXTBOX, cityName);
    }

    @Step("Enter to province textbox")
    public void enterToProvinceTextbox(String provinceName) {
        waitForElementVisible(driver, ContactDetailsPUI.PROVINCE_TEXTBOX);
        sendKeyToElement(driver, ContactDetailsPUI.PROVINCE_TEXTBOX, provinceName);
    }

    @Step("Enter to postal code textbox")
    public void enterToPostalCodeTextbox(String postalCode) {
        waitForElementVisible(driver, ContactDetailsPUI.POSTAL_CODE_TEXTBOX);
        sendKeyToElement(driver, ContactDetailsPUI.POSTAL_CODE_TEXTBOX, postalCode);
    }

    @Step("Select country dropdown")
    public void selectCountryDropdown(String countryName) {
        waitForElementClickable(driver, ContactDetailsPUI.COUNTRY_DROPDOWN_PARENT);
        selectItemInCustomDropdown(driver, ContactDetailsPUI.COUNTRY_DROPDOWN_PARENT, ContactDetailsPUI.COUNTRY_DROPDOWN_CHILD, countryName);
    }

    @Step("Enter to work email textbox")
    public void enterToWorkEmailTextbox(String email) {
        waitForElementVisible(driver, ContactDetailsPUI.WORK_EMAIL_TEXTBOX);
        sendKeyToElement(driver, ContactDetailsPUI.WORK_EMAIL_TEXTBOX, email);
    }

    @Step("Enter to home telephone textbox")
    public void enterToHomeTelephoneTextbox(String phoneNumber) {
        waitForElementVisible(driver, ContactDetailsPUI.HOME_TELEPHONE_TEXTBOX);
        sendKeyToElement(driver, ContactDetailsPUI.HOME_TELEPHONE_TEXTBOX, phoneNumber);
    }

    @Step("Click save button at contact detail container")
    public void clickSaveButtonAtContactDetailContainer() {
        waitForElementClickable(driver, ContactDetailsPUI.SAVE_BUTTON_AT_CONTACT_DETAIL_CONTAINER);
        clickToElement(driver, ContactDetailsPUI.SAVE_BUTTON_AT_CONTACT_DETAIL_CONTAINER);
    }

    @Step("Get street textbox value")
    public String getStreetTextboxValue() {
        waitForElementVisible(driver, ContactDetailsPUI.STREET_TEXTBOX);
        return getElementAttribute(driver, ContactDetailsPUI.STREET_TEXTBOX, "value");
    }

    @Step("Get city textbox value")
    public String getCityTextboxValue() {
        waitForElementVisible(driver, ContactDetailsPUI.CITY_TEXTBOX);
        return getElementAttribute(driver, ContactDetailsPUI.CITY_TEXTBOX, "value");
    }

    @Step("Get province textbox value")
    public String getProvinceTextboxValue() {
        waitForElementVisible(driver, ContactDetailsPUI.PROVINCE_TEXTBOX);
        return getElementAttribute(driver, ContactDetailsPUI.PROVINCE_TEXTBOX, "value");
    }

    @Step("Get postal code textbox value")
    public String getPostalCodeTextboxValue() {
        waitForElementVisible(driver, ContactDetailsPUI.POSTAL_CODE_TEXTBOX);
        return getElementAttribute(driver, ContactDetailsPUI.POSTAL_CODE_TEXTBOX, "value");
    }

    @Step("Get country dropdown value")
    public String getCountryDropdownValue() {
        waitForElementVisible(driver, ContactDetailsPUI.COUNTRY_DROPDOWN_ITEM_SELECTED);
        return getElementText(driver, ContactDetailsPUI.COUNTRY_DROPDOWN_ITEM_SELECTED);
    }

    @Step("Get home telephone text box value")
    public String getHomeTelephoneTextboxValue() {
        waitForElementVisible(driver, ContactDetailsPUI.HOME_TELEPHONE_TEXTBOX);
        return getElementAttribute(driver, ContactDetailsPUI.HOME_TELEPHONE_TEXTBOX, "value");
    }

    @Step("Get work email text box")
    public String getWorkEmailTextbox() {
        waitForElementVisible(driver, ContactDetailsPUI.WORK_EMAIL_TEXTBOX);
        return getElementAttribute(driver, ContactDetailsPUI.WORK_EMAIL_TEXTBOX, "value");
    }
}