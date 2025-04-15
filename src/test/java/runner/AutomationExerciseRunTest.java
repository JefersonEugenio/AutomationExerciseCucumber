package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/cadastrar",
        glue = {"framework.supports", "steps"},
        name = "Cadastras com validas",
        plugin = {"pretty", "html:target/HtmlReports.html"}
)
public class AutomationExerciseRunTest {
}
