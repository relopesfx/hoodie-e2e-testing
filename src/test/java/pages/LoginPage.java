package pages;

import com.codeborne.selenide.SelenideElement;
import data.model.User;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class LoginPage {

    private final SelenideElement txtEmailAddress = $("#username");
    private final SelenideElement txtPassword = $("#password");
    private final SelenideElement lnkForgotPassword = $(By.linkText("Forgot password?"));
    private final SelenideElement btnContinue = $("[type=submit]");

    @Step("Type '{emailAddress}' in email address field")
    public LoginPage setEmailAddress(String emailAddress) {
        log.info("Type '{}' in email address field", emailAddress);
        txtEmailAddress.val(emailAddress);
        return this;
    }

    @Step("Type '{password}' in password field")
    public LoginPage setPassword(String password) {
        log.info("Type '{}' in password field", password);
        txtPassword.val(password);
        return this;
    }

    @Step("Click on 'Forgot password?' link")
    public ForgotYourPasswordPage clickOnForgotPasswordLink() {
        log.info("Click on 'Forgot password?' link");
        lnkForgotPassword.click();
        return new ForgotYourPasswordPage();
    }

    @Step("Click on 'Continue' button")
    public LoginPage clickOnLogInButton() {
        log.info("Click on 'Continue' button");
        btnContinue.click();
        return this;
    }

    public DashboardPage loginAs(String emailAddress, String password) {
        this.setEmailAddress(emailAddress);
        this.setPassword(password);
        this.clickOnLogInButton();
        return new DashboardPage();
    }

    public DashboardPage loginAs(User user) {
        this.setEmailAddress(user.getEmail());
        this.setPassword(user.getPassword());
        this.clickOnLogInButton();
        return new DashboardPage();
    }

    public CompleteYourAccountPage loginToCompleteAccountSetup(String emailAddress, String password) {
        this.setEmailAddress(emailAddress);
        this.setPassword(password);
        this.clickOnLogInButton();
        return new CompleteYourAccountPage();
    }

    public CompleteYourAccountPage loginToCompleteAccountSetup(User user) {
        this.setEmailAddress(user.getEmail());
        this.setPassword(user.getPassword());
        this.clickOnLogInButton();
        return new CompleteYourAccountPage();
    }
}
