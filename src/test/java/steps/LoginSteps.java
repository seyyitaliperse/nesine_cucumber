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
    private final String fileName = "login";

    public LoginSteps(){
        this.loginPage = ContainerSetup.getComponent(LoginPage.class);
        this.utils = ContainerSetup.getComponent(Utils.class);
    }

    @Then("user navigates to nesine login page")
    public void userNavigatesToNesineLoginPage() {
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
        String tckn = JsonDataReader.getUserCredential("user","tckn");
        String password = "axasdjasjdj";
        loginPage.loginNegative(tckn, password);
    }

    @And("user should see an invalid credential dialog error details")
    public void userShouldSeeAnInvalidCredentialDialogErrorDetails() {
        String dialogFirst = JsonDataReader.getFeatureData(fileName, "invalidCredentials", "textFirst");
        String dialogSecond = JsonDataReader.getFeatureData(fileName, "invalidCredentials", "textSecond");

        utils.assertContainsText(loginPage.invalidCredentialsDialogDetails, dialogFirst, "Invalid credentials first dialog details is not as expected..");
        utils.assertContainsText(loginPage.invalidCredentialsDialogDetails, dialogSecond, "Invalid credentials second dialog details is not as expected..");
    }
}
