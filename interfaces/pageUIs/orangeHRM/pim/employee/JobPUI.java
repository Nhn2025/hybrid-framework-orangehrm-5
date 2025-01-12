package pageUIs.orangeHRM.pim.employee;

public class JobPUI {
    public static final String JOINED_DATE_TEXT_BOX = "xpath=//label[text()='Joined Date']/parent::div/following-sibling::div//input";
    public static final String JOB_TITLE_DROPDOWN_PARENT = "xpath=//label[text()='Job Title']/parent::div/following-sibling::div//i";
    public static final String JOB_TITLE_DROPDOWN_CHILD = "xpath=//label[contains(text(), 'Job Title')]/parent::div/following-sibling::div//div[@class='oxd-select-option']/span";
    public static final String JOB_TITLE_DROPDOWN_ITEM_SELECTED = "xpath=//label[contains(text(), 'Job Title')]/parent::div/following-sibling::div//div[@class='oxd-select-text-input']";
    public static final String JOB_CATEGORY_DROPDOWN_PARENT = "xpath=//label[text()='Job Category']/parent::div/following-sibling::div//i";
    public static final String JOB_CATEGORY_DROPDOWN_CHILD = "xpath=//label[contains(text(), 'Job Category')]/parent::div/following-sibling::div//div[@class='oxd-select-option']/span";
    public static final String JOB_CATEGORY_DROPDOWN_ITEM_SELECTED = "xpath=//label[contains(text(), 'Job Category')]/parent::div/following-sibling::div//div[@class='oxd-select-text-input']";
    public static final String LOCATION_DROPDOWN_PARENT = "xpath=//label[text()='Location']/parent::div/following-sibling::div//i";
    public static final String LOCATION_DROPDOWN_CHILD = "xpath=//label[contains(text(), 'Location')]/parent::div/following-sibling::div//div[@class='oxd-select-option']/span";
    public static final String LOCATION_DROPDOWN_ITEM_SELECTED = "xpath=//label[contains(text(), 'Location')]/parent::div/following-sibling::div//div[@class='oxd-select-text-input']";
    public static final String EMPLOYMENT_STATUS_DROPDOWN_PARENT = "xpath=//label[text()='Employment Status']/parent::div/following-sibling::div//i";
    public static final String EMPLOYMENT_STATUS_DROPDOWN_CHILD = "xpath=//label[contains(text(), 'Employment Status')]/parent::div/following-sibling::div//div[@class='oxd-select-option']/span";
    public static final String EMPLOYMENT_STATUS_DROPDOWN_ITEM_SELECTED = "xpath=//label[contains(text(), 'Employment Status')]/parent::div/following-sibling::div//div[@class='oxd-select-text-input']";
    public static final String SAVE_BUTTON_AT_JOB_CONTAINER = "xpath=//button[normalize-space()='Save']";
}
