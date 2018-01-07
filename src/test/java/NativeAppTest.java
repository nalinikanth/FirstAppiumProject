import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class NativeAppTest {

    public AppiumDriver driver;
    DesiredCapabilities caps;

    @Test
    public void NativeTest() throws MalformedURLException {
        DesiredCapabilities caps=new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"android");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
//        caps.setCapability(MobileCapabilityType.APP,"/VodQA.apk");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"MAD");
//        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.android.settings");
//        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.android.settings.Settings");)
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.vodqareactnative");
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.vodqareactnative.MainActivity");
    }

    @Test
    public void NativeIosTest() throws MalformedURLException {
        DesiredCapabilities caps=new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"XCUITest");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"11.2");
        caps.setCapability(MobileCapabilityType.UDID,"776CAE5C-FD9E-465E-AA16-B4DE66CF5767");
        caps.setCapability(MobileCapabilityType.APP,"/Users/null/appium/AppiumSample/VodQAReactNative.app");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"iphone 6");
        driver =new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"),caps);
    }



    @AfterClass
    public void tearDown() {

//        driver.quit();
    }

}
