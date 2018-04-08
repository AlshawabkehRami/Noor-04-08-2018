/*
 * Created By Rami Alshawabkeh  3/21/18 11:15 AM
 */

package NoorProject.EduWaveSafeAndSecurity.StaffSAndSInDistrict.TheReport.Schools;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static NoorProject.Other.NoorLogin.browserQA;
import static NoorProject.Other.NoorLogin.waitQA;

public class SchoolDataWithEducationalStagesStaff {

    private By SwitchProfileLocator = By.id("ctl00_oHeader_divSwitchUser");
    private By UserNameLabelLocator = By.partialLinkText("موظف بإدارة الأمن والسلامة بإدارة التعليم");
    private By reports_menu_Locator = By.id("divMenuItem_304");
    private By SerachLinkReportLocator = By.id("lisearch_list");
    private By SerachTXTLocatr = By.id("myInput");
    private By ReportNameLocator = By.linkText("بيانات المدرسة مع المراحل التعليمية");
    private By OfficeNameLOcater = By.id("select2-ctl00_PlaceHolderMain_ddlSupervisionCenter-container");
    private By OfficeNameSearchLOcater = By.xpath("/html/body/span/span/span[1]/input");
    private By SearchBTNLocator = By.id("ctl00_PlaceHolderMain_ibtnSearch");
    private By BackBTN = By.id("ctl00_PlaceHolderMain_ibtnBack");


    //
//بيانات المدرسة مع المراحل التعليمية
    @Test
    public void SchoolDataWithEducationalStages() {
        browserQA.findElement(SwitchProfileLocator).click();
        browserQA.findElement(UserNameLabelLocator).click();
        browserQA.findElement(reports_menu_Locator).click();
        browserQA.findElement(SerachLinkReportLocator).click();
        WebElement SerachTXTLocatrWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachTXTLocatr));
        SerachTXTLocatrWait.sendKeys("بيانات المدرسة مع المراحل التعليمية");

        WebElement ReportLOcatrWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportNameLocator));
        ReportLOcatrWait.click();

        WebElement OfficeNameLOcaterWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(OfficeNameLOcater));
        OfficeNameLOcaterWait.click();
        browserQA.findElement(OfficeNameSearchLOcater).sendKeys("مكتب الخالدية الشمالية" , Keys.ENTER);
        try {
            WebElement SearchBTNLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchBTNLocator));
            SearchBTNLocatorWait.click();
        } catch (Exception e) {
            WebElement SearchBTNLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchBTNLocator));
            SearchBTNLocatorWait.click();
        }


        WebElement BackBTNWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(BackBTN));
        BackBTNWait.click();

        System.out.println(browserQA.findElement(ReportNameLocator).getText());
        Assert.assertEquals(browserQA.findElement(ReportNameLocator).getText() , "بيانات المدرسة مع المراحل التعليمية" , "تم الروجع الى صفحة خاطئة");

    }
}
