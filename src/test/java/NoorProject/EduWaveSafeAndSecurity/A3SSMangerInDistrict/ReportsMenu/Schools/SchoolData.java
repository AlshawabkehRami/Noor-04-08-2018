/*
 * Created By Rami Alshawabkeh  3/20/18 11:10 AM
 */

package NoorProject.EduWaveSafeAndSecurity.A3SSMangerInDistrict.ReportsMenu.Schools;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static NoorProject.Other.NoorLogin.browserQA;
import static NoorProject.Other.NoorLogin.waitQA;

public class SchoolData {

    private By SwitchProfileLocator = By.id("ctl00_oHeader_divSwitchUser");
    private By UserNameLabelLocator = By.partialLinkText("مدير الأمن والسلامة في إدارة التعليم");
    private By ReportsMainMenuLocator = By.id("divMenuItem_304");
    private By SerachLinkReportLocator = By.id("lisearch_list");
    private By SerachTextReportLocator = By.id("myInput");

    private By school_data_Locator = By.linkText("بيانات المدرسة");
    private By drop_down_list_Locator = By.id("select2-ctl00_PlaceHolderMain_ddlSupervisionCenter-container");
    private By txt_field_Locator = By.xpath("/html/body/span/span/span[1]/input");
    private By btn_search_Locator = By.id("ctl00_PlaceHolderMain_ibtnSearch");
//
//بيانات المدرسة
    @Test
    public void SchoolDataReport() throws InterruptedException {
        browserQA.findElement(SwitchProfileLocator).click();
        browserQA.findElement(UserNameLabelLocator).click();
        WebElement reports_menu_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportsMainMenuLocator));
        reports_menu_Locator_wait.click();
        WebElement search_logo_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachLinkReportLocator));
        search_logo_Locator_wait.click();
        WebElement search_field_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachTextReportLocator));
        search_field_Locator_wait.sendKeys("بيانات المدرسة");
        WebElement school_data_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(school_data_Locator));
        school_data_Locator_wait.click();
        WebElement drop_down_list_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(drop_down_list_Locator));
        drop_down_list_Locator_wait.click();
        WebElement txt_field_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(txt_field_Locator));
        txt_field_Locator_wait.sendKeys("مكتب الخالدية الشمالية" , Keys.ENTER);
        Thread.sleep(300);
        WebElement btn_search_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(btn_search_Locator));
        btn_search_Locator_wait.click();
        String expected_result = "بيانات المدرسة";
        By actual_result = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[4]/div/span/div/table/tbody/tr[5]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[9]/td[3]/table/tbody/tr/td/div/div/span");
        WebElement actual_result_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(actual_result));
        String actual__result = actual_result_wait.getText();
        Assert.assertEquals(actual__result , expected_result , "التقرير المطلوب غير متوفر");

    }
}

