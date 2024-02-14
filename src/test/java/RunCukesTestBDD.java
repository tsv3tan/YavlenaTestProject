

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(plugin = { "progress", "html:target/cucumber-html-TestReport.html" },
        features = "src/test/resources",
        tags = "@smoke")
public class RunCukesTestBDD extends AbstractTestNGCucumberTests {

}
