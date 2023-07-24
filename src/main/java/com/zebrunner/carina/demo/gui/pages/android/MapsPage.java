package com.zebrunner.carina.demo.gui.pages.android;

import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.demo.gui.pages.common.MapsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MapsPageBase.class)
public class MapsPage extends MapsPageBase {

    public MapsPage(WebDriver driver) {
        super(driver);
    }

}
