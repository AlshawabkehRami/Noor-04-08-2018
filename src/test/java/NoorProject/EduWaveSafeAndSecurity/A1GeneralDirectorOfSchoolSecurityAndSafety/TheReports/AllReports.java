/*
 * Created By Rami AlShawabkeh  4/5/18 10:18 AM
 */

package NoorProject.EduWaveSafeAndSecurity.A1GeneralDirectorOfSchoolSecurityAndSafety.TheReports;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static NoorProject.Other.NoorLogin.browserQA;
import static NoorProject.Other.NoorLogin.waitQA;

public class AllReports {


    private By SwitchProfileLocator = By.id("ctl00_oHeader_divSwitchUser");
    private By UserNameLabelLocator = By.linkText("مدير عام الأمن والسلامة المدرسية");
    private By ReportsMainMenuLocator = By.id("divMenuItem_325");
    private By SearchLinkLocator = By.id("lisearch_list");
    private By DistributeStudentsToClassesReportLocator = By.linkText("توزيع الطلاب على الفصول");
    private By ddlLearningGenderLocatorDSTC = By.id("select2-ctl00_PlaceHolderMain_ddlLearningGender-container");
    private By ddlLearningGenderSearchLocatorDSTC = By.xpath("/html/body/span/span/span[1]/input");
    private By ddlDistrictLocatorDSTC = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[1]/div/div/div/div[2]/div[2]/div/span[1]/span[1]/span/span[2]");
    private By ddlDistrictSearchLocatorDSTC = By.xpath("/html/body/span/span/span[1]/input");
    private By ddlStudylevelLocatorDSTC = By.id("select2-ctl00_PlaceHolderMain_ddlStudylevel-container");
    private By ddlStudylevelSearchLocatorDSTC = By.xpath("/html/body/span/span/span[1]/input");
    private By ddlSchoolCategorizationLocatorDSTC = By.id("select2-ctl00_PlaceHolderMain_ddlSchoolCategorization-container");
    private By ddlSchoolCategorizationSearchLoactorDSTC = By.xpath("/html/body/span/span/span[1]/input");
    private By btnSearchLocatorDSTC = By.id("ctl00_PlaceHolderMain_ibtnSearch");


    //التقارير_تقارير المدارس
    //توزيع الطلاب على الفصول
    @Test
    public void viewDistributeStudentsToClasses() throws InterruptedException {

        browserQA.manage().window().maximize();
        browserQA.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);


