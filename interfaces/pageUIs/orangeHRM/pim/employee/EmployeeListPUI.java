package pageUIs.orangeHRM.pim.employee;

public class EmployeeListPUI {
    public final static String EMPLOYEE_NAV_LINK = "xpath=//div[@class='oxd-topbar-body']//a[text()='Add Employee']";
    public final static String NEW_RECORD_CHECKBOX = "xpath=//div[text()='%s']/parent::div/parent::div//i[contains(@class, 'oxd-checkbox-input-icon')]";
    public final static String DELETE_RECORD_BUTTON = "xpath=//div[text()='%s']/parent::div/parent::div//button//i[contains(@class, 'bi-trash')]";
    public final static String ACCEPT_DELETE_BUTTON = "xpath=//button[normalize-space()='Yes, Delete']";
}