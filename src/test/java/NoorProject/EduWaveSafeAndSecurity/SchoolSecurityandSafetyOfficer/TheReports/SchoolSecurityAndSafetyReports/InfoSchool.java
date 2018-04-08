/*
 * Created By Rami Alshawabkeh  3/14/18 2:07 PM
 */

/*
 * Created By Rami Alshawabkeh  3/13/18 2:03 PM
 */

/*
 * Created By Rami Alshawabkeh  3/13/18 12:38 PM
 */

//رعد صبيح

package NoorProject.EduWaveSafeAndSecurity.SchoolSecurityandSafetyOfficer.TheReports.SchoolSecurityAndSafetyReports;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static NoorProject.Other.NoorLogin.browserQA;
import static NoorProject.Other.NoorLogin.waitQA;

public class InfoSchool {

    private By SwitchProfileLocator = By.id("ctl00_oHeader_divSwitchUser");
    private By UserNameLabelLocator = By.linkText("موظف الأمن والسلامة المدرسية");
    private By ReportsMainMenuLocator = By.id("divMenuItem_325");
    private By SerachLoactor = By.id("lisearch_list");


    private By TheReportNameLoactor = By.linkText("بيانات المدرسة");
    private By drop_down_sex_Locator = By.id("select2-ctl00_PlaceHolderMain_ddlLearningGender-container");
    private By txt_male_Locator = By.xpath("/html/body/span/span/span[1]/input");
    private By drop_down_managements_Locator = By.id("select2-ctl00_PlaceHolderMain_ddlDistrict-container");
    private By txt_drop_down_managements_Locator = By.xpath("/html/body/span/span/span[1]/input");
    private By education_office_Locator = By.id("select2-ctl00_PlaceHolderMain_ddlSupervisionCenter-container");
    private By education_office_Locator_txt = By.xpath("/html/body/span/span/span[1]/input");
    private By btn_search_Locator = By.id("ctl00_PlaceHolderMain_ibtnSearch");
    private By Info_Schools_Locator = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[4]/div/span/div/table/tbody/tr[5]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[9]/td[3]/table/tbody/tr/td/div/div/span");
    private By btn_back_Locator = By.id("ctl00_PlaceHolderMain_ibtnBack");

    //
//بيانات المدرسة
    @Test
    public void InfoSchoolReport() throws InterruptedException {

        browserQA.findElement(SwitchProfileLocator).click();
        browserQA.findElement(UserNameLabelLocator).click();
        browserQA.findElement(ReportsMainMenuLocator).click();
        browserQA.findElement(SerachLoactor).click();

        waitQA.until(ExpectedConditions.visibilityOfElementLocated(TheReportNameLoactor)).click();
        waitQA.until(ExpectedConditions.visibilityOfElementLocated(drop_down_sex_Locator)).click();
        WebElement txt_male_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(txt_male_Locator));
        txt_male_wait.sendKeys("بنين", Keys.ENTER);

        Actions actions = new Actions(browserQA);
        try {
            WebElement drop_down_managements_LocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(drop_down_managements_Locator));
            drop_down_managements_LocatorWait.click();
        } catch (Exception e) {
            WebElement drop_down_managements_LocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(drop_down_managements_Locator));
            drop_down_managements_LocatorWait.click();
        }

        WebElement txt_drop_down_managements_Locator_Element = browserQA.findElement(txt_drop_down_managements_Locator);
        actions.moveToElement(txt_drop_down_managements_Locator_Element).sendKeys("الحد الغربي", Keys.ENTER).build().perform();

        try {
            WebElement education_office_LocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(education_office_Locator));
            education_office_LocatorWait.click();
        } catch (Exception e) {
            WebElement education_office_LocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(education_office_Locator));
            education_office_LocatorWait.click();
        }


        waitQA.until(ExpectedConditions.visibilityOfElementLocated(education_office_Locator_txt)).sendKeys("مكتب الخالدية", Keys.ENTER);

        Thread.sleep(1000);

        WebElement btn_search_LocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(btn_search_Locator));
        btn_search_LocatorWait.click();

        waitQA.until(ExpectedConditions.visibilityOfElementLocated(Info_Schools_Locator));
        String s = browserQA.findElement(Info_Schools_Locator).getText();
        String Info_schools_2 = "بيانات المدرسة";
        Assert.assertEquals(s, Info_schools_2, "البيانات غير صحيحة");

        waitQA.until(ExpectedConditions.visibilityOfElementLocated(btn_back_Locator)).click();
    }
}

