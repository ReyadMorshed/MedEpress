package stepDefinitions;


import base.Base;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Hook extends Base {

    public static FileInputStream fileInputStream;
    public static Properties configProperties;
    public static Properties projectProperties;

    @Before
    public void setUp() throws IOException {
        String projectPath = System.getProperty("user.dir");
        configProperties = new Properties();
        fileInputStream = new FileInputStream(projectPath + "\\src\\test\\resources\\properties\\configuration.properties");
        configProperties.load(fileInputStream);

        fileInputStream = new FileInputStream(projectPath + "\\src\\test\\resources\\properties\\project.properties");
        projectProperties = new Properties();
        projectProperties.load(fileInputStream);

        if(configProperties.getProperty("browser").contains("chrome")) {
            driver = new ChromeDriver();
            
        } else if (configProperties.getProperty("browser").contains("edge")) {
            driver = new EdgeDriver();
        } else if (configProperties.getProperty("browser").contains("firefox")) {
            driver = new FirefoxDriver();
        }
        
        

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @After
    public void tearDown(){
        driver.close();
    }

    @AfterStep
    public void endStep(Scenario scenario) {
        if(scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        }
    }


}
