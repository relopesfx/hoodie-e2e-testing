package tests.desktop;

import com.foxbox.hoodie.test.e2e.core.BaseTest;
import org.testng.annotations.Test;
import pages.AdminOnboardingPage;

import static com.codeborne.selenide.Selenide.open;

public class AdminOnboardingTest extends BaseTest {

    @Test
    public void shouldCompleteAdminOnboardingFlow() {
        open("/#/onboarding/admin");

        new AdminOnboardingPage()
                .selectYourBrands()
                .confirmYourStates()
                .targetYourCompetition()
                .customizeYourNotifications()
                .uploadYourInventory();
    }

    @Test
    public void shouldCompleteAdminOnboardingFlowAddingMissingItems() {
        open("/#/onboarding/admin");

        new AdminOnboardingPage()
                .selectYourBrandsAndAddMissingBrands();
    }

}
