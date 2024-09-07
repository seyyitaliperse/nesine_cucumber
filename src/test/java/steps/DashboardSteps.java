package steps;

import helpers.container.Context;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.factory.PageFactoryManager;
import pages.factory.Utils;
import pages.webpages.DashboardPage;
import pages.webpages.LoginPage;

public class DashboardSteps {
    private final Context context;
    private final Utils utils;
    private final LoginPage loginPage;
    private final DashboardPage dashboardPage;

    public DashboardSteps(Context context){
        this.context = context;
        this.loginPage = PageFactoryManager.getLoginPage(context);
        this.utils = PageFactoryManager.getUtils(context);
        this.dashboardPage = PageFactoryManager.getDashboardPage(context);
    }

    @And("user log out from system")
    public void userLogOutFromSystem() {
        dashboardPage.logout();
    }

    @Then("user verifies that logged out successfully")
    public void userVerifiesThatLoggedOutSuccessfully() {
        utils.assertInvisibilityOfElement(loginPage.balanceEvidence,"Could not logout from system!");
    }
}
