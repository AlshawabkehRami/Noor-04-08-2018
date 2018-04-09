/*
 * Created By Rami Alshawabkeh  3/20/18 9:40 AM
 */

package NoorProject.EduWaveSafeAndSecurity.A3SSMangerInDistrict.ReportsMenu.SchoolSecurityAndSafetyReports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static NoorProject.Other.NoorLogin.browserQA;
import static NoorProject.Other.NoorLogin.waitQA;

public class UserDataInSchools {





    //
//بيانات المستخدمين بالمدارس
    private By SwitchProfileLocator = By.id("ctl00_oHeader_divSwitchUser");
    private By UserNameLabelLocator = By.partialLinkText("مدير الأمن والسلامة في إدارة التعليم");
    private By ReportsMainMenuLocator = By.id("divMenuItem_304");
    private By SerachLinkReportLocator = By.id("lisearch_list");
    private By SerachTextReportLocator = By.id("myInput");
    private By TheReportNameLocator = By.linkText("بيانات المستخدمين بالمدارس");
    private By btn_search_Locator = By.id("ctl00_PlaceHolderMain_ibtnSearch");
//بيانات المستخدمين بالمدارس
    @Test
    public void UserDataInSchoolsReport() {
        browserQA.findElement(SwitchProfileLocator).click();
        browserQA.findElement(UserNameLabelLocator).click();
        WebElement reports_menu_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportsMainMenuLocator));
        reports_menu_Locator_wait.click();
        WebElement search_logo_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachLinkReportLocator));
        search_logo_Locator_wait.click();
        WebElement search_field_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachTextReportLocator));
        search_field_Locator_wait.sendKeys("بيانات المستخدمين بالمدارس");
        WebElement UserDataInSchools_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(TheReportNameLocator));
        UserDataInSchools_Locator_wait.click();
        WebElement btn_search_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(btn_search_Locator));
        btn_search_Locator_wait.click();
        String expected_result = "بيانات المستخدمين بالمدارس";
        By actual_result = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[4]/span/div/table/tbody/tr[4]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[6]/td[3]/table/tbody/tr/td/div/div[1]/span");
        WebElement actual_result_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(actual_result));
        String actual__result = actual_result_wait.getText();
        Assert.assertEquals(actual__result , expected_result , "البيانات غير صحيحة");
    }
}

