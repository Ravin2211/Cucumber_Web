package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en_scouse.An;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class LoginStepDef {


    WebDriver driver;

    @Given("User should be navigated to application")
    public void userShouldBeNavigatedToApplication() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @And("User gives the valid Username")
    public void userGivesTheValidUsername() {
        driver.findElement(By.name("username")).sendKeys("Admin");
    }

    @And("User gives the valid Password")
    public void userGivesTheValidPassword() {
        driver.findElement(By.name("password")).sendKeys("admin123");
    }

    @When("User Clicks the Login Button")
    public void userClicksTheLoginButton() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("Login should be Successfull")
    public void loginShouldBeSuccessfull() {
        String UsernameLogin = driver.findElement(By.xpath("//span[@class='oxd-topbar-header-breadcrumb']/h6[text()='Dashboard']")).getText();
            Assert.assertEquals(UsernameLogin, "Dashboard");
    }

//Invalid Login

//    @Given("User gives the Invalid Username")
//    public void userGivesTheInvalidUsername() {
//        driver.findElement(By.xpath("//input[@placeholder='username']")).sendKeys("nick");
//    }
//
//    @And("User gives the Invalid Password")
//    public void userGivesTheInvalidPassword() {
//        driver.findElement(By.xpath("//input[@placeholder='password']")).sendKeys("admin123");
//    }
//
//    @Then("Login should be Failed")
//    public void loginShouldBeFailed() {
//        System.out.println("Login Failed");
//    }




}
