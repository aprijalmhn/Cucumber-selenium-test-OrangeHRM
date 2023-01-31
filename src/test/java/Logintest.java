import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Logintest {

    public static void main(String[] args) throws InterruptedException {
        // provide chrome driver
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://employee.sdcillsy.my.id/");
        Thread.sleep(2000);

        //username
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        //password
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("s3Kol4HQA!*");
        //login button
        driver.findElement(By.cssSelector(".oxd-button")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='PIM']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//button[@type='button'])[41]")).click();
        Thread.sleep(2000);

        WebElement nationality = driver.findElement(By.xpath("(//div[contains(text(),'-- Select --')])[1]"));
        Select selectObject = new Select(nationality);
        selectObject.selectByVisibleText("Indonesian");
        Thread.sleep(2000);

        WebElement status = driver.findElement(By.xpath("(//div[contains(text(),'-- Select --')])[2]"));
        Select selectStatus = new Select(status);
        selectStatus.selectByVisibleText("Single");
        Thread.sleep(2000);

//        driver.findElement(By.xpath("(//button[normalize-space()='Save'])[1]")).click();
//        Thread.sleep(2000);


    }
}
