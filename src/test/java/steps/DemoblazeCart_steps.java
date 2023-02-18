package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.DemoblazeCart_Page;

public class DemoblazeCart_steps {
    DemoblazeCart_Page demoblazeCartPage;

    public DemoblazeCart_steps(DemoblazeCart_Page demoblazeCartPage)
    {
        this.demoblazeCartPage = demoblazeCartPage;
    }
    @When("I open the cart page")
    public void openTheCartPage()
    {
        System.out.println("I open the cart page");
        demoblazeCartPage.openCartPage();
    }

    @When("I delete item from the cart")
    public void deleteItemFromCart()
    {
        System.out.println("I delete item from the cart");
        demoblazeCartPage.deleteItem();
    }

    @When("I click on place order")
    public void clickOnPlaceOrder()
    {
        System.out.println("I delete item from the cart");
        demoblazeCartPage.clickOnPlaceOrder();
    }
    @When("I enter {string} {string} {string} {string} {string} and {string}")
    public void enterUserData(String name, String country, String city, String creditCard, String month, String year)
    {
        demoblazeCartPage.enterUserData(name, country, city, creditCard, month, year);
    }

    @When("I click purchase")
    public void clickOnPurchase()
    {
        System.out.println("I click on purchase button");
        demoblazeCartPage.clickPurchaseButton();
    }

    @Then("Verify the cart page has items")
    public void verifyTheCartPageHasItems()
    {
        System.out.println("Verify the cart page has items");
        Assert.assertTrue("The cart is empty", demoblazeCartPage.itemsChecker());
    }

    @Then("Verify the item deleted successfully")
    public void verifyTheItemDeleted()
    {
        System.out.println("Verify the item deleted successfully");
        Assert.assertTrue("Item still displayed after deletion", demoblazeCartPage.checkItemIsDeleted());
    }

    @Then("Verify the item purchased successfully")
    public void verifyItemPurchasedSuccessfully()
    {
        System.out.println("Verify the item purchased successfully");
        Assert.assertTrue("Item not purchased correctly", demoblazeCartPage.successfullPurchase());
    }
}
