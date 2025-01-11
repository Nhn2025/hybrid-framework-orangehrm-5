package commons;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageUIs.orangeHRM.BasePagePUI;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePage {
    public static BasePage getBasePage() {
        return new BasePage();
    }

    public void openPageUrl(WebDriver driver, String pageUrl) {
        driver.get(pageUrl);
    }

    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public String getCurrentPageUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public String getPageSource(WebDriver driver) {
        return driver.getPageSource();
    }

    public void backToPage(WebDriver driver) {
        driver.navigate().back();
    }

    public void forwardToPage(WebDriver driver) {
        driver.navigate().forward();
    }

    public void refreshCurrentPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    public Alert waitForAlertPresence(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.alertIsPresent());
    }

    public void acceptToAlert(WebDriver driver) {
        waitForAlertPresence(driver).accept();
    }

    public void cancelToAlert(WebDriver driver) {
        waitForAlertPresence(driver).dismiss();
    }

    public void getTextInAlert(WebDriver driver) {
        waitForAlertPresence(driver).getText();
    }

    public void sendkeyToAlert(WebDriver driver, String keysToSend) {
        waitForAlertPresence(driver).sendKeys(keysToSend);
    }

    public void switchToWindowByID(WebDriver driver, String expectedID) {
        Set<String> allIDs = driver.getWindowHandles();
        for (String id : allIDs)
            if (id.equals(expectedID)) {
                driver.switchTo().window(id);
                break;
            }
    }

    public void switchToWindowByTitle(WebDriver driver, String expectedTitle) {
        Set<String> allIDs = driver.getWindowHandles();
        for (String id : allIDs) {
            driver.switchTo().window(id);
            sleepInSeconds(2);
            String actualTitle = driver.getTitle();
            if (actualTitle.equals(expectedTitle))
                break;
        }
    }

    public void closeAllWindowWithoutParent(WebDriver driver, String parentID) {
        Set<String> allIDs = driver.getWindowHandles();
        for (String id : allIDs)
            if (!id.equals(parentID))  {
                driver.switchTo().window(id);
                driver.close();
            }
        driver.switchTo().window(parentID);
    }

    public void sleepInSeconds(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Set<Cookie> getBrowserCookies(WebDriver driver) {
        return driver.manage().getCookies();
    }

    public void setCookies(WebDriver driver, Set<Cookie> cookies) {
        for (Cookie cookie : cookies)
            driver.manage().addCookie(cookie);
    }

    public void deleteAllCookies(WebDriver driver) {
        driver.manage().deleteAllCookies();
    }

    public WebElement getWebElement(WebDriver driver, String locator) {
        return driver.findElement(getByLocator(locator));
    }

    public List<WebElement> getListWebElement(WebDriver driver, String locator) {
        return driver.findElements(getByLocator(locator));
    }

    public List<WebElement> getListWebElement(WebDriver driver, String locator, String... restParams) {
        return driver.findElements(getByLocator(getDynamicLocator(locator, restParams)));
    }

    public By getByLocator(String locatorValue) {
        By by = null;

        if (locatorValue.startsWith("xpath=") || locatorValue.startsWith("XPath=")
                || locatorValue.startsWith("XPATH=") || locatorValue.startsWith("Xpath="))
            by = By.xpath(locatorValue.substring(6));
        else if (locatorValue.startsWith("css=") || locatorValue.startsWith("Css=")
                || locatorValue.startsWith("CSS="))
            by = By.cssSelector(locatorValue.substring(4));
        else if (locatorValue.startsWith("id=") || locatorValue.startsWith("ID=")
                || locatorValue.startsWith("Id="))
            by = By.id(locatorValue.substring(3));
        else if (locatorValue.startsWith("name=") || locatorValue.startsWith("Name=")
                || locatorValue.startsWith("NAME="))
            by = By.name(locatorValue.substring(5));
        else if (locatorValue.startsWith("class=") || locatorValue.startsWith("Class=")
                || locatorValue.startsWith("CLASS="))
            by = By.className(locatorValue.substring(6));
        else if (locatorValue.startsWith("Tagname=") || locatorValue.startsWith("Tagname=")
                || locatorValue.startsWith("TAGNAME="))
            by = By.tagName(locatorValue.substring(8));
        else
            throw new RuntimeException("Locator type is not valid.");
        return by;
    }

    public By getByLocatorV2(String locator) {
        By by = null;
        String[] splitLocator = locator.split("=", 2);
        if (splitLocator[0].equalsIgnoreCase("xpath"))
            by = By.xpath(splitLocator[1]);
        else if (splitLocator[0].equalsIgnoreCase("css"))
            by = By.cssSelector(splitLocator[1]);
        else if (splitLocator[0].equalsIgnoreCase("id"))
            by = By.id(splitLocator[1]);
        else if (splitLocator[0].equalsIgnoreCase("class"))
            by = By.className(splitLocator[1]);
        else if (splitLocator[0].equalsIgnoreCase("name"))
            by = By.name(splitLocator[1]);
        else if (splitLocator[0].equalsIgnoreCase("tagname"))
            by = By.tagName(splitLocator[1]);
        else
            throw new RuntimeException("Locator type is not valid.");
        return by;
    }

    public String getDynamicLocator(String locator, String... restParams) {
        return String.format(locator, (Object[]) restParams);
    }

    public By getByXpath(String locator) {
        return By.xpath(locator);
    }

    public void clickToElement(WebDriver driver, String locator) {
        getWebElement(driver, locator).click();
    }

    public void clickToElement(WebDriver driver, WebElement element) {
        element.click();
    }

    public void clickToElement(WebDriver driver, String locator, String... restParams) {
        getWebElement(driver, getDynamicLocator(locator, restParams)).click();
    }

    public void sendKeyToElement(WebDriver driver, String locator, String valueToSend, String... restParams) {
        getWebElement(driver, getDynamicLocator(locator, restParams)).clear();
        getWebElement(driver, getDynamicLocator(locator, restParams)).sendKeys(valueToSend);
    }

    public void sendKeyToElement(WebDriver driver, String locator, String valueToSend) {
        getWebElement(driver, locator).clear();
        getWebElement(driver, locator).sendKeys(valueToSend);
    }

    public void sendKeyToElementBackSpace(WebDriver driver, String locator, String valueToSend) {
        Keys key = null;
        if (GlobalConstants.OS_NAME.startsWith("Windows"))
            key = Keys.CONTROL;
        else
            key = Keys.COMMAND;
        getWebElement(driver, locator).sendKeys(Keys.chord(key, "a", Keys.BACK_SPACE));
        getWebElement(driver, locator).sendKeys(valueToSend);
    }

    public void selectInItemDefaultDropdown(WebDriver driver, String locator, String itemValue) {
        new Select(getWebElement(driver, locator)).selectByVisibleText(itemValue);
    }

    public void selectInItemDefaultDropdown(WebDriver driver, String locator, String itemValue, String... restParams) {
        new Select(getWebElement(driver, getDynamicLocator(locator, restParams))).selectByVisibleText(itemValue);
    }

    public String getFirstSelectedTextInDefault(WebDriver driver, String locator) {
        return new Select(getWebElement(driver, locator)).getFirstSelectedOption().getText();
    }

    public Boolean isDefaultDropdownMultiple(WebDriver driver, String locator) {
        return new Select(getWebElement(driver, locator)).isMultiple();
    }

    public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String chillLocator, String itemTextExpected) {
        getWebElement(driver, parentLocator).click();
        sleepInSeconds(1);

        List<WebElement> allItems = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.
                presenceOfAllElementsLocatedBy(getByLocator(chillLocator)));
        for (WebElement item : allItems) {
            if (item.getText().trim().equals(itemTextExpected)) {
                sleepInSeconds(1);
                item.click();
                break;
            }
        }
    }

    public String getElementText(WebDriver driver, String locator) {
        return getWebElement(driver, locator).getText();
    }

    public String getElementText(WebDriver driver, String locator, String... restParams) {
        return getWebElement(driver, getDynamicLocator(locator, restParams)).getText();
    }

    public String getElementAttribute(WebDriver driver, String locator, String attributeName) {
        return getWebElement(driver, locator).getAttribute(attributeName);
    }

    public String getElementAttribute(WebDriver driver, String locator, String attributeName, String... restParams) {
        return getWebElement(driver, getDynamicLocator(locator, restParams)).getAttribute(attributeName);
    }

    public String getElementCssValue(WebDriver driver, String locator, String propertyName) {
        return getWebElement(driver, locator).getCssValue(propertyName);
    }

    public String convertRBGAToHexaColor(WebDriver driver, String locator) {
        return Color.fromString(getElementCssValue(driver, locator, "background-color")).asHex();
    }

    public Dimension getElementSize(WebDriver driver, String locator) {
        return getWebElement(driver, locator).getSize();
    }

    public int getListElementsSize(WebDriver driver, String locator) {
        return getListWebElement(driver, locator).size();
    }

    public int getListElementsSize(WebDriver driver, String locator, String... restParams) {
        return getListWebElement(driver, getDynamicLocator(locator, restParams)).size();
    }

    /*
    * Apply for checkbox and radio button
    */
    public void checkToCheckboxRadio(WebDriver driver, String locator) {
        if (!getWebElement(driver, locator).isSelected())
            getWebElement(driver, locator).click();
    }

    public void checkToCheckboxRadio(WebDriver driver, String locator, String... restParams) {
        if (!getWebElement(driver, getDynamicLocator(locator, restParams)).isSelected())
            getWebElement(driver, getDynamicLocator(locator, restParams)).click();
    }

    /*
     * Only apply for checkbox
     */
    public void uncheckToCheckboxRadio(WebDriver driver, String locator) {
        if (getWebElement(driver, locator).isSelected())
            getWebElement(driver, locator).click();
    }

    // Case 01: Element hiển thị và có trong HTML
    // Case 02: Element ko hiển thị và có trong HTML
    public boolean isElementDisplayed(WebDriver driver, String locator) {
        return getWebElement(driver, locator).isDisplayed();
    }

    public boolean isElementDisplayed(WebDriver driver, String locator, String... restParams) {
        return getWebElement(driver, getDynamicLocator(locator, restParams)).isDisplayed();
    }

    public void setImplicitWait(WebDriver driver, long timeout) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
    }

    // Case 03: Element không có trong UI và không có trên UI
    public boolean isElementUndisplayed(WebDriver driver, String locator) {
        // Trước khi tìm element thì set time ngắn thôi
        setImplicitWait(driver, GlobalConstants.SHORT_TIMEOUT);
        List<WebElement> elements = getListWebElement(driver, locator);
        // Trả lại timeout cho các step còn lại
        setImplicitWait(driver, GlobalConstants.LONG_TIMEOUT);

        if (elements.size() > 0 && elements.get(0).isDisplayed())
            // Case 01: Element có trong UI và DOM -> false
            return false;
        else if (elements.size() > 0 && !elements.get(0).isDisplayed())
            // Case 02: Không có trên UI và có trong DOM -> true
            return true;
        else // elements.size() == 0
            // Case 03: Không có trên UI và không có trong DOM -> true
            return true;
    }

    public boolean isElementSelected(WebDriver driver, String locator) {
        return getWebElement(driver, locator).isSelected();
    }

    public boolean isElementSelected(WebDriver driver, String locator, String... restParams) {
        return getWebElement(driver, getDynamicLocator(locator, restParams)).isSelected();
    }

    public boolean isElementEnabled(WebDriver driver, String locator) {
        return getWebElement(driver, locator).isEnabled();
    }

    public void switchToIframe(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(getByLocator(locator)));
    }

    public void switchToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    public void hoverToElement(WebDriver driver, String locator) {
        new Actions(driver).moveToElement(getWebElement(driver, locator)).perform();
    }

    public void doubleClickToELement(WebDriver driver, String locator) {
        new Actions(driver).doubleClick(getWebElement(driver, locator)).perform();
    }

    public void rightClickToELement(WebDriver driver, String locator) {
        new Actions(driver).contextClick(getWebElement(driver, locator)).perform();
    }

    public void dragAndDropToELement(WebDriver driver, String sourceLocator, String targetLocator) {
        new Actions(driver).dragAndDrop
                (getWebElement(driver, sourceLocator), getWebElement(driver, targetLocator)).perform();
    }

    public void sendKeyBoardToELement(WebDriver driver, String locator, Keys key) {
        new Actions(driver).sendKeys(getWebElement(driver, locator), key).perform();
    }

    public Object executeForBrowser(WebDriver driver, String javaScript) {
        return ((JavascriptExecutor) driver).executeScript(javaScript);
    }

    public String getInnerText(WebDriver driver) {
        return (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText;");
    }

    public boolean isExpectedTextInInnerText(WebDriver driver, String textExpected) {
        String textActual = (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
        return textActual.equals(textExpected);
    }

    public void scrollToBottomPage(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void sleepInSecond(int timeout) {
        try {
            Thread.sleep(timeout * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void navigateToUrlByJS(WebDriver driver, String url) {
        ((JavascriptExecutor) driver).executeScript("window.location = '" + url + "'");
        sleepInSecond(3);
    }

    public void highLightElement(WebDriver driver, String locator) {
        WebElement element = getWebElement(driver, locator);
        String originalStyle = element.getAttribute("style");
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInSecond(2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getWebElement(driver, locator));
        sleepInSecond(3);
    }

    public void clickToElementByJS(WebDriver driver, String locator, String... restParams) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getWebElement(driver, getDynamicLocator(locator, restParams)));
        sleepInSecond(3);
    }

    public void scrollToElementOnTop(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locator));
    }

    public void scrollToElementOnDown(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", getWebElement(driver, locator));
    }

    public void setAttributeInDOM(WebDriver driver, String locator, String attributeName, String attributeValue) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue +"');", getWebElement(driver, locator));
    }

    public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, locator));
    }

    public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')", getWebElement(driver, locator));
    }

    public String getAttributeInDOM(WebDriver driver, String locator, String attributeName) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].getAttribute('" + attributeName + "');", getWebElement(driver, locator));
    }

    public String getElementValidationMessage(WebDriver driver, String locator) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getWebElement(driver, locator));
    }

    public boolean isImageLoaded(WebDriver driver, String locator) {
        boolean status = (boolean) ((JavascriptExecutor) driver).executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getWebElement(driver, locator));
        return status;
    }

    public void waitForElementVisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
    }

    public void waitForElementVisible(WebDriver driver, String locator, String... restParams) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicLocator(locator, restParams))));
    }

    public void waitForListElementVisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.visibilityOfAllElements(getListWebElement(driver, locator)));
    }

    public boolean waitForElementInvisible(WebDriver driver, String locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
    }

    public boolean waitForListElementInvisible(WebDriver driver, String locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, locator)));
    }

    public void waitForElementClickable(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.elementToBeClickable(getWebElement(driver, locator)));
    }

    public void waitForElementClickable(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementClickable(WebDriver driver, String locator, String... restParams) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.elementToBeClickable(getWebElement(driver, getDynamicLocator(locator, restParams))));
    }

    public void waitForElementSelected(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.elementToBeSelected(element));
    }

    public void waitForElementSelected(WebDriver driver, String locator, String... restParams) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.elementToBeSelected(getWebElement(driver, getDynamicLocator(locator, restParams))));

    }

    public boolean isPageLoadedSuccess(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return (Boolean) ((JavascriptExecutor) driver)
                        .executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
            }
        });
    }

    public void uploadMultipleFiles(WebDriver driver, String... fileNames) {
        String filePath = GlobalConstants.UPLOAD_PATH;
        String fullFileName = "";
        for (String file : fileNames)
            fullFileName = fullFileName + filePath + file + "\n";
        fullFileName = fullFileName.trim();
        getWebElement(driver, BasePagePUI.UPLOAD_IMAGE_BUTTON).sendKeys(fullFileName);
    }

    public boolean waitAllLoadingIconInvisible(WebDriver driver) {
        return waitForListElementInvisible(driver, BasePagePUI.LOADING_ICON);
    }

    @Step("Update success message is displayed")
    public boolean isUpdateSuccessMessageDisplayed(WebDriver driver) {
        waitForElementVisible(driver, BasePagePUI.UPDATE_SUCCESS_MESSAGE);
        return isElementDisplayed(driver, BasePagePUI.UPDATE_SUCCESS_MESSAGE);
    }

    @Step("Save success message is displayed")
    public boolean isSaveSuccessMessageDisplayed(WebDriver driver) {
        waitForElementVisible(driver, BasePagePUI.SAVE_SUCCESS_MESSAGE);
        return isElementDisplayed(driver, BasePagePUI.SAVE_SUCCESS_MESSAGE);
    }
}