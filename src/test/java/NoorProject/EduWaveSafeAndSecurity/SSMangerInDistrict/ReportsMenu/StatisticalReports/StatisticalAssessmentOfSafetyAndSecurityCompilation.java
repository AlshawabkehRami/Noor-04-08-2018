/*
 * Created By Rami Alshawabkeh  3/20/18 9:23 AM
 */

package NoorProject.EduWaveSafeAndSecurity.SSMangerInDistrict.ReportsMenu.StatisticalReports;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static NoorProject.Other.NoorLogin.browserQA;
import static NoorProject.Other.NoorLogin.waitQA;

public class StatisticalAssessmentOfSafetyAndSecurityCompilation {

    private By SwitchProfileLocator = By.id("ctl00_oHeader_divSwitchUser");
    private By UserNameLabelLocator = By.partialLinkText("مدير الأمن والسلامة في إدارة التعليم");
    private By ReportsMainMenuLocator = By.id("divMenuItem_304");
    private By SerachLinkReportLocator = By.id("lisearch_list");
    private By SerachTextReportLocator = By.id("myInput");

    private By TheReportNameLocator = By.linkText("إحصائي عن تقييم الأمن والسلامة - تجميعي");
    private By drop_down_l_Locator = By.id("select2-ctl00_PlaceHolderMain_ddlSupervisionCenter-container");
    private By txt_field_1_Locator = By.xpath("/html/body/span/span/span[1]/input");
    private By drop_down_2_Locator = By.id("select2-ctl00_PlaceHolderMain_ddlFormName-container");
    private By txt_field_2_Locator = By.xpath("/html/body/span/span/span[1]/input");
    private By btn_search_Locator = By.id("ctl00_PlaceHolderMain_ibtnSearch");

    //
//إحصائي عن تقييم الأمن والسلامة - تجميعي
    @Test
    public void StatisticalAssessmentOfSafetyAndSecurityCompilationReport() throws InterruptedException {
        browserQA.findElement(SwitchProfileLocator).click();
        browserQA.findElement(UserNameLabelLocator).click();
        WebElement reports_menu_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportsMainMenuLocator));
        reports_menu_Locator_wait.click();
        WebElement search_logo_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachLinkReportLocator));
        search_logo_Locator_wait.click();
        WebElement search_field_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachTextReportLocator));
        search_field_Locator_wait.sendKeys("إحصائي عن تقييم الأمن والسلامة - تجميعي");
        WebElement statistical_assessment_of_safety_and_security_aggregate_link_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(TheReportNameLocator));
        statistical_assessment_of_safety_and_security_aggregate_link_wait.click();
        WebElement drop_down_1_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(drop_down_l_Locator));
        drop_down_1_Locator_wait.click();
        WebElement txt_field_1_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(txt_field_1_Locator));
        txt_field_1_Locator_wait.sendKeys("مكتب الخالدية الشمالية", Keys.ENTER);
        Thread.sleep(300);
        WebElement drop_down_2_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(drop_down_2_Locator));
        drop_down_2_Locator_wait.click();
        WebElement txt_field_2_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(txt_field_2_Locator));
        txt_field_2_Locator_wait.sendKeys("abdullah", Keys.ENTER);

        try {
            WebElement btn_search_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(btn_search_Locator));
            btn_search_Locator_wait.click();
        } catch (Exception e) {
            WebElement btn_search_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(btn_search_Locator));
            btn_search_Locator_wait.click();
        }
        String expected_result = "إحصائي عن تقييم الأمن والسلامة - تجميعي";
        By actual_result = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[5]/div/span/div/table/tbody/tr[4]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[9]/td[3]/table/tbody/tr/td");
        WebElement actual_resultt = waitQA.until(ExpectedConditions.visibilityOfElementLocated(actual_result));
        String actual__result = actual_resultt.getText();
        System.out.println(actual_resultt);
        Assert.assertEquals(actual__result, expected_result, "التقرير المطلوب غير متوفر");

    }
}

