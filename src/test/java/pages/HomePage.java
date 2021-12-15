package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class HomePage {

    private final SelenideElement btnLogIn = $(By.xpath("//span[.='Log in']"));
    private final SelenideElement btnSignUp = $(By.linkText("Sign up"));

    @Step("Navigate to home page")
    public HomePage goTo() {
        log.info("Navigate to {}", baseUrl);
        open("/");
        return this;
    }

    @Step("Click on 'Log in' button")
    public LoginPage clickOnLogInButton() {
        log.info("Click on 'Log in' button");
        btnLogIn.click();
        return new LoginPage();
    }

    @Step("Click on 'Sign up' button")
    public SignUpPage clickOnSignUpButton() {
        log.info("Click on 'Sign up' button");
        btnSignUp.click();
        return new SignUpPage();
    }



}
