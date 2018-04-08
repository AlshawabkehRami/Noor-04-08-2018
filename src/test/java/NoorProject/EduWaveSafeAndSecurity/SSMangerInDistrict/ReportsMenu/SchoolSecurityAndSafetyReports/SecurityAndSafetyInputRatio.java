/*
 * Created By Rami Alshawabkeh  3/20/18 9:39 AM
 */

package NoorProject.EduWaveSafeAndSecurity.SSMangerInDistrict.ReportsMenu.SchoolSecurityAndSafetyReports;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static NoorProject.Other.NoorLogin.browserQA;
import static NoorProject.Other.NoorLogin.waitQA;

public class SecurityAndSafetyInputRatio {

    private By SwitchProfileLocator = By.id("ctl00_oHeader_divSwitchUser");
    private By UserNameLabelLocator = By.partialLinkText("مدير الأمن والسلامة في إدارة التعليم");
    private By ReportsMainMenuLocator = By.id("divMenuItem_304");
    private By SerachLinkReportLocator = By.id("lisearch_list");
    private By SerachTextReportLocator = By.id("myInput");

    private By ReportLinkLocator = By.linkText("الأمن والسلامة - نسبة الإدخال");
    private By DDlFormNameLocator = By.id("select2-ctl00_PlaceHolderMain_ddlFormName-container");
    private By DDlFormNameSearchLocator = By.xpath("/html/body/span/span/span[1]/input");
    private By SearchButtonLOcator = By.id("ctl00_PlaceHolderMain_ibtnSearch");


    //
//الأمن والسلامة - نسبة الإدخال
    @Test
    public void SecurityAndSafetyInputRatioReport() throws InterruptedException {

        WebElement SwitchProfileLocatorWait= waitQA.until(ExpectedConditions.visibilityOfElementLocated(SwitchProfileLocator));
        SwitchProfileLocatorWait.click();

        WebElement UserNameLabelLocatorWait= waitQA.until(ExpectedConditions.visibilityOfElementLocated(UserNameLabelLocator));
        UserNameLabelLocatorWait.click();

        WebElement ReportsMainMenuLocatorWait= waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportsMainMenuLocator));
        ReportsMainMenuLocatorWait.click();

        WebElement SerachReportLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachLinkReportLocator));
        SerachReportLocatorWait.click();

        WebElement SerachTextReportLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachTextReportLocator));
        SerachTextReportLocatorWait.sendKeys("نسبة الإدخال");

        WebElement ReportLinkLocatorWait= waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportLinkLocator));
        ReportLinkLocatorWait.click();

        WebElement DDlFormNameLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DDlFormNameLocator));
        DDlFormNameLocatorWait.click();

        WebElement DDlFormNameSearchLocatorWait= waitQA.until(ExpectedConditions.visibilityOfElementLocated(DDlFormNameSearchLocator));
        DDlFormNameSearchLocatorWait.sendKeys("SeleniumTestDon'tDelete" , Keys.ENTER);

        Thread.sleep(1000);
      try {
          WebElement SearchButtonLOcatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchButtonLOcator));
          SearchButtonLOcatorWait.click();
      }
      catch (Exception e){

          WebElement SearchButtonLOcatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchButtonLOcator));
          SearchButtonLOcatorWait.click();
      }


        By ReportTitleLoactor = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div/div[7]/div/span/div/table/tbody/tr[4]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/table/tbody/tr[8]/td[3]/table/tbody/tr/td/div/div/span");
        WebElement ReportTitleLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportTitleLoactor));
        String ReportName = browserQA.findElement(ReportTitleLoactor).getText();
        String NameOfTheReport = "الأمن والسلامة-نسب الإدخال على مستوى الإدارة";

        Assert.assertEquals(ReportName , NameOfTheReport , "التقرير المطلوب غير متوفر");

    }
}
