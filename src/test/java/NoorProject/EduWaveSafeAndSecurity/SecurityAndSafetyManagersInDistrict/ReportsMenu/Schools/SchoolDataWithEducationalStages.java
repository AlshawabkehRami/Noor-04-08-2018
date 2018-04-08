/*
 * Created By Rami Alshawabkeh  3/20/18 10:53 AM
 */

package NoorProject.EduWaveSafeAndSecurity.SecurityAndSafetyManagersInDistrict.ReportsMenu.Schools;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static NoorProject.Other.NoorLogin.browserQA;
import static NoorProject.Other.NoorLogin.waitQA;

public class SchoolDataWithEducationalStages {

    private By SwitchProfileLocator = By.id("ctl00_oHeader_divSwitchUser");
    private By UserNameLabelLocator = By.partialLinkText("مدير الأمن والسلامة في إدارة التعليم");
    private By ReportsMainMenuLocator = By.id("divMenuItem_304");
    private By SerachLinkReportLocator = By.id("lisearch_list");
    private By SerachTextReportLocator = By.id("myInput");

    private By TheReportNameLocator = By.linkText("بيانات المدرسة مع المراحل التعليمية");
    private By OfficeNameLOcater = By.id("select2-ctl00_PlaceHolderMain_ddlSupervisionCenter-container");
    private By OfficeNameSearchLOcater = By.xpath("/html/body/span/span/span[1]/input");
    private By SearchBTNLocator = By.id("ctl00_PlaceHolderMain_ibtnSearch");
    private By BackBTN = By.id("ctl00_PlaceHolderMain_ibtnBack");


    //
//بيانات المدرسة مع المراحل التعليمية
    @Test
    public void SchoolDataWithEducationalStagesReport() throws InterruptedException {
        browserQA.findElement(SwitchProfileLocator).click();
        browserQA.findElement(UserNameLabelLocator).click();
        browserQA.findElement(ReportsMainMenuLocator).click();
        browserQA.findElement(SerachLinkReportLocator).click();
        WebElement SerachTXTLocatrWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachTextReportLocator));
        SerachTXTLocatrWait.sendKeys("بيانات المدرسة مع المراحل التعليمية");
        WebElement ReportLOcatrWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(TheReportNameLocator));
        ReportLOcatrWait.click();
        WebElement OfficeNameLOcaterWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(OfficeNameLOcater));
        OfficeNameLOcaterWait.click();
        browserQA.findElement(OfficeNameSearchLOcater).sendKeys("مكتب الخالدية الشمالية" , Keys.ENTER);

        Thread.sleep(1000);
        WebElement SearchBTNLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchBTNLocator));
        SearchBTNLocatorWait.click();




    }
}

