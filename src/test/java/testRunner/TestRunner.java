package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"features"},
        glue = {"steps"},
        plugin = {"pretty", "html:Report"},
        tags = "@Login or @CheckCategoriesItems or @AddRandomItemToCart or @DeleteItemFromCart or @CompleteCheckOut"
)
public class TestRunner {

}
