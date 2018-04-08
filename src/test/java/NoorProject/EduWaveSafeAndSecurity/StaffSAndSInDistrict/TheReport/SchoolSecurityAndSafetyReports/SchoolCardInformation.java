/*
 * Created By Rami Alshawabkeh  3/21/18 11:55 AM
 */

package NoorProject.EduWaveSafeAndSecurity.StaffSAndSInDistrict.TheReport.SchoolSecurityAndSafetyReports;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static NoorProject.Other.NoorLogin.browserQA;
import static NoorProject.Other.NoorLogin.waitQA;

public class SchoolCardInformation {
    private By SwitchProfileLocator = By.id("ctl00_oHeader_divSwitchUser");
    private By UserNameLabelLocator = By.partialLinkText("موظف بإدارة الأمن والسلامة بإدارة التعليم");
    private By ReportsMainMenuLocator = By.id("divMenuItem_304");
    private By SerachLinkReportLocator = By.id("lisearch_list");
    private By SerachTextReportLocator = By.id("myInput");
    private By ReportLinkLocator = By.linkText("معلومات بطاقات المدارس");
    private By ddlSchoolLocator = By.id("select2-ctl00_PlaceHolderMain_ddlSchool-container");
    private By ddlSchoolSearchLocator = By.xpath("/html/body/span/span/span[1]/input");
    private By BTNSearchLocator = By.id("ctl00_PlaceHolderMain_ibtnSearch");


    //
//معلومات بطاقات المدارس
    @Test
    public void SecurityAndSafetyAssessmentRateReport() throws InterruptedException {

        browserQA.findElement(SwitchProfileLocator).click();
        browserQA.findElement(UserNameLabelLocator).click();
        browserQA.findElement(ReportsMainMenuLocator).click();
        WebElement SerachReportLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachLinkReportLocator));
        SerachReportLocatorWait.click();
        WebElement SerachTextReportLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachTextReportLocator));
        SerachTextReportLocatorWait.sendKeys("معلومات بطاقات");
        browserQA.findElement(ReportLinkLocator).click();

        By ddlSupervisionCenterLocator = By.id("select2-ctl00_PlaceHolderMain_ddlSupervisionCenter-container");
        By ddlSupervisionCenterSearchLocator = By.xpath("/html/body/span/span/span[1]/input");

        WebElement ddlSupervisionCenterLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ddlSupervisionCenterLocator));
        ddlSupervisionCenterLocatorWait.click();
        browserQA.findElement(ddlSupervisionCenterSearchLocator).sendKeys("مكتب الخالدية الشمالية", Keys.ENTER);
        Thread.sleep(1000);
        try {
            WebElement ddlSchoolLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ddlSchoolLocator));
            ddlSchoolLocatorWait.click();
        } catch (Exception e) {
            WebElement ddlSchoolLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ddlSchoolLocator));
            ddlSchoolLocatorWait.click();
        }
        browserQA.findElement(ddlSchoolSearchLocator).sendKeys("مدرسة سعيد بن المسيب التانوية", Keys.ENTER);

        try {
            WebElement BTNSearchLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(BTNSearchLocator));

            BTNSearchLocatorWait.click();
        } catch (Exception e) {
            WebElement BTNSearchLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(BTNSearchLocator));

            BTNSearchLocatorWait.click();
        }

    }
}
