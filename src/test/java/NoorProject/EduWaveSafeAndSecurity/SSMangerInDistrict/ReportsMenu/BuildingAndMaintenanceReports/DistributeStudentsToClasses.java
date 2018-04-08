/*
 * Created By Rami Alshawabkeh  3/19/18 2:44 PM
 */

package NoorProject.EduWaveSafeAndSecurity.SSMangerInDistrict.ReportsMenu.BuildingAndMaintenanceReports;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static NoorProject.Other.NoorLogin.browserQA;
import static NoorProject.Other.NoorLogin.waitQA;

public class DistributeStudentsToClasses {


    private By SwitchProfileLocator = By.id("ctl00_oHeader_divSwitchUser");
    private By UserNameLabelLocator = By.partialLinkText("مدير الأمن والسلامة في إدارة التعليم");
    private By ReportsMainMenuLocator = By.id("divMenuItem_304");
    private By SerachLinkReportLocator = By.id("lisearch_list");
    private By SerachTextReportLocator = By.id("myInput");




    private By ReportLinkLocator = By.linkText("توزيع الطلاب على الفصول");
    private By ddlStudylevelLocator = By.id("select2-ctl00_PlaceHolderMain_ddlStudylevel-container");
    private By ddlStudylevelSearchLocator = By.xpath("/html/body/span/span/span[1]/input");
    private By ddlSchoolCategorizationLocator = By.id("select2-ctl00_PlaceHolderMain_ddlSchoolCategorization-container");
    private By ddlSchoolCategorizationSearchLocator = By.xpath("/html/body/span/span/span[1]/input");
    private By ibtnSearchLocator = By.id("ctl00_PlaceHolderMain_ibtnSearch");


    //التقارير_تقارير المباني والصيانة
    //
    //توزيع الطلاب على الفصول
    @Test
    public void BuildingInformationReport() {

        browserQA.findElement(SwitchProfileLocator).click();
        browserQA.findElement(UserNameLabelLocator).click();
        browserQA.findElement(ReportsMainMenuLocator).click();
        WebElement SerachReportLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachLinkReportLocator));
        SerachReportLocatorWait.click();

        WebElement SerachTextReportLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachTextReportLocator));
        SerachTextReportLocatorWait.sendKeys("توزيع الطلاب على الفصول");
        browserQA.findElement(ReportLinkLocator).click();


        WebElement ddlStudylevelLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ddlStudylevelLocator));
        ddlStudylevelLocatorWait.click();
        browserQA.findElement(ddlStudylevelSearchLocator).sendKeys("المرحلة الثانوية" , Keys.ENTER);

        try {
            WebElement ddlSchoolCategorizationLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ddlSchoolCategorizationLocator));
            ddlSchoolCategorizationLocatorWait.click();
            browserQA.findElement(ddlSchoolCategorizationSearchLocator).sendKeys("حكومي" , Keys.ENTER);
        } catch (Exception e) {
            WebElement ddlSchoolCategorizationLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ddlSchoolCategorizationLocator));
            ddlSchoolCategorizationLocatorWait.click();
            browserQA.findElement(ddlSchoolCategorizationSearchLocator).sendKeys("حكومي" , Keys.ENTER);
        }

        try {
            WebElement ibtnSearchLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ibtnSearchLocator));
            ibtnSearchLocatorWait.click();
        } catch (Exception e) {
            WebElement ibtnSearchLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ibtnSearchLocator));
            ibtnSearchLocatorWait.click();
        }


        By ReportTitleLocator = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[5]/div/span/div/table/tbody/tr[4]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[3]/table/tbody/tr/td/table/tbody/tr[11]/td[3]/table/tbody/tr/td/div");
        WebElement ReportTitleLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportTitleLocator));
        String ReportTitleString = browserQA.findElement(ReportTitleLocator).getText();
        String ReportNameString = "توزيع الطلاب على الفصول مكتب";
        Assert.assertEquals(ReportTitleString , ReportNameString , "التقرير المطلوب غير متوفر");
    }
}
