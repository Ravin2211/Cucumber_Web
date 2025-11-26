package testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//We can use Tags over Feature,Scenario,Scenario Outline,Examples

@CucumberOptions(
        features = {"src/test/java/Feature/Parameter.feature"},
        dryRun = false,    //To genarate the Step def template
        glue ={"steps","hooks"},
        //Report generation
        plugin = {"pretty","html:reports/TestResult.html",
                    "json:reports/TestResult2.json",
                    "junit:reports/TestResult3.xml"},
        //To remove Underscore between class name
        snippets = SnippetType.CAMELCASE
        //tags = {"@smoke"} //This runs by OR condition by Default,Runs multiple grouping
)
public class Runner extends AbstractTestNGCucumberTests { // we extend to create a main class type file


}
