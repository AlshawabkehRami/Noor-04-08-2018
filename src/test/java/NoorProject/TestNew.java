/*
 * Created By Rami AlShawabkeh 3/28/18 12:26 PM
 */

package NoorProject;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestNew {


    public static void main(String[] args) {

        System.out.println("");

        WebDriver driverR;
        WebDriverWait waitR;
        String URLR = "https://10.0.1.195/EduWaveNewDesign/Login.aspx";
        By loginFormLAbelLocator = By.xpath("/html/body/form/div[3]/div[1]/div/div[1]/div[2]/label[1]");
        By UserNameR = By.id("tbPublic");
        By PassWordR = By.id("tbPrivate");
        By LoginInforamtionLabelLocatorR = By.id("ctl00_PlaceHolderMain_lblProfileRecord");
        ChromeDriverManager.getInstance().setup();
        driverR = new ChromeDriver();
        waitR = new WebDriverWait(driverR , 10);
        driverR.navigate().to(URLR);
        driverR.manage().timeouts().pageLoadTimeout(20 , TimeUnit.SECONDS);

        WebElement LabelAssert = driverR.findElement(loginFormLAbelLocator);

        Assert.assertEquals(LabelAssert.getText() , "تسجيل الدخول" , "لم تتم عملية الولوج الى النظام بنجاح");
        //********************************************************************

        driverR.findElement(UserNameR).sendKeys("emisadmin");
        driverR.findElement(PassWordR).sendKeys("1234" , Keys.ENTER);
        WebElement LoginInforamtionLabelWait = waitR.until(ExpectedConditions.visibilityOfElementLocated(LoginInforamtionLabelLocatorR));
        Assert.assertEquals(LoginInforamtionLabelWait.getText() , "معلومات الدخول" , "لم تتم عملية الولوج الى النظام بالشكل الصحيح");


        driverR.findElement(By.id("divMenuItem_4720")).click();

        By jhhhhh = By.linkText("وكلاء الوزارة");

        driverR.findElement(jhhhhh).click();

        System.out.println("لللللللللللللللللللل ؟");




    }
}
