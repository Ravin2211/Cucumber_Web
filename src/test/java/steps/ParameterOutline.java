package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.DriverInstance;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class ParameterOutline extends DriverInstance {

    //WebDriver driver;

    @Given("User should be able to login")
    public void userShouldBeAbleToLogin() {
        //WebDriverManager.chromedriver().setup();
        DriverInstance.initialize();
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //give Username
        driver.findElement(By.name("username")).sendKeys("Admin");
        //give Password
        driver.findElement(By.name("password")).sendKeys("admin123");
        //Click Login Button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Given("Click the Admin Field")
    public void clickTheAdminField() {
        driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span " +
                "oxd-main-menu-item--name'][text()='Admin']")).click();
    }

    @Given("Select the user name as {string}")
    public void selectTheUserNameAs(String username) {
        driver.findElement(By.xpath("//div[2]/input[@class='oxd-input oxd-input--active'][1]")).sendKeys(username);
    }



    @When("Click the submit button")
    public void clickTheSubmitButton() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("Records should generate")
    public void recordsShouldGenerate() {
        String Records_found =driver.findElement(By.xpath("//span[text()='No Records Found']")).getText();
        Assert.assertEquals(Records_found,"No Records Found");
    }

}
