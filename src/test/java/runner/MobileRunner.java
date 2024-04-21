package runner;

import core.AndroidDriverSetup;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

@CucumberOptions(
        features = "src/test/resources/features/01setAvailability.feature",
        glue = "steps",
        plugin = {
                "pretty",
        },
        monochrome = true
)
public class MobileRunner extends AbstractTestNGCucumberTests {

        @BeforeClass
        public void setUp() throws IOException {
                AndroidDriverSetup.androidDriver("4723");
        }
}
