/*
 * Created By  Rami AlShawabkeh  4/11/18 3:58 PM
 */

/*
 * Created By  Rami AlShawabkeh  4/8/18 3:08 PM
 */

/*
 * Created By  Rami AlShawabkeh  4/8/18 12:54 PM
 */

package NoorProject.EduWaveSafeAndSecurity.A2SSOfficerInMinstry.Report;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static NoorProject.Other.NoorLogin.browserQA;
import static NoorProject.Other.NoorLogin.waitQA;

public class TheReports {


    private By SwitchProfileLocator = By.id("ctl00_oHeader_divSwitchUser");
    private By UserNameLabelLocator = By.linkText("موظف الأمن والسلامة المدرسية");
    private By ReportsMainMenuLocator = By.id("divMenuItem_325");
    private By SerachLoactor = By.id("lisearch_list");
    private By TheReprtNameLocatorBI = By.linkText("بيانات المباني");
    private By GenderLocatorBI = By.id("select2-ctl00_PlaceHolderMain_ddlLearningGender-container");
    private By GenderSearchLocatorBI = By.xpath("/html/body/span/span/span[1]/input");
    private By DDLDistrictLocatorBI = By.id("select2-ctl00_PlaceHolderMain_ddlDistrict-container");
    private By DDLDistrictSearchLocatorBI = By.xpath("/html/body/span/span/span[1]/input");
    private By BTNSearchLocatorBI = By.id("ctl00_PlaceHolderMain_ibtnSearch");
    private By BTNBackLoactorBI = By.id("ctl00_PlaceHolderMain_ibtnBack");

    @Test

    public void switchUser() {

        browserQA.manage().window().maximize();
        browserQA.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);


