package NoorProject.Other;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class NoorLoginStaging {


    public static WebDriver browserST;
    public static WebDriverWait waitST;
    public static String URLST = "https://noorst.moe.gov.sa/QASite/Login.aspx";
    public static By loginFormLAbelLocator = By.xpath("/html/body/form/div[3]/div[1]/div/div[1]/div[2]/label[1]");
    public static By UserName = By.id("tbPublic");
    public static By PassWord = By.id("tbPrivate");
    public static By LoginInforamtionLabelLocator = By.id("ctl00_PlaceHolderMain_lblProfileRecord");

    //مدير النظام
    @Test
    public void EmisadminUserST() {

        // FirefoxDriverManager.getInstance().setup();
        // browserQA = new FirefoxDriver();
        ChromeDriverManager.getInstance().setup();
        browserST = new ChromeDriver();
        waitST = new WebDriverWait(browserST , 10);
        browserST.navigate().to(URLST);
        browserST.manage().timeouts().pageLoadTimeout(10 , TimeUnit.SECONDS);

        WebElement LabelAssert = browserST.findElement(loginFormLAbelLocator);

        Assert.assertEquals(LabelAssert.getText() , "تسجيل الدخول" , "لم تتم عملية الولوج الى النظام بنجاح");
        //********************************************************************

        browserST.findElement(UserName).sendKeys("EMISADMIN");
        browserST.findElement(PassWord).sendKeys("noor1234" , Keys.ENTER);
        WebElement LoginInforamtionLabelWait = waitST.until(ExpectedConditions.visibilityOfElementLocated(LoginInforamtionLabelLocator));
        Assert.assertEquals(LoginInforamtionLabelWait.getText() , "معلومات الدخول" , "لم تتم عملية الولوج الى النظام بالشكل الصحيح");
    }
}
