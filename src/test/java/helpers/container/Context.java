package helpers.container;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Context {

    @Getter
    @Setter
    public WebDriver driver;

    @Getter
    @Setter
    public WebDriverWait webDriverWait;

    @Getter
    private GlobalData globalData;

    public Context() {
        globalData = new GlobalData();
    }

}