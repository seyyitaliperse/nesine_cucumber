package steps;

import helpers.container.Context;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.factory.PageFactoryManager;
import pages.factory.Utils;
import pages.webpages.PersonalInformation;

public class PersonalInformationSteps {
    private final Context context;
    private final Utils utils;
    private final PersonalInformation personalInformation;

    public PersonalInformationSteps(Context context){
        this.context = context;
        this.utils = PageFactoryManager.getUtils(context);
        this.personalInformation = PageFactoryManager.getPersonalInformation(context);
    }


    @When("user verifies that member id is display properly")
    public void userVerifiesThatMemberIdIsDisplayProperly() {
        String uyeNumarasi = context.getGlobalData().getData("uyeNumarasi");
        utils.assertContainsText(personalInformation.uyeNumarasiValue, uyeNumarasi, "Uye numarasi values are not matched!");
    }


}
