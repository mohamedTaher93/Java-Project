package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DemoblazeCart_Elements {
    WebDriver driver;
    @FindBy(linkText = "Cart") public WebElement cartButton;
    @FindAll(@FindBy(xpath = "//div[@class = 'table-responsive']//tr[@class = 'success']")) public List <WebElement> itemsInCart;
    @FindBy(linkText = "Delete") public WebElement deleteButton;
    @FindBy(xpath = "//button[text() = 'Place Order']") public WebElement placeOrderButton;
    @FindBy(id = "name") public WebElement nameField;
    @FindBy(id = "country") public WebElement countryField;
    @FindBy(id = "city") public WebElement cityField;
    @FindBy(id = "card") public WebElement creditCardField;
    @FindBy(id = "month") public WebElement monthField;
    @FindBy(id = "year") public WebElement yearField;
    @FindBy(xpath = "//div[@class = 'modal-footer']//button[text() = 'Purchase']") public WebElement purchaseButton;
    @FindBy(xpath = "//h2[text() = 'Thank you for your purchase!']") public WebElement successPurchase;


    public DemoblazeCart_Elements(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
