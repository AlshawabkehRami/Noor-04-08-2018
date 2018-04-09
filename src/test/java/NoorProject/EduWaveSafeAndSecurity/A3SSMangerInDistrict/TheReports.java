/*
 * Created By  Rami AlShawabkeh  4/9/18 5:22 PM
 */

/*
 * Created By  Rami AlShawabkeh  4/9/18 4:16 PM
 */

package NoorProject.EduWaveSafeAndSecurity.A3SSMangerInDistrict;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static NoorProject.Other.NoorLogin.browserQA;
import static NoorProject.Other.NoorLogin.waitQA;

public class TheReports {

    private By SwitchProfileLocator = By.id("ctl00_oHeader_divSwitchUser");
    private By UserNameLabelLocator = By.partialLinkText("مدير الأمن والسلامة في إدارة التعليم");
    private By ReportsMainMenuLocator = By.id("divMenuItem_304");
    private By SerachLinkReportLocator = By.id("lisearch_list");
    private By SerachTextReportLocator = By.id("myInput");
    private By SearchButtonLOcator = By.id("ctl00_PlaceHolderMain_ibtnSearch");
    private By DDLSearchSendOptionTxtLoactor = By.xpath("/html/body/span/span/span[1]/input");


    @Test
    public void LoginTotheUserAndSwitchDistrict() {
        WebElement SwitchProfileLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SwitchProfileLocator));
        SwitchProfileLocatorWait.click();
        WebElement UserNameLabelLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(UserNameLabelLocator));
        UserNameLabelLocatorWait.click();
    }

    //بيانات المباني
    private By ReportNameLoactorBI = By.linkText("بيانات المباني");
    @Test
    public void buildingInformation() {

        WebElement ReportsMainMenuLocatorBIWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportsMainMenuLocator));
        ReportsMainMenuLocatorBIWait.click();

        WebElement SerachReportLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachLinkReportLocator));
        SerachReportLocatorWait.click();

        WebElement SerachTextReportLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachTextReportLocator));
        SerachTextReportLocatorWait.sendKeys("بيانات المباني");
        browserQA.findElement(ReportNameLoactorBI).click();

        WebElement SearchButtonLOcatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchButtonLOcator));
        SearchButtonLOcatorWait.click();

        By NameOfTheReportLocator = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[4]/div/span/div/table/tbody/tr[4]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/table/tbody/tr[10]/td[2]/table/tbody/tr/td/div");
        WebElement NameOfTheReportLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(NameOfTheReportLocator));
        String NameOfTheReportString = browserQA.findElement(NameOfTheReportLocator).getText();
        String NameOfThePageLString = "بيانات المباني";
        Assert.assertEquals(NameOfTheReportString , NameOfThePageLString , "التقرير المطلوب غير متوفر");
    }


    private By ReportLinkLocatorDSTC = By.linkText("توزيع الطلاب على الفصول");
    private By ddlStudylevelLocatorDSTC = By.id("select2-ctl00_PlaceHolderMain_ddlStudylevel-container");
    private By ddlSchoolCategorizationLocatorDSTC = By.id("select2-ctl00_PlaceHolderMain_ddlSchoolCategorization-container");
    //توزيع الطلاب على الفصول
    @Test
    public void DSTC() {

        WebElement ReportsMainMenuLocatorBIWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportsMainMenuLocator));
        ReportsMainMenuLocatorBIWait.click();

        WebElement SerachReportLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachLinkReportLocator));
        SerachReportLocatorWait.click();

        WebElement SerachTextReportLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachTextReportLocator));
        SerachTextReportLocatorWait.sendKeys("توزيع الطلاب على الفصول");
        browserQA.findElement(ReportLinkLocatorDSTC).click();


        WebElement ddlStudylevelLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ddlStudylevelLocatorDSTC));
        ddlStudylevelLocatorWait.click();
        browserQA.findElement(DDLSearchSendOptionTxtLoactor).sendKeys("المرحلة الثانوية" , Keys.ENTER);

        try {
            WebElement ddlSchoolCategorizationLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ddlSchoolCategorizationLocatorDSTC));
            ddlSchoolCategorizationLocatorWait.click();
            browserQA.findElement(DDLSearchSendOptionTxtLoactor).sendKeys("حكومي" , Keys.ENTER);
        } catch (Exception e) {
            WebElement ddlSchoolCategorizationLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ddlSchoolCategorizationLocatorDSTC));
            ddlSchoolCategorizationLocatorWait.click();
            browserQA.findElement(DDLSearchSendOptionTxtLoactor).sendKeys("حكومي" , Keys.ENTER);
        }

        try {
            WebElement ibtnSearchLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchButtonLOcator));
            ibtnSearchLocatorWait.click();
        } catch (Exception e) {
            WebElement ibtnSearchLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchButtonLOcator));
            ibtnSearchLocatorWait.click();
        }


        By ReportTitleLocator = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[5]/div/span/div/table/tbody/tr[4]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[3]/table/tbody/tr/td/table/tbody/tr[11]/td[3]/table/tbody/tr/td/div");
        WebElement ReportTitleLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportTitleLocator));
        String ReportTitleString = browserQA.findElement(ReportTitleLocator).getText();
        String ReportNameString = "توزيع الطلاب على الفصول مكتب";
        Assert.assertEquals(ReportTitleString , ReportNameString , "التقرير المطلوب غير متوفر");
    }


    private By TheReportNameLocatorSC = By.linkText("إحصائي عن تقييم الأمن والسلامة - تجميعي");
    private By drop_down_l_LocatorSC = By.id("select2-ctl00_PlaceHolderMain_ddlSupervisionCenter-container");
    private By drop_down_2_LocatorSC = By.id("select2-ctl00_PlaceHolderMain_ddlFormName-container");

    //
