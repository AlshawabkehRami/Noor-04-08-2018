/*
 * Created By Rami AlShawabkeh 4/1/18 3:25 PM
 */

package NoorProject.EduWaveSafeAndSecurity.A6SSInTheSchools.TheReport;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static NoorProject.Other.NoorLogin.waitQA;

public class SchoolCardInformation {



    private By MainMenuReportsLocator = By.id("divMenuItem_321");
    private By SchoolCardInformationLocator = By.linkText("معلومات بطاقات المدارس");
    private By TextFieldTitleLocator = By.id("ctl00_lblPageTitle");

    @Test
    public void SchoolCardInformationView() {

       // for (int i=0;i<5;i++) {
            WebElement MainMenuReportsLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(MainMenuReportsLocator));
            MainMenuReportsLocatorWait.click();
            WebElement SchoolCardInformationLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SchoolCardInformationLocator));
            SchoolCardInformationLocatorWait.click();
            WebElement TextFieldTitleLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(TextFieldTitleLocator));
            String ExpectedResult = TextFieldTitleLocatorWait.getText();
            String ActualResult = "معلومات بطاقات المدارس";
            Assert.assertEquals(ActualResult , ExpectedResult , "التقرير المطلوب غير متوفر");
      //  }

    }

}
