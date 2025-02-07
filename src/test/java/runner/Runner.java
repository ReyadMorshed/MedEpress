package runner;

import com.vimalselvam.cucumber.listener.Reporter;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepDefinitions",
        tags = "@Smoke or @Regression",
        dryRun = false,
        monochrome = true,
        plugin = { "html:target/reports/extent-report.html" }
)

public class Runner {

    @AfterClass
    public static void writeExtentReport() {
        String project_path = System.getProperty("user.dir");
        Reporter.loadXMLConfig(new File(project_path + "src/extent-config.xml"));
    }

}
