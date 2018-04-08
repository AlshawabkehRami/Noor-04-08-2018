/*
 * Created By Rami AlShawabkeh 3/27/18 3:33 PM
 */

package NoorProject.EduWaveSafeAndSecurity.SchoolAdmin.TheReport;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static NoorProject.Other.NoorLogin.waitQA;

public class SchoolData {


    private By ReportsMenuLocator = By.id("divMenuItem_321");
    private By SearchFieldLocator = By.id("lisearch_list");
    private By TextFieldLocator = By.id("myInput");
    private By TheReportLocator = By.linkText("بيانات المدرسة");
    private By TxtFieldTableLocator = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[3]/div/span/div/table/tbody/tr[4]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[7]/td[3]/table/tbody/tr/td/div/div/span");
//مدير مدرسة تقرير بيانات المدرسة
    @Test
    public void SchoolDataReport() throws InterruptedException {

       // for (int i=0;i<10;i++) {
            WebElement ReportsMenuLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportsMenuLocator));
            ReportsMenuLocatorWait.click();

            WebElement SearchFieldLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchFieldLocator));
            SearchFieldLocatorWait.click();

            WebElement TextFieldLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(TextFieldLocator));
            TextFieldLocatorWait.sendKeys("بيانات المدرسة");

            try {
                WebElement SchoolDataLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(TheReportLocator));
                SchoolDataLocatorWait.click();
            } catch (Exception e) {

                WebElement SchoolDataLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(TheReportLocator));
                SchoolDataLocatorWait.click();
            }

            String TextFieldTitle = "بيانات المدرسة";

            Thread.sleep(1000);
            WebElement TxtFieldTableLocatorElement = waitQA.until(ExpectedConditions.visibilityOfElementLocated(TxtFieldTableLocator));
            String TextFieldTable = TxtFieldTableLocatorElement.getText();
            System.out.println(TextFieldTitle);
            System.out.println(TextFieldTable);
            Assert.assertEquals(TextFieldTable , TextFieldTitle , "التقرير المطلوب غير متوفر");

            By BTNBack = By.id("ctl00_PlaceHolderMain_ibtnBack");

            WebElement BTNBackWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(BTNBack));
            BTNBackWait.click();
       // }
    }

}