//إحصائي عن تقييم الأمن والسلامة - تجميعي
    @Test
    public void statisticalAssessmentOfSafetyAndSecurityCompilationReport() throws InterruptedException {


        WebElement reports_menu_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportsMainMenuLocator));
        reports_menu_Locator_wait.click();
        WebElement search_logo_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachLinkReportLocator));
        search_logo_Locator_wait.click();
        WebElement search_field_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachTextReportLocator));
        search_field_Locator_wait.sendKeys("إحصائي عن تقييم الأمن والسلامة - تجميعي");
        WebElement statistical_assessment_of_safety_and_security_aggregate_link_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(TheReportNameLocatorSC));
        statistical_assessment_of_safety_and_security_aggregate_link_wait.click();
        WebElement drop_down_1_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(drop_down_l_LocatorSC));
        drop_down_1_Locator_wait.click();
        WebElement txt_field_1_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DDLSearchSendOptionTxtLoactor));
        txt_field_1_Locator_wait.sendKeys("مكتب الخالدية الشمالية" , Keys.ENTER);
        Thread.sleep(300);
        WebElement drop_down_2_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(drop_down_2_LocatorSC));
        drop_down_2_Locator_wait.click();
        WebElement txt_field_2_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DDLSearchSendOptionTxtLoactor));
        txt_field_2_Locator_wait.sendKeys("Selenium Form Dont Delete" , Keys.ENTER);

        try {
            WebElement btn_search_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchButtonLOcator));
            btn_search_Locator_wait.click();
        } catch (Exception e) {
            WebElement btn_search_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchButtonLOcator));
            btn_search_Locator_wait.click();
        }
        String expected_result = "إحصائي عن تقييم الأمن والسلامة - تجميعي";
        By actual_result = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[5]/div/span/div/table/tbody/tr[4]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[9]/td[3]/table/tbody/tr/td");
        WebElement actual_resultt = waitQA.until(ExpectedConditions.visibilityOfElementLocated(actual_result));
        String actual__result = actual_resultt.getText();
        System.out.println(actual_resultt);
        Assert.assertEquals(actual__result , expected_result , "التقرير المطلوب غير متوفر");

    }

    private By TheReportNameLocatorSD = By.linkText("إحصائي عن تقييم الأمن والسلامة - تفصيلي");
    private By SupervisionCenterLocatorSD = By.xpath("//*[@id=\"select2-ctl00_PlaceHolderMain_ddlSupervisionCenter-container\"]");
    private By FormNameLocatorSD = By.id("select2-ctl00_PlaceHolderMain_ddlFormName-container");

    //
