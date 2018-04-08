/*
 * Created By Rami Alshawabkeh  3/21/18 12:18 PM
 */

package NoorProject.EduWaveSafeAndSecurity.StaffSAndSInDistrict.TheReport.StatisticalReports;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static NoorProject.Other.NoorLogin.browserQA;
import static NoorProject.Other.NoorLogin.waitQA;

public class NumberOfStudentsWhoOwnTheSchoolBuildingStaff {

    private By SwitchProfileLocator = By.id("ctl00_oHeader_divSwitchUser");
    private By UserNameLabelLocator = By.partialLinkText("موظف بإدارة الأمن والسلامة بإدارة التعليم");
    private By reports_menu_Locator = By.id("divMenuItem_304");
    private By SerachLinkReportLocator = By.id("lisearch_list");
    private By Search_field_Locator = By.id("myInput");
    private By TheReportNameLocator = By.linkText("عدد الطلاب مع ملكية مبنى المدرسة");
    private By Drop_down_list_Locator = By.id("select2-ctl00_PlaceHolderMain_ddlSupervisionCenter-container");
    private By Txt_field = By.xpath("/html/body/span/span/span[1]/input");
    private By Btn_search = By.id("ctl00_PlaceHolderMain_ibtnSearch");

    //
//عدد الطلاب مع ملكية مبنى المدرسة
    @Test
    public void NumberOfStudentsWhoOwnTheSchoolBuilding() {
        browserQA.findElement(SwitchProfileLocator).click();
        browserQA.findElement(UserNameLabelLocator).click();
        WebElement reports_menu_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(reports_menu_Locator));
        reports_menu_Locator_wait.click();
        WebElement search_logo_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachLinkReportLocator));
        search_logo_Locator_wait.click();
        WebElement search_field_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(Search_field_Locator));
        search_field_Locator_wait.sendKeys("عدد الطلاب مع ملكية مبنى المدرسة");
        WebElement NumberOfStudentsWhoOwnTheSchoolBuilding_link_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(TheReportNameLocator));
        NumberOfStudentsWhoOwnTheSchoolBuilding_link_wait.click();
        WebElement drop_down_list_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(Drop_down_list_Locator));
        drop_down_list_Locator_wait.click();
        WebElement txt_field_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(Txt_field));
        txt_field_wait.sendKeys("مكتب الخالدية الشمالية" , Keys.ENTER);

        try {
            WebElement btn_search_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(Btn_search));
            btn_search_wait.click();
        } catch (Exception e) {
            WebElement btn_search_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(Btn_search));
            btn_search_wait.click();
        }

        String expected_result = " عدد الطلاب مع ملكية مبنى المدرسة";
        By actual_result = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[5]/div/span/div/table/tbody/tr[4]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[7]/td[3]/table/tbody/tr/td/div/div/span");
        WebElement actual__result = waitQA.until(ExpectedConditions.visibilityOfElementLocated(actual_result));
        String actual___result = actual__result.getText();
        Assert.assertEquals(expected_result , actual___result , "التقرير المطلوب غير متوفر");
    }
}
