/*******************************************************************************
 * Copyright 2020-2023 Zebrunner Inc (https://www.zebrunner.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.zebrunner.carina.demo.gui.components.footer;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.demo.gui.pages.common.HomePageBase;
import com.zebrunner.carina.demo.gui.pages.common.NewsPageBase;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

public class MobileFooterMenu extends FooterMenuBase implements ICustomTypePageFactory {

    @FindBy(xpath = ".//a[text()='News']")
    private ExtendedWebElement newsLink;

    @FindBy(xpath = ".//a[text()='Home']")
    private ExtendedWebElement homeLink;

    public MobileFooterMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public NewsPageBase openNewsPage() {
        newsLink.click();
        return initPage(driver, NewsPageBase.class);
    }

    @Override
    public HomePageBase openHomePage() {
        homeLink.click();
        return initPage(driver, HomePageBase.class);
    }
}
