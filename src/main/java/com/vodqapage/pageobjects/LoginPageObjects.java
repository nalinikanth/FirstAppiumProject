package com.vodqapage.pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class LoginPageObjects {

    @AndroidFindBy(accessibility = "login")
    @iOSFindBy(accessibility = "login")
    public MobileElement loginButton;


}
