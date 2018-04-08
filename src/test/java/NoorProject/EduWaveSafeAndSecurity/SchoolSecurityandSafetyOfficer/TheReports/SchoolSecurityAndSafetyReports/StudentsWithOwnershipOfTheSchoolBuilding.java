/*
 * Created By Rami Alshawabkeh  3/14/18 2:07 PM
 */

/*
 * Created By Rami Alshawabkeh  3/13/18 4:26 PM
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

public class StudentsWithOwnershipOfTheSchoolBuilding {


    private By SwitchProfileLocator = By.id("ctl00_oHeader_divSwitchUser");
    private By UserNameLabelLocator = By.linkText("موظف الأمن والسلامة المدرسية");
    private By ReportsMainMenuLocator = By.id("divMenuItem_325");
    private By SerachLoactor = By.id("lisearch_list");


    private By TheReportNameLocator = By.linkText("عدد الطلاب مع ملكية مبنى المدرسة");
    private By GenderLocator = By.id("select2-ctl00_PlaceHolderMain_ddlLearningGender-container");
    private By Femalelocator = By.xpath("/html/body/span/span/span[1]/input");
    private By ddlDistrictLocator = By.id("select2-ctl00_PlaceHolderMain_ddlDistrict-container");
    private By ddlDistrictSearchLocator = By.xpath("/html/body/span/span/span[1]/input");
    private By ddlSupervisionCenteLocator = By.id("select2-ctl00_PlaceHolderMain_ddlSupervisionCenter-container");
    private By ddlSupervisionCenteSearchLocator = By.xpath("/html/body/span/span/span[1]/input");
    private By ibtnSearchLocator = By.id("ctl00_PlaceHolderMain_ibtnSearch");

    ///عدد الطلاب مع ملكية مبنى المدرسة
    @Test
    public void StudentsWithOwnershipOfTheSchoolBuildingReport() throws InterruptedException {
        browserQA.findElement(SwitchProfileLocator).click();
        browserQA.findElement(UserNameLabelLocator).click();
        browserQA.findElement(ReportsMainMenuLocator).click();
        browserQA.findElement(SerachLoactor).click();

        WebElement NumberOfStudendLocatorwait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(TheReportNameLocator));
        NumberOfStudendLocatorwait.click();

        WebElement GenderLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(GenderLocator));
        GenderLocatorWait.click();
        browserQA.findElement(Femalelocator).sendKeys("بنين", Keys.ENTER);

        Thread.sleep(1000);
        try {
            WebElement ddlDistrictLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ddlDistrictLocator));
            ddlDistrictLocatorWait.click();
        } catch (Exception e) {
            WebElement ddlDistrictLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ddlDistrictLocator));
            ddlDistrictLocatorWait.click();
        }

        browserQA.findElement(ddlDistrictSearchLocator).sendKeys("ادارة تعليم الحد الغربي(بنين)", Keys.ENTER);
        Thread.sleep(1000);
        try {
            WebElement ddlSupervisionCenteLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ddlSupervisionCenteLocator));
            ddlSupervisionCenteLocatorWait.click();
        } catch (Exception e) {
            WebElement ddlSupervisionCenteLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ddlSupervisionCenteLocator));
            ddlSupervisionCenteLocatorWait.click();
        }

        browserQA.findElement(ddlSupervisionCenteSearchLocator).sendKeys("مكتب الخالدية الشمالية", Keys.ENTER);

        try {
            WebElement ibtnSearchLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ibtnSearchLocator));
            ibtnSearchLocatorWait.click();
        } catch (Exception e) {
            WebElement ibtnSearchLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ibtnSearchLocator));
            ibtnSearchLocatorWait.click();
        }


        By ReportTitleInsidLoactor = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[5]/div/span/div/table/tbody/tr[4]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[7]/td[3]/table/tbody/tr/td/div/div/span");
        WebElement ReportTitleInsidLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportTitleInsidLoactor));
        String ReportTitleInsidLoactorElement = browserQA.findElement(ReportTitleInsidLoactor).getText();
        String ReportTitleInsidString = " عدد الطلاب مع ملكية مبنى المدرسة";

        Assert.assertEquals(ReportTitleInsidLoactorElement, ReportTitleInsidString, "لايمكن عرض التقرير المطلوب");

    }
}

