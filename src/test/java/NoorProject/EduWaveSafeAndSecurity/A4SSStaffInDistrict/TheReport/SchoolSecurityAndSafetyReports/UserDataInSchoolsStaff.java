/*
 * Created By Rami Alshawabkeh  3/21/18 11:37 AM
 */

package NoorProject.EduWaveSafeAndSecurity.A4SSStaffInDistrict.TheReport.SchoolSecurityAndSafetyReports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static NoorProject.Other.NoorLogin.browserQA;
import static NoorProject.Other.NoorLogin.waitQA;

public class UserDataInSchoolsStaff {


    //
//بيانات المستخدمين بالمدارس
    private By SwitchProfileLocator = By.id("ctl00_oHeader_divSwitchUser");
    private By UserNameLabelLocator = By.partialLinkText("موظف بإدارة الأمن والسلامة بإدارة التعليم");

    private By reports_menu_Locator = By.id("divMenuItem_304");
    private By SerachLinkReportLocator = By.id("lisearch_list");
    private By search_field_Locator = By.id("myInput");
    private By TheReportNameLocator = By.linkText("بيانات المستخدمين بالمدارس");
    private By btn_search_Locator = By.id("ctl00_PlaceHolderMain_ibtnSearch");

    @Test
    public void UserDataInSchools() {
        browserQA.findElement(SwitchProfileLocator).click();
        browserQA.findElement(UserNameLabelLocator).click();
        WebElement reports_menu_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(reports_menu_Locator));
        reports_menu_Locator_wait.click();
        WebElement search_logo_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachLinkReportLocator));
        search_logo_Locator_wait.click();
        WebElement search_field_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(search_field_Locator));
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


