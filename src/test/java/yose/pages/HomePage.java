package yose.pages;

import com.objogate.wl.web.AsyncWebDriver;

import static org.hamcrest.Matchers.containsString;

public class HomePage {
    private final AsyncWebDriver browser;

    public HomePage(AsyncWebDriver browser) {
        this.browser = browser;
    }

    public HomePage displaysGreeting(String message) {
        browser.assertPageSource(containsString(message));
        return this;
    }

    public HomePage checkCreatorNames(String name)
    {
        browser.assertPageSource(containsString(name));
        return this;
    }

}