//إحصائي عن تقييم الأمن والسلامة - تفصيلي
    @Test
    public void statisticalAssessmentOfSafetyAndSecurityDetailedReport() throws InterruptedException {

        WebElement ReportsMenuLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportsMainMenuLocator));
        ReportsMenuLocatorWait.click();

        WebElement SearchLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachLinkReportLocator));
        SearchLinkLocatorWait.click();

        WebElement SearchFieldLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachTextReportLocator));
        SearchFieldLocatorWait.sendKeys("إحصائي عن تقييم الأمن والسلامة - تفصيلي");

        WebElement TheReportLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(TheReportNameLocatorSD));
        TheReportLinkLocatorWait.click();

        WebElement SupervisionCenterLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SupervisionCenterLocatorSD));
        SupervisionCenterLocatorWait.click();

        WebElement SearchSupervisionCenterLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DDLSearchSendOptionTxtLoactor));
        SearchSupervisionCenterLocatorWait.sendKeys("مكتب الخالدية الشمالية" , Keys.ENTER);

        Thread.sleep(300);

        WebElement FormNameLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(FormNameLocatorSD));
        FormNameLocatorWait.click();

        WebElement FormNameSearchLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DDLSearchSendOptionTxtLoactor));
        FormNameSearchLocatorWait.sendKeys("Selenium Form Dont Delete" , Keys.ENTER);

        Thread.sleep(300);

        try {
            WebElement BTNSearchLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchButtonLOcator));
            BTNSearchLocatorWait.click();
        } catch (Exception e) {
            WebElement BTNSearchLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchButtonLOcator));
            BTNSearchLocatorWait.click();
        }


        String expected_result = "إحصائي عن تقييم الأمن والسلامة - تفصيلي";
        By actual_reuslt = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[5]/div/span/div/table/tbody/tr[5]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[8]/td[3]/table/tbody/tr/td/div/div/span");
        WebElement actual__result = waitQA.until(ExpectedConditions.visibilityOfElementLocated(actual_reuslt));
        String actual___reuslt = actual__result.getText();
        Assert.assertEquals(actual___reuslt , expected_result , "التقرير المطلوب غير متوفر");

    }

    private By TheReportNameLocatorNSSB = By.linkText("عدد الطلاب مع ملكية مبنى المدرسة");
    private By Drop_down_list_LocatorNSSB = By.id("select2-ctl00_PlaceHolderMain_ddlSupervisionCenter-container");

    //
//عدد الطلاب مع ملكية مبنى المدرسة
    @Test
    public void numberOfStudentsWhoOwnTheSchoolBuildingReport() {

        WebElement reports_menu_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportsMainMenuLocator));
        reports_menu_Locator_wait.click();
        WebElement search_logo_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachLinkReportLocator));
        search_logo_Locator_wait.click();
        WebElement search_field_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachTextReportLocator));
        search_field_Locator_wait.sendKeys("عدد الطلاب مع ملكية مبنى المدرسة");
        WebElement NumberOfStudentsWhoOwnTheSchoolBuilding_link_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(TheReportNameLocatorNSSB));
        NumberOfStudentsWhoOwnTheSchoolBuilding_link_wait.click();
        WebElement drop_down_list_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(Drop_down_list_LocatorNSSB));
        drop_down_list_Locator_wait.click();
        WebElement txt_field_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DDLSearchSendOptionTxtLoactor));
        txt_field_wait.sendKeys("مكتب الخالدية الشمالية" , Keys.ENTER);

        try {
            WebElement btn_search_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchButtonLOcator));
            btn_search_wait.click();
        } catch (Exception e) {
            WebElement btn_search_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchButtonLOcator));
            btn_search_wait.click();
        }

        String expected_result = " عدد الطلاب مع ملكية مبنى المدرسة";
        By actual_result = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[5]/div/span/div/table/tbody/tr[4]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[7]/td[3]/table/tbody/tr/td/div/div/span");
        WebElement actual__result = waitQA.until(ExpectedConditions.visibilityOfElementLocated(actual_result));
        String actual___result = actual__result.getText();
        Assert.assertEquals(expected_result , actual___result , "التقرير المطلوب غير متوفر");
    }

    private By TheReportNameLocatorAI = By.linkText("المدارس التي قامت بتعبئة الاستمارة ولم يتم اعتمادها من مدير المدرسة");
    private By drop_down_list_LocatorAI = By.id("select2-ctl00_PlaceHolderMain_ddlFormName-container");

    //