        WebElement SwitchProfileLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SwitchProfileLocator));
        SwitchProfileLocatorWait.click();

        WebElement UserNameLabelLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(UserNameLabelLocator));
        UserNameLabelLocatorWait.click();


        WebElement ReportsMainMenuLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportsMainMenuLocator));
        ReportsMainMenuLocatorWait.click();


        browserQA.findElement(SearchLinkLocator).click();

        WebElement DistributeStudentsToClassesReportLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DistributeStudentsToClassesReportLocator));
        DistributeStudentsToClassesReportLocatorWait.click();

        WebElement ddlLearningGenderWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ddlLearningGenderLocatorDSTC));
        ddlLearningGenderWait.click();
        browserQA.findElement(ddlLearningGenderSearchLocatorDSTC).sendKeys("بنين", Keys.ENTER);


        Thread.sleep(1000);
        WebElement ddlDistrictLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ddlDistrictLocatorDSTC));
        ddlDistrictLocatorWait.click();


        WebElement ddlDistrictSearchLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ddlDistrictSearchLocatorDSTC));
        ddlDistrictSearchLocatorWait.sendKeys("الحد الغربي", Keys.ENTER);


        Thread.sleep(1000);

        WebElement ddlStudylevelLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ddlStudylevelLocatorDSTC));
        ddlStudylevelLocatorWait.click();


        browserQA.findElement(ddlStudylevelSearchLocatorDSTC).sendKeys("الثانوية", Keys.ENTER);


        try {
            WebElement ddlSchoolCategorizationLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ddlSchoolCategorizationLocatorDSTC));
            ddlSchoolCategorizationLocatorWait.click();
        } catch (Exception e) {
            WebElement ddlSchoolCategorizationLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ddlSchoolCategorizationLocatorDSTC));
            ddlSchoolCategorizationLocatorWait.click();
        }
        browserQA.findElement(ddlSchoolCategorizationSearchLoactorDSTC).sendKeys("حكومي", Keys.ENTER);

        try {
            WebElement btnSearchLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(btnSearchLocatorDSTC));
            btnSearchLocatorWait.click();
        } catch (Exception e) {
            WebElement btnSearchLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(btnSearchLocatorDSTC));
            btnSearchLocatorWait.click();
        }


        By ReportTitleLocator = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[5]/div/span/div/table/tbody/tr[4]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[3]/table/tbody/tr/td/table/tbody/tr[11]/td[3]/table/tbody/tr/td/div");

        WebElement ReportTitleLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportTitleLocator));

        String ActualResult = browserQA.findElement(ReportTitleLocator).getText();
        String ExpectedResult = "توزيع الطلاب على الفصول تجميعي";

        Assert.assertEquals(ActualResult, ExpectedResult, "التقرير المطلوب غير متوفر");
    }

    private By BuildingInformationReportLocator = By.linkText("بيانات المباني");
    private By GenderLocatorBI = By.id("select2-ctl00_PlaceHolderMain_ddlLearningGender-container");
    private By GenderSearchLocatorBI = By.xpath("/html/body/span/span/span[1]/input");
    private By DDLDistrictLocatorBI = By.id("select2-ctl00_PlaceHolderMain_ddlDistrict-container");
    private By DDLDistrictSearchLocatorBI = By.xpath("/html/body/span/span/span[1]/input");
    private By BTNSearchLocatorBI = By.id("ctl00_PlaceHolderMain_ibtnSearch");

    //التقارير_تقارير المباني والصيانة
    //بيانات المباني
    @Test
    public void buildingInformation() throws InterruptedException {


        WebElement ReportsMainMenuLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportsMainMenuLocator));
        ReportsMainMenuLocatorWait.click();

        WebElement SearchLinkLocatorrWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchLinkLocator));
        SearchLinkLocatorrWait.click();

        WebElement BuildingInformationReportLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(BuildingInformationReportLocator));
        BuildingInformationReportLocatorWait.click();

        WebElement GebderWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(GenderLocatorBI));
        GebderWait.click();

        WebElement GenderSearchLocatorBIWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(GenderSearchLocatorBI));
        GenderSearchLocatorBIWait.sendKeys("بنين", Keys.ENTER);

        Thread.sleep(1000);
        WebElement ddlDistrictLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DDLDistrictLocatorBI));
        ddlDistrictLocatorWait.click();

        WebElement ddlDistrictSearchLocatorBIWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DDLDistrictSearchLocatorBI));
        ddlDistrictSearchLocatorBIWait.sendKeys("الحد الغربي", Keys.ENTER);
        Thread.sleep(1000);

        try {
            WebElement btnSearchLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(BTNSearchLocatorBI));
            btnSearchLocatorWait.click();
        } catch (Exception e) {
            WebElement btnSearchLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(BTNSearchLocatorBI));
            btnSearchLocatorWait.click();
        }

        By ReportTitleLoactor = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[5]/div/span/div/table/tbody/tr[4]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/table/tbody/tr[10]/td[2]/table/tbody/tr/td/div");

        WebElement ReportTitleWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportTitleLoactor));
        String ActualResult = browserQA.findElement(ReportTitleLoactor).getText();
        String ExpectedResult = "بيانات المباني";
        Assert.assertEquals(ActualResult, ExpectedResult, "التقرير المطلوب غير متوفر");


    }

    private By InputRatioReportLocator = By.linkText("الأمن والسلامة - نسبة الإدخال");
    private By GenderLocatorIR = By.id("select2-ctl00_PlaceHolderMain_ddlLearningGender-container");
    private By GenderSearchLoactorIR = By.xpath("/html/body/span/span/span[1]/input");
    private By DDLFormNameLoactorIR = By.id("select2-ctl00_PlaceHolderMain_ddlFormName-container");
    private By DDLFormNameSearchLoactorIR = By.xpath("/html/body/span/span/span[1]/input");
    private By BTNSearchLocatorIR = By.id("ctl00_PlaceHolderMain_ibtnSearch");

    //    //التقارير_تقارير الامن والسلامة المدرسية
    //الأمن والسلامة-نسب الإدخال على مستوى الوزارة
    @Test
    public void inputRatio() throws InterruptedException {


        WebElement ReportsMainMenuLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportsMainMenuLocator));
        ReportsMainMenuLocatorWait.click();

        WebElement SearchLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchLinkLocator));
        SearchLinkLocatorWait.click();

        WebElement TheReportNameLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(InputRatioReportLocator));
        TheReportNameLocatorWait.click();

        try {
            WebElement GenderLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(GenderLocatorIR));
            GenderLocatorWait.click();
        } catch (Exception e) {
            WebElement GenderLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(GenderLocatorIR));
            GenderLocatorWait.click();
        }

        WebElement GenderSearchLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(GenderSearchLoactorIR));
        GenderSearchLoactorWait.sendKeys("بنين", Keys.ENTER);

        try {

            WebElement ddlFormNameLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DDLFormNameLoactorIR));
            ddlFormNameLoactorWait.click();
        } catch (Exception e) {

            WebElement ddlFormNameLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DDLFormNameLoactorIR));
            ddlFormNameLoactorWait.click();

        }

        WebElement ddlFormNameSearchLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DDLFormNameSearchLoactorIR));
        ddlFormNameSearchLoactorWait.sendKeys("Selenium Form Dont Delete", Keys.ENTER);

        Thread.sleep(1000);
        WebElement btnSearchLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(BTNSearchLocatorIR));
        btnSearchLocatorWait.click();


        By ReportInsideLabelLocator = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div/div[7]/div/span/div/table/tbody/tr[4]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[5]/td[3]/table/tbody/tr/td/div/div");
        WebElement ReportInsideLabelLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportInsideLabelLocator));
        String ActualResult = browserQA.findElement(ReportInsideLabelLocator).getText();
        String ExpectedResult = "الأمن والسلامة-نسب الإدخال على مستوى الوزارة";

        Assert.assertEquals(ActualResult, ExpectedResult, "التقرير المطلوب غير متوفر");


    }

    private By AssessmentRateReportLocator = By.linkText("الأمن والسلامة - نسبة التقييم");
    private By GenderLoactorAR = By.id("select2-ctl00_PlaceHolderMain_ddlLearningGender-container");
    private By GenderSearchLoactorAR = By.xpath("/html/body/span/span/span[1]/input");
    private By FormNameLoactorAR = By.id("select2-ctl00_PlaceHolderMain_ddlFormName-container");
    private By FormNameSearchLoactorAR = By.xpath("/html/body/span/span/span[1]/input");
    private By BTNSearchLoactorAR = By.id("ctl00_PlaceHolderMain_ibtnSearch");
    private By ReportInsideNameLoactorAR = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div/div[7]/div/span/div/table/tbody/tr[4]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/table/tbody/tr[6]/td[3]/table/tbody/tr/td/div/div/span");

    //التقارير_تقارير الامن والسلامة المدرسية
    //الأمن والسلامة-نسب التقييم على مستوى الوزارة
    @Test
    public void assessmentRate() throws InterruptedException {


        WebElement ReportsMainMenuLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportsMainMenuLocator));
        ReportsMainMenuLocatorWait.click();

        Thread.sleep(1000);
        WebElement SearchLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchLinkLocator));
        SearchLinkLocatorWait.click();

        WebElement TheReportNameLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AssessmentRateReportLocator));
        TheReportNameLocatorWait.click();


        WebElement GenderLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(GenderLoactorAR));
        GenderLoactorWait.click();

        WebElement GenderSearchLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(GenderSearchLoactorAR));
        GenderSearchLoactorWait.sendKeys("بنين", Keys.ENTER);

        Thread.sleep(1000);
        try {
            WebElement FormNameLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(FormNameLoactorAR));
            FormNameLoactorWait.click();
        } catch (Exception j) {
            WebElement FormNameLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(FormNameLoactorAR));
            FormNameLoactorWait.click();
        }

        browserQA.findElement(FormNameSearchLoactorAR).sendKeys("Selenium Form Dont Delete", Keys.ENTER);

        try {
            WebElement ibtnSearchLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(BTNSearchLoactorAR));
            ibtnSearchLoactorWait.click();
        } catch (Exception gg) {
            WebElement ibtnSearchLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(BTNSearchLoactorAR));
            ibtnSearchLoactorWait.click();
        }

        WebElement ReportInsideNameLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportInsideNameLoactorAR));

        String ActualResult = browserQA.findElement(ReportInsideNameLoactorAR).getText();
        String ExpectedResult = "الأمن والسلامة-نسب التقييم على مستوى الوزارة";

        Assert.assertEquals(ActualResult, ExpectedResult, "التقرير المطلوب غير متوفر");


    }

    private By SchoolInfoReportLocator = By.linkText("بيانات المدرسة");
    private By DDLGenderLocatorSR = By.id("select2-ctl00_PlaceHolderMain_ddlLearningGender-container");
    private By DDLGenderSearchLocatorSR = By.xpath("/html/body/span/span/span[1]/input");
    private By DDLDistrictLocatorSR = By.id("select2-ctl00_PlaceHolderMain_ddlDistrict-container");
    private By DDLDistrictSearchLocatorSR = By.xpath("/html/body/span/span/span[1]/input");
    private By DDLOfficeLocatorSR = By.id("select2-ctl00_PlaceHolderMain_ddlSupervisionCenter-container");
    private By DDLOfficeSearchLocatorSR = By.xpath("/html/body/span/span/span[1]/input");
    private By BTNSearchLocator = By.id("ctl00_PlaceHolderMain_ibtnSearch");
    private By Info_Schools_Locator = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[4]/div/span/div/table/tbody/tr[5]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[9]/td[3]/table/tbody/tr/td/div/div/span");

    //