        WebElement SwitchProfileLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SwitchProfileLocator));
        SwitchProfileLocatorWait.click();

        WebElement UserNameLabelLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(UserNameLabelLocator));
        UserNameLabelLocatorWait.click();
    }

    //التقارير_تقارير المباني والصيانة
    //بيانات المباني
    @Test
    public void buildingInformation() throws InterruptedException {


        WebElement ReportsMainMenuLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportsMainMenuLocator));
        ReportsMainMenuLocatorWait.click();

        browserQA.findElement(SerachLoactor).click();

        WebElement BuildingAndMaintenanceReportsLabelWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(TheReprtNameLocatorBI));
        BuildingAndMaintenanceReportsLabelWait.click();


        WebElement GenderWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(GenderLocatorBI));
        GenderWait.click();


        WebElement GenderSearchLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(GenderSearchLocatorBI));
        GenderSearchLocatorWait.sendKeys("بنين", Keys.ENTER);

        try {
            WebElement ddlDistrictLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DDLDistrictLocatorBI));
            ddlDistrictLocatorWait.click();
        } catch (Exception e) {
            WebElement ddlDistrictLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DDLDistrictLocatorBI));
            ddlDistrictLocatorWait.click();
        }

        WebElement ddlDistrictSearchLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DDLDistrictSearchLocatorBI));
        ddlDistrictSearchLocatorWait.sendKeys("الحد الغربي", Keys.ENTER);

        Thread.sleep(1000);

        WebElement btnSearchLocatorElement = browserQA.findElement(BTNSearchLocatorBI);

        WebElement btnSearchLocatorElementWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(BTNSearchLocatorBI));
        btnSearchLocatorElementWait.click();

        By ReportTitleLoactor = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[5]/div/span/div/table/tbody/tr[4]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/table/tbody/tr[10]/td[2]/table/tbody/tr/td/div");
        try {
            WebElement ReportTitleWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportTitleLoactor));

        } catch (Exception e) {
            WebElement ReportTitleWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportTitleLoactor));

        }
        String TitleForTheReport = browserQA.findElement(ReportTitleLoactor).getText();
        String Title = "بيانات المباني";
        Assert.assertEquals(TitleForTheReport, Title, "التقرير المطلوب غير موجود");

        browserQA.findElement(BTNBackLoactorBI).click();


    }

    private By TheReportNameLocatorSTC = By.linkText("توزيع الطلاب على الفصول");
    private By ddlLearningGenderLocatorSTC = By.id("select2-ctl00_PlaceHolderMain_ddlLearningGender-container");
    private By ddlLearningGenderSearchLocatorSTC = By.xpath("/html/body/span/span/span[1]/input");
    private By ddlDistrictLocatorSTC = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[1]/div/div/div/div[2]/div[2]/div/span[1]/span[1]/span/span[2]");
    private By ddlDistrictSearchLocatorSTC = By.xpath("/html/body/span/span/span[1]/input");
    private By ddlStudylevelLocatorSTC = By.id("select2-ctl00_PlaceHolderMain_ddlStudylevel-container");
    private By ddlStudylevelSearchLocatorSTC = By.xpath("/html/body/span/span/span[1]/input");
    private By ddlSchoolCategorizationLocatorSTC = By.id("select2-ctl00_PlaceHolderMain_ddlSchoolCategorization-container");
    private By ddlSchoolCategorizationSearchLoactorSTC = By.xpath("/html/body/span/span/span[1]/input");
    private By btnSearchLocatorSTC = By.id("ctl00_PlaceHolderMain_ibtnSearch");
    private By NameOfTheReprtLoactorSTC = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[5]/div/span/div/table/tbody/tr[4]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[3]/table/tbody/tr/td/table/tbody/tr[11]/td[3]/table/tbody/tr/td/div");
    private By btnBackLocatorSTC = By.id("ctl00_PlaceHolderMain_ibtnBack");


    //التقارير_تقارير المدارس
    //توزيع الطلاب على الفصول
    @Test
    public void distributeStudentsToClasses() throws InterruptedException {

        browserQA.manage().window().maximize();
        browserQA.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);


        WebElement ReportsMainMenuLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportsMainMenuLocator));
        ReportsMainMenuLocatorWait.click();

        browserQA.findElement(SerachLoactor).click();

        WebElement SchoolReportsWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(TheReportNameLocatorSTC));
        SchoolReportsWait.click();

        WebElement ddlLearningGenderWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ddlLearningGenderLocatorSTC));
        ddlLearningGenderWait.click();

        browserQA.findElement(ddlLearningGenderSearchLocatorSTC).sendKeys("بنين", Keys.ENTER);

        Actions actions = new Actions(browserQA);


        try {
            WebElement ddlDistrictLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ddlDistrictLocatorSTC));
            ddlDistrictLocatorWait.click();
        } catch (Exception e) {
            WebElement ddlDistrictLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ddlDistrictLocatorSTC));
            ddlDistrictLocatorWait.click();
        }
        WebElement ddlDistrictSearchLocatorElement = browserQA.findElement(ddlDistrictSearchLocatorSTC);
        actions.moveToElement(ddlDistrictSearchLocatorElement).sendKeys("الحد الغربي", Keys.ENTER).perform();


        Thread.sleep(1000);
        WebElement ddlStudylevelLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ddlStudylevelLocatorSTC));
        ddlStudylevelLocatorWait.click();
        browserQA.findElement(ddlStudylevelSearchLocatorSTC).sendKeys("الثانوية", Keys.ENTER);


        try {

            WebElement ddlSchoolCategorizationLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ddlSchoolCategorizationLocatorSTC));
            ddlSchoolCategorizationLocatorWait.click();
        } catch (Exception e) {
            WebElement ddlSchoolCategorizationLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ddlSchoolCategorizationLocatorSTC));
            ddlSchoolCategorizationLocatorWait.click();
        }
        browserQA.findElement(ddlSchoolCategorizationSearchLoactorSTC).sendKeys("حكومي", Keys.ENTER);


        try {
            WebElement btnSearchLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(btnSearchLocatorSTC));
            btnSearchLocatorWait.click();
        } catch (Exception e) {
            WebElement btnSearchLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(btnSearchLocatorSTC));
            btnSearchLocatorWait.click();
        }


        WebElement NameOfTheReprtLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(NameOfTheReprtLoactorSTC));
        String NameOfTheReprtTilte = "توزيع الطلاب على الفصول تجميعي";
        String NameOfTheReprtLoactoTitle = browserQA.findElement(NameOfTheReprtLoactorSTC).getText();
        Assert.assertEquals(NameOfTheReprtTilte, NameOfTheReprtLoactoTitle, "التقرير غير صحيح");
        browserQA.findElement(btnBackLocatorSTC).click();


    }


    private By TheReportNameLocatorDSSOS = By.linkText("بيانات مسؤولي الامن والسلامة في المدارس");
    private By GenderDDlLocatorDSSOS = By.id("select2-ctl00_PlaceHolderMain_ddlLearningGender-container");
    private By GenderDDlSearchLocatorDSSOS = By.xpath("/html/body/span/span/span[1]/input");
    private By btnSearchLocatorDSSOS = By.id("ctl00_PlaceHolderMain_ibtnSearch");

    @Test
    public void dataSecurityAndSafetyOfficialsInSchools() {


        WebElement ReportsMainMenuLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportsMainMenuLocator));
        ReportsMainMenuLocatorWait.click();

        browserQA.findElement(SerachLoactor).click();


        WebElement TheReportLocatoeWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(TheReportNameLocatorDSSOS));
        TheReportLocatoeWait.click();

        WebElement GenderDDlLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(GenderDDlLocatorDSSOS));
        GenderDDlLocatorWait.click();
        browserQA.findElement(GenderDDlSearchLocatorDSSOS).sendKeys("بنين", Keys.ENTER);

        try {
            WebElement btnSearchLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(btnSearchLocatorDSSOS));
            btnSearchLocatorWait.click();
        } catch (Exception e) {
            WebElement btnSearchLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(btnSearchLocatorDSSOS));
            btnSearchLocatorWait.click();
        }

        By NameofTheReportLocator = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[5]/div/span/div/table/tbody/tr[4]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[6]/td[3]/table/tbody/tr/td/div");

        WebElement NameofTheReportLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(NameofTheReportLocator));

        String NameofTheReportString = browserQA.findElement(NameofTheReportLocator).getText();
        String ReportLabelString = "بيانات مسؤولي الامن والسلامة في المدارس";

        Assert.assertEquals(NameofTheReportString, ReportLabelString, "التقرير المطلوب غير موجود");

    }

    private By TheReportNameLoactorIS = By.linkText("بيانات المدرسة");
    private By drop_down_sex_LocatorIS = By.id("select2-ctl00_PlaceHolderMain_ddlLearningGender-container");
    private By txt_male_LocatorIS = By.xpath("/html/body/span/span/span[1]/input");
    private By drop_down_managements_LocatorIS = By.id("select2-ctl00_PlaceHolderMain_ddlDistrict-container");
    private By txt_drop_down_managements_LocatorIS = By.xpath("/html/body/span/span/span[1]/input");
    private By education_office_LocatorIS = By.id("select2-ctl00_PlaceHolderMain_ddlSupervisionCenter-container");
    private By education_office_Locator_txtIS = By.xpath("/html/body/span/span/span[1]/input");
    private By btn_search_LocatorIS = By.id("ctl00_PlaceHolderMain_ibtnSearch");
    private By Info_Schools_LocatorIS = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[4]/div/span/div/table/tbody/tr[5]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[9]/td[3]/table/tbody/tr/td/div/div/span");
    private By btn_back_LocatorIS = By.id("ctl00_PlaceHolderMain_ibtnBack");

    //
