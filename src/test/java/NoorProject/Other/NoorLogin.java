package NoorProject.Other;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class NoorLogin {


    public static WebDriver browserQA;
    public static WebDriverWait waitQA;
    public static String URLQA = "https://10.0.1.195/EduWaveNewDesign/Login.aspx";
    public  static By loginFormLAbelLocator = By.xpath("/html/body/form/div[3]/div[1]/div/div[1]/div[2]/label[1]");
    public static By UserName = By.id("tbPublic");
    public static By PassWord = By.id("tbPrivate");
    public static By LoginInforamtionLabelLocator = By.id("ctl00_PlaceHolderMain_lblProfileRecord");


    @Test
//مدير عام الأمن والسلامة المدرسية
    public void GeneralDirectorOfSchoolSecurityAndSafety() {


        // FirefoxDriverManager.getInstance().setup();
        // browserQA = new FirefoxDriver();
        ChromeDriverManager.getInstance().setup();
        browserQA = new ChromeDriver();
        waitQA = new WebDriverWait(browserQA , 10);
        browserQA.navigate().to(URLQA);
        browserQA.manage().timeouts().pageLoadTimeout(10 , TimeUnit.SECONDS);

        WebElement LabelAssert = browserQA.findElement(loginFormLAbelLocator);

        Assert.assertEquals(LabelAssert.getText() , "تسجيل الدخول" , "لم تتم عملية الولوج الى النظام بنجاح");
        //********************************************************************

        browserQA.findElement(UserName).sendKeys("raadaa01");
        browserQA.findElement(PassWord).sendKeys("1234" , Keys.ENTER);
        WebElement LoginInforamtionLabelWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(LoginInforamtionLabelLocator));
        Assert.assertEquals(LoginInforamtionLabelWait.getText() , "معلومات الدخول" , "لم تتم عملية الولوج الى النظام بالشكل الصحيح");


    }

    @Test
