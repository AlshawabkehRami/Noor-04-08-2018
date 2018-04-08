/*
 * Created By Rami Alshawabkeh  3/14/18 2:07 PM
 */

/*
 * Created By Rami Alshawabkeh  3/13/18 2:03 PM
 */

/*
 * Created By Rami Alshawabkeh  3/13/18 12:08 PM
 */

/*
 * Created By Rami Alshawabkeh  3/13/18 12:07 PM
 */

/*
 * Created By Rami Alshawabkeh  3/13/18 12:07 PM
 */

/*
 * Created By Rami Alshawabkeh  3/13/18 12:05 PM
 */

/*
 * Created By Rami Alshawabkeh  3/13/18 9:31 AM
 */

package NoorProject.EduWaveSafeAndSecurity.SchoolSecurityandSafetyOfficer.TheReports.SchoolSecurityAndSafetyReports;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static NoorProject.Other.NoorLogin.browserQA;
import static NoorProject.Other.NoorLogin.waitQA;

public class SecurityAndSafety_AssessmentRate {

    private By SwitchProfileLocator = By.id("ctl00_oHeader_divSwitchUser");
    private By UserNameLabelLocator = By.linkText("موظف الأمن والسلامة المدرسية");
    private By ReportsMainMenuLocator = By.id("divMenuItem_325");
    private By SerachLoactor = By.id("lisearch_list");


    private By TheReportNameLocator = By.linkText("الأمن والسلامة - نسبة التقييم");
    private By GenderLoactor = By.id("select2-ctl00_PlaceHolderMain_ddlLearningGender-container");
    private By GenderSearchLoactor = By.xpath("/html/body/span/span/span[1]/input");
    private By FormNameLoactor = By.id("select2-ctl00_PlaceHolderMain_ddlFormName-container");
    private By FormNameSearchLoactor = By.xpath("/html/body/span/span/span[1]/input");
    private By ibtnSearchLoactor = By.id("ctl00_PlaceHolderMain_ibtnSearch");
    private By ReportInsideNameLoactor = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div/div[7]/div/span/div/table/tbody/tr[4]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/table/tbody/tr[6]/td[3]/table/tbody/tr/td/div/div/span");
    private By ibtnBackLoactor = By.id("ctl00_PlaceHolderMain_ibtnBack");

    //التقارير_تقارير الامن والسلامة المدرسية
    //الأمن والسلامة-نسب التقييم على مستوى الوزارة
    @Test
    public void SecurityAndSafety_AssessmentRateReport() {

        browserQA.findElement(SwitchProfileLocator).click();
        browserQA.findElement(UserNameLabelLocator).click();
        browserQA.findElement(ReportsMainMenuLocator).click();
        browserQA.findElement(SerachLoactor).click();

        WebElement SecurityAndSafety_AssessmentRateLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(TheReportNameLocator));
        SecurityAndSafety_AssessmentRateLoactorWait.click();


        WebElement GenderLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(GenderLoactor));
        GenderLoactorWait.click();

        browserQA.findElement(GenderSearchLoactor).sendKeys("بنين" , Keys.ENTER);

        try {
            WebElement FormNameLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(FormNameLoactor));
            FormNameLoactorWait.click();
        } catch (Exception j) {
            WebElement FormNameLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(FormNameLoactor));
            FormNameLoactorWait.click();
        }

        browserQA.findElement(FormNameSearchLoactor).sendKeys("Rami0550814558" , Keys.ENTER);

        try {
            WebElement ibtnSearchLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ibtnSearchLoactor));
            ibtnSearchLoactorWait.click();
        } catch (Exception gg) {
            WebElement ibtnSearchLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ibtnSearchLoactor));
            ibtnSearchLoactorWait.click();
        }

        WebElement ReportInsideNameLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportInsideNameLoactor));

        String ReportInsideName = browserQA.findElement(ReportInsideNameLoactor).getText();
        String ReportInsideNameString = "الأمن والسلامة-نسب التقييم على مستوى الوزارة";

        Assert.assertEquals(ReportInsideName , ReportInsideNameString , "لتقرير المطلوب غير متوفر حاليا");

        browserQA.findElement(ibtnBackLoactor).click();

    }
}
