package com.foxbox.hoodie.test.e2e.core;

import com.automation.remarks.testng.UniversalVideoListener;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.testng.ScreenShooter;
import com.foxbox.hoodie.test.e2e.config.PropertiesManager;
import com.foxbox.hoodie.test.e2e.listeners.AllureListener;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

@Log4j2
@Listeners({
        ScreenShooter.class,
        AllureListener.class,
        UniversalVideoListener.class
})
public class BaseTest {

    @BeforeSuite(description = "Set automation parameters")
    public void setUpParams() {
        log.info("Set automation parameters");
        Configuration.timeout = 8_000;
        Configuration.holdBrowserOpen = PropertiesManager.get().holdBrowserOpen();
        Configuration.reportsFolder = "target/output";
        ScreenShooter.captureSuccessfulTests = true;
    }

    @BeforeClass(description = "Set up browser")
    public void setUpBrowser() {
        log.info("Set up browser");
        Configuration.baseUrl = PropertiesManager.get().baseUrl();
        Configuration.browser = PropertiesManager.get().browser();
        Configuration.headless = PropertiesManager.get().headless();
        Configuration.browserSize = PropertiesManager.get().browserSize();
        Configuration.startMaximized = true;
    }
}
