package pageUIs.orangeHRM.pim.employee;

public class SalaryPUI {
    public static final String ADD_SALARY_COMPONENT_BUTTON = "xpath=//h6[text()='Assigned Salary Components']/following-sibling::button";
    public static final String SALARY_COMPONENT_TEXTBOX = "xpath=//label[text()='Salary Component']/parent::div/following-sibling::div/input";
    public static final String PAY_GRADE_DROPDOWN_PARENT = "xpath=//label[text()='Pay Grade']/parent::div/following-sibling::div//i";
    public static final String PAY_GRADE_DROPDOWN_CHILD = "xpath=//label[contains(text(), 'Pay Grade')]/parent::div/following-sibling::div//div[@class='oxd-select-option']/span";
    public static final String PAY_FREQUENCY_DROPDOWN_PARENT = "xpath=//label[text()='Pay Frequency']/parent::div/following-sibling::div//i";
    public static final String PAY_FREQUENCY_DROPDOWN_CHILD = "xpath=//label[contains(text(), 'Pay Frequency')]/parent::div/following-sibling::div//div[@class='oxd-select-option']/span";
    public static final String CURRENCY_DROPDOWN_PARENT = "xpath=//label[text()='Currency']/parent::div/following-sibling::div//i";
    public static final String CURRENCY_DROPDOWN_CHILD = "xpath=//label[contains(text(), 'Currency')]/parent::div/following-sibling::div//div[@class='oxd-select-option']/span";
    public static final String AMOUNT_TEXTBOX = "xpath=//label[contains(text(), 'Amount')]/parent::div/following-sibling::div//input";
    public static final String SALARY_COMPONENT_COLUMN = "xpath=//div[@class='oxd-table-body']//div[text()='%s']";
    public static final String PAY_GRADE_COLUMN = "xpath=//div[@class='oxd-table-body']//div[text()='%s']";
    public static final String PAY_FREQUENCY_COLUMN = "xpath=//div[@class='oxd-table-body']//div[text()='%s']";
    public static final String CURRENCY_DROPDOWN_COLUMN = "xpath=//div[@class='oxd-table-body']//div[text()='%s']";
    public static final String AMOUNT_COLUMN = "xpath=//div[@class='oxd-table-body']//div[text()='%s']";
    public static final String SAVE_BUTTON_AT_SALARY_CONTAINER = "xpath=//button[normalize-space()='Save']";
}