package pages;

import elements.DemoblazeHome_Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import steps.BaseSteps;
import steps.CommonSteps;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class DemoblazeHome_Page {
    private WebDriver driver;
    CommonSteps commonSteps;
    DemoblazeHome_Elements demoblazeHome_elements;

    public DemoblazeHome_Page (BaseSteps baseSteps, CommonSteps commonSteps)
    {
        this.driver = baseSteps.getDriver();

        this.commonSteps = commonSteps;
        demoblazeHome_elements = new DemoblazeHome_Elements(driver);
    }

    //Data
    String demoBlazeUrl = "https://www.demoblaze.com/";
    public void loginToDemoBlaze(String username, String password)
    {
        System.out.println("login to demoBlaze website");
        commonSteps.navigateToUrl(demoBlazeUrl);
        commonSteps.explicitWait().until(ExpectedConditions.elementToBeClickable(demoblazeHome_elements.mainLoginButton));
        demoblazeHome_elements.mainLoginButton.click();
        enterUserCredentials(username, password);

    }

    public void enterUserCredentials (String username, String password)
    {
        System.out.println("Enter user credentials");
        commonSteps.explicitWait().until(ExpectedConditions.visibilityOf(demoblazeHome_elements.userNameField));
        demoblazeHome_elements.userNameField.sendKeys(username);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        demoblazeHome_elements.passwordField.sendKeys(password);
        demoblazeHome_elements.loginButton.click();
    }

    public Boolean isUserLoggedIn (String username)
    {
        commonSteps.explicitWait().until(ExpectedConditions.visibilityOf(demoblazeHome_elements.welcomeUser));
        String welcomeUserText = demoblazeHome_elements.welcomeUser.getText();
        if(welcomeUserText.equals("Welcome " + username)) return true;
        return false;
    }

    public Boolean checkItemsInListGroup (String listName)
    {
        System.out.printf("\nCheck group list %s has items", listName);
        if(listName.toLowerCase().startsWith("categories"))
        {
            commonSteps.explicitWait().until(ExpectedConditions.visibilityOf(demoblazeHome_elements.categories));
            if(demoblazeHome_elements.categoriesItems.size() > 0) return true;
        }
        return false;
    }

    public void addItemToCart ()
    {
        System.out.println("Add item to the cart");
        List<WebElement> items = demoblazeHome_elements.categoriesItems;
        int randomNum = new Random().nextInt(items.size());
        WebElement selectedItem = items.get(randomNum);
        selectedItem.click();
        commonSteps.explicitWait().until(ExpectedConditions.elementToBeClickable(demoblazeHome_elements.addToCart));
        demoblazeHome_elements.addToCart.click();
    }

    public Boolean isItemAddedToCart ()
    {
        commonSteps.explicitWait().until(ExpectedConditions.alertIsPresent());
        String alertText = driver.switchTo().alert().getText();
        System.out.println(alertText);
        String expText = "Product added";
        if(alertText.contains(expText))
        {
            driver.switchTo().alert().accept();
            return true;
        }

        return false;
    }
}
