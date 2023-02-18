package pages;

import elements.DemoblazeCart_Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import steps.BaseSteps;
import steps.CommonSteps;

public class DemoblazeCart_Page {
    private WebDriver driver;
    CommonSteps commonSteps;
    DemoblazeCart_Elements demoblazeCart_elements;

    private int numOfItems = 0;

    public DemoblazeCart_Page(BaseSteps baseSteps, CommonSteps commonSteps)
    {
        this.driver = baseSteps.getDriver();

        this.commonSteps = commonSteps;
        demoblazeCart_elements = new DemoblazeCart_Elements(driver);
    }

    public void openCartPage()
    {
        System.out.println("Open the cart page");
        commonSteps.explicitWait().until(ExpectedConditions.elementToBeClickable(demoblazeCart_elements.cartButton));
        demoblazeCart_elements.cartButton.click();
        commonSteps.explicitWait().until(ExpectedConditions.visibilityOf(demoblazeCart_elements.placeOrderButton));

    }

    public Boolean itemsChecker()
    {
        if(demoblazeCart_elements.itemsInCart.size() > 0)
        {
            numOfItems = demoblazeCart_elements.itemsInCart.size();
            System.out.println("num of items: " + numOfItems);
            return true;
        }

        return false;
    }
    public void deleteItem ()
    {
        commonSteps.explicitWait().until(ExpectedConditions.elementToBeClickable(demoblazeCart_elements.deleteButton));
        demoblazeCart_elements.deleteButton.click();
    }

    public Boolean checkItemIsDeleted()
    {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        commonSteps.explicitWait().until(ExpectedConditions.visibilityOfAllElements(demoblazeCart_elements.itemsInCart));
        int currentNumOfItems = demoblazeCart_elements.itemsInCart.size();
        System.out.println("current num of items: " + currentNumOfItems);
        if(currentNumOfItems == (numOfItems -1)) {
            numOfItems = 0;
            return true;
        }

        return false;
    }

    public void clickOnPlaceOrder()
    {
        commonSteps.explicitWait().until(ExpectedConditions.elementToBeClickable(demoblazeCart_elements.placeOrderButton));
        demoblazeCart_elements.placeOrderButton.click();
        commonSteps.explicitWait().until(ExpectedConditions.visibilityOf(demoblazeCart_elements.nameField));
    }

    public void enterUserData (String name, String country, String city, String creditCard, String month, String year)
    {
        commonSteps.explicitWait().until(ExpectedConditions.visibilityOf(demoblazeCart_elements.nameField));
        demoblazeCart_elements.nameField.sendKeys(name);
        demoblazeCart_elements.countryField.sendKeys(country);
        demoblazeCart_elements.cityField.sendKeys(city);
        demoblazeCart_elements.creditCardField.sendKeys(creditCard);
        demoblazeCart_elements.monthField.sendKeys(month);
        demoblazeCart_elements.yearField.sendKeys(year);
    }

    public void clickPurchaseButton()
    {
        commonSteps.scrollToElement(demoblazeCart_elements.purchaseButton);
        commonSteps.explicitWait().until(ExpectedConditions.elementToBeClickable(demoblazeCart_elements.purchaseButton));
        demoblazeCart_elements.purchaseButton.click();
    }

    public Boolean successfullPurchase()
    {
        try {
            commonSteps.explicitWait().until(ExpectedConditions.visibilityOf(demoblazeCart_elements.successPurchase));
            return true;
        }
        catch (Exception error)
        {
            return false;
        }
    }
}
