package pageUIs.orangeHRM.pim.employee;

public class ReportToPUI {
    public static final String ADD_ASSIGNED_SUPERVISORS_BUTTON = "xpath=//h6[text()='Assigned Supervisors']/following-sibling::button";
    public static final String NAME_SUPERVISORS_TEXTBOX = "xpath=//label[text()='Name']/parent::div/following-sibling::div//input";
    public static final String NAME_SUPERVISORS_DROPDOWN_CHILD = "xpath=//label[contains(text(), 'Name')]/parent::div/following-sibling::div//div[@role='option']/span";
    public static final String REPORTING_METHOD_SUPERVISORS_DROPDOWN_PARENT = "xpath=//label[text()='Reporting Method']/parent::div/following-sibling::div//i";
    public static final String REPORTING_METHOD_SUPERVISORS_DROPDOWN_CHILD = "xpath=//label[contains(text(), 'Reporting Method')]/parent::div/following-sibling::div//div[@class='oxd-select-option']/span";
    public static final String ADD_ASSIGNED_SUBORDINATE_BUTTON = "xpath=//h6[text()='Assigned Subordinates']/following-sibling::button";
    public static final String NAME_SUBORDINATE_TEXTBOX = "xpath=//label[text()='Name']/parent::div/following-sibling::div//input";
    public static final String NAME_SUBORDINATE_DROPDOWN_CHILD = "xpath=//label[contains(text(), 'Name')]/parent::div/following-sibling::div//div[@role='option']/span";
    public static final String REPORTING_METHOD_SUBORDINATE_DROPDOWN_PARENT = "xpath=//label[text()='Reporting Method']/parent::div/following-sibling::div//i";
    public static final String REPORTING_METHOD_SUBORDINATE_DROPDOWN_CHILD = "xpath=//label[contains(text(), 'Reporting Method')]/parent::div/following-sibling::div//div[@class='oxd-select-option']/span";
    public static final String NAME_SUPERVISORS_COLUMN = "xpath=//div[contains(@class, 'oxd-table-cell')]//div[normalize-space()='%s']";
    public static final String REPORTING_METHOD_SUPERVISORS_COLUMN = "xpath=//div[contains(@class, 'oxd-table-cell')]//div[normalize-space()='%s']";
    public static final String NAME_SUBORDINATE_COLUMN = "xpath=//div[contains(@class, 'oxd-table-cell')]//div[normalize-space()='%s']";
    public static final String REPORTING_METHOD_SUBORDINATE_COLUMN = "xpath=//div[contains(@class, 'oxd-table-cell')]//div[normalize-space()='%s']";
    public static final String SAVE_BUTTON_AT_REPORT_TO_CONTAINER = "xpath=//button[normalize-space()='Save']";
}