//بيانات المدرسة
    @Test
    public void infoSchool() throws InterruptedException {


        WebElement ReportsMainMenuLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportsMainMenuLocator));
        ReportsMainMenuLocatorWait.click();

        Thread.sleep(1000);
        WebElement SearchLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchLinkLocator));
        SearchLinkLocatorWait.click();

        WebElement schools_info_LocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SchoolInfoReportLocator));
        schools_info_LocatorWait.click();

        WebElement drop_down_sex_LocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DDLGenderLocatorSR));
        drop_down_sex_LocatorWait.click();

        WebElement txt_male_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DDLGenderSearchLocatorSR));
        txt_male_wait.sendKeys("بنين", Keys.ENTER);

        Thread.sleep(1000);
        WebElement drop_down_managements_LocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DDLDistrictLocatorSR));
        drop_down_managements_LocatorWait.click();


        WebElement txt_drop_down_managements_LocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DDLDistrictSearchLocatorSR));
        txt_drop_down_managements_LocatorWait.sendKeys("الحد الغربي", Keys.ENTER);

        Thread.sleep(1000);
        try {
            WebElement education_office_LocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DDLOfficeLocatorSR));
            education_office_LocatorWait.click();
        } catch (Exception e) {

            WebElement education_office_LocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DDLOfficeLocatorSR));
            education_office_LocatorWait.click();


        }

        WebElement education_office_Locator_txtWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DDLOfficeSearchLocatorSR));
        education_office_Locator_txtWait.sendKeys("مكتب الخالدية", Keys.ENTER);

        Thread.sleep(1000);
        WebElement btn_search_LocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(BTNSearchLocator));
        btn_search_LocatorWait.click();


        waitQA.until(ExpectedConditions.visibilityOfElementLocated(Info_Schools_Locator));
        String ActualResult = browserQA.findElement(Info_Schools_Locator).getText();
        String ExpectedResult = "بيانات المدرسة";
        Assert.assertEquals(ActualResult, ExpectedResult, "التقرير المطلوب غير متوفر");


    }

    private By SchoolDataWithEducationalStagesLocator = By.linkText("بيانات المدرسة مع المراحل التعليمية");
    private By DDLGenderLocatorSDWES = By.id("select2-ctl00_PlaceHolderMain_ddlLearningGender-container");
    private By GenderSearchLocatorSDWES = By.xpath("/html/body/span/span/span[1]/input");
    private By DDLDistrictLocatorSDWES = By.id("select2-ctl00_PlaceHolderMain_ddlDistrict-container");
    private By DistrictSearchLocatorSDWES = By.xpath("/html/body/span/span/span[1]/input");
    private By OfficeLocatorSDWES = By.id("select2-ctl00_PlaceHolderMain_ddlSupervisionCenter-container");
    private By OfficeSearchLocatorSDWES = By.xpath("/html/body/span/span/span[1]/input");
    private By BTNSearchLocatorSDWES = By.id("ctl00_PlaceHolderMain_ibtnSearch");

    //