//بيانات المدرسة
    @Test
    public void infoSchoolReport() throws InterruptedException {


        WebElement ReportsMainMenuLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportsMainMenuLocator));
        ReportsMainMenuLocatorWait.click();

        browserQA.findElement(SerachLoactor).click();


        waitQA.until(ExpectedConditions.visibilityOfElementLocated(TheReportNameLoactorIS)).click();
        waitQA.until(ExpectedConditions.visibilityOfElementLocated(drop_down_sex_LocatorIS)).click();
        WebElement txt_male_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(txt_male_LocatorIS));
        txt_male_wait.sendKeys("بنين", Keys.ENTER);

        Actions actions = new Actions(browserQA);
        try {
            WebElement drop_down_managements_LocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(drop_down_managements_LocatorIS));
            drop_down_managements_LocatorWait.click();
        } catch (Exception e) {
            WebElement drop_down_managements_LocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(drop_down_managements_LocatorIS));
            drop_down_managements_LocatorWait.click();
        }

        WebElement txt_drop_down_managements_Locator_Element = browserQA.findElement(txt_drop_down_managements_LocatorIS);
        actions.moveToElement(txt_drop_down_managements_Locator_Element).sendKeys("الحد الغربي", Keys.ENTER).build().perform();

        try {
            WebElement education_office_LocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(education_office_LocatorIS));
            education_office_LocatorWait.click();
        } catch (Exception e) {
            WebElement education_office_LocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(education_office_LocatorIS));
            education_office_LocatorWait.click();
        }


        waitQA.until(ExpectedConditions.visibilityOfElementLocated(education_office_Locator_txtIS)).sendKeys("مكتب الخالدية", Keys.ENTER);

        Thread.sleep(1000);

        WebElement btn_search_LocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(btn_search_LocatorIS));
        btn_search_LocatorWait.click();

        waitQA.until(ExpectedConditions.visibilityOfElementLocated(Info_Schools_LocatorIS));
        String s = browserQA.findElement(Info_Schools_LocatorIS).getText();
        String Info_schools_2 = "بيانات المدرسة";
        Assert.assertEquals(s, Info_schools_2, "البيانات غير صحيحة");

        waitQA.until(ExpectedConditions.visibilityOfElementLocated(btn_back_LocatorIS)).click();
    }


    private By TheReportNameLoactorSDWES = By.linkText("بيانات المدرسة مع المراحل التعليمية");
    private By ddlLearningGender_LocatorSDWES = By.id("select2-ctl00_PlaceHolderMain_ddlLearningGender-container");
    private By search_filed_LocatorSDWES = By.xpath("/html/body/span/span/span[1]/input");
    private By ddlDistrict_LocatorSDWES = By.id("select2-ctl00_PlaceHolderMain_ddlDistrict-container");
    private By search_field_2_LocatorSDWES = By.xpath("/html/body/span/span/span[1]/input");
    private By office_education_LocatorSDWES = By.id("select2-ctl00_PlaceHolderMain_ddlSupervisionCenter-container");
    private By search_field_3_LocatorSDWES = By.xpath("/html/body/span/span/span[1]/input");
    private By btn_search_LocatorSDWES = By.id("ctl00_PlaceHolderMain_ibtnSearch");

    //
