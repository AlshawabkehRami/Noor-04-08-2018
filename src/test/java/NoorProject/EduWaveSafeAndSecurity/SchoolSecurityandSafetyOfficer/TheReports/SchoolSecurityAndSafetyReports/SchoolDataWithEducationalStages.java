/*
 * Created By Rami Alshawabkeh  3/14/18 2:07 PM
 */

/*
 * Created By Rami Alshawabkeh  3/13/18 2:03 PM
 */

/*
 * Created By Rami Alshawabkeh  3/13/18 12:33 PM
 */
//رعد صبيح

package NoorProject.EduWaveSafeAndSecurity.SchoolSecurityandSafetyOfficer.TheReports.SchoolSecurityAndSafetyReports;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static NoorProject.Other.NoorLogin.browserQA;
import static NoorProject.Other.NoorLogin.waitQA;

public class SchoolDataWithEducationalStages {


    private By SwitchProfileLocator = By.id("ctl00_oHeader_divSwitchUser");
    private By UserNameLabelLocator = By.linkText("موظف الأمن والسلامة المدرسية");
    private By ReportsMainMenuLocator = By.id("divMenuItem_325");
    private By SerachLoactor = By.id("lisearch_list");


    private By TheReportNameLoactor = By.linkText("بيانات المدرسة مع المراحل التعليمية");
    private By ddlLearningGender_Locator = By.id("select2-ctl00_PlaceHolderMain_ddlLearningGender-container");
    private By search_filed_Locator = By.xpath("/html/body/span/span/span[1]/input");
    private By ddlDistrict_Locator = By.id("select2-ctl00_PlaceHolderMain_ddlDistrict-container");
    private By search_field_2_Locator = By.xpath("/html/body/span/span/span[1]/input");
    private By office_education_Locator = By.id("select2-ctl00_PlaceHolderMain_ddlSupervisionCenter-container");
    private By search_field_3_Locator = By.xpath("/html/body/span/span/span[1]/input");
    private By btn_search_Locator = By.id("ctl00_PlaceHolderMain_ibtnSearch");
    private By btn_back_Locator = By.id("ctl00_PlaceHolderMain_ibtnBack");

    //
//بيانات المدرسة مع المراحل التعليمية
    @Test
    public void SchoolDataWithEducationalStagesReport() {

        WebElement switch_profie_LocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SwitchProfileLocator));
        switch_profie_LocatorWait.click();

        WebElement general_manager_link_LocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(UserNameLabelLocator));
        general_manager_link_LocatorWait.click();

        // for (int i = 0; i < 10; i++) {
        WebElement reports_LocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportsMainMenuLocator));
        reports_LocatorWait.click();

        browserQA.findElement(SerachLoactor).click();

        WebElement SchoolInfoWithStudyLevel_LocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(TheReportNameLoactor));
        SchoolInfoWithStudyLevel_LocatorWait.click();

        WebElement ddlLearningGender_LocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ddlLearningGender_Locator));
        ddlLearningGender_LocatorWait.click();

        WebElement search_filed_LocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(search_filed_Locator));
        search_filed_LocatorWait.sendKeys("بنين" , Keys.ENTER);

        try {
            WebElement ddlDistrict_LocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ddlDistrict_Locator));
            ddlDistrict_LocatorWait.click();
        } catch (Exception e) {
            WebElement ddlDistrict_LocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ddlDistrict_Locator));
            ddlDistrict_LocatorWait.click();
        }

        WebElement search_field_2_LocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(search_field_2_Locator));
        search_field_2_LocatorWait.sendKeys("الحد الغربي" , Keys.ENTER);

        try {

            WebElement office_education_LocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(office_education_Locator));
            office_education_LocatorWait.click();
        } catch (Exception e) {

            WebElement office_education_LocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(office_education_Locator));
            office_education_LocatorWait.click();
        }

        WebElement search_field_3_LocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(search_field_3_Locator));
        search_field_3_LocatorWait.sendKeys("الخالدية" , Keys.ENTER);

        try {
            WebElement btn_search_LocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(btn_search_Locator));
            btn_search_LocatorWait.click();
        } catch (Exception e) {
            WebElement btn_search_LocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(btn_search_Locator));
            btn_search_LocatorWait.click();
        }

        // }
   /*     By Info_School_Label_Locator = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[5]/div/span/div/table/tbody/tr[4]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[6]/td[3]/table/tbody/tr/td/div/div/span");
        waitQA.until(ExpectedConditions.visibilityOfElementLocated(Info_School_Label_Locator));
        String s = browserQA.findElement(Info_School_Label_Locator).getText();
        String Info_schools_2 = "بيانات المدرسة مع المراحل التعليمية ";
        Assert.assertEquals(s , Info_schools_2 , "البيانات غير صحيحة");*/


    }

}
