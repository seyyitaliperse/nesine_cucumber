package steps;

import helpers.container.Context;
import io.cucumber.java.en.When;
import pages.factory.PageFactoryManager;
import pages.factory.Utils;
import pages.webpages.KisiselBilgilerim;

public class KisiselBilgilerimSteps {
    private final Context context;
    private final Utils utils;
    private final KisiselBilgilerim kisiselBilgilerim;

    public KisiselBilgilerimSteps(Context context){
        this.context = context;
        this.utils = PageFactoryManager.getUtils(context);
        this.kisiselBilgilerim = PageFactoryManager.getKisiselBilgilerim(context);
    }


    @When("user verifies that member id is display properly")
    public void userVerifiesThatMemberIdIsDisplayProperly() {
        String uyeNumarasi = context.getGlobalData().getData("uyeNumarasi");
        utils.assertContainsText(kisiselBilgilerim.uyeNumarasiValue, uyeNumarasi, "Uye numarasi values are not matched!");
    }


}
