package testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"src/test/java/Feature/login.feature"},
        dryRun = true,    //To genarate the Step def template
        glue ="steps",
        snippets = SnippetType.CAMELCASE
)
public class Runner extends AbstractTestNGCucumberTests { // we extend to create a main class type file


}
