package hooks.preConditionHooks;

import helpers.container.Context;
import helpers.readers.JsonDataReader;
import io.cucumber.java.Before;
import pages.factory.PageFactoryManager;
import pages.webpages.LoginPage;

public class LoginHooks {
    private final LoginPage loginPage;
    private Context context;

    public LoginHooks(Context context){
        this.context = context;
        this.loginPage = PageFactoryManager.getLoginPage(context);
    }

    @Before(value = "@_userLogin", order = 10)
    public void userLogin() {
        String email = JsonDataReader.getUserCredential("user", "tckn");
        String password = JsonDataReader.getUserCredential("user", "password");
        loginPage.navigateToLoginPage();
        loginPage.login(email, password);
    }


}
