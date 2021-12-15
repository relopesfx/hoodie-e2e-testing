package tests.webview;

import com.automation.remarks.video.annotations.Video;
import com.foxbox.hoodie.test.e2e.core.WebViewBaseTest;
import data.factory.UserDataFactory;
import data.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CompleteYourAccountPage;
import pages.HomePage;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;

public class LoginTest extends WebViewBaseTest {

    private User user;

    @BeforeMethod
    public void createTestData() {
        this.user = new UserDataFactory().create();
    }

    @Test
    @Video
    public void shouldLoginForTheFirstTimeAndCompleteAccountSetup() {
        this.user.setEmail("user91520-prod@1secmail.com");

        CompleteYourAccountPage completeYourAccountPage = new HomePage()
                .goTo()
                .clickOnLogInButton()
                .loginToCompleteAccountSetup(this.user.getEmail(), this.user.getPassword());

        completeYourAccountPage.getEmail().shouldHave(attribute("value", this.user.getEmail()));

        completeYourAccountPage
                .setPhone(this.user.getPhoneNumber())
                .setFirstName(this.user.getFirstName())
                .setLastName(this.user.getLastName());

        Assert.assertTrue(false);
//                .clickOnNextButton();
    }

    @Test
    public void shouldLoginSuccessfully() {
        this.user.setEmail("renato2@getnada.com");

        new HomePage()
                .goTo()
                .clickOnLogInButton()
                .loginAs(this.user.getEmail(), this.user.getPassword())
                .getNameOfTheUserLoggedIn().shouldHave(text(this.user.getEmail()));
    }

}
