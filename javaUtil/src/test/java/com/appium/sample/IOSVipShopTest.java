package com.appium.sample;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

public class IOSVipShopTest {

    private IOSDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "iOS");
        desiredCapabilities.setCapability("platformVersion", "12.1");
        desiredCapabilities.setCapability("deviceName", "iPhone Simulator");
        desiredCapabilities.setCapability("app", "/Users/chad.long/project/git/ios_automation/automation_spec/apps/Spec.app");
        desiredCapabilities.setCapability("noReset", true);
        desiredCapabilities.setCapability("printPageSourceOnFindFailure", true);

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new IOSDriver(remoteUrl, desiredCapabilities);
    }

    @Test
    public void sampleTest() {
//        IOSElement searchInput;
//        searchInput = (IOSElement) driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"唯品会\"]");

        (new TouchAction(driver)).tap(328, 640).perform();

        IOSElement filter;
        MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("筛选");
        filter = (IOSElement) el1;
        filter.click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }


}
