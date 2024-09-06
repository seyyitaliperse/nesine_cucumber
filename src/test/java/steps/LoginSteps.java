package steps;

import helpers.container.ContainerSetup;
import helpers.readers.JsonDataReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.factory.Utils;
import pages.webpages.LoginPage;

public class LoginSteps {
    private final LoginPage loginPage;
    private final Utils utils;

    public LoginSteps(){
        this.loginPage = ContainerSetup.getComponent(LoginPage.class);
        this.utils = ContainerSetup.getComponent(Utils.class);
    }

    @Then("user is on the nesine login page")
    public void userIsOnTheNesineLoginPage() {
        loginPage.navigateToLoginPage();
    }

    @When("user log in nesine dashboard")
    public void userLogInNesineDashboard() {
        String tckn = JsonDataReader.getUserCredential("user","tckn");
        String password = JsonDataReader.getUserCredential("user","password");
        loginPage.login(tckn, password);
    }

    @Then("user verifies that logged in successfully")
    public void userVerifiesThatLoggedInSuccessfully() {
        utils.assertVisibilityOfElement(loginPage.balanceEvidence,"Could not login system!");
    }

    @When("user attempts to log in with invalid credentials")
    public void userAttemptsToLogInWithInvalidCredentials() {
    }

    @And("user should see an invalid credential dialog error details")
    public void userShouldSeeAnInvalidCredentialDialogErrorDetails() {
    }
}
