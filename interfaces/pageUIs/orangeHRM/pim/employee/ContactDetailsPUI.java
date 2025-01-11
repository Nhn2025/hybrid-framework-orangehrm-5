package pageUIs.orangeHRM.pim.employee;

public class ContactDetailsPUI {
    public static final String STREET_TEXTBOX = "xpath=//label[text()='Street 1']/parent::div/following-sibling::div/input";
    public static final String CITY_TEXTBOX = "xpath=//label[text()='City']/parent::div/following-sibling::div/input";
    public static final String PROVINCE_TEXTBOX = "xpath=//label[text()='State/Province']/parent::div/following-sibling::div/input";
    public static final String POSTAL_CODE_TEXTBOX = "xpath=//label[text()='Zip/Postal Code']/parent::div/following-sibling::div/input";
    public static final String COUNTRY_DROPDOWN_PARENT = "xpath=//label[text()='Country']/parent::div/following-sibling::div//i";
    public static final String COUNTRY_DROPDOWN_CHILD = "xpath=//label[contains(text(), 'Country')]/parent::div/following-sibling::div//div[@class='oxd-select-option']/span";
    public static final String HOME_TELEPHONE_TEXTBOX = "xpath=//label[text()='Home']/parent::div/following-sibling::div/input";
    public static final String WORK_EMAIL_TEXTBOX = "xpath=//label[text()='Work Email']/parent::div/following-sibling::div/input";
    public static final String SAVE_BUTTON_AT_CONTACT_DETAIL_CONTAINER = "xpath=//button[normalize-space()='Save']";
    public static final String COUNTRY_DROPDOWN_ITEM_SELECTED = "xpath=//label[contains(text(), 'Country')]/parent::div/following-sibling::div//div[@class='oxd-select-text-input']";
}