package com.foxbox.hoodie.test.e2e.listeners;

import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

import static java.util.Objects.requireNonNull;

public class AllureListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        this.addScreenshotToAllure();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        this.addScreenshotToAllure();
    }

    @Attachment(value = "screenshot", type = "image/png")
    private byte[] addScreenshotToAllure() {
        byte[] screenshot = new byte[0];
        try {
            screenshot = Files.toByteArray(requireNonNull(Screenshots.getLastScreenshot()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshot;
    }

}
