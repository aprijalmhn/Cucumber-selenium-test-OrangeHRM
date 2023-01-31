package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@Test",
        features="classpath:Features",
        glue= {"StepDef"},
        plugin ={"pretty","json:target/cucumber.json"})
public class TestRunner {

}
