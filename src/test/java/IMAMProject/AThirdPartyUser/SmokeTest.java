/*
 * Created By  Rami AlShawabkeh  4/11/18 3:16 PM
 */

package IMAMProject.AThirdPartyUser;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import sun.awt.windows.WEmbeddedFrame;

public class SmokeTest {



    @Test
    public void loginToIMMAMAndSwitchPrfile(){

        ChromeDriverManager.getInstance().setup();
        WebDriver driverImam=new ChromeDriver();
        driverImam.navigate().to("https://10.0.1.195/EduWaveKSA_Imam/Login.aspx");
        By UserNameLOctor= By.id("tbPublic");
        By PassWordLocator=By.id("tbPrivate");

        WebDriverWait waitImam=new WebDriverWait(driverImam,10);

        WebElement UserNameLOctorWait=waitImam.until(ExpectedConditions.visibilityOfElementLocated(UserNameLOctor));
        UserNameLOctorWait.sendKeys("2354571560");
        WebElement PassWordLocatorWait=waitImam.until(ExpectedConditions.visibilityOfElementLocated(PassWordLocator));
        PassWordLocatorWait.sendKeys("1234",Keys.ENTER);





    }
}
