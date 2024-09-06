package pages.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Utils extends FactoryPage{
    public Utils(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //This class usage for only prefix
}