//المدارس التي قامت بتعبئة الاستمارة ولم يتم اعتمادها من قائد المدرسة
    @Test
    public void SchoolsThatHaveCompletedTheFormAndHaveNotBeenApprovedByTheSchoolLeaderReport() throws InterruptedException {

        WebElement reports_menu_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportsMainMenuLocator));
        reports_menu_Locator_wait.click();
        WebElement search_logo_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachLinkReportLocator));
        search_logo_Locator_wait.click();
        WebElement search_field_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachTextReportLocator));
        search_field_Locator_wait.sendKeys("المدارس التي قامت بتعبئة الاستمارة ولم يتم اعتمادها");
        WebElement SchoolsThatHaveCompletedTheFormAndHaveNotBeenApprovedByTheSchoolLeader_link_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(TheReportNameLocatorAI));
        SchoolsThatHaveCompletedTheFormAndHaveNotBeenApprovedByTheSchoolLeader_link_Locator_wait.click();
        WebElement drop_down_list_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(drop_down_list_LocatorAI));
        drop_down_list_Locator_wait.click();
        WebElement txt_field_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DDLSearchSendOptionTxtLoactor));
        txt_field_Locator_wait.sendKeys("Form12" , Keys.ENTER);
        Thread.sleep(300);
        WebElement btn_search_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchButtonLOcator));
        btn_search_Locator_wait.click();
        String expected_result = "   المدارس التي قامت بتعبئة الاستمارة ولم يتم اعتمادها من قائد المدرسة   ";
        By acutal_result = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[5]/div/span/div/table/tbody/tr[4]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[5]/td[3]/table/tbody/tr/td/div/div/span");
        WebElement actual__reuslt = waitQA.until(ExpectedConditions.visibilityOfElementLocated(acutal_result));
        String actual___result = actual__reuslt.getText();
        System.out.println(actual___result);
        Assert.assertEquals(actual___result , expected_result , "التقرير المطلوب غير متوفر");


    }


    private By TheReportNameLocatorSHCF = By.linkText("المدارس التي لم تقم بتعبئة الاستمارة");
    private By drop_down_list_LocatorSHCF = By.id("select2-ctl00_PlaceHolderMain_ddlFormName-container");


    @Test
    public void schoolsThatHaveNotCompletedTheFormReport() throws InterruptedException { //المدارس التي لم تقم بتعبئة الاستمارة

        WebElement reports_menu_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportsMainMenuLocator));
        reports_menu_Locator_wait.click();
        WebElement search_logo_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachLinkReportLocator));
        search_logo_Locator_wait.click();
        WebElement search_field_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachTextReportLocator));
        search_field_Locator_wait.sendKeys("المدارس التي لم تقم بتعبئة الاستمارة");
        WebElement SchoolsThatHaveNotCompletedTheForm_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(TheReportNameLocatorSHCF));
        SchoolsThatHaveNotCompletedTheForm_Locator_wait.click();
        WebElement drop_down_list_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(drop_down_list_LocatorSHCF));
        drop_down_list_Locator_wait.click();
        WebElement txt_field_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DDLSearchSendOptionTxtLoactor));
        txt_field_Locator_wait.sendKeys("Selenium Form Dont Delete" , Keys.ENTER);
        Thread.sleep(300);
        WebElement btn_search_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchButtonLOcator));
        btn_search_Locator_wait.click();
        String expected_result = "المدارس التي لم تقم بتعبئة الاستمارة";
        By actual_result = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[5]/div/span/div/table/tbody/tr[4]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[4]/td[3]/table/tbody/tr/td/div/div/span");
        WebElement actual__result = waitQA.until(ExpectedConditions.visibilityOfElementLocated(actual_result));
        String actual___result = actual__result.getText();
        Assert.assertEquals(actual___result , expected_result , "التقرير المطلوب غير متوفر");

    }

    private By school_data_LocatorSDD = By.linkText("بيانات المدرسة");
    private By drop_down_list_LocatorSDD = By.id("select2-ctl00_PlaceHolderMain_ddlSupervisionCenter-container");

    //
