package steps;

import helpers.container.ContainerSetup;
import helpers.factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.factory.InjectionFactory;
import pages.webpages.LoginPage;

public class LoginSteps {
    private final LoginPage loginPage;

    public LoginSteps(){
        this.loginPage = ContainerSetup.getComponent(LoginPage.class);
    }

    @Then("user is on the nesine login page")
    public void userIsOnTheNesineLoginPage() {

    }

    @When("user log in nesine dashboard")
    public void userLogInNesineDashboard() {
    }

    @Then("user verifies that logged in successfully")
    public void userVerifiesThatLoggedInSuccessfully() {
    }

    @When("user attempts to log in with invalid credentials")
    public void userAttemptsToLogInWithInvalidCredentials() {
    }

    @And("user should see an invalid credential dialog error details")
    public void userShouldSeeAnInvalidCredentialDialogErrorDetails() {
    }
}
