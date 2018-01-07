package com.vodqapage.utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class Helper {
    public AppiumDriver driver;
    public Helper(AppiumDriver driver){
        this.driver = driver;
    }
}
