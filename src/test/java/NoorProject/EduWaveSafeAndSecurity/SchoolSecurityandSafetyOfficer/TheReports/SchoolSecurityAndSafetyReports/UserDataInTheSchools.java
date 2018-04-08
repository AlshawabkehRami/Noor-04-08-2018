/*
 * Created By Rami Alshawabkeh  3/14/18 2:07 PM
 */

/*
 * Created By Rami Alshawabkeh  3/13/18 2:03 PM
 */

/*
 * Created By Rami Alshawabkeh  3/13/18 12:27 PM
 */
//رعد صبيح
package NoorProject.EduWaveSafeAndSecurity.SchoolSecurityandSafetyOfficer.TheReports.SchoolSecurityAndSafetyReports;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static NoorProject.Other.NoorLogin.browserQA;
import static NoorProject.Other.NoorLogin.waitQA;

public class UserDataInTheSchools {


    private By SwitchProfileLocator = By.id("ctl00_oHeader_divSwitchUser");
    private By UserNameLabelLocator = By.linkText("موظف الأمن والسلامة المدرسية");
    private By ReportsMainMenuLocator = By.id("divMenuItem_325");
    private By SerachLoactor = By.id("lisearch_list");
    private By TheReportNameLocator = By.linkText("بيانات المستخدمين بالمدارس");

    private By drop_down_sex_Locator = By.id("select2-ctl00_PlaceHolderMain_ddlGender-container");
    private By txt_field_1_Locator = By.xpath("/html/body/span/span/span[1]/input");
    private By drop_down_managementt_Locator = By.id("select2-ctl00_PlaceHolderMain_ddlDistrict-container");
    private By txt_field_2_Locator = By.xpath("/html/body/span/span/span[1]/input");
    private By btn_search_Locator = By.id("ctl00_PlaceHolderMain_ibtnSearch");
    private By info_schools_Locator = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[5]/span/div/table/tbody/tr[4]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[6]/td[3]/table/tbody/tr/td/div/div[1]/span");
    private By btn_back_Locator = By.id("ctl00_PlaceHolderMain_ibtnBack");

    //
//بيانات المستخدمين بالمدارس
    @Test
    public void UserDataInTheSchoolsReports() throws InterruptedException {

        browserQA.findElement(SwitchProfileLocator).click();
        browserQA.findElement(UserNameLabelLocator).click();
        browserQA.findElement(ReportsMainMenuLocator).click();
        browserQA.findElement(SerachLoactor).click();

        WebElement reports_LocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(TheReportNameLocator));
        reports_LocatorWait.click();

        waitQA.until(ExpectedConditions.visibilityOfElementLocated(drop_down_sex_Locator)).click();
        waitQA.until(ExpectedConditions.visibilityOfElementLocated(txt_field_1_Locator)).sendKeys("بنين" , Keys.ENTER);
        Thread.sleep(100);
        waitQA.until(ExpectedConditions.visibilityOfElementLocated(drop_down_managementt_Locator)).click();
        waitQA.until(ExpectedConditions.visibilityOfElementLocated(txt_field_2_Locator)).sendKeys("الحد الغربي" , Keys.ENTER);
        Thread.sleep(100);
        waitQA.until(ExpectedConditions.visibilityOfElementLocated(btn_search_Locator)).click();

        waitQA.until(ExpectedConditions.visibilityOfElementLocated(info_schools_Locator));
        String s = browserQA.findElement(info_schools_Locator).getText();
        String Info_schools_2 = "بيانات المستخدمين بالمدارس";
        Assert.assertEquals(s , Info_schools_2 , "البيانات غير صحيحة");
        waitQA.until(ExpectedConditions.visibilityOfElementLocated(btn_back_Locator)).click();

    }

}

