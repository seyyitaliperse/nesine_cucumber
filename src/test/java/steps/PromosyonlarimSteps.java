package steps;

import helpers.container.Context;
import helpers.readers.JsonDataReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.factory.PageFactoryManager;
import pages.factory.Utils;
import pages.webpages.PromosyonlarimPage;

public class PromosyonlarimSteps {
    private final Context context;
    private final Utils utils;
    private final PromosyonlarimPage promosyonlarimPage;
    private String fileName = "promotions";

    public PromosyonlarimSteps(Context context){
        this.context = context;
        this.utils = PageFactoryManager.getUtils(context);
        this.promosyonlarimPage = PageFactoryManager.getPromosyonlarimPage(context);
    }

    @When("user fills kod girisi component")
    public void userFillsKodGirisiComponent() {
        String promotionCode = JsonDataReader.getFeatureData(fileName,"promotions", "couponFirst");
        String securityCode = "x";

        promosyonlarimPage.fillKodGirisiComponents(promotionCode, securityCode);
    }

    @Then("user verifies that return hesabim page after close promotion")
    public void userVerifiesThatReturnHesabimPageAfterClosePromotion() {
        //MOBILE VERSION
    }

}
