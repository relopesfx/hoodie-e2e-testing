package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ChangeYourPasswordPage {

    private final SelenideElement txtNewPassword = $("#password-reset");
    private final SelenideElement txtReEnterNewPassword = $("#re-enter-password");
    private final SelenideElement btnResetPassword = $("[type=submit]");

    public ChangeYourPasswordPage setNewPassword(String password) {
        txtNewPassword.val(password);
        return this;
    }

    public ChangeYourPasswordPage setReEnterNewPassword(String password) {
        txtReEnterNewPassword.val(password);
        return this;
    }

    public ChangeYourPasswordPage clickOnResetPasswordButton() {
        btnResetPassword.click();
        return this;
    }

    public void resetPassword(String password) {
        this.setNewPassword(password);
        this.setReEnterNewPassword(password);
        this.clickOnResetPasswordButton();
    }
}
