/*
 * Created By Rami Alshawabkeh  3/20/18 9:41 AM
 */

package NoorProject.EduWaveSafeAndSecurity.SecurityAndSafetyManagersInDistrict.ReportsMenu.SchoolSecurityAndSafetyReports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static NoorProject.Other.NoorLogin.browserQA;
import static NoorProject.Other.NoorLogin.waitQA;

public class DataSecurityAndSafetyOfficialsInSchools {

    private By SwitchProfileLocator = By.id("ctl00_oHeader_divSwitchUser");
    private By UserNameLabelLocator = By.partialLinkText("مدير الأمن والسلامة في إدارة التعليم");
    private By ReportsMainMenuLocator = By.id("divMenuItem_304");
    private By SerachLinkReportLocator = By.id("lisearch_list");
    private By SerachTextReportLocator = By.id("myInput");

    private By ReportLinkLocator = By.linkText("بيانات مسؤولي الامن والسلامة في المدارس");
    private By SearchButtonLOcator = By.id("ctl00_PlaceHolderMain_ibtnSearch");


    //
//بيانات مسؤولي الامن والسلامة في المدارس
    @Test
    public void DataSecurityAndSafetyOfficialsInSchoolsReport() {

        browserQA.findElement(SwitchProfileLocator).click();
        browserQA.findElement(UserNameLabelLocator).click();
        browserQA.findElement(ReportsMainMenuLocator).click();
        WebElement SerachReportLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachLinkReportLocator));
        SerachReportLocatorWait.click();

        WebElement SerachTextReportLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachTextReportLocator));
        SerachTextReportLocatorWait.sendKeys("بيانات مسؤولي الامن");

        browserQA.findElement(ReportLinkLocator).click();
        WebElement SearchButtonLOcatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchButtonLOcator));
        SearchButtonLOcatorWait.click();

        By ReportTitleLocator = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[5]/div/span/div/table/tbody/tr[4]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[6]/td[3]/table/tbody/tr/td/div");
        WebElement ReportTitleLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportTitleLocator));
        String ReportTitle = browserQA.findElement(ReportTitleLocator).getText();
        String ReportTitleName = "بيانات مسؤولي الامن والسلامة في المدارس";
        Assert.assertEquals(ReportTitle , ReportTitleName , "التقرير المطلوب غير متوفر");
    }
}
