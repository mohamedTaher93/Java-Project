package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.DemoblazeHome_Page;

public class DemoblazeHome_steps {
    DemoblazeHome_Page demoblazeHomePage;

    public DemoblazeHome_steps (DemoblazeHome_Page demoblazeHomePage)
    {
        this.demoblazeHomePage = demoblazeHomePage;
    }
    @Given("I'm login to demoblaze with {string} and {string}")
    public void IamLoginToDemoblazeWithUserNameAndPassword(String userName, String password) {
        System.out.printf("\nI'm login to demoblaze with username: %s and password: %s", userName, password);
        demoblazeHomePage.loginToDemoBlaze(userName, password);
    }
    @Then("Verify the {string} user logged in successfully")
    public void VerifyTheUserLoggedInSuccessfully(String userName) {
        System.out.printf("\nVerify the user: %s logged in successfully", userName);
        Assert.assertTrue("User is not logged in", demoblazeHomePage.isUserLoggedIn(userName));
    }

    @Then("Verify that {string} list group has items")
    public void VerifyTheListGroupHasItems(String listGroup)
    {
        System.out.printf("\nVerify that %s list group has items", listGroup);
        Assert.assertTrue("The list has no items", demoblazeHomePage.checkItemsInListGroup(listGroup));
    }

    @When("I add random item to the cart")
    public void IAddRandomItemToTheCart()
    {
        System.out.println("I add random item to the cart");
        demoblazeHomePage.addItemToCart();
    }

    @Then("Verify item added successfully in the cart")
    public void VerifyItemAddedToTheCart()
    {
        System.out.println("Verify the item added to the cart");
        Assert.assertTrue("Item not added to the cart", demoblazeHomePage.isItemAddedToCart());
    }
}
