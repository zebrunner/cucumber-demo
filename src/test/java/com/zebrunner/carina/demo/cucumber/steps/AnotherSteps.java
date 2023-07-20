package com.zebrunner.carina.demo.cucumber.steps;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zebrunner.carina.cucumber.CucumberRunner;

import io.cucumber.java.en.Then;

public class AnotherSteps extends CucumberRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Then("run test with {string}, {string}, {string}")
    public void pageSettingsShouldContainsAllItems(String id, String name, String data) {
        LOGGER.info(id);
        LOGGER.info(name);
        LOGGER.info(data);
    }
}
