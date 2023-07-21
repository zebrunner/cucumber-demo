package com.zebrunner.carina.demo.cucumber.steps;

import com.zebrunner.carina.utils.R;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.zebrunner.carina.cucumber.CucumberRunner;
import com.zebrunner.carina.demo.gui.pages.HomePage;
import com.zebrunner.carina.demo.gui.pages.NewsPage;
import com.zebrunner.carina.webdriver.core.capability.CapabilitiesLoader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class GSMArenaNewsSteps extends CucumberRunner {

    private static final String WEB_DRIVER_NAME = "web";
    private static final String MOBILE_NATIVE_DRIVER_NAME = "mobile_native";


    @Given("^I am on main page")
    public boolean iAmOnMainPage() {
        // Read "web" capabilities from file
        MutableCapabilities options = new CapabilitiesLoader().getCapabilities(R.CONFIG.get("web_capabilities_path"));
        // Create driver "web" in driverPool with custom capabilities
        WebDriver driver = getDriver(WEB_DRIVER_NAME, options);
        //...
        HomePage homePage = new HomePage(driver);
        homePage.open();
        boolean isPageOpened = homePage.isPageOpened();
        // we have to remove the driver since we won't use it anymore in the future
        quitDriver(WEB_DRIVER_NAME);
        return isPageOpened;
    }

    @When("^I open 'News' page$")
    public void iOpenNewsPage()  {
        // read "mobile" capabilities from file
        MutableCapabilities capabilities = new CapabilitiesLoader().getCapabilities(R.CONFIG.get("mobile_capabilities_path"));
        // here we should set appium link
        WebDriver driver = getDriver(MOBILE_NATIVE_DRIVER_NAME, capabilities, "http://localhost:4723/wd/hub");
        NewsPage newsPage = new NewsPage(driver);
        Assert.assertTrue(newsPage.isPageOpened(), "News page is not opened!");
    }

}
