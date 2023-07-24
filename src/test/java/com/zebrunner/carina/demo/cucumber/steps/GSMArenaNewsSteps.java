package com.zebrunner.carina.demo.cucumber.steps;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.zebrunner.carina.cucumber.CucumberRunner;
import com.zebrunner.carina.demo.gui.pages.android.DragAndDropPage;
import com.zebrunner.carina.demo.gui.pages.common.CarinaDescriptionPageBase;
import com.zebrunner.carina.demo.gui.pages.common.LoginPageBase;
import com.zebrunner.carina.demo.gui.pages.common.WelcomePageBase;
import com.zebrunner.carina.utils.android.IAndroidUtils;
import com.zebrunner.carina.webdriver.DriverHelper;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.appmanagement.AndroidInstallApplicationOptions;
import io.cucumber.java.en.When;

public class GSMArenaNewsSteps extends CucumberRunner implements IAndroidUtils {

    @When("^I open 'News' page$")
    public void iOpenNewsPage()  {
        // start testing carina-demo app
        WebDriver driver = getDriver();
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

        // install appium demo app
        installApp("https://github.com/appium/java-client/raw/master/src/test/resources/apps/ApiDemos-debug.apk",
                new AndroidInstallApplicationOptions().withGrantPermissionsEnabled()
                        .withReplaceEnabled());
        // open Appium Demo app with 'DragAndDropDemo' activity
        Activity appiumDemoAppActivity = new Activity("io.appium.android.apis", ".view.DragAndDropDemo");
        startActivity(appiumDemoAppActivity);
        DriverHelper driverHelper = new DriverHelper(getDriver());
        // accept alert
        if (driverHelper.waitUntil(ExpectedConditions.alertIsPresent(), 10)) {
            getDriver().switchTo().alert().accept();
            getDriver().switchTo().defaultContent();
        }

        DragAndDropPage dragAndDropPage = new DragAndDropPage(getDriver());
        dragAndDropPage.dragDown();
        dragAndDropPage.dragRight();
        dragAndDropPage.dragDiagonal();
        Assert.assertTrue(dragAndDropPage.isDragAndDropMessagePresent(), "Should be provided pop up message after successful drag and drop");

        //return to the carina-demo app
        startApp("com.solvd.carinademoapplication");
        CarinaDescriptionPageBase carinaDescriptionPage = loginPage.clickLoginBtn();
        Assert.assertTrue(carinaDescriptionPage.isPageOpened(), "Carina description page isn't opened");

    }

}
