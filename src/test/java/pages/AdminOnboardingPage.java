package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.Random;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AdminOnboardingPage {

    private final ElementsCollection radOptionsToSelect = $$("div.MuiDialogContent-root > div button span.MuiButton-label");
    private final SelenideElement radMissingBrandYes = $(By.xpath("//legend[.='Are any of your brands missing?']/following-sibling::div//input[@value='yes']"));
    private final SelenideElement radMissingBrandNo = $(By.xpath("//legend[.='Are any of your brands missing?']/following-sibling::div//input[@value='no']"));
    private final SelenideElement radMissingStatesYes = $(By.xpath("//legend[.='Are any of your states missing?']/following-sibling::div//input[@value='yes'])"));
    private final SelenideElement radMissingStatesNo = $(By.xpath("//legend[.='Are any of your states missing?']/following-sibling::div//input[@value='no']"));
    private final SelenideElement btnNext = $(By.xpath("//span[.='Next']/parent::button"));
    private final SelenideElement btnSkip = $(By.xpath("//span[.='Skip']/parent::button"));
    private final SelenideElement chkAllItemsSelected = $("[aria-label='all items selected']");
    private final ElementsCollection btnAdd = $$(By.xpath("//span[.='Add']/.."));

    public AdminOnboardingPage selectYourBrands() {
        radOptionsToSelect.get(new Random().nextInt(3)).click();
        radMissingBrandNo.click();
        btnNext.click();
        return this;
    }

    public AdminOnboardingPage selectYourBrandsAndAddMissingBrands() {
        radOptionsToSelect.get(new Random().nextInt(3)).click();
        radMissingBrandYes.click();
        chkAllItemsSelected.click();
        btnAdd.last().click();
//        btnNext.click();
        return this;
    }

    public AdminOnboardingPage confirmYourStates() {
        radOptionsToSelect.get(new Random().nextInt(3)).click();
        radMissingStatesNo.click();
        btnNext.click();
        return this;
    }

    public AdminOnboardingPage confirmYourStatesAndAddMissingStates() {
        radOptionsToSelect.get(new Random().nextInt(3)).click();
        radMissingStatesYes.click();
        chkAllItemsSelected.click();
        btnAdd.last().click();
//        btnNext.click();
        return this;
    }

    public AdminOnboardingPage targetYourCompetition() {
        radOptionsToSelect.get(new Random().nextInt(3)).click();
        radMissingBrandNo.click();
        btnNext.click();
        return this;
    }

    public AdminOnboardingPage customizeYourNotifications() {
        btnNext.click();
        return this;
    }

    public AdminOnboardingPage uploadYourInventory() {
        btnSkip.click();
        return this;
    }
}
