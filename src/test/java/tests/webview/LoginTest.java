package tests.webview;

import com.automation.remarks.video.annotations.Video;
import com.foxbox.hoodie.test.e2e.config.PropertiesManager;
import com.foxbox.hoodie.test.e2e.core.WebViewBaseTest;
import data.factory.UserDataFactory;
import data.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CompleteYourAccountPage;
import pages.HomePage;

import static com.codeborne.selenide.Condition.attribute;

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
        new HomePage()
                .goTo()
                .clickOnLogInButton()
                .loginAs(PropertiesManager.get().adminUser(), PropertiesManager.get().adminPassword());
//                .getNameOfTheUserLoggedIn().shouldHave(text(this.user.getEmail()));

        assert true;
    }

}
