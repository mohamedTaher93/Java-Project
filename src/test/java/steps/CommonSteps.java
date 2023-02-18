package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class CommonSteps {
    private WebDriver driver;

    public CommonSteps (BaseSteps baseSteps)
    {
        this.driver = baseSteps.getDriver();
    }

    public WebDriverWait explicitWait()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait;
    }

    public void navigateToUrl (String url)
    {
        driver.get(url);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        try
        {
            driver.findElement(By.id("logout2")).click();
        }
        catch (Exception e)
        {
        }
    }

    public void scrollToElement (WebElement element)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

}
