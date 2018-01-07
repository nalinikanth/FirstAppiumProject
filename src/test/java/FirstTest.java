import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class FirstTest {

    public AppiumDriver driver;
//    String deviceType="iphone";
    String deviceType="android";

    @BeforeClass
    public void setUp() throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps=new DesiredCapabilities();
        if(deviceType.equalsIgnoreCase("android")){
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"android");
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
//        caps.setCapability(MobileCapabilityType.APP,"/VodQA.apk");
            caps.setCapability(MobileCapabilityType.DEVICE_NAME,"MAD");
            caps.setCapability(MobileCapabilityType.APP,"/Users/null/appium/AppiumSample/VodQA.apk");
            driver =new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),caps);
            driver.findElementByAccessibilityId("username").sendKeys("admin");
            driver.findElementByAccessibilityId("password").sendKeys("admin");
            driver.findElementByAccessibilityId("login").click();
            Thread.sleep(3000);
        }else if(deviceType.equalsIgnoreCase("iphone")){
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"XCUITest");
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"11.2");
            caps.setCapability(MobileCapabilityType.UDID,"776CAE5C-FD9E-465E-AA16-B4DE66CF5767");
            caps.setCapability(MobileCapabilityType.APP,"/Users/null/appium/AppiumSample/VodQAReactNative.app");
            caps.setCapability(MobileCapabilityType.DEVICE_NAME,"iphone 6");
            driver =new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"),caps);
            MobileElement username=(MobileElement) driver.findElementByAccessibilityId("username");
            username.clear();
            username.sendKeys("admin");
            MobileElement password=(MobileElement)driver.findElementByAccessibilityId("password");
            password.clear();
            password.sendKeys("admin");
            driver.findElementByAccessibilityId("login").click();
            Thread.sleep(3000);
        }




    }
    @Test
    public void slideTest() throws InterruptedException {
        driver.findElementByAccessibilityId("Slide your number").click();
        Thread.sleep(3000);
        MobileElement slider = (MobileElement) driver.findElementByAccessibilityId("slider");
        Thread.sleep(3000);
        MobileElement slider1 = (MobileElement) driver.findElementByAccessibilityId("slider1");
        Dimension d=slider.getSize();
        Dimension d1=slider1.getSize();
        TouchAction touchAction1=new TouchAction(driver);
//        touchAction1.press(slider1, 0,d1.getHeight()/2)
//                .waitAction(Duration.ofSeconds(3))
//                .moveTo(slider1, d1.getWidth()/2,d1.getHeight()/2);
//        touchAction1.release().perform();
        touchAction1.press(ElementOption.element(slider1).withCoordinates(0,d.getHeight()/2))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(ElementOption.element(slider1).withCoordinates(d1.getWidth()/2,d.getHeight()/2));
        touchAction1.release().perform();
//        TouchAction touchAction=new TouchAction(driver);
//        touchAction.press(slider1, 0,d.getHeight()/2)
//                .waitAction(Duration.ofSeconds(3))
//                .moveTo(slider1, d.getWidth()/2,d.getHeight()/2);
//        touchAction.release().perform();

    }

    @Test
    public void multiTouchTest() throws InterruptedException {
        driver.findElementByAccessibilityId("Slide your number").click();
        Thread.sleep(3000);
        MobileElement slider = (MobileElement) driver.findElementByAccessibilityId("slider");
        Thread.sleep(3000);
        MobileElement slider1 = (MobileElement) driver.findElementByAccessibilityId("slider1");
        Dimension d=slider.getSize();
        Dimension d1=slider1.getSize();
        TouchAction touchAction1=new TouchAction(driver);
        touchAction1.press(ElementOption.element(slider1).withCoordinates(0,d1.getHeight()/2))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(ElementOption.element(slider1).withCoordinates(d1.getWidth()/2,d1.getHeight()/2));
        TouchAction touchAction=new TouchAction(driver);
        touchAction.press(ElementOption.element(slider).withCoordinates(0,d.getHeight()/2))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(ElementOption.element(slider).withCoordinates(d.getWidth()/2,d.getHeight()/2));
        new MultiTouchAction(driver).add(touchAction).add(touchAction1).perform();
    }

    @Test
    public void verticalSwipeTest() throws  InterruptedException {
        MobileElement verticalSwiping = (MobileElement) driver.findElementByAccessibilityId("verticalSwipe");
        verticalSwiping.click();
        Thread.sleep(3000);
        MobileElement list=(MobileElement) driver.findElementByAccessibilityId("listview");
        Dimension listDimension=list.getSize();
        TouchAction touchAction1=new TouchAction(driver);
        touchAction1.press(ElementOption.element(list).withCoordinates(listDimension.getWidth()/2,listDimension.getHeight()/2))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(ElementOption.element(list).withCoordinates(listDimension.getWidth()/2,listDimension.getHeight()/9));
        touchAction1.release().perform();
    }


    @Test
    public void iOSTest() throws  InterruptedException {
        MobileElement username = (MobileElement) driver.findElementByAccessibilityId("username");
        username.clear();
        username.sendKeys("admin");
        MobileElement password= (MobileElement) driver.findElementByAccessibilityId("password");
        password.clear();
        password.sendKeys("admin");
        driver.findElementByAccessibilityId("login").click();
        driver.findElement(MobileBy.iOSNsPredicateString("name BEGINSWITH 'Slide'")).click();
        Thread.sleep(3000);
        MobileElement slider = (MobileElement) driver.findElementByAccessibilityId("slider");
        slider.click();
        Thread.sleep(3000);
        MobileElement slider1 = (MobileElement) driver.findElementByAccessibilityId("slider1");
        Dimension d=slider1.getSize();
        Dimension d1=slider.getSize();
        TouchAction touchAction1=new TouchAction(driver);
        touchAction1.press(slider1, 0,d1.getHeight()/2)
                .waitAction(Duration.ofSeconds(3))
                .moveTo(slider1, d1.getWidth()/2,d1.getHeight()/2);
        touchAction1.release().perform();

        TouchAction touchAction=new TouchAction(driver);
        touchAction.press(slider1, 0,d.getHeight()/2)
                .waitAction(Duration.ofSeconds(3))
                .moveTo(slider1, d.getWidth()/2,d.getHeight()/2);
        touchAction.release().perform();

    }

    @AfterClass
    public void tearDown() {
//        driver.quit();
    }

}
