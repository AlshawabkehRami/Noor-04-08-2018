package Linkein;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Connection {
    public static WebDriver DRiVer;
    public static WebDriverWait LinkedinWait;
    public static String LinkInURL = "https://www.linkedin.com";


    @Test
    public void AddConnection() throws InterruptedException {


        ChromeDriverManager.getInstance().setup();
        DRiVer = new ChromeDriver();
        LinkedinWait = new WebDriverWait(DRiVer, 10);
        DRiVer.manage().window().maximize();
        DRiVer.navigate().to(LinkInURL);
        DRiVer.findElement(By.cssSelector("input[id='login-email']")).sendKeys("alshawabkeh.rami.1987@gmail.com");
        DRiVer.findElement(By.cssSelector("input[name='session_password']")).sendKeys("Majd0799114438");
        DRiVer.findElement(By.cssSelector("input[class='login submit-button']")).click();
        DRiVer.findElement(By.cssSelector("span[id='mynetwork-tab-icon']")).click();
        Thread.sleep(1000);

        for (int i = 0; i < 100; i++) {

            Thread.sleep(1000);
            LinkedinWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[id^='ember'][data-control-name='invite']"))).click();
            DRiVer.navigate().refresh();
            Thread.sleep(1000);

        }
        DRiVer.close();
    }
}
