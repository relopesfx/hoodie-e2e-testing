package tests.webview;

import com.automation.remarks.video.annotations.Video;
import com.codeborne.selenide.Selenide;
import com.foxbox.hoodie.test.e2e.config.PropertiesManager;
import com.foxbox.hoodie.test.e2e.core.BaseTest;
import data.factory.UserDataFactory;
import data.model.User;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.AdminOnboardingPage;
import pages.ChangeYourPasswordPage;
import pages.DashboardPage;
import pages.HomePage;
import utils.HoodieEmailService;

import java.time.Duration;

import static com.codeborne.selenide.ClickOptions.usingJavaScript;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;

public class InvitationFlowTest extends BaseTest {

    @Test @Video
    public void shouldBeAbleToCompleteInvitationFlowForSalesRepUser() {
        User user = new UserDataFactory().create();
        HomePage homePage = new HomePage().goTo();

        DashboardPage dashboardPage = homePage
                .clickOnLogInButton()
                .loginAs(PropertiesManager.get().adminUser(), PropertiesManager.get().adminPassword());

        $(By.xpath("//span[.='Settings']")).click();
        $(By.xpath("//span[.=' Add new user']")).click();
        $("input[name=name]").val(user.getFullName());
        $("input[name=email]").val(user.getEmail());
        $("#mui-component-select-roleId").click();
        $(By.xpath("//ul[@role='listbox']/li[.='User']")).click(usingJavaScript());
        $(By.xpath("//span[.='Invite']")).click();
        $("div[role=status]").shouldHave(text("Sending invitation..."));
        $("div[role=status]").shouldHave(text(format("Invitation sent for %s", user.getEmail())));
        HoodieEmailService emailService = new HoodieEmailService(user.getEmail());
        String resetPasswordLink = emailService.extractLinkFromMessageContaining("reset-password", Duration.ofSeconds(10));
        Selenide.open(resetPasswordLink);
        ChangeYourPasswordPage changeYourPasswordPage = new ChangeYourPasswordPage();
        changeYourPasswordPage.resetPassword(user.getPassword());
        homePage.goTo();
        new DashboardPage()
                .clickOnSignOutButton()
                .clickOnLogInButton()
                .loginToCompleteAccountSetup(user)
                .setPhone(user.getPhoneNumber())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .clickOnNextButton();
        AdminOnboardingPage adminOnboardingPage = new AdminOnboardingPage();
        adminOnboardingPage
                .selectYourBrands() // completeStep2
                .confirmYourStates() // completeStep3
                .targetYourCompetition()
                .customizeYourNotifications()
                .uploadYourInventory();
    }

}
