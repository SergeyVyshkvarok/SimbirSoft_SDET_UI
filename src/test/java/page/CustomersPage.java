package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomersPage extends BasePage {

    @FindBy(xpath = "(//table//thead//a[contains(., 'First Name')])")
    private WebElement firstNameHeader;

    @FindBy(xpath = "//table//tbody//tr[1]/td[1]")
    private WebElement firstElementOfFirstNameColumn;

    public CustomersPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getFirstNamesFromTable() {
        List<WebElement> values = getDriver().findElements(By.xpath("//table[@class='table']//tbody//tr/td[1]"));
        List<String> names = new ArrayList<>();
        for (WebElement value:values) {
            names.add(value.getText());
        }
        return names;
    }

    public CustomersPage sortByFirstName() {
        getWait5().until((ExpectedConditions.elementToBeClickable(firstNameHeader))).click();
        return this;
    }

    public CustomersPage checkAndSortIfNeeded() {
        if (!isListSorted(getFirstNamesFromTable())) {
            sortByFirstName();
            waitForTableUpdate();
        }
        return this;
    }

    public boolean verifyListSorted() {
        return isListSorted(getFirstNamesFromTable());
    }

    public boolean isListSorted(List<String> list) {
        List<String> sortedList = new ArrayList<>(list);
        Collections.sort(sortedList);
        return list.equals(sortedList);
    }

    public void waitForTableUpdate() {
        getWait5().until(ExpectedConditions.stalenessOf(firstElementOfFirstNameColumn));
        getFirstNamesFromTable().get(0);
    }

}
