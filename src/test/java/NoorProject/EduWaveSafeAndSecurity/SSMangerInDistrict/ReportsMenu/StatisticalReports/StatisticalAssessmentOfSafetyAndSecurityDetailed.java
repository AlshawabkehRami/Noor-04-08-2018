/*
 * Created By Rami Alshawabkeh  3/20/18 9:29 AM
 */

package NoorProject.EduWaveSafeAndSecurity.SSMangerInDistrict.ReportsMenu.StatisticalReports;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static NoorProject.Other.NoorLogin.waitQA;

public class StatisticalAssessmentOfSafetyAndSecurityDetailed {

    private By SwitchProfileLocator = By.id("ctl00_oHeader_divSwitchUser");
    private By UserNameLabelLocator = By.partialLinkText("مدير الأمن والسلامة في إدارة التعليم");
    private By ReportsMainMenuLocator = By.id("divMenuItem_304");
    private By SerachLinkReportLocator = By.id("lisearch_list");
    private By SerachTextReportLocator = By.id("myInput");
    private By TheReportNameLocator = By.linkText("إحصائي عن تقييم الأمن والسلامة - تفصيلي");
    private By SupervisionCenterLocator = By.xpath("//*[@id=\"select2-ctl00_PlaceHolderMain_ddlSupervisionCenter-container\"]");
    private By SearchSupervisionCenterLocator = By.xpath("/html/body/span/span/span[1]/input");
    private By FormNameLocator = By.id("select2-ctl00_PlaceHolderMain_ddlFormName-container");
    private By FormNameSearchLocator = By.xpath("/html/body/span/span/span[1]/input");
    private By BTNSearchLocator = By.id("ctl00_PlaceHolderMain_ibtnSearch");

    //
//إحصائي عن تقييم الأمن والسلامة - تفصيلي
    @Test
    public void StatisticalAssessmentOfSafetyAndSecurityDetailedReport() throws InterruptedException {

        WebElement SwitchProfileLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SwitchProfileLocator));
        SwitchProfileLocatorWait.click();

        WebElement UserLabelLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(UserNameLabelLocator));
        UserLabelLocatorWait.click();

        WebElement ReportsMenuLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportsMainMenuLocator));
        ReportsMenuLocatorWait.click();

        WebElement SearchLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachLinkReportLocator));
        SearchLinkLocatorWait.click();

        WebElement SearchFieldLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachTextReportLocator));
        SearchFieldLocatorWait.sendKeys("إحصائي عن تقييم الأمن والسلامة - تفصيلي");

        WebElement TheReportLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(TheReportNameLocator));
        TheReportLinkLocatorWait.click();

        WebElement SupervisionCenterLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SupervisionCenterLocator));
        SupervisionCenterLocatorWait.click();

        WebElement SearchSupervisionCenterLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchSupervisionCenterLocator));
        SearchSupervisionCenterLocatorWait.sendKeys("مكتب الخالدية الشمالية" , Keys.ENTER);

        Thread.sleep(300);

        WebElement FormNameLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(FormNameLocator));
        FormNameLocatorWait.click();

        WebElement FormNameSearchLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(FormNameSearchLocator));
        FormNameSearchLocatorWait.sendKeys("abdullah" , Keys.ENTER);

        Thread.sleep(300);

        try {
            WebElement BTNSearchLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(BTNSearchLocator));
            BTNSearchLocatorWait.click();
        } catch (Exception e) {
            WebElement BTNSearchLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(BTNSearchLocator));
            BTNSearchLocatorWait.click();
        }


        String expected_result = "إحصائي عن تقييم الأمن والسلامة - تفصيلي";
        By actual_reuslt = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[5]/div/span/div/table/tbody/tr[5]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[8]/td[3]/table/tbody/tr/td/div/div/span");
        WebElement actual__result = waitQA.until(ExpectedConditions.visibilityOfElementLocated(actual_reuslt));
        String actual___reuslt = actual__result.getText();
        Assert.assertEquals(actual___reuslt , expected_result , "التقرير المطلوب غير متوفر");

        }
        }

