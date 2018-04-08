/*
 * Created By Rami Alshawabkeh  3/21/18 11:38 AM
 */

package NoorProject.EduWaveSafeAndSecurity.SSStaffInDistrict.TheReport.SchoolSecurityAndSafetyReports;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static NoorProject.Other.NoorLogin.browserQA;
import static NoorProject.Other.NoorLogin.waitQA;

public class SecurityAndSafetyAssessmentRateStaff {

    private By SwitchProfileLocator = By.id("ctl00_oHeader_divSwitchUser");
    private By UserNameLabelLocator = By.partialLinkText("موظف بإدارة الأمن والسلامة بإدارة التعليم");
    private By ReportsMainMenuLocator = By.id("divMenuItem_304");
    private By SerachLinkReportLocator = By.id("lisearch_list");
    private By SerachTextReportLocator = By.id("myInput");
    private By ReportLinkLocator = By.linkText("الأمن والسلامة - نسبة التقييم");
    private By DDLFormNameLocator = By.id("select2-ctl00_PlaceHolderMain_ddlFormName-container");
    private By DDLFormNameSrearchLocator = By.xpath("/html/body/span/span/span[1]/input");
    private By SearchButtonLOcator = By.id("ctl00_PlaceHolderMain_ibtnSearch");


    //
//الأمن والسلامة - نسبة التقييم
    @Test
    public void SecurityAndSafetyAssessmentRateReport() {

        browserQA.findElement(SwitchProfileLocator).click();
        browserQA.findElement(UserNameLabelLocator).click();
        browserQA.findElement(ReportsMainMenuLocator).click();
        try {
            WebElement SerachReportLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachLinkReportLocator));
            SerachReportLocatorWait.click();
        } catch (Exception e) {
            WebElement SerachReportLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachLinkReportLocator));
            SerachReportLocatorWait.click();
        }

        WebElement SerachTextReportLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachTextReportLocator));
        SerachTextReportLocatorWait.sendKeys("نسبة التقييم");

        WebElement ReportLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportLinkLocator));
        ReportLinkLocatorWait.click();

        WebElement DDLFormNameLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DDLFormNameLocator));
        DDLFormNameLocatorWait.click();
        browserQA.findElement(DDLFormNameSrearchLocator).sendKeys("abdullah" , Keys.ENTER);
        try {
            WebElement SearchButtonLOcatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchButtonLOcator));
            SearchButtonLOcatorWait.click();
        } catch (Exception e) {
            WebElement SearchButtonLOcatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchButtonLOcator));
            SearchButtonLOcatorWait.click();
        }

        By ReportTitleLoactr = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div/div[7]/div/span/div/table/tbody/tr[4]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/table/tbody/tr[7]/td[3]/table/tbody/tr/td/div/div/span");
        WebElement ReportTitleLoactrWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportTitleLoactr));
        String ReportTilte = browserQA.findElement(ReportTitleLoactr).getText();
        String NameOfTheReport = "الأمن والسلامة-نسب التقييم على مستوى الإدارة";

        Assert.assertEquals(ReportTilte , NameOfTheReport , "التقرير المطلوب غير متوفر");
    }
}
