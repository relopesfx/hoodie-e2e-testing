package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ForgotYourPasswordPage {

    private final SelenideElement txtEmailAddress = $("#email");
    private final SelenideElement btnContinue = $("[type=submit]");

    public ForgotYourPasswordPage setEmailAddress(String emailAddress) {
        txtEmailAddress.val(emailAddress);
        return this;
    }

    public ForgotYourPasswordPage clickOnContinueButton() {
        btnContinue.click();
        return this;
    }

}
