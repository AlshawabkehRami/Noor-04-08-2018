/*
 * Created By  Rami AlShawabkeh  4/11/18 3:16 PM
 */

package IMAMProject.AThirdPartyUser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static IMAMProject.Login.driverImam;
import static IMAMProject.Login.waitImam;

public class SmokeTest {

    By personalInformationLoactor = By.id("divMenuItem_1");

    @Test
    public void personalInformation() {

        WebElement personalInformationLoactorWait = waitImam.until(ExpectedConditions.visibilityOfElementLocated(personalInformationLoactor));
        personalInformationLoactorWait.click();
    }

    By Training = By.id("divMenuItem_1361");
    By RegisterLoacotor = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div/div[2]/div[3]/div[1]/div/div/div[2]/a");
    By SreachButtonLocator = By.id("ctl00_PlaceHolderMain_ibtnView");


    @Test
    public void training() throws InterruptedException {


        WebElement TrainingWait = waitImam.until(ExpectedConditions.visibilityOfElementLocated(Training));
        TrainingWait.click();

        WebElement RegisterLoacotorWait = waitImam.until(ExpectedConditions.visibilityOfElementLocated(RegisterLoacotor));
        RegisterLoacotorWait.click();

        WebElement SreachButtonLocatorWait = waitImam.until(ExpectedConditions.visibilityOfElementLocated(SreachButtonLocator));
        SreachButtonLocatorWait.click();
    }

    @Test
    public void queryTheResult() {

        By queryTheResult = By.id("divMenuItem_6897");

        WebElement queryTheResultWait = waitImam.until(ExpectedConditions.visibilityOfElementLocated(queryTheResult));
        queryTheResultWait.click();


    }

    @Test
    public void downloadData() {
        By downloadData = By.id("divMenuItem_6907");

        WebElement downloadDataWait = waitImam.until(ExpectedConditions.visibilityOfElementLocated(downloadData));
        downloadDataWait.click();


    }
}