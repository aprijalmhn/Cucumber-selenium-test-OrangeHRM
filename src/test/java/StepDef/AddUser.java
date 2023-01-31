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

public class AddUser {
    WebDriver driver;

    @Given("Login web {string}")
    public void loginOnWebUrl(String url) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(3000);

        //username
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        //password
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("s3Kol4HQA!*");
        //login button
        driver.findElement(By.cssSelector(".oxd-button")).click();
        Thread.sleep(3000);
    }

    @And("Click menu PIM and Add button")
    public void clickMenuPIMAndAddButton() throws InterruptedException {
        driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='PIM']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();
        Thread.sleep(3000);
    }

    @And("Input first name {string}, middle name {string} and last name {string}")
    public void inputFirstNameMiddleNameAndLastName(String first, String middle, String last) {
        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(first);
        driver.findElement(By.xpath("//input[@placeholder='Middle Name']")).sendKeys(middle);
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(last);
    }

    @When("Click textfield Create Login Details")
    public void clickTextfieldCreateLoginDetails() throws InterruptedException {
        driver.findElement(By.cssSelector(".oxd-switch-input.oxd-switch-input--active.--label-right")).click();
        Thread.sleep(3000);
    }

    @And("Input username {string} password {string} and confirm password {string}")
    public void inputUsernameUsernamePasswordPasswordAndConfirmPasswordConfirmPassword(String username, String password, String confirm_password) throws InterruptedException {
        driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[3]")).sendKeys(username);
        driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys(password);
        driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys(confirm_password);
        Thread.sleep(3000);
    }

    @And("Click save button")
    public void clickSaveButton() throws InterruptedException {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(5000);
    }

    @Then("Should success add user and redirected to PIM page")
    public void shouldSuccessAddUserAndRedirectedToPIMPage() throws InterruptedException {
        Assert.assertTrue(driver.findElement(By.xpath("(//span[@class='oxd-topbar-body-nav-tab-item'])[1]")).isDisplayed());
        Thread.sleep(2000);
        driver.close();
        driver.quit();
    }

}
