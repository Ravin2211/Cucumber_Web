package hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;
import cucumber.api.java.BeforeStep;
import driver.DriverInstance;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;

public class Hooks extends DriverInstance {

//    @BeforeStep
//    public void beforestep(Scenario scenario){
//        System.out.println("Name:Renu");
//    }
//
//    @AfterStep
//    public void afterstep(Scenario scenario){
//        System.out.println("Name:Sankaran");
//    }

    @Before
    public void beforeScenario(Scenario scenario){
       // WebDriverManager.chromedriver().setup();
        String name = scenario.getName();
        System.out.println(name);

    }

    @After
    public void afterScenario(Scenario scenario){
        boolean response = scenario.isFailed();
        System.out.println("Failed Scenario" +response);

            byte[] scrnshot = driver.getScreenshotAs(OutputType.BYTES);
            scenario.embed(scrnshot, "image/png");
        DriverInstance.quitDriver();
    }
}
