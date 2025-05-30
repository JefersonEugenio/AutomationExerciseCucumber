package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/login",
        glue = {"framework.supports", "steps"},
        plugin = {"pretty", "html:target/HtmlReports.html"}
)
public class LoginRunner {
}
