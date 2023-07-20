package com.zebrunner.carina.demo;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.zebrunner.carina.cucumber.CucumberBaseTest;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/GSMArenaNews.feature",
        glue = "com.zebrunner.carina.demo.cucumber.steps",
        tags = "@FeatureGSMArena",
        plugin={"pretty",
                "html:target/cucumber-core-test-report",
                "pretty:target/cucumber-core-test-report.txt",
                "json:target/cucumber-core-test-report.json",
                "junit:target/cucumber-core-test-report.xml"}
)
public class CucumberWebSampleTest extends CucumberBaseTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    //do nothing here as everything is declared in "GSMArenaNews.feature" and steps
    @BeforeSuite
    public void beforeSuite() {
        LOGGER.info("Before Suite");
    }

    @AfterSuite
    public void afterSuite() {
        LOGGER.info("After Suite");
    }
}
