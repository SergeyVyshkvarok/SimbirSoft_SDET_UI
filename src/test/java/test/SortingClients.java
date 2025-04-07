package test;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.MainPage;


public class SortingClients extends BaseTest {

    @Test
    public void sortingCustomersTest() {

        boolean isSorted = new MainPage(getDriver())
                .goOnSortingCustomersPage()
                .checkAndSortIfNeeded()
                .verifyListSorted();

        Assert.assertTrue(isSorted, "Список не отсортирован");

    }
}
