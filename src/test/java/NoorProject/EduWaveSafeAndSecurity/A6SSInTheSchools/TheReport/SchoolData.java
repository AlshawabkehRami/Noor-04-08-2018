/*
 * Created By Rami AlShawabkeh 4/1/18 3:41 PM
 */

package NoorProject.EduWaveSafeAndSecurity.A6SSInTheSchools.TheReport;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static NoorProject.Other.NoorLogin.waitQA;

public class SchoolData {

    private By MainMenuReportLocator = By.id("divMenuItem_321");
    private By SchoolDataLinkLocator = By.linkText("بيانات المدرسة");
    private By TextFieldTitleLocator = By.id("ctl00_lblPageTitle");

    @Test
    public void ViewSchoolData() {

    //    for (int i=0;i<10;i++) {
            WebElement MainMenuReportLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(MainMenuReportLocator));
            MainMenuReportLocatorWait.click();
            WebElement SchoolDataLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SchoolDataLinkLocator));
            SchoolDataLinkLocatorWait.click();
            WebElement TextFieldLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(TextFieldTitleLocator));
            String ExpectedResult = TextFieldLocatorWait.getText();
            System.out.println(ExpectedResult);
            String ActualResult = "بيانات المدرسة";
            Assert.assertEquals(ActualResult , ExpectedResult , "التقرير المطلوب غير متوفر");
      //  }

    }

}
