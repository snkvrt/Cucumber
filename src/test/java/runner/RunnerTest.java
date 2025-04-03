package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"steps","features"},

        plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json"},
        tags = "@TNR"
)
public class RunnerTest {


}
