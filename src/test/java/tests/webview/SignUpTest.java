package tests.webview;

import com.foxbox.hoodie.test.e2e.core.BaseTest;
import data.factory.UserDataFactory;
import data.model.User;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.HoodieEmailService;

import java.time.Duration;

public class SignUpTest extends BaseTest {

    @Test
    public void shouldSignUpSuccessfully() {
        User user = new UserDataFactory().create();

        new HomePage()
                .goTo()
                .clickOnSignUpButton()
                .signUpAs(user.getEmail(), user.getPassword());

        HoodieEmailService emailService = new HoodieEmailService(user.getEmail());
        String s = emailService.extractLinkFromMessageContaining("email-verification", Duration.ofSeconds(10));
        System.out.println(s);
    }

}