//بيانات المدرسة مع المراحل التعليمية
    @Test
    public void schoolDataWithEducationalStages() throws InterruptedException {


        WebElement ReportsMainMenuLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportsMainMenuLocator));
        ReportsMainMenuLocatorWait.click();

        WebElement SearchLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchLinkLocator));
        SearchLinkLocatorWait.click();

        WebElement TheReportNameLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SchoolDataWithEducationalStagesLocator));
        TheReportNameLocatorWait.click();

        WebElement ddlLearningGender_LocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DDLGenderLocatorSDWES));
        ddlLearningGender_LocatorWait.click();

        WebElement GenderSearchLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(GenderSearchLocatorSDWES));
        GenderSearchLocatorWait.sendKeys("بنين", Keys.ENTER);

        Thread.sleep(2000);
        WebElement DDLDistrictLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DDLDistrictLocatorSDWES));
        DDLDistrictLocatorWait.click();


        WebElement DistrictSearchLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DistrictSearchLocatorSDWES));
        DistrictSearchLocatorWait.sendKeys("الحد الغربي", Keys.ENTER);

        Thread.sleep(1000);
        WebElement OfficeLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(OfficeLocatorSDWES));
        OfficeLocatorWait.click();

        WebElement OfficeSearchLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(OfficeSearchLocatorSDWES));
        OfficeSearchLocatorWait.sendKeys("الخالدية", Keys.ENTER);


        Thread.sleep(1000);
        WebElement btn_search_LocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(BTNSearchLocatorSDWES));
        btn_search_LocatorWait.click();


    }


    private By UserDataInTheSchoolsLocator = By.linkText("بيانات المستخدمين بالمدارس");
    private By DDLGenderLocatorUDIS = By.id("select2-ctl00_PlaceHolderMain_ddlGender-container");
    private By DDLGenderSearchLocatorUDIS = By.xpath("/html/body/span/span/span[1]/input");
    private By DDLDistrictLocatorUDIS = By.id("select2-ctl00_PlaceHolderMain_ddlDistrict-container");
    private By DDLDistrictSearchLocatorUDIS = By.xpath("/html/body/span/span/span[1]/input");
    private By BTNSearchLocatorUDIS = By.xpath("//*[@id=\"ctl00_PlaceHolderMain_ibtnSearch\"]");
    private By info_schools_LocatorUDIS = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[5]/span/div/table/tbody/tr[4]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[6]/td[3]/table/tbody/tr/td/div/div[1]/span");

    //
