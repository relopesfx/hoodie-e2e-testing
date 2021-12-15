package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class DashboardPage {

    private final SelenideElement userNameInHeader = $("img[alt$=avatar] + div > div");
    private final SelenideElement btnSignOut = $(By.xpath("//span[.='Sign out']"));

    public SelenideElement getNameOfTheUserLoggedIn() {
        return userNameInHeader;
    }

    @Step("Click on 'Sign out' button")
    public HomePage clickOnSignOutButton() {
        log.info("Click on 'Sign out' button");
        btnSignOut.click();
        return new HomePage();
    }
}
