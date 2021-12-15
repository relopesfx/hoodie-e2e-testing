package com.foxbox.hoodie.test.e2e.config;

import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.Sources;
import org.aeonbits.owner.Mutable;

import static org.aeonbits.owner.Config.LoadType.MERGE;

@LoadPolicy(MERGE)
@Sources({
        "system:properties",
        "file:src/test/resources/properties/general.properties",
        "file:src/test/resources/properties/qa.properties",
        "file:src/test/resources/properties/stage.properties",
        "file:src/test/resources/properties/prod.properties"
})
public interface Properties extends Mutable {

    @Key("env")
    @DefaultValue("qa")
    String env();

    @Key("execute.on")
    @DefaultValue("local")
    String executeOn();

    @Key("browser")
    @DefaultValue("chrome")
    String browser();

    @Key("browser.size")
    @DefaultValue("800x600")
    String browserSize();

    @Key("headless")
    @DefaultValue("false")
    boolean headless();

    @Key("device")
    @DefaultValue("Pixel 2")
    String device();

    @Key("${env}.base.url")
    String baseUrl();

    @Key("hold.browser.open")
    @DefaultValue("false")
    boolean holdBrowserOpen();

    @Key("faker.locale")
    @DefaultValue("en-US")
    String fakerLocale();

    @Key("admin.user")
    String adminUser();

    @Key("admin.password")
    String adminPassword();
}
