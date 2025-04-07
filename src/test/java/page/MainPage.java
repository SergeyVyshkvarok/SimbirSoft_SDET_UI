package page;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {

    @FindBy(xpath = "//button[@ng-click='addCust()']")
    private WebElement addCustomerButton;
    @FindBy(xpath = "//button[@ng-click='showCust()']")
    private WebElement customersButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public AddCustomerPage goOnAddCustomerPage() {
        getWait5().until(ExpectedConditions.visibilityOf(addCustomerButton)).click();
        return new AddCustomerPage(getDriver());
    }

    public CustomersPage goOnSortingCustomersPage() {
        getWait5().until(ExpectedConditions.visibilityOf(customersButton)).click();
        return new CustomersPage(getDriver());
    }
}
