package com.foxbox.hoodie.test.e2e.core;

import com.codeborne.selenide.Configuration;
import com.foxbox.hoodie.test.e2e.config.PropertiesManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;

import java.util.HashMap;
import java.util.Map;

@Log4j2
public class WebViewBaseTest extends BaseTest {

    @BeforeMethod(description = "Make browser emulates a mobile device")
    public void configBrowserMobileEmulation() {
        log.info("Make browser emulates a {} device", PropertiesManager.get().device());
        Map<String, Object> mobileEmulation = new HashMap<>() {{
            put("deviceName", PropertiesManager.get().device());
        }};
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
    }
}