//مدير عام شؤون المعلمين بالوزارة
    public void DirectorGeneralofTeachersAffairsintheMinistry() {

        FirefoxDriverManager.getInstance().setup();
        browserQA = new FirefoxDriver();
    /*    ChromeDriverManager.getInstance().setup();
        browserQA = new ChromeDriver();*/
        waitQA = new WebDriverWait(browserQA , 10);
        browserQA.navigate().to(URLQA);
        browserQA.manage().timeouts().pageLoadTimeout(10 , TimeUnit.SECONDS);

        WebElement LabelAssert = browserQA.findElement(loginFormLAbelLocator);

        Assert.assertEquals(LabelAssert.getText() , "تسجيل الدخول" , "لم تتم عملية الولوج الى النظام بنجاح");
        //********************************************************************

        browserQA.findElement(UserName).sendKeys("raad0017");
        browserQA.findElement(PassWord).sendKeys("1234" , Keys.ENTER);
        WebElement LoginInforamtionLabelWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(LoginInforamtionLabelLocator));
        Assert.assertEquals(LoginInforamtionLabelWait.getText() , "معلومات الدخول" , "لم تتم عملية الولوج الى النظام بالشكل الصحيح");


    }

    //موظف الامن والسلامة المدرسية

    @Test
    public void SchoolSecurityandSafetyOfficer() {

        // FirefoxDriverManager.getInstance().setup();
        // browserQA = new FirefoxDriver();
        ChromeDriverManager.getInstance().setup();
        browserQA = new ChromeDriver();
        waitQA = new WebDriverWait(browserQA , 10);
        browserQA.navigate().to(URLQA);
        browserQA.manage().timeouts().pageLoadTimeout(10 , TimeUnit.SECONDS);

        WebElement LabelAssert = browserQA.findElement(loginFormLAbelLocator);

        Assert.assertEquals(LabelAssert.getText() , "تسجيل الدخول" , "لم تتم عملية الولوج الى النظام بنجاح");
        //********************************************************************

        browserQA.findElement(UserName).sendKeys("raadaa02");
        browserQA.findElement(PassWord).sendKeys("1234" , Keys.ENTER);
        WebElement LoginInforamtionLabelWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(LoginInforamtionLabelLocator));
        Assert.assertEquals(LoginInforamtionLabelWait.getText() , "معلومات الدخول" , "لم تتم عملية الولوج الى النظام بالشكل الصحيح");
    }

    //مدير النظام
    @Test
    public void EmisadminUser() {

        // FirefoxDriverManager.getInstance().setup();
        // browserQA = new FirefoxDriver();
        ChromeDriverManager.getInstance().setup();
        browserQA = new ChromeDriver();
        waitQA = new WebDriverWait(browserQA , 10);
        browserQA.navigate().to(URLQA);
        browserQA.manage().timeouts().pageLoadTimeout(10 , TimeUnit.SECONDS);

        WebElement LabelAssert = browserQA.findElement(loginFormLAbelLocator);

        Assert.assertEquals(LabelAssert.getText() , "تسجيل الدخول" , "لم تتم عملية الولوج الى النظام بنجاح");
        //********************************************************************

        browserQA.findElement(UserName).sendKeys("EMISADMIN");
        browserQA.findElement(PassWord).sendKeys("1234" , Keys.ENTER);
        WebElement LoginInforamtionLabelWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(LoginInforamtionLabelLocator));
        Assert.assertEquals(LoginInforamtionLabelWait.getText() , "معلومات الدخول" , "لم تتم عملية الولوج الى النظام بالشكل الصحيح");
    }

    //مدير تقنية المعلومات
    @Test
    public void DirectorOfInformationTechnology() {

        // FirefoxDriverManager.getInstance().setup();
        // browserQA = new FirefoxDriver();
        ChromeDriverManager.getInstance().setup();
        browserQA = new ChromeDriver();
        waitQA = new WebDriverWait(browserQA , 10);
        browserQA.navigate().to(URLQA);
        browserQA.manage().timeouts().pageLoadTimeout(10 , TimeUnit.SECONDS);

        WebElement LabelAssert = browserQA.findElement(loginFormLAbelLocator);

        Assert.assertEquals(LabelAssert.getText() , "تسجيل الدخول" , "لم تتم عملية الولوج الى النظام بنجاح");
        //********************************************************************

        browserQA.findElement(UserName).sendKeys("raad10");
        browserQA.findElement(PassWord).sendKeys("1234" , Keys.ENTER);
        WebElement LoginInforamtionLabelWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(LoginInforamtionLabelLocator));
        Assert.assertEquals(LoginInforamtionLabelWait.getText() , "معلومات الدخول" , "لم تتم عملية الولوج الى النظام بالشكل الصحيح");
    }

    //مدير الامن والسلامة المدرسية بادارة التعليم
    @Test
    public void SecurityAndSafetyManagersInDistrictLogin() {

        // FirefoxDriverManager.getInstance().setup();
        // browserQA = new FirefoxDriver();
        ChromeDriverManager.getInstance().setup();
        browserQA = new ChromeDriver();
        waitQA = new WebDriverWait(browserQA , 10);
        browserQA.navigate().to(URLQA);
        browserQA.manage().timeouts().pageLoadTimeout(10 , TimeUnit.SECONDS);

        WebElement LabelAssert = browserQA.findElement(loginFormLAbelLocator);

        Assert.assertEquals(LabelAssert.getText() , "تسجيل الدخول" , "لم تتم عملية الولوج الى النظام بنجاح");
        //********************************************************************

        browserQA.findElement(UserName).sendKeys("raadaa03");
        browserQA.findElement(PassWord).sendKeys("1234" , Keys.ENTER);
        WebElement LoginInforamtionLabelWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(LoginInforamtionLabelLocator));
        Assert.assertEquals(LoginInforamtionLabelWait.getText() , "معلومات الدخول" , "لم تتم عملية الولوج الى النظام بالشكل الصحيح");
    }

    //
    //موظفون بإدارة الأمن والسلامة بإدارة التعليم
    @Test
    public void StaffSAndSInDistrictLogin() {

        // FirefoxDriverManager.getInstance().setup();
        // browserQA = new FirefoxDriver();
        ChromeDriverManager.getInstance().setup();
        browserQA = new ChromeDriver();
        waitQA = new WebDriverWait(browserQA , 10);
        browserQA.navigate().to(URLQA);
        browserQA.manage().timeouts().pageLoadTimeout(10 , TimeUnit.SECONDS);

        WebElement LabelAssert = browserQA.findElement(loginFormLAbelLocator);

        Assert.assertEquals(LabelAssert.getText() , "تسجيل الدخول" , "لم تتم عملية الولوج الى النظام بنجاح");
        //********************************************************************

        browserQA.findElement(UserName).sendKeys("raadaa04");
        browserQA.findElement(PassWord).sendKeys("1234" , Keys.ENTER);
        WebElement LoginInforamtionLabelWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(LoginInforamtionLabelLocator));
        Assert.assertEquals(LoginInforamtionLabelWait.getText() , "معلومات الدخول" , "لم تتم عملية الولوج الى النظام بالشكل الصحيح");
    }

    //
    //مدير مدرسة
    @Test
    public void SchoolAdminLoginQA() {

        // FirefoxDriverManager.getInstance().setup();
        // browserQA = new FirefoxDriver();
        ChromeDriverManager.getInstance().setup();
        browserQA = new ChromeDriver();
        waitQA = new WebDriverWait(browserQA , 10);
        browserQA.navigate().to(URLQA);
        browserQA.manage().timeouts().pageLoadTimeout(10 , TimeUnit.SECONDS);

        WebElement LabelAssert = browserQA.findElement(loginFormLAbelLocator);

        Assert.assertEquals(LabelAssert.getText() , "تسجيل الدخول" , "لم تتم عملية الولوج الى النظام بنجاح");
        //********************************************************************

        browserQA.findElement(UserName).sendKeys("raad3424");
        browserQA.findElement(PassWord).sendKeys("1234" , Keys.ENTER);
        WebElement LoginInforamtionLabelWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(LoginInforamtionLabelLocator));
        Assert.assertEquals(LoginInforamtionLabelWait.getText() , "معلومات الدخول" , "لم تتم عملية الولوج الى النظام بالشكل الصحيح");
    }


    //
    //مسؤول الامن والسلامة المدرسية في المدرسة
    @Test
    public void SchoolSecurityAndSafetyInSchoolQA() {

        // FirefoxDriverManager.getInstance().setup();
        // browserQA = new FirefoxDriver();
        ChromeDriverManager.getInstance().setup();
        browserQA = new ChromeDriver();
        waitQA = new WebDriverWait(browserQA , 10);
        browserQA.navigate().to(URLQA);
        browserQA.manage().timeouts().pageLoadTimeout(10 , TimeUnit.SECONDS);

        WebElement LabelAssert = browserQA.findElement(loginFormLAbelLocator);

        Assert.assertEquals(LabelAssert.getText() , "تسجيل الدخول" , "لم تتم عملية الولوج الى النظام بنجاح");
        //********************************************************************

        browserQA.findElement(UserName).sendKeys("Raadaa05");
        browserQA.findElement(PassWord).sendKeys("1234" , Keys.ENTER);
        WebElement LoginInforamtionLabelWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(LoginInforamtionLabelLocator));
        Assert.assertEquals(LoginInforamtionLabelWait.getText() , "معلومات الدخول" , "لم تتم عملية الولوج الى النظام بالشكل الصحيح");
    }

    //مدير مدرسة ثانوي
    @Test
    public void schoolAdminsecondary() {

        // FirefoxDriverManager.getInstance().setup();
        // browserQA = new FirefoxDriver();
        ChromeDriverManager.getInstance().setup();
        browserQA = new ChromeDriver();
        waitQA = new WebDriverWait(browserQA , 10);
        browserQA.navigate().to(URLQA);
        browserQA.manage().timeouts().pageLoadTimeout(10 , TimeUnit.SECONDS);

        WebElement LabelAssert = browserQA.findElement(loginFormLAbelLocator);

        Assert.assertEquals(LabelAssert.getText() , "تسجيل الدخول" , "لم تتم عملية الولوج الى النظام بنجاح");
        //********************************************************************

        browserQA.findElement(UserName).sendKeys("rami25");
        browserQA.findElement(PassWord).sendKeys("1234" , Keys.ENTER);
        WebElement LoginInforamtionLabelWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(LoginInforamtionLabelLocator));
        Assert.assertEquals(LoginInforamtionLabelWait.getText() , "معلومات الدخول" , "لم تتم عملية الولوج الى النظام بالشكل الصحيح");
    }
}
