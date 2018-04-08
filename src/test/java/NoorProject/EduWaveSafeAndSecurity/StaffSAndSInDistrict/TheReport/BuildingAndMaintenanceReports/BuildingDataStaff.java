/*
 * Created By Rami Alshawabkeh  3/21/18 11:10 AM
 */

package NoorProject.EduWaveSafeAndSecurity.StaffSAndSInDistrict.TheReport.BuildingAndMaintenanceReports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static NoorProject.Other.NoorLogin.browserQA;
import static NoorProject.Other.NoorLogin.waitQA;

public class BuildingDataStaff {


    private By SwitchProfileLocator = By.id("ctl00_oHeader_divSwitchUser");
    private By UserNameLabelLocator = By.partialLinkText("موظف بإدارة الأمن والسلامة بإدارة التعليم");
    private By ReportsMainMenuLocator = By.id("divMenuItem_304");
    private By SerachLinkReportLocator = By.id("lisearch_list");
    private By SerachTextReportLocator = By.id("myInput");
    private By ReportLinkLocator = By.linkText("بيانات المباني");
    private By SearchButtonLOcator = By.id("ctl00_PlaceHolderMain_ibtnSearch");


    //التقارير_تقارير المباني والصيانة
    //بيانات المباني
    @Test
    public void BuildingInformationReport() {

        browserQA.findElement(SwitchProfileLocator).click();
        browserQA.findElement(UserNameLabelLocator).click();
        browserQA.findElement(ReportsMainMenuLocator).click();
        WebElement SerachReportLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachLinkReportLocator));
        SerachReportLocatorWait.click();
        WebElement SerachTextReportLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachTextReportLocator));
        SerachTextReportLocatorWait.sendKeys("بيانات المباني");
        browserQA.findElement(ReportLinkLocator).click();
        WebElement SearchButtonLOcatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchButtonLOcator));
        SearchButtonLOcatorWait.click();

        By NameOfTheReportLocator = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[4]/div/span/div/table/tbody/tr[4]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/table/tbody/tr[10]/td[2]/table/tbody/tr/td/div");
        WebElement NameOfTheReportLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(NameOfTheReportLocator));
        String NameOfTheReportString = browserQA.findElement(NameOfTheReportLocator).getText();
        String NameOfThePageLString = "بيانات المباني";
        Assert.assertEquals(NameOfTheReportString , NameOfThePageLString , "التقرير المطلوب غير متوفر");
    }

}
