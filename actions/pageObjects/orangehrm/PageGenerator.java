package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;
import pageObjects.orangehrm.pim.configuration.*;
import pageObjects.orangehrm.pim.employee.*;
import pageObjects.orangehrm.pim.reports.AddNewReportPO;

public class PageGenerator {
    public static DashboardPO getDashboardPage(WebDriver driver) {
        return new DashboardPO(driver);
    }

    public static LoginPO getLoginPage(WebDriver driver) {
        return new LoginPO(driver);
    }

    public static AddNewEmployeePO getAddNewEmployeePage(WebDriver driver) {
        return new AddNewEmployeePO(driver);
    }

    public static AddNewReportPO getAddNewReportPage(WebDriver driver) {
        return new AddNewReportPO(driver);
    }

    public static ContactDetailsPO getContactDetailsPage(WebDriver driver) {
        return new ContactDetailsPO(driver);
    }

    public static EmployeeListPO getEmployeeListPage(WebDriver driver) {
        return new EmployeeListPO(driver);
    }

    public static PersonalDetailsPO getPersonalDetailsPage(WebDriver driver) {
        return new PersonalDetailsPO(driver);
    }

    public static CustomFieldPO getCustomFieldPage(WebDriver driver) {
        return new CustomFieldPO(driver);
    }

    public static DataImportFieldsPO getDataImportFieldsPage(WebDriver driver) {
        return new DataImportFieldsPO(driver);
    }

    public static OptionalFieldsPO getOptionalFieldsPage(WebDriver driver) {
        return new OptionalFieldsPO(driver);
    }

    public static ReportingMethodPO getReportingMethodPage(WebDriver driver) {
        return new ReportingMethodPO(driver);
    }

    public static TerminationReasonsPO getTerminationReasonsPage(WebDriver driver) {
        return new TerminationReasonsPO(driver);
    }

    public static ContactDetailsPO getContactDetailsPOPage(WebDriver driver) {
        return new ContactDetailsPO(driver);
    }

    public static EmergencyContactsPO getEmergencyContactsPage(WebDriver driver) {
        return new EmergencyContactsPO(driver);
    }
}