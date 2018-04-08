/*
 * Created By Rami AlShawabkeh 3/27/18 3:48 PM
 */

package NoorProject.EduWaveSafeAndSecurity.SchoolAdmin.TheReport;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static NoorProject.Other.NoorLogin.browserQA;
import static NoorProject.Other.NoorLogin.waitQA;

public class SchoolCardInformation {


    private By ReportsMenuLocator = By.id("divMenuItem_321");
    private By SearchFieldLocator = By.id("lisearch_list");
    private By TextFieldLocator = By.id("myInput");
    private By TheReportLocator = By.linkText("معلومات بطاقات المدارس");
    private By TextFieldTitleLocator = By.id("ctl00_lblPageTitle");
    private By BTNBack = By.id("ctl00_PlaceHolderMain_ibtnBack");


    //مدير مدرسة-تقرير معلومات بطاقات المدرسة
    @Test
    public void SchoolCardInformationView(){

       // for (int i = 0; i < 10; i++) {

            WebElement ReportsMenuLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportsMenuLocator));
            ReportsMenuLocatorWait.click();

            WebElement SearchFieldLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchFieldLocator));
            SearchFieldLocatorWait.click();

            WebElement TextFieldLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(TextFieldLocator));
            TextFieldLocatorWait.sendKeys("معلومات بطاقات المدارس");

            try {
                WebElement TheReportLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(TheReportLocator));
                TheReportLocatorWait.click();
            } catch (Exception e) {

                WebElement TheReportLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(TheReportLocator));
                TheReportLocatorWait.click();
            }
            WebElement TextFieldTitleLocatorElement = waitQA.until(ExpectedConditions.visibilityOfElementLocated(TextFieldTitleLocator));
            String ExpectedResult = TextFieldTitleLocatorElement.getText();
            String Actual_Result = "معلومات بطاقات المدارس";
            Assert.assertEquals(Actual_Result , ExpectedResult , "التقرير المطلوب غير متوفر");


            WebElement BTNBackWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(BTNBack));
            BTNBackWait.click();

        //}

    }

}

