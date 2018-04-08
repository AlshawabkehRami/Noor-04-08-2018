/*
 * Created By Rami Alshawabkeh  3/18/18 12:53 PM
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

@Test
public class DataSecurityAndSafetyOfficialsInSchools {


    private By SwitchProfileLocator = By.id("ctl00_oHeader_divSwitchUser");
    private By UserNameLabelLocator = By.linkText("موظف الأمن والسلامة المدرسية");
    private By ReportsMainMenuLocator = By.id("divMenuItem_325");
    private By SerachLoactor = By.id("lisearch_list");


    private By TheReportNameLocator = By.linkText("بيانات مسؤولي الامن والسلامة في المدارس");
    private By GenderDDlLocator = By.id("select2-ctl00_PlaceHolderMain_ddlLearningGender-container");
    private By GenderDDlSearchLocator = By.xpath("/html/body/span/span/span[1]/input");
    private By btnSearchLocator = By.id("ctl00_PlaceHolderMain_ibtnSearch");


    public void ViewReport() {


        browserQA.findElement(SwitchProfileLocator).click();
        browserQA.findElement(UserNameLabelLocator).click();
        browserQA.findElement(ReportsMainMenuLocator).click();

        browserQA.findElement(SerachLoactor).click();

        WebElement TheReportLocatoeWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(TheReportNameLocator));
        TheReportLocatoeWait.click();

        WebElement GenderDDlLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(GenderDDlLocator));
        GenderDDlLocatorWait.click();
        browserQA.findElement(GenderDDlSearchLocator).sendKeys("بنين" , Keys.ENTER);

        try {
            WebElement btnSearchLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(btnSearchLocator));
            btnSearchLocatorWait.click();
        } catch (Exception e) {
            WebElement btnSearchLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(btnSearchLocator));
            btnSearchLocatorWait.click();
        }

        By NameofTheReportLocator = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[5]/div/span/div/table/tbody/tr[4]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[6]/td[3]/table/tbody/tr/td/div");

        WebElement NameofTheReportLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(NameofTheReportLocator));

        String NameofTheReportString = browserQA.findElement(NameofTheReportLocator).getText();
        String ReportLabelString = "بيانات مسؤولي الامن والسلامة في المدارس";

        Assert.assertEquals(NameofTheReportString , ReportLabelString , "التقرير المطلوب غير موجود");

    }
}
