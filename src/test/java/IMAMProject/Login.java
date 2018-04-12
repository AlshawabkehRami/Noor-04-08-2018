/*
 * Created By  Rami AlShawabkeh  4/11/18 5:33 PM
 */

package IMAMProject;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Login {

        public static WebDriver driverImam;
        public static WebDriverWait waitImam;
        public static String URLImam = "https://10.0.1.195/EduWaveKSA_Imam/Login.aspx";
        public static By UserNameIm = By.id("tbPublic");
        public static By PassWordIm = By.id("tbPrivate");


        @Test

        // مستخدم جهة خارجية
        public void AThirdPartyUser() {

            ChromeDriverManager.getInstance().setup();
            driverImam = new ChromeDriver();
            waitImam = new WebDriverWait(driverImam , 10);
            driverImam.navigate().to(URLImam);
            driverImam.manage().timeouts().pageLoadTimeout(10 , TimeUnit.SECONDS);
            driverImam.findElement(UserNameIm).sendKeys("2354571560");
            driverImam.findElement(PassWordIm).sendKeys("1234" , Keys.ENTER);
        }

    }
