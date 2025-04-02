package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "steps",
        dryRun = true ,

        plugin = {"pretty", "html:target/cucumber-reports.html"},

        tags = "@TNR"
)
public class RunnerTest {


}
