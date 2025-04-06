package page;

import base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.Random;

public class AddCustomerPage extends BasePage {

    @FindBy(xpath = "//input[@placeholder='First Name']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    private WebElement postCodeField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    public AddCustomerPage(WebDriver driver) {
        super(driver);
    }

    public AddCustomerPage fillPostCode() {
        int[] arrayForPostCodeField = new int[10];

        Random random = new Random();

        String postCodeValue = "";

        for (int i = 0; i < 10; i++) {
            arrayForPostCodeField[i] = random.nextInt(0, 10);
            postCodeValue += arrayForPostCodeField[i];
        }

        postCodeField.clear();
        postCodeField.sendKeys(postCodeValue);

        return this;
    }

    public AddCustomerPage firstNameFieldFilling() {
        String realPostCodeContent = (String) ((JavascriptExecutor)getDriver()).executeScript("return arguments[0].value", postCodeField);

        int[] arrayForFirstNameField = new int[5];
        for (int i = 0; i < 5; i++) {
            arrayForFirstNameField[i] = Integer.parseInt(realPostCodeContent.substring(i * 2, i * 2 + 2));
        }
        StringBuilder sb = new StringBuilder();
        for (int num : arrayForFirstNameField) {
            char letter = numberToLetter(num);
            sb.append(letter);
        }

        firstNameField.sendKeys(sb.toString());

        return this;
    }

    public AddCustomerPage lastNameFieldFilling() {
        String realFirstNameFieldContent = (String) ((JavascriptExecutor)getDriver()).executeScript("return arguments[0].value", firstNameField);
        String reversedFirstName = new StringBuilder(realFirstNameFieldContent).reverse().toString();
        lastNameField.sendKeys(reversedFirstName);

        return this;
    }

    public AddCustomerPage buttonAddCustomersClickToSubmit() {
        getWait5().until(ExpectedConditions.visibilityOf(submitButton)).click();

        return this;
    }

    public String checkAlertString() {
        Alert alert = getDriver().switchTo().alert();
        String alertText = alert.getText();

        return alertText;
    }
}