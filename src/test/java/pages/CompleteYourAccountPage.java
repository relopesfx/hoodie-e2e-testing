package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class CompleteYourAccountPage {

    private final SelenideElement txtEmail = $("input[type=email]");
    private final SelenideElement txtPhone = $(By.xpath("//label[.='Phone']/following::input"));
    private final SelenideElement txtFirstName= $("input[name=firstName]");
    private final SelenideElement txtLastName = $("input[name=lastName]");
    private final SelenideElement btnNext = $("button[type=submit]");

    public SelenideElement getEmail() {
        return txtEmail;
    }

    @Step("Type {phone} in Phone field")
    public CompleteYourAccountPage setPhone(String phone) {
        log.info("Type '{}' in Phone field", phone);
        txtPhone.sendKeys(Keys.HOME + phone);
        return this;
    }

    @Step("Type {firstName} in First Name field")
    public CompleteYourAccountPage setFirstName(String firstName) {
        log.info("Type {} in First Name field", firstName);
        txtFirstName.val(firstName);
        return this;
    }

    @Step("Type {lastName} in Last Name field")
    public CompleteYourAccountPage setLastName(String lastName) {
        log.info("Type {} in Last Name field", lastName);
        txtLastName.val(lastName);
        return this;
    }

    @Step("Click on 'Next' button")
    public CompleteYourAccountPage clickOnNextButton() {
        log.info("Click on 'Next' button");
        btnNext.click();
        return this;
    }

}