//بيانات المدرسة مع المراحل التعليمية
    @Test
    public void schoolDataWithEducationalStagesReport() throws InterruptedException {


        WebElement ReportsMainMenuLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportsMainMenuLocator));
        ReportsMainMenuLocatorWait.click();

        browserQA.findElement(SerachLoactor).click();


        WebElement SchoolInfoWithStudyLevel_LocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(TheReportNameLoactorSDWES));
        SchoolInfoWithStudyLevel_LocatorWait.click();

        WebElement ddlLearningGender_LocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ddlLearningGender_LocatorSDWES));
        ddlLearningGender_LocatorWait.click();

        WebElement search_filed_LocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(search_filed_LocatorSDWES));
        search_filed_LocatorWait.sendKeys("بنين", Keys.ENTER);


        Thread.sleep(1000);
        WebElement ddlDistrict_LocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ddlDistrict_LocatorSDWES));
        ddlDistrict_LocatorWait.click();


        WebElement search_field_2_LocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(search_field_2_LocatorSDWES));
        search_field_2_LocatorWait.sendKeys("الحد الغربي", Keys.ENTER);

        try {

            WebElement office_education_LocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(office_education_LocatorSDWES));
            office_education_LocatorWait.click();
        } catch (Exception e) {

            WebElement office_education_LocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(office_education_LocatorSDWES));
            office_education_LocatorWait.click();
        }

        WebElement search_field_3_LocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(search_field_3_LocatorSDWES));
        search_field_3_LocatorWait.sendKeys("الخالدية", Keys.ENTER);

        try {
            WebElement btn_search_LocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(btn_search_LocatorSDWES));
            btn_search_LocatorWait.click();
        } catch (Exception e) {
            WebElement btn_search_LocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(btn_search_LocatorSDWES));
            btn_search_LocatorWait.click();
        }


    }

    private By TheReportNameLocatorIR = By.linkText("الأمن والسلامة - نسبة الإدخال");
    private By GenderLocatorIR = By.id("select2-ctl00_PlaceHolderMain_ddlLearningGender-container");
    private By GenderSearchLoactorIR = By.xpath("/html/body/span/span/span[1]/input");
    private By ddlFormNameLoactorIR = By.id("select2-ctl00_PlaceHolderMain_ddlFormName-container");
    private By ddlFormNameSearchLoactorIR = By.xpath("/html/body/span/span/span[1]/input");
    private By btnSearchLocatorIR = By.id("ctl00_PlaceHolderMain_ibtnSearch");
    private By btnBackLocatorIR = By.id("ctl00_PlaceHolderMain_ibtnBack");

    //    //التقارير_تقارير الامن والسلامة المدرسية
    //الأمن والسلامة-نسب الإدخال على مستوى الوزارة
    @Test
    public void inputRatio() throws InterruptedException {


        Thread.sleep(1000);
        WebElement ReportsMainMenuLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportsMainMenuLocator));
        ReportsMainMenuLocatorWait.click();

        browserQA.findElement(SerachLoactor).click();

        Thread.sleep(200);

        WebElement SecurityAndSafety_InputRatioReportLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(TheReportNameLocatorIR));
        SecurityAndSafety_InputRatioReportLoactorWait.click();

        try {
            WebElement GenderLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(GenderLocatorIR));
            GenderLocatorWait.click();
        } catch (Exception ff) {
            WebElement GenderLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(GenderLocatorIR));
            GenderLocatorWait.click();
        }

        browserQA.findElement(GenderSearchLoactorIR).sendKeys("بنين", Keys.ENTER);

        Thread.sleep(1000);
        WebElement ddlFormNameLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ddlFormNameLoactorIR));
        ddlFormNameLoactorWait.click();


        browserQA.findElement(ddlFormNameSearchLoactorIR).sendKeys("Selenium Form Dont Delete", Keys.ENTER);

        Thread.sleep(1000);

        WebElement btnSearchLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(btnSearchLocatorIR));
        btnSearchLocatorWait.click();


        By ReportInsideLabelLocator = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div/div[7]/div/span/div/table/tbody/tr[4]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[5]/td[3]/table/tbody/tr/td/div/div");
        WebElement ReportInsideLabelLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportInsideLabelLocator));
        String ddd = browserQA.findElement(ReportInsideLabelLocator).getText();
        String ggg = "الأمن والسلامة-نسب الإدخال على مستوى الوزارة";

        Assert.assertEquals(ddd, ggg, "التقرير غير موجود");


        browserQA.findElement(btnBackLocatorIR).click();


    }

    private By TheReportNameLocatorAR = By.linkText("الأمن والسلامة - نسبة التقييم");
    private By GenderLoactorAR = By.id("select2-ctl00_PlaceHolderMain_ddlLearningGender-container");
    private By GenderSearchLoactorAR = By.xpath("/html/body/span/span/span[1]/input");
    private By FormNameLoactorAR = By.id("select2-ctl00_PlaceHolderMain_ddlFormName-container");
    private By FormNameSearchLoactorAR = By.xpath("/html/body/span/span/span[1]/input");
    private By ibtnSearchLoactorAR = By.id("ctl00_PlaceHolderMain_ibtnSearch");
    private By ReportInsideNameLoactorAR = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div/div[7]/div/span/div/table/tbody/tr[4]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/table/tbody/tr[6]/td[3]/table/tbody/tr/td/div/div/span");
    private By ibtnBackLoactorAR = By.id("ctl00_PlaceHolderMain_ibtnBack");

    //التقارير_تقارير الامن والسلامة المدرسية
    //الأمن والسلامة-نسب التقييم على مستوى الوزارة
    @Test
    public void aasessmentRateReport() throws InterruptedException {

        Thread.sleep(1000);
        WebElement ReportsMainMenuLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportsMainMenuLocator));
        ReportsMainMenuLocatorWait.click();

        browserQA.findElement(SerachLoactor).click();

        WebElement SecurityAndSafety_AssessmentRateLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(TheReportNameLocatorAR));
        SecurityAndSafety_AssessmentRateLoactorWait.click();

        Thread.sleep(1000);
        WebElement GenderLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(GenderLoactorAR));
        GenderLoactorWait.click();

        browserQA.findElement(GenderSearchLoactorAR).sendKeys("بنين", Keys.ENTER);

        try {
            WebElement FormNameLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(FormNameLoactorAR));
            FormNameLoactorWait.click();
        } catch (Exception j) {
            WebElement FormNameLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(FormNameLoactorAR));
            FormNameLoactorWait.click();
        }

        Thread.sleep(200);
        WebElement FormNameSearchLoactorARWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(FormNameSearchLoactorAR));
        FormNameSearchLoactorARWait.sendKeys("Selenium Form Dont Delete", Keys.ENTER);

        try {
            WebElement ibtnSearchLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ibtnSearchLoactorAR));
            ibtnSearchLoactorWait.click();
        } catch (Exception gg) {
            WebElement ibtnSearchLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ibtnSearchLoactorAR));
            ibtnSearchLoactorWait.click();
        }

        WebElement ReportInsideNameLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportInsideNameLoactorAR));

        String ReportInsideName = browserQA.findElement(ReportInsideNameLoactorAR).getText();
        String ReportInsideNameString = "الأمن والسلامة-نسب التقييم على مستوى الوزارة";

        Assert.assertEquals(ReportInsideName, ReportInsideNameString, "لتقرير المطلوب غير متوفر حاليا");

        browserQA.findElement(ibtnBackLoactorAR).click();

    }

    private By TheReportNameLocatorSWO = By.linkText("عدد الطلاب مع ملكية مبنى المدرسة");
    private By GenderLocatorSWO = By.id("select2-ctl00_PlaceHolderMain_ddlLearningGender-container");
    private By FemalelocatorSWO = By.xpath("/html/body/span/span/span[1]/input");
    private By ddlDistrictLocatorSWO = By.id("select2-ctl00_PlaceHolderMain_ddlDistrict-container");
    private By ddlDistrictSearchLocatorSWO = By.xpath("/html/body/span/span/span[1]/input");
    private By ddlSupervisionCenteLocatorSWO = By.id("select2-ctl00_PlaceHolderMain_ddlSupervisionCenter-container");
    private By ddlSupervisionCenteSearchLocatorSWO = By.xpath("/html/body/span/span/span[1]/input");
    private By ibtnSearchLocatorSWO = By.id("ctl00_PlaceHolderMain_ibtnSearch");

    ///عدد الطلاب مع ملكية مبنى المدرسة
    @Test
    public void studentsWithOwnershipOfTheSchoolBuilding() throws InterruptedException {


        WebElement ReportsMainMenuLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportsMainMenuLocator));
        ReportsMainMenuLocatorWait.click();

        browserQA.findElement(SerachLoactor).click();


        WebElement NumberOfStudendLocatorwait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(TheReportNameLocatorSWO));
        NumberOfStudendLocatorwait.click();
        Thread.sleep(1000);
        WebElement GenderLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(GenderLocatorSWO));
        GenderLocatorWait.click();
        browserQA.findElement(FemalelocatorSWO).sendKeys("بنين", Keys.ENTER);

        Thread.sleep(1000);

        WebElement ddlDistrictLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ddlDistrictLocatorSWO));
        ddlDistrictLocatorWait.click();

        browserQA.findElement(ddlDistrictSearchLocatorSWO).sendKeys("ادارة تعليم الحد الغربي(بنين)", Keys.ENTER);
        Thread.sleep(2000);

        WebElement ddlSupervisionCenteLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ddlSupervisionCenteLocatorSWO));
        ddlSupervisionCenteLocatorWait.click();

        browserQA.findElement(ddlSupervisionCenteSearchLocatorSWO).sendKeys("مكتب الخالدية الشمالية", Keys.ENTER);

        try {
            WebElement ibtnSearchLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ibtnSearchLocatorSWO));
            ibtnSearchLocatorWait.click();
        } catch (Exception e) {
            WebElement ibtnSearchLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ibtnSearchLocatorSWO));
            ibtnSearchLocatorWait.click();
        }


        By ReportTitleInsidLoactor = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[5]/div/span/div/table/tbody/tr[4]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[7]/td[3]/table/tbody/tr/td/div/div/span");
        WebElement ReportTitleInsidLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportTitleInsidLoactor));
        String ReportTitleInsidLoactorElement = browserQA.findElement(ReportTitleInsidLoactor).getText();
        String ReportTitleInsidString = " عدد الطلاب مع ملكية مبنى المدرسة";

        Assert.assertEquals(ReportTitleInsidLoactorElement, ReportTitleInsidString, "لايمكن عرض التقرير المطلوب");

    }


    private By TheReportNameLocatorUDS = By.linkText("بيانات المستخدمين بالمدارس");
    private By drop_down_sex_LocatorUDS = By.id("select2-ctl00_PlaceHolderMain_ddlGender-container");
    private By txt_field_1_LocatorUDS = By.xpath("/html/body/span/span/span[1]/input");
    private By drop_down_managementt_LocatorUDS = By.id("select2-ctl00_PlaceHolderMain_ddlDistrict-container");
    private By txt_field_2_LocatorUDS = By.xpath("/html/body/span/span/span[1]/input");
    private By btn_search_LocatorUDS = By.id("ctl00_PlaceHolderMain_ibtnSearch");
    private By info_schools_LocatorUDS = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[5]/span/div/table/tbody/tr[4]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[6]/td[3]/table/tbody/tr/td/div/div[1]/span");
    private By btn_back_LocatorUDS = By.id("ctl00_PlaceHolderMain_ibtnBack");

    //
