package steps;

import io.cucumber.java.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseSteps {
    private WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        try
        {
            driver.findElement(By.id("logout2")).click();
        }
        catch (Exception e)
        {

        }
        driver.quit();
    }

    public WebDriver getDriver(){
        return driver;
    }
}
