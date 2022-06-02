package com.zebrunner.carina.demo.gui.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;

public class WeValuePrivacyAd extends AbstractUIObject {
	@FindBy(xpath = "//button[contains(@onclick, 'setAndSaveAllConsent')]")
	private ExtendedWebElement okBtn;

	public WeValuePrivacyAd(WebDriver driver, SearchContext searchContext) {
		super(driver, searchContext);
	}

	public WeValuePrivacyAd(WebDriver driver) {
		super(driver);
	}

	public void closeAdIfPresent() {
		okBtn.clickIfPresent();
	}

}
