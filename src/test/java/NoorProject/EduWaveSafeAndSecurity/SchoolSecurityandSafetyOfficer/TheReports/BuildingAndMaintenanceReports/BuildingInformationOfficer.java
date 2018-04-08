/*
 * Created By Rami Alshawabkeh  3/18/18 12:00 PM
 */

package NoorProject.EduWaveSafeAndSecurity.SchoolSecurityandSafetyOfficer.TheReports.BuildingAndMaintenanceReports;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static NoorProject.Other.NoorLogin.browserQA;
import static NoorProject.Other.NoorLogin.waitQA;

public class BuildingInformationOfficer {


    private By SwitchProfileLocator = By.id("ctl00_oHeader_divSwitchUser");
    private By UserNameLabelLocator = By.linkText("موظف الأمن والسلامة المدرسية");
    private By ReportsMainMenuLocator = By.id("divMenuItem_325");
    private By SerachLoactor = By.id("lisearch_list");
    private By TheReprtNameLocator = By.linkText("بيانات المباني");
    private By GenderLocator = By.id("select2-ctl00_PlaceHolderMain_ddlLearningGender-container");
    private By GenderSearchLocator = By.xpath("/html/body/span/span/span[1]/input");
    private By ddlDistrictLocator = By.id("select2-ctl00_PlaceHolderMain_ddlDistrict-container");
    private By ddlDistrictSearchLocator = By.xpath("/html/body/span/span/span[1]/input");
    private By btnSearchLocator = By.id("ctl00_PlaceHolderMain_ibtnSearch");
    private By btnBackLoactor = By.id("ctl00_PlaceHolderMain_ibtnBack");

    //التقارير_تقارير المباني والصيانة
    //بيانات المباني
    @Test
    public void BuildingInformationReport() throws InterruptedException {


        WebElement SwitchProfileLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SwitchProfileLocator));
        SwitchProfileLocatorWait.click();

        WebElement UserNameLabelLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(UserNameLabelLocator));
        UserNameLabelLocatorWait.click();
        // for (int i = 0; i < 10; i++) {
        WebElement ReportsMainMenuLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportsMainMenuLocator));
        ReportsMainMenuLocatorWait.click();

        browserQA.findElement(SerachLoactor).click();

        WebElement BuildingAndMaintenanceReportsLabelWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(TheReprtNameLocator));
        BuildingAndMaintenanceReportsLabelWait.click();


        WebElement GenderWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(GenderLocator));
        GenderWait.click();


        WebElement GenderSearchLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(GenderSearchLocator));
        GenderSearchLocatorWait.sendKeys("بنين" , Keys.ENTER);

        try {
            WebElement ddlDistrictLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ddlDistrictLocator));
            ddlDistrictLocatorWait.click();
        } catch (Exception e) {
            WebElement ddlDistrictLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ddlDistrictLocator));
            ddlDistrictLocatorWait.click();
        }

        WebElement ddlDistrictSearchLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ddlDistrictSearchLocator));
        ddlDistrictSearchLocatorWait.sendKeys("الحد الغربي" , Keys.ENTER);

        Thread.sleep(1000);

        WebElement btnSearchLocatorElement = browserQA.findElement(btnSearchLocator);

        WebElement btnSearchLocatorElementWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(btnSearchLocator));
        btnSearchLocatorElementWait.click();

        By ReportTitleLoactor = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[5]/div/span/div/table/tbody/tr[4]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/table/tbody/tr[10]/td[2]/table/tbody/tr/td/div");
        try {
            WebElement ReportTitleWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportTitleLoactor));

        } catch (Exception e) {
            WebElement ReportTitleWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportTitleLoactor));

        }
        String TitleForTheReport = browserQA.findElement(ReportTitleLoactor).getText();
        String Title = "بيانات المباني";
        Assert.assertEquals(TitleForTheReport , Title , "التقرير المطلوب غير موجود");

        browserQA.findElement(btnBackLoactor).click();
        // }


    }


}


