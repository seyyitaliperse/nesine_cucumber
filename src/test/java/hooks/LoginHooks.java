package hooks;

import helpers.container.ContainerSetup;
import helpers.factory.DriverFactory;
import helpers.readers.JsonDataReader;
import io.cucumber.java.Before;
import pages.factory.InjectionFactory;
import pages.webpages.LoginPage;

public class LoginHooks {
    private final LoginPage loginPage;

    public LoginHooks(){
        this.loginPage = ContainerSetup.getComponent(LoginPage.class);
    }

    @Before(value = "@_userLogin", order = 10)
    public void userLogin() {
        String email = JsonDataReader.getUserCredential("user", "tckn");
        String password = JsonDataReader.getUserCredential("user", "password");
        loginPage.navigateToLoginPage();
        loginPage.login(email, password);
    }


}
