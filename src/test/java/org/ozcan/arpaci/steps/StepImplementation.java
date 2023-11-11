package org.ozcan.arpaci.steps;

import com.thoughtworks.gauge.Step;
import org.junit.jupiter.api.Assertions;
import org.ozcan.arpaci.utilities.SeleniumUtils;


public class StepImplementation {
    SeleniumUtils seleniumUtils;

    public StepImplementation() {
        this.seleniumUtils = new SeleniumUtils();
    }

    @Step("Go to url <url>")
    public void goUrl(String url)  {
        seleniumUtils.openURL(url);
    }

    @Step("send text <text> to element <key>")
    public void sendKeys(String text, String key) {
        seleniumUtils.sendKeys(key,text);
    }

    @Step("Click element <key>")
    public void clickElement(String key) {
        seleniumUtils.clickElement(key);
    }

    @Step("Driver title contains <text> value")
    public void getTitle(String text) {
        String title = seleniumUtils.getTitle();
        Assertions.assertTrue(title.contains(text), "title is not contains text");
    }

}
