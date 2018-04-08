/*
 * Created By Rami Alshawabkeh  3/21/18 11:38 AM
 */

package NoorProject.EduWaveSafeAndSecurity.StaffSAndSInDistrict.TheReport.SchoolSecurityAndSafetyReports;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static NoorProject.Other.NoorLogin.browserQA;
import static NoorProject.Other.NoorLogin.waitQA;

public class SecurityAndSafetyInputRatioStaff {

    private By SwitchProfileLocator = By.id("ctl00_oHeader_divSwitchUser");
    private By UserNameLabelLocator = By.partialLinkText("موظف بإدارة الأمن والسلامة بإدارة التعليم");
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
    public void SecurityAndSafetyInputRatioReport() {

        browserQA.findElement(SwitchProfileLocator).click();
        browserQA.findElement(UserNameLabelLocator).click();
        browserQA.findElement(ReportsMainMenuLocator).click();
        WebElement SerachReportLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachLinkReportLocator));
        SerachReportLocatorWait.click();
        WebElement SerachTextReportLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachTextReportLocator));
        SerachTextReportLocatorWait.sendKeys("نسبة الإدخال");
        browserQA.findElement(ReportLinkLocator).click();

        WebElement DDlFormNameLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DDlFormNameLocator));
        DDlFormNameLocatorWait.click();
        browserQA.findElement(DDlFormNameSearchLocator).sendKeys("SeleniumTestDon'tDelete", Keys.ENTER);

        try {
            WebElement SearchButtonLOcatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchButtonLOcator));
            SearchButtonLOcatorWait.click();
        } catch (Exception e) {

            WebElement SearchButtonLOcatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchButtonLOcator));
            SearchButtonLOcatorWait.click();
        }
        By ReportTitleLoactor = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div/div[7]/div/span/div/table/tbody/tr[4]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/table/tbody/tr[8]/td[3]/table/tbody/tr/td/div/div/span");
        WebElement ReportTitleLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportTitleLoactor));
        String ReportName = browserQA.findElement(ReportTitleLoactor).getText();
        String NameOfTheReport = "الأمن والسلامة-نسب الإدخال على مستوى الإدارة";

        Assert.assertEquals(ReportName, NameOfTheReport, "التقرير المطلوب غير متوفر");

    }
}
