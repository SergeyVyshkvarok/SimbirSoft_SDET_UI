package page;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {

    @FindBy(xpath = "//button[@ng-click='addCust()']")
    private WebElement addCustomerButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public AddCustomerPage goOnAddCustomerPage() {
        getWait5().until(ExpectedConditions.visibilityOf(addCustomerButton)).click();
        return new AddCustomerPage(getDriver());
    }
}
