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
        driver.get("https://bookcart.azurewebsites.net/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @And("User clicks on the Login Link")
    public void userClicksOnTheLoginLink() {
        driver.findElement(By.xpath("/html/body/app-root" +
                "/app-nav-bar/mat-toolbar/mat-toolbar-row/div[3]/button[2]/span[2]")).click();

    }

    @And("User gives the valid Username")
    public void userGivesTheValidUsername() {
        driver.findElement(By.id("mat-input-0")).sendKeys("Lara2011");
    }

    @And("User gives the valid Password")
    public void userGivesTheValidPassword() {
        driver.findElement(By.id("mat-input-1")).sendKeys("Lara@3434");
    }

    @When("User Clicks the Login Button")
    public void userClicksTheLoginButton() {
        driver.findElement(By.xpath("//button[@color='primary']//span[text()='Login']")).click();
    }

    @Then("Login should be Successfull")
    public void loginShouldBeSuccessfull() {
        String UsernameLogin = driver.findElement(By.xpath("driver.findElement(By.id(\"mat-input-1\")).sendKeys(\"Lara@3434\");")).getText();
             Assert.assertEquals(UsernameLogin, "No books found.");
    }

//Invalid Login

//    @Given("User gives the Invalid Username")
//    public void userGivesTheInvalidUsername() {
//        driver.findElement(By.id("mat-input-0")).sendKeys("Leztt");
//    }
//
//    @And("User gives the Invalid Password")
//    public void userGivesTheInvalidPassword() {
//        driver.findElement(By.id("mat-input-1")).sendKeys("left@3434");
//    }
//
//    @Then("Login should be Failed")
//    public void loginShouldBeFailed() {
//        System.out.println("Login Failed");
//    }




}
