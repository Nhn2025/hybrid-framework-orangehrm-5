package pageObjects.orangehrm.pim.employee;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.orangeHRM.pim.employee.SalaryPUI;

public class SalaryPO extends EmployeeTabsPO {
    private WebDriver driver;

    public SalaryPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Click add button at add salary component")
    public void clickAddButtonAtAddSalaryComponent() {
        waitForElementClickable(driver, SalaryPUI.ADD_SALARY_COMPONENT_BUTTON);
        clickToElement(driver, SalaryPUI.ADD_SALARY_COMPONENT_BUTTON);
    }

    @Step("Enter to salary component textbox")
    public void enterToSalaryComponentTextbox(String salaryComponentName) {
        waitForElementVisible(driver, SalaryPUI.SALARY_COMPONENT_TEXTBOX);
        sendKeyToElement(driver, SalaryPUI.SALARY_COMPONENT_TEXTBOX, salaryComponentName);
    }

    @Step("Select pay grade dropdown")
    public void selectPayGradeDropdown(String payGradeName) {
        waitForElementVisible(driver, SalaryPUI.PAY_GRADE_DROPDOWN_PARENT);
        selectItemInCustomDropdown(driver, SalaryPUI.PAY_GRADE_DROPDOWN_PARENT, SalaryPUI.PAY_GRADE_DROPDOWN_CHILD, payGradeName);
    }

    @Step("Select pay frequency dropdown")
    public void selectPayFrequencyDropdown(String payFrequencyName) {
        waitAllLoadingIconInvisible(driver);
        waitForElementClickable(driver, SalaryPUI.PAY_FREQUENCY_DROPDOWN_PARENT);
        selectItemInCustomDropdown(driver, SalaryPUI.PAY_FREQUENCY_DROPDOWN_PARENT, SalaryPUI.PAY_FREQUENCY_DROPDOWN_CHILD, payFrequencyName);
    }

    @Step("Select currency dropdown")
    public void selectCurrencyDropdown(String currencyName) {
        waitForElementClickable(driver, SalaryPUI.CURRENCY_DROPDOWN_PARENT);
        selectItemInCustomDropdown(driver, SalaryPUI.CURRENCY_DROPDOWN_PARENT, SalaryPUI.CURRENCY_DROPDOWN_CHILD, currencyName);
    }

    @Step("Enter to amount text box")
    public void enterToAmountTextbox(String salaryAmount) {
        waitForElementVisible(driver, SalaryPUI.AMOUNT_TEXTBOX);
        sendKeyToElement(driver, SalaryPUI.AMOUNT_TEXTBOX, salaryAmount);
    }

    @Step("Click to save button at salary container")
    public void clickToSaveButtonAtSalaryContainer() {
        waitForElementClickable(driver, SalaryPUI.SAVE_BUTTON_AT_SALARY_CONTAINER);
        clickToElement(driver, SalaryPUI.SAVE_BUTTON_AT_SALARY_CONTAINER);
    }

    @Step("Salary component is updated success")
    public boolean isSalaryComponentUpdatedSuccess(String salaryComponentName) {
        waitForElementVisible(driver, SalaryPUI.SALARY_COMPONENT_COLUMN, salaryComponentName);
        return isElementDisplayed(driver, SalaryPUI.SALARY_COMPONENT_COLUMN, salaryComponentName);
    }

    @Step("Page grade is updated success")
    public boolean isPayGradeUpdatedSuccess(String payGradeName) {
        waitForElementVisible(driver, SalaryPUI.PAY_GRADE_COLUMN, payGradeName);
        return isElementDisplayed(driver, SalaryPUI.PAY_GRADE_COLUMN, payGradeName);
    }

    @Step("Pay frequency is updated success")
    public boolean isPayFrequencyUpdatedSuccess(String payFrequencyName) {
        waitForElementVisible(driver, SalaryPUI.PAY_FREQUENCY_COLUMN, payFrequencyName);
        return isElementDisplayed(driver, SalaryPUI.PAY_FREQUENCY_COLUMN, payFrequencyName);
    }

    @Step("Currency is updated success")
    public boolean isCurrencyUpdatedSuccess(String currencyName) {
        waitForElementVisible(driver, SalaryPUI.CURRENCY_DROPDOWN_COLUMN, currencyName);
        return isElementDisplayed(driver, SalaryPUI.CURRENCY_DROPDOWN_COLUMN, currencyName);
    }

    @Step("Amount is updated success")
    public boolean isAmountUpdatedSuccess(String salaryAmount) {
        waitForElementVisible(driver, SalaryPUI.AMOUNT_COLUMN, salaryAmount);
        return isElementDisplayed(driver, SalaryPUI.AMOUNT_COLUMN, salaryAmount);
    }
}
