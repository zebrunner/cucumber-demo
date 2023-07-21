package com.zebrunner.carina.demo.gui.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.demo.gui.pages.common.CompareModelsPageBase;
import com.zebrunner.carina.demo.gui.pages.common.HomePageBase;
import com.zebrunner.carina.demo.gui.pages.common.NewsPageBase;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;

public class FooterMenu extends AbstractUIObject implements ICustomTypePageFactory {

    @FindBy(linkText = "Home")
    private ExtendedWebElement homeLink;

    @FindBy(xpath = "//div[@class='footer-inner']//a[contains(text(),'Compare')]")
    private ExtendedWebElement compareLink;
    
    @FindBy(linkText = "News")
    private ExtendedWebElement newsLink;

    public FooterMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public HomePageBase openHomePage() {
        homeLink.click();
        return initPage(driver, HomePageBase.class);
    }

    public CompareModelsPageBase openComparePage() {
        compareLink.click();
        return initPage(driver, CompareModelsPageBase.class);
    }
    
    public NewsPageBase openNewsPage() {
        newsLink.click();
        return initPage(driver, NewsPageBase.class);
    }
}
