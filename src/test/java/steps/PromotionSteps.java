package steps;

import helpers.container.Context;
import helpers.readers.JsonDataReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.factory.PageFactoryManager;
import pages.factory.Utils;
import pages.webpages.PromotionsPage;

public class PromotionSteps {
    private final Context context;
    private final Utils utils;
    private final PromotionsPage promotionsPage;
    private String fileName = "promotions";

    public PromotionSteps(Context context){
        this.context = context;
        this.utils = PageFactoryManager.getUtils(context);
        this.promotionsPage = PageFactoryManager.getPromotionsPage(context);
    }

    @When("user fills kod girisi component")
    public void userFillsKodGirisiComponent() {
        String promotionCode = JsonDataReader.getFeatureData(fileName,"promotions", "couponFirst");
        String securityCode = "x";

        promotionsPage.fillKodGirisiComponents(promotionCode, securityCode);
    }

    @Then("user verifies that return hesabim page after close promotion")
    public void userVerifiesThatReturnHesabimPageAfterClosePromotion() {
    }

}
