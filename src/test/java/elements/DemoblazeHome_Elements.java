package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DemoblazeHome_Elements {
    WebDriver driver;
    @FindBy(id = "login2") public WebElement mainLoginButton;
    @FindBy(id = "loginusername") public WebElement userNameField;
    @FindBy(id = "loginpassword") public WebElement passwordField;
    @FindBy(xpath = "//div[@class = 'modal-footer']//button[text() = 'Log in']") public WebElement loginButton;
    @FindBy(id = "nameofuser") public WebElement welcomeUser;
    @FindBy(id = "cat") public WebElement categories;
    @FindAll(@FindBy(xpath = "//div[@id = 'tbodyid']/div")) public List<WebElement> categoriesItems;
    @FindBy(linkText = "Add to cart") public WebElement addToCart;

    public DemoblazeHome_Elements (WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
