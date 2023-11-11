package org.ozcan.arpaci.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.ozcan.arpaci.base.BaseDriver;
import org.ozcan.arpaci.model.ElementInfo;

import java.time.Duration;

public class SeleniumUtils {
    WebDriver driver;
    FluentWait<WebDriver> wait;
    long waitElementTimeout = 30;
    long pollingEveryValue = 300;

    public SeleniumUtils() {
        this.driver = BaseDriver.driver;
        wait = setFluentWait(waitElementTimeout);
    }

    public FluentWait<WebDriver> setFluentWait(long timeout) {

        FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver);
        fluentWait.withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofMillis(pollingEveryValue))
                .ignoring(NoSuchElementException.class);
        return fluentWait;
    }

    public WebElement findElement(By locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));

        return element;
    }

    public void openURL(String url) {
        driver.get(url);
    }

    public void sendKeys(String locator, String text) {
        findElement(getBy(locator)).sendKeys(text);

    }

    public void clickElement(String locator) {
        findElement(getBy(locator)).click();
    }

    public String getElementText(String locator) {
        return findElement(getBy(locator)).getText();
    }
    public String getTitle(){
        return driver.getTitle();
    }
    public ElementInfo getElementInfo(String key) {
        LocatorUtility storeHelper=new LocatorUtility();

        return storeHelper.findElementInfoByKey(key);
    }
    public By getBy(String key) {
        ElementInfo elementInfo = getElementInfo(key);
        By by = ElementHelper.getElementInfoToBy(elementInfo);

        return by;
    }

}

