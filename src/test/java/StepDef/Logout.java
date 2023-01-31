package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Logout {
    WebDriver driver;
    @Given("Login web url {string}")
    public void loginWebUrl(String url) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        Thread.sleep(3000);

        //username
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        //password
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("s3Kol4HQA!*");
        //login button
        driver.findElement(By.cssSelector(".oxd-button")).click();
        Thread.sleep(5000);
    }

    @And("Click icon time")
    public void clickIconTime() throws InterruptedException {
        driver.findElement(By.xpath("(//i[@class='oxd-icon bi-stopwatch'])[1]")).click();
        Thread.sleep(3000);
    }

    @When("Click In button")
    public void clickInButton() throws InterruptedException {
        driver.findElement(By.xpath("(//button[normalize-space()='In'])[1]")).click();
        Thread.sleep(5000);
    }

    @Then("Should succes punch in")
    public void shouldSuccesPunchIn() throws InterruptedException {
        Assert.assertTrue(driver.findElement(By.xpath("(//button[normalize-space()='Out'])[1]")).isDisplayed());
        Thread.sleep(5000);
    }

    @And("Click Out button")
    public void clickOutButton() throws InterruptedException {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(5000);
    }

    @Then("Should succes punch out")
    public void shouldSuccesPunchOut() throws InterruptedException {
        Assert.assertTrue(driver.findElement(By.cssSelector("button[type='submit']")).isDisplayed());
        Thread.sleep(2000);
    }

    @And("Click menu account or profile picture")
    public void clickMenuAccountOrProfilePicture() throws InterruptedException {
        driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']")).click();
        Thread.sleep(2000);
    }

    @When("Click menu logout")
    public void clickMenuLogout() throws InterruptedException {
        driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
        Thread.sleep(2000);
    }

    @Then("Should succes logout")
    public void shouldSuccesLogout() {
        Assert.assertTrue(driver.findElement(By.xpath("(//h5[normalize-space()='Login'])[1]")).isDisplayed());
        driver.close();
        driver.quit();
    }
}
