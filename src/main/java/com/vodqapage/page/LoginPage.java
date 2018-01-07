package com.vodqapage.page;

import com.vodqapage.pageobjects.LoginPageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPageObjects loginPageObjects;
    public LoginPage(AppiumDriver driver)
    {
        loginPageObjects = new LoginPageObjects();
        PageFactory.initElements(new AppiumFieldDecorator(driver), loginPageObjects);

    }

    public void signIn(){
        loginPageObjects.loginButton.click();
    }

}
