package com.zebrunner.carina.demo;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.zebrunner.carina.cucumber.CucumberBaseTest;
import com.zebrunner.carina.utils.R;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/GSMArenaNews.feature",
        glue = "com.zebrunner.carina.demo.cucumber.steps",
        plugin={"pretty",
                "html:target/cucumber-core-test-report",
                "pretty:target/cucumber-core-test-report.txt",
                "json:target/cucumber-core-test-report.json",
                "junit:target/cucumber-core-test-report.xml"}
)
public class CucumberWebSampleTest extends CucumberBaseTest {
    //do nothing here as everything is declared in "GSMArenaNews.feature" and steps

    @Parameters({ "web_capabilities_path", "mobile_capabilities_path" })
    @BeforeTest
    public static void setUpScenario(String webCapabilitiesPath, String mobileCapabilitiesPath) {
        R.CONFIG.put("web_capabilities_path", webCapabilitiesPath);
        R.CONFIG.put("mobile_capabilities_path", mobileCapabilitiesPath);

    }
}