//بيانات المدرسة
    @Test
    public void schoolDataReport() throws InterruptedException {

        WebElement reports_menu_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportsMainMenuLocator));
        reports_menu_Locator_wait.click();
        WebElement search_logo_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachLinkReportLocator));
        search_logo_Locator_wait.click();
        WebElement search_field_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachTextReportLocator));
        search_field_Locator_wait.sendKeys("بيانات المدرسة");
        WebElement school_data_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(school_data_LocatorSDD));
        school_data_Locator_wait.click();
        WebElement drop_down_list_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(drop_down_list_LocatorSDD));
        drop_down_list_Locator_wait.click();
        WebElement txt_field_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DDLSearchSendOptionTxtLoactor));
        txt_field_Locator_wait.sendKeys("مكتب الخالدية الشمالية" , Keys.ENTER);
        Thread.sleep(300);
        WebElement btn_search_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchButtonLOcator));
        btn_search_Locator_wait.click();
        String expected_result = "بيانات المدرسة";
        By actual_result = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[4]/div/span/div/table/tbody/tr[5]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[9]/td[3]/table/tbody/tr/td/div/div/span");
        WebElement actual_result_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(actual_result));
        String actual__result = actual_result_wait.getText();
        Assert.assertEquals(actual__result , expected_result , "التقرير المطلوب غير متوفر");

    }


    private By TheReportNameLocatorSDES = By.linkText("بيانات المدرسة مع المراحل التعليمية");
    private By OfficeNameLOcaterSDES = By.id("select2-ctl00_PlaceHolderMain_ddlSupervisionCenter-container");


    //
//بيانات المدرسة مع المراحل التعليمية
    @Test
    public void schoolDataWithEducationalStagesReport() throws InterruptedException {

        WebElement reports_menu_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportsMainMenuLocator));
        reports_menu_Locator_wait.click();
        WebElement search_logo_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachLinkReportLocator));
        search_logo_Locator_wait.click();

        WebElement SerachTXTLocatrWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachTextReportLocator));
        SerachTXTLocatrWait.sendKeys("بيانات المدرسة مع المراحل التعليمية");
        WebElement ReportLOcatrWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(TheReportNameLocatorSDES));
        ReportLOcatrWait.click();
        WebElement OfficeNameLOcaterWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(OfficeNameLOcaterSDES));
        OfficeNameLOcaterWait.click();
        browserQA.findElement(DDLSearchSendOptionTxtLoactor).sendKeys("مكتب الخالدية الشمالية" , Keys.ENTER);

        Thread.sleep(1000);
        WebElement SearchBTNLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchButtonLOcator));
        SearchBTNLocatorWait.click();


    }


    private By ReportLinkLocatorDSOIS = By.linkText("بيانات مسؤولي الامن والسلامة في المدارس");


    //
//بيانات مسؤولي الامن والسلامة في المدارس
    @Test
    public void dataSecurityAndSafetyOfficialsInSchoolsReport() {


        WebElement reports_menu_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportsMainMenuLocator));
        reports_menu_Locator_wait.click();

        WebElement SerachReportLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachLinkReportLocator));
        SerachReportLocatorWait.click();

        WebElement SerachTextReportLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachTextReportLocator));
        SerachTextReportLocatorWait.sendKeys("بيانات مسؤولي الامن");

        browserQA.findElement(ReportLinkLocatorDSOIS).click();
        WebElement SearchButtonLOcatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchButtonLOcator));
        SearchButtonLOcatorWait.click();

        By ReportTitleLocator = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[5]/div/span/div/table/tbody/tr[4]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[6]/td[3]/table/tbody/tr/td/div");
        WebElement ReportTitleLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportTitleLocator));
        String ReportTitle = browserQA.findElement(ReportTitleLocator).getText();
        String ReportTitleName = "بيانات مسؤولي الامن والسلامة في المدارس";
        Assert.assertEquals(ReportTitle , ReportTitleName , "التقرير المطلوب غير متوفر");
    }

    private By ReportLinkLocatorSASAR = By.linkText("الأمن والسلامة - نسبة التقييم");
    private By DDLFormNameLocatorSASAR = By.id("select2-ctl00_PlaceHolderMain_ddlFormName-container");


    //