//بيانات المستخدمين بالمدارس
    @Test
    public void userDataInTheSchools() throws InterruptedException {

        Thread.sleep(1000);

        WebElement ReportsMainMenuLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportsMainMenuLocator));
        ReportsMainMenuLocatorWait.click();

        browserQA.findElement(SerachLoactor).click();
        WebElement reports_LocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(TheReportNameLocatorUDS));
        reports_LocatorWait.click();

        waitQA.until(ExpectedConditions.visibilityOfElementLocated(drop_down_sex_LocatorUDS)).click();
        waitQA.until(ExpectedConditions.visibilityOfElementLocated(txt_field_1_LocatorUDS)).sendKeys("بنين", Keys.ENTER);
        Thread.sleep(100);
        waitQA.until(ExpectedConditions.visibilityOfElementLocated(drop_down_managementt_LocatorUDS)).click();
        waitQA.until(ExpectedConditions.visibilityOfElementLocated(txt_field_2_LocatorUDS)).sendKeys("الحد الغربي", Keys.ENTER);
        Thread.sleep(100);
        waitQA.until(ExpectedConditions.visibilityOfElementLocated(btn_search_LocatorUDS)).click();
        Thread.sleep(1000);
        waitQA.until(ExpectedConditions.visibilityOfElementLocated(info_schools_LocatorUDS));
        String s = browserQA.findElement(info_schools_LocatorUDS).getText();
        String Info_schools_2 = "بيانات المستخدمين بالمدارس";
        Assert.assertEquals(s, Info_schools_2, "البيانات غير صحيحة");
        waitQA.until(ExpectedConditions.visibilityOfElementLocated(btn_back_LocatorUDS)).click();

    }

}
