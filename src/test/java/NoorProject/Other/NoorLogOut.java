package NoorProject.Other;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static NoorProject.Other.NoorLogin.browserQA;

public class NoorLogOut {


    public static By LogOutLocator = By.id("ctl00_oHeader_lblLogout");

    @Test
    public void ValidLogOut() throws InterruptedException {

        Thread.sleep(1000);

        browserQA.findElement(LogOutLocator).click();

        browserQA.close();

    }
}