//بيانات المستخدمين بالمدارس
    @Test
    public void userDataInTheSchools() throws InterruptedException {


        Thread.sleep(1000);

        WebElement ReportsMainMenuLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportsMainMenuLocator));
        ReportsMainMenuLocatorWait.click();


        WebElement SearchLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchLinkLocator));
        SearchLinkLocatorWait.click();


        WebElement TheReportLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(UserDataInTheSchoolsLocator));
        TheReportLoactorWait.click();

        waitQA.until(ExpectedConditions.visibilityOfElementLocated(DDLGenderLocatorUDIS)).click();
        waitQA.until(ExpectedConditions.visibilityOfElementLocated(DDLGenderSearchLocatorUDIS)).sendKeys("بنين", Keys.ENTER);
        Thread.sleep(100);
        waitQA.until(ExpectedConditions.visibilityOfElementLocated(DDLDistrictLocatorUDIS)).click();
        waitQA.until(ExpectedConditions.visibilityOfElementLocated(DDLDistrictSearchLocatorUDIS)).sendKeys("الحد الغربي", Keys.ENTER);
        Thread.sleep(100);
        waitQA.until(ExpectedConditions.visibilityOfElementLocated(BTNSearchLocatorUDIS)).click();

        waitQA.until(ExpectedConditions.visibilityOfElementLocated(info_schools_LocatorUDIS));
        String ActualResult = browserQA.findElement(info_schools_LocatorUDIS).getText();
        String ExpectedResult = "بيانات المستخدمين بالمدارس";
        Assert.assertEquals(ActualResult, ExpectedResult, "البيانات غير صحيحة");

    }

    private By StudentsWithOwnershipOfTheSchoolBuilding = By.linkText("عدد الطلاب مع ملكية مبنى المدرسة");
    private By GenderLocatorSWOSB = By.id("select2-ctl00_PlaceHolderMain_ddlLearningGender-container");
    private By FemalelocatorSWOSB = By.xpath("/html/body/span/span/span[1]/input");
    private By DDLDistrictLocatorSWOSB = By.id("select2-ctl00_PlaceHolderMain_ddlDistrict-container");
    private By DDLDistrictSearchLocatorSWOSB = By.xpath("/html/body/span/span/span[1]/input");
    private By DDLSupervisionCenteLocatorSWOSB = By.id("select2-ctl00_PlaceHolderMain_ddlSupervisionCenter-container");
    private By DDLSupervisionCenteSearchLocatorSWOSB = By.xpath("/html/body/span/span/span[1]/input");
    private By BTNSearchLocatorSWOSB = By.id("ctl00_PlaceHolderMain_ibtnSearch");


    @Test
    public void studentsWithOwnershipOfTheSchoolBuilding() throws InterruptedException {


        WebElement ReportsMainMenuLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportsMainMenuLocator));
        ReportsMainMenuLocatorWait.click();

        WebElement SearchLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchLinkLocator));
        SearchLinkLocatorWait.click();

        WebElement TheRwportLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(StudentsWithOwnershipOfTheSchoolBuilding));
        TheRwportLoactorWait.click();

        WebElement GenderLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(GenderLocatorSWOSB));
        GenderLocatorWait.click();
        browserQA.findElement(FemalelocatorSWOSB).sendKeys("بنات", Keys.ENTER);


        try {
            WebElement ddlDistrictLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DDLDistrictLocatorSWOSB));
            ddlDistrictLocatorWait.click();
        } catch (Exception e) {
            WebElement ddlDistrictLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DDLDistrictLocatorSWOSB));
            ddlDistrictLocatorWait.click();
        }

        WebElement DDLDistrictSearchLocatorSWOSBWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DDLDistrictSearchLocatorSWOSB));
        DDLDistrictSearchLocatorSWOSBWait.sendKeys("عمان", Keys.ENTER);

        Thread.sleep(2000);

        WebElement ddlSupervisionCenteLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DDLSupervisionCenteLocatorSWOSB));
        ddlSupervisionCenteLocatorWait.click();

        browserQA.findElement(DDLSupervisionCenteSearchLocatorSWOSB).sendKeys("عمان", Keys.ENTER);

        Thread.sleep(1000);
        WebElement ibtnSearchLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(BTNSearchLocatorSWOSB));
        ibtnSearchLocatorWait.click();

        By ReportTitleInsidLoactor = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[5]/div/span/div/table/tbody/tr[4]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[7]/td[3]/table/tbody/tr/td/div/div/span");

        WebElement ReportTitleInsidLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportTitleInsidLoactor));

        String ActualResult = browserQA.findElement(ReportTitleInsidLoactor).getText();
        String ExpectedResult = " عدد الطلاب مع ملكية مبنى المدرسة";

        Assert.assertEquals(ActualResult, ExpectedResult, "لايمكن عرض التقرير المطلوب");

    }

}
