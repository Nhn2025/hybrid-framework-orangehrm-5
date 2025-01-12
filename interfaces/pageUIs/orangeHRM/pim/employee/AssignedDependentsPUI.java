package pageUIs.orangeHRM.pim.employee;

public class AssignedDependentsPUI {
    public static final String ADD_ASSIGNED_DEPENDENTS_BUTTON = "xpath=//h6[text()='Assigned Dependents']/following-sibling::button";
    public static final String DEPENDENTS_NAME_TEXTBOX = "xpath=//label[text()='Name']/parent::div/following-sibling::div/input";
    public static final String DEPENDENTS_RELATIONSHIP_DROPDOWN_PARENT = "xpath=//label[text()='Relationship']/parent::div/following-sibling::div//i";
    public static final String DEPENDENTS_RELATIONSHIP_DROPDOWN_CHILD = "xpath=//label[contains(text(), 'Relationship')]/parent::div/following-sibling::div//div[@class='oxd-select-option']/span";
    public static final String DEPENDENTS_DATE_OF_BIRTH_TEXTBOX = "xpath=//label[contains(text(), 'Date of Birth')]/parent::div/following-sibling::div//input";
    public static final String DEPENDENTS_NAME_COLUMN = "xpath=//div[@class='oxd-table-body']//div[text()='%s']";
    public static final String DEPENDENTS_RELATIONSHIP_COLUMN = "xpath=//div[@class='oxd-table-body']//div[text()='%s']";
    public static final String DEPENDENTS_DATE_OF_BIRTH_COLUMN = "xpath=//div[@class='oxd-table-body']//div[text()='%s']";
    public static final String ADD_DEPENDENTS_ATTACHMENTS_BUTTON = "xpath=//h6[text()='Attachments']/following-sibling::button";
    public static final String DEPENDENTS_ATTACHMENTS_FILE_NAME_COLUMN = "xpath=//div[@class='oxd-table-body']//div[text()='%s']";
    public static final String SAVE_BUTTON_AT_ASSIGNED_DEPENDENTS_CONTAINER = "xpath=//button[normalize-space()='Save']";
}
