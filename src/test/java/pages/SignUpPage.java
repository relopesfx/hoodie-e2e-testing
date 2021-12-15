package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class SignUpPage {

    private final SelenideElement txtEmailAddress = $("#email");
    private final SelenideElement txtPassword = $("#password");
    private final SelenideElement btnContinue = $("[type=submit]");

    @Step("Type '{email}' in email address field")
    public SignUpPage setEmailAddress(String email) {
        log.info("Type '{}' in email address field", email);
        txtEmailAddress.val(email);
        return this;
    }

    @Step("Type '{password}' in password field")
    public SignUpPage setPassword(String password) {
        log.info("Type '{}' in password field", password);
        txtPassword.val(password);
        return this;
    }

    @Step("Click on 'Continue' button")
    public SignUpPage clickOnContinueButton() {
        log.info("Click on 'Continue' button");
        btnContinue.click();
        return this;
    }

    public void signUpAs(String email, String password) {
        this.setEmailAddress(email);
        this.setPassword(password);
        this.clickOnContinueButton();
    }

}
