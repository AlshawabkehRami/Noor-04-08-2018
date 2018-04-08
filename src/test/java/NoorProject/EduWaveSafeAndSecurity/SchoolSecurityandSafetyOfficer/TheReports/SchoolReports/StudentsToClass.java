/*
 * Created By Rami Alshawabkeh  3/18/18 12:12 PM
 */

package NoorProject.EduWaveSafeAndSecurity.SchoolSecurityandSafetyOfficer.TheReports.SchoolReports;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static NoorProject.Other.NoorLogin.browserQA;
import static NoorProject.Other.NoorLogin.waitQA;

public class StudentsToClass {


    private By SwitchProfileLocator = By.id("ctl00_oHeader_divSwitchUser");
    private By UserNameLabelLocator = By.linkText("موظف الأمن والسلامة المدرسية");
    private By ReportsMainMenuLocator = By.id("divMenuItem_325");
    private By SerachLoactor = By.id("lisearch_list");


    private By TheReportNameLocator = By.linkText("توزيع الطلاب على الفصول");
    private By ddlLearningGenderLocator = By.id("select2-ctl00_PlaceHolderMain_ddlLearningGender-container");
    private By ddlLearningGenderSearchLocator = By.xpath("/html/body/span/span/span[1]/input");
    private By ddlDistrictLocator = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[1]/div/div/div/div[2]/div[2]/div/span[1]/span[1]/span/span[2]");
    private By ddlDistrictSearchLocator = By.xpath("/html/body/span/span/span[1]/input");
    private By ddlStudylevelLocator = By.id("select2-ctl00_PlaceHolderMain_ddlStudylevel-container");
    private By ddlStudylevelSearchLocator = By.xpath("/html/body/span/span/span[1]/input");
    private By ddlSchoolCategorizationLocator = By.id("select2-ctl00_PlaceHolderMain_ddlSchoolCategorization-container");
    private By ddlSchoolCategorizationSearchLoactor = By.xpath("/html/body/span/span/span[1]/input");
    private By btnSearchLocator = By.id("ctl00_PlaceHolderMain_ibtnSearch");
    private By NameOfTheReprtLoactor = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[5]/div/span/div/table/tbody/tr[4]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[3]/table/tbody/tr/td/table/tbody/tr[11]/td[3]/table/tbody/tr/td/div");
    private By btnBackLocator = By.id("ctl00_PlaceHolderMain_ibtnBack");


    //التقارير_تقارير المدارس
    //توزيع الطلاب على الفصول
    @Test
    public void ViewDistributeStudentsToClassesReport() {

        browserQA.findElement(SwitchProfileLocator).click();
        browserQA.findElement(UserNameLabelLocator).click();
        browserQA.findElement(ReportsMainMenuLocator).click();
        browserQA.findElement(SerachLoactor).click();
        WebElement SchoolReportsWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(TheReportNameLocator));
        SchoolReportsWait.click();

        WebElement ddlLearningGenderWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ddlLearningGenderLocator));
        ddlLearningGenderWait.click();
        browserQA.findElement(ddlLearningGenderSearchLocator).sendKeys("بنين" , Keys.ENTER);

        Actions actions = new Actions(browserQA);


        try {
            WebElement ddlDistrictLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ddlDistrictLocator));
            ddlDistrictLocatorWait.click();
        } catch (Exception e) {
            WebElement ddlDistrictLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ddlDistrictLocator));
            ddlDistrictLocatorWait.click();
        }
        WebElement ddlDistrictSearchLocatorElement = browserQA.findElement(ddlDistrictSearchLocator);
        actions.moveToElement(ddlDistrictSearchLocatorElement).sendKeys("الحد الغربي" , Keys.ENTER).perform();


        try {
            WebElement ddlStudylevelLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ddlStudylevelLocator));
            ddlStudylevelLocatorWait.click();
            browserQA.findElement(ddlStudylevelSearchLocator).sendKeys("الثانوية" , Keys.ENTER);
        } catch (Exception e) {

            WebElement ddlStudylevelLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ddlStudylevelLocator));
            ddlStudylevelLocatorWait.click();
            browserQA.findElement(ddlStudylevelSearchLocator).sendKeys("الثانوية" , Keys.ENTER);
        }


        try {

            WebElement ddlSchoolCategorizationLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ddlSchoolCategorizationLocator));
            ddlSchoolCategorizationLocatorWait.click();
        } catch (Exception e) {
            WebElement ddlSchoolCategorizationLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ddlSchoolCategorizationLocator));
            ddlSchoolCategorizationLocatorWait.click();
        }
        browserQA.findElement(ddlSchoolCategorizationSearchLoactor).sendKeys("حكومي" , Keys.ENTER);


        try {
            WebElement btnSearchLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(btnSearchLocator));
            btnSearchLocatorWait.click();
        } catch (Exception e) {
            WebElement btnSearchLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(btnSearchLocator));
            btnSearchLocatorWait.click();
        }


        WebElement NameOfTheReprtLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(NameOfTheReprtLoactor));
        String NameOfTheReprtTilte = "توزيع الطلاب على الفصول تجميعي";
        String NameOfTheReprtLoactoTitle = browserQA.findElement(NameOfTheReprtLoactor).getText();
        Assert.assertEquals(NameOfTheReprtTilte , NameOfTheReprtLoactoTitle , "التقرير غير صحيح");
        browserQA.findElement(btnBackLocator).click();


    }
}
