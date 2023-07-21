package com.zebrunner.carina.demo.cucumber.steps;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.zebrunner.carina.cucumber.CucumberRunner;
import com.zebrunner.carina.demo.gui.pages.common.BrandModelsPageBase;
import com.zebrunner.carina.demo.gui.pages.common.CarinaDescriptionPageBase;
import com.zebrunner.carina.demo.gui.pages.common.HomePageBase;
import com.zebrunner.carina.demo.gui.pages.common.LoginPageBase;
import com.zebrunner.carina.demo.gui.pages.common.ModelInfoPageBase;
import com.zebrunner.carina.demo.gui.pages.common.WelcomePageBase;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.android.IAndroidUtils;
import com.zebrunner.carina.webdriver.core.capability.CapabilitiesLoader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class GSMArenaNewsSteps extends CucumberRunner implements IAndroidUtils {
    private static final String WEB_DRIVER_NAME = "web";
    private static final String NATIVE_DRIVER_NAME = "native";

    @Given("^I am on main page")
    public boolean iAmOnMainPage() {
        R.CONFIG.put("capabilities.platformName", "ANDROID", true);
        MutableCapabilities options = new CapabilitiesLoader().getCapabilities(R.CONFIG.get("web_capabilities_path"));
        WebDriver driver = getDriver(WEB_DRIVER_NAME, options);
        // Open GSM Arena home page and verify page is opened
        HomePageBase homePage = initPage(driver, HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        // Select phone brand
        BrandModelsPageBase productsPage = homePage.selectBrand("Samsung");
        // Select phone model
        ModelInfoPageBase productInfoPage = productsPage.selectModel("Galaxy A04");
        // Verify phone specifications
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(productInfoPage.readDisplay(), "6.5\"", "Invalid display info!");
        softAssert.assertEquals(productInfoPage.readCamera(), "50MP", "Invalid camera info!");
        softAssert.assertEquals(productInfoPage.readRam(), "3-8GB RAM", "Invalid ram info!");
        softAssert.assertEquals(productInfoPage.readBattery(), "5000mAh", "Invalid battery info!");
        softAssert.assertAll();
        quitDriver(WEB_DRIVER_NAME);
        return true;
    }

    @When("^I open 'News' page$")
    public void iOpenNewsPage()  {
        R.CONFIG.put("capabilities.platformName", "ANDROID", true);
        MutableCapabilities options = new CapabilitiesLoader().getCapabilities(R.CONFIG.get("mobile_capabilities_path"));
        WebDriver driver = getDriver(NATIVE_DRIVER_NAME, options);
        String username = "Test user";
        String password = RandomStringUtils.randomAlphabetic(10);
        WelcomePageBase welcomePage = initPage(driver, WelcomePageBase.class);
        Assert.assertTrue(welcomePage.isPageOpened(), "Welcome page isn't opened");
        LoginPageBase loginPage = welcomePage.clickNextBtn();
        Assert.assertFalse(loginPage.isLoginBtnActive(), "Login button is active when it should be disabled");
        loginPage.typeName(username);
        loginPage.typePassword(password);
        loginPage.selectMaleSex();
        loginPage.checkPrivacyPolicyCheckbox();
        CarinaDescriptionPageBase carinaDescriptionPage = loginPage.clickLoginBtn();
        Assert.assertTrue(carinaDescriptionPage.isPageOpened(), "Carina description page isn't opened");
    }

}
