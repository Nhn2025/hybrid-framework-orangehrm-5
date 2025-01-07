package pageUIs.orangeHRM.pim.employee;

public class PersonalDetailsPUI {
    public static final String EMPLOYEE_IMAGE = "css=div.orangehrm-edit-employee-image>img.employee-image";
    public static final String SAVE_BUTTON_AT_CHANGE_PROFILE_CONTAINER = "xpath=//button[normalize-space()='Save']";
    public static final String FIRSTNAME_TEXTBOX = "name=firstName";
    public static final String LASTNAME_TEXTBOX = "name=lastName";
    public static final String EMPLOYEE_ID_TEXTBOX = "xpath=//label[text()='Employee Id']/parent::div/following-sibling::div/input";
    public static final String DRIVER_LICENSE_TEXTBOX = "xpath=//label[contains(text(), 'License Number')]/parent::div/following-sibling::div/input";

    public static final String EXPIRY_DATE_LICENSE_TEXTBOX = "xpath=//label[contains(text(), 'License Expiry Date')]/parent::div/following-sibling::div//input";
    public static final String NATIONALITY_DROPDOWN_PARENT = "xpath=//label[contains(text(), 'Nationality')]/parent::div/following-sibling::div//i";
    public static final String NATIONALITY_DROPDOWN_CHILD = "xpath=//label[contains(text(), 'Nationality')]/parent::div/following-sibling::div//div[@class='oxd-select-option']/span";
    public static final String NATIONALITY_DROPDOWN_ITEM_SELECTED = "xpath=//label[contains(text(), 'Nationality')]/parent::div/following-sibling::div//div[@class='oxd-select-text-input']";

    public static final String MARITAL_STATUS_DROPDOWN_PARENT = "xpath=//label[contains(text(), 'Marital Status')]/parent::div/following-sibling::div//i";
    public static final String MARITAL_STATUS_DROPDOWN_CHILD = "xpath=//label[contains(text(), 'Marital Status')]/parent::div/following-sibling::div//div[@class='oxd-select-option']/span";
    public static final String MARITAL_STATUS_DROPDOWN_ITEM_SELECTED = "xpath=//label[contains(text(), 'Marital Status')]/parent::div/following-sibling::div//div[@class='oxd-select-text-input']";

    public static final String DATE_OF_BIRTH_TEXTBOX = "xpath=//label[contains(text(), 'Date of Birth')]/parent::div/following-sibling::div//input";

    public static final String GENDER_RADIO_BUTTON = "xpath=//label[contains(text(), 'Gender')]/parent::div/following-sibling::div//label[contains(string(), '%s')]/input";
    public static final String SAVE_BUTTON_AT_DETAIL_PERSONAL_CONTAINER = "xpath=//button[normalize-space()='Save']";
}