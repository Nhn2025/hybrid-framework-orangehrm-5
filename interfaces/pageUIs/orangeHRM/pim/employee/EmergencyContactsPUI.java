package pageUIs.orangeHRM.pim.employee;

public class EmergencyContactsPUI {
    public static final String ADD_EMERGENCY_CONTACTS_BUTTON = "xpath=//h6[text()='Assigned Emergency Contacts']/following-sibling::button";
    public static final String EMERGENCY_NAME_TEXTBOX = "xpath=//label[text()='Name']/parent::div/following-sibling::div/input";
    public static final String EMERGENCY_RELATIONSHIP_TEXTBOX = "xpath=//label[text()='Relationship']/parent::div/following-sibling::div/input";
    public static final String EMERGENCY_HOME_TELEPHONE_TEXTBOX = "xpath=//label[text()='Home Telephone']/parent::div/following-sibling::div/input";
    public static final String EMERGENCY_NAME_COLUMN = "xpath=//div[@class='oxd-table-body']//div[text()='%s']";
    public static final String EMERGENCY_RELATIONSHIP_COLUMN = "xpath=//div[@class='oxd-table-body']//div[text()='%s']";
    public static final String EMERGENCY_HOME_TELEPHONE_COLUMN = "xpath=//div[@class='oxd-table-body']//div[text()='%s']";
    public static final String EMERGENCY_ADD_ATTACHMENTS_BUTTON = "xpath=//h6[text()='Attachments']/following-sibling::button";
    public static final String EMERGENCY_ATTACHMENTS_FILE_NAME_COLUMN = "xpath=//div[@class='oxd-table-body']//div[text()='%s']";
    public static final String SAVE_BUTTON_AT_EMERGENCY_CONTACTS_CONTAINER = "xpath=//button[normalize-space()='Save']";
}
