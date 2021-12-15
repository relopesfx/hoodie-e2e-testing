package tests.webview;

import com.codeborne.selenide.Selenide;
import com.foxbox.hoodie.test.e2e.core.BaseTest;
import data.factory.UserDataFactory;
import data.model.User;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.HoodieEmailService;

import java.time.Duration;

public class ForgotPasswordTest extends BaseTest {

    @Test
    public void shouldChangePasswordSuccessfully() {
        User user = new UserDataFactory().create();
        user.setEmail("user07576-qa@1secmail.com");
        new HomePage()
                .goTo()
                .clickOnLogInButton()
                .clickOnForgotPasswordLink()
                .setEmailAddress(user.getEmail())
                .clickOnContinueButton();
        HoodieEmailService emailService = new HoodieEmailService(user.getEmail());
        String resetPasswordLink = emailService.extractLinkFromMessageContaining("reset-password", Duration.ofSeconds(10));
        System.out.println(resetPasswordLink);
        Selenide.open(resetPasswordLink);
    }

}
