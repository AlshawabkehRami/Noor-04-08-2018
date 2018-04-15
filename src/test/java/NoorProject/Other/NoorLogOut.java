package NoorProject.Other;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static NoorProject.Other.NoorLogin.browserQA;
import static NoorProject.Other.NoorLogin.waitQA;

public class NoorLogOut {


    public static By LogOutLocator = By.id("ctl00_oHeader_lblLogout");

    @Test
    public void ValidLogOut() throws InterruptedException {

        Thread.sleep(1000);

        WebElement LogOutLocatorWait=waitQA.until(ExpectedConditions.visibilityOfElementLocated(LogOutLocator));
        LogOutLocatorWait.click();

        browserQA.close();

    }
}
