package test;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.MainPage;

public class AddCustomerNew extends BaseTest {

    @Test
    public void addCustomerTest() {

        String actualAlertText = new MainPage(getDriver())
                .goOnAddCustomerPage()
                .fillPostCode()
                .firstNameFieldFilling()
                .lastNameFieldFilling()
                .buttonAddCustomersClickToSubmit()
                .checkAlertString();


        Assert.assertTrue(actualAlertText.contains(expectedMessage));
    }
}
