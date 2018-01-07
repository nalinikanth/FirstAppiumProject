package com.vodqapage.Test;

import com.vodqapage.page.LoginPage;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;

public class ChainedTest extends BaseTest{
    LoginPage loginPage;

    @Test
    public void loginTest(){
        loginPage =new LoginPage(driver);
        loginPage.signIn();
    }

}
