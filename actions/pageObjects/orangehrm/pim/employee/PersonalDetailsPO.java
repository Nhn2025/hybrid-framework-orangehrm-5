package pageObjects.orangehrm.pim.employee;

import commons.BasePage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public class PersonalDetailsPO extends BasePage {
    private WebDriver driver;

    public PersonalDetailsPO(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToSaveButtonAtProfileContainer() {

    }

    public void clickToEmployeeAvatarImage() {
    }

    public void loadAvatarImage() {
    }

    public void isSuccessMessageDisplayed(String message) {
    }

    public boolean isProfileAvatarUpdateSuccess() {
        return true;
    }

    public Dimension getAvatarSize() {
        return null;
    }
}