//الأمن والسلامة - نسبة التقييم
    @Test
    public void assessmentRate() {


        browserQA.findElement(ReportsMainMenuLocator).click();
        WebElement SerachReportLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachLinkReportLocator));
        SerachReportLocatorWait.click();

        WebElement SerachTextReportLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachTextReportLocator));
        SerachTextReportLocatorWait.sendKeys("نسبة التقييم");

        browserQA.findElement(ReportLinkLocatorSASAR).click();
        WebElement DDLFormNameLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DDLFormNameLocatorSASAR));
        DDLFormNameLocatorWait.click();
        browserQA.findElement(DDLSearchSendOptionTxtLoactor).sendKeys("Selenium Form Dont Delete" , Keys.ENTER);

        try {
            WebElement SearchButtonLOcatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchButtonLOcator));
            SearchButtonLOcatorWait.click();
        } catch (Exception e) {
            WebElement SearchButtonLOcatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchButtonLOcator));
            SearchButtonLOcatorWait.click();
        }

        By ReportTitleLoactr = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div/div[7]/div/span/div/table/tbody/tr[4]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/table/tbody/tr[7]/td[3]/table/tbody/tr/td/div/div/span");
        WebElement ReportTitleLoactrWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportTitleLoactr));
        String ReportTilte = browserQA.findElement(ReportTitleLoactr).getText();
        String NameOfTheReport = "الأمن والسلامة-نسب التقييم على مستوى الإدارة";

        Assert.assertEquals(ReportTilte , NameOfTheReport , "التقرير المطلوب غير متوفر");
    }


    private By ReportLinkLocatorIRR = By.linkText("الأمن والسلامة - نسبة الإدخال");
    private By DDlFormNameLocatorIRR = By.id("select2-ctl00_PlaceHolderMain_ddlFormName-container");


    //
//الأمن والسلامة - نسبة الإدخال
    @Test
    public void inputRatio() throws InterruptedException {


        WebElement ReportsMainMenuLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportsMainMenuLocator));
        ReportsMainMenuLocatorWait.click();

        WebElement SerachReportLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachLinkReportLocator));
        SerachReportLocatorWait.click();

        WebElement SerachTextReportLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachTextReportLocator));
        SerachTextReportLocatorWait.sendKeys("نسبة الإدخال");

        WebElement ReportLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportLinkLocatorIRR));
        ReportLinkLocatorWait.click();

        WebElement DDlFormNameLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DDlFormNameLocatorIRR));
        DDlFormNameLocatorWait.click();

        WebElement DDlFormNameSearchLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DDLSearchSendOptionTxtLoactor));
        DDlFormNameSearchLocatorWait.sendKeys("Selenium Form Dont Delete" , Keys.ENTER);

        Thread.sleep(1000);
        try {
            WebElement SearchButtonLOcatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchButtonLOcator));
            SearchButtonLOcatorWait.click();
        } catch (Exception e) {

            WebElement SearchButtonLOcatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchButtonLOcator));
            SearchButtonLOcatorWait.click();
        }


        By ReportTitleLoactor = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div/div[7]/div/span/div/table/tbody/tr[4]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/table/tbody/tr[8]/td[3]/table/tbody/tr/td/div/div/span");
        WebElement ReportTitleLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportTitleLoactor));
        String ReportName = browserQA.findElement(ReportTitleLoactor).getText();
        String NameOfTheReport = "الأمن والسلامة-نسب الإدخال على مستوى الإدارة";

        Assert.assertEquals(ReportName , NameOfTheReport , "التقرير المطلوب غير متوفر");

    }

    private By TheReportNameLocatorUDITS = By.linkText("بيانات المستخدمين بالمدارس");

    //بيانات المستخدمين بالمدارس
    @Test
    public void userDataInSchoolsReport() {

        WebElement reports_menu_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportsMainMenuLocator));
        reports_menu_Locator_wait.click();
        WebElement search_logo_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachLinkReportLocator));
        search_logo_Locator_wait.click();
        WebElement search_field_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachTextReportLocator));
        search_field_Locator_wait.sendKeys("بيانات المستخدمين بالمدارس");
        WebElement UserDataInSchools_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(TheReportNameLocatorUDITS));
        UserDataInSchools_Locator_wait.click();
        WebElement btn_search_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchButtonLOcator));
        btn_search_Locator_wait.click();
        String expected_result = "بيانات المستخدمين بالمدارس";
        By actual_result = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[4]/span/div/table/tbody/tr[4]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[6]/td[3]/table/tbody/tr/td/div/div[1]/span");
        WebElement actual_result_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(actual_result));
        String actual__result = actual_result_wait.getText();
        Assert.assertEquals(actual__result , expected_result , "البيانات غير صحيحة");
    }
}
