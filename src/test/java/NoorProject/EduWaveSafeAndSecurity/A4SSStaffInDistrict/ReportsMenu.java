/*
 * Created By  Rami AlShawabkeh  4/10/18 11:25 AM
 */

package NoorProject.EduWaveSafeAndSecurity.A4SSStaffInDistrict;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static NoorProject.Other.NoorLogin.browserQA;
import static NoorProject.Other.NoorLogin.waitQA;

public class ReportsMenu {


    private By SwitchProfileLocator = By.id("ctl00_oHeader_divSwitchUser");
    private By UserNameLabelLocator = By.partialLinkText("موظف بإدارة الأمن والسلامة بإدارة التعليم");
    private By ReportsMainMenuLocator = By.id("divMenuItem_304");
    private By SerachLinkReportLocator = By.id("lisearch_list");
    private By SerachTextReportLocator = By.id("myInput");
    private By SearchButtonLocator = By.id("ctl00_PlaceHolderMain_ibtnSearch");
    private By SearchDDLOptionLocator = By.xpath("/html/body/span/span/span[1]/input");



    @Test

    public void SwitchProfile(){

        WebElement SwitchProfileLocatorWait=waitQA.until(ExpectedConditions.visibilityOfElementLocated(SwitchProfileLocator));
        SwitchProfileLocatorWait.click();
        WebElement UserNameLabelLocatorWait=waitQA.until(ExpectedConditions.visibilityOfElementLocated(UserNameLabelLocator));
        UserNameLabelLocatorWait.click();
    }

    private By ReportLinkLocator = By.linkText("بيانات المباني");
    //بيانات المباني
    @Test
    public void buildingInformation() {

        WebElement ReportsMainMenuLocatorWait=waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportsMainMenuLocator));
        ReportsMainMenuLocatorWait.click();

        WebElement SerachReportLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachLinkReportLocator));
        SerachReportLocatorWait.click();

        WebElement SerachTextReportLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachTextReportLocator));

        SerachTextReportLocatorWait.sendKeys("بيانات المباني");
        browserQA.findElement(ReportLinkLocator).click();
        WebElement SearchButtonLOcatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchButtonLocator));
        SearchButtonLOcatorWait.click();

        By NameOfTheReportLocator = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[4]/div/span/div/table/tbody/tr[4]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/table/tbody/tr[10]/td[2]/table/tbody/tr/td/div");
        WebElement NameOfTheReportLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(NameOfTheReportLocator));
        String NameOfTheReportString = browserQA.findElement(NameOfTheReportLocator).getText();
        String NameOfThePageLString = "بيانات المباني";
        Assert.assertEquals(NameOfTheReportString , NameOfThePageLString , "التقرير المطلوب غير متوفر");
    }


    private By ReportNameLocator1 = By.linkText("بيانات المدرسة مع المراحل التعليمية");
    private By OfficeNameLOcater1 = By.id("select2-ctl00_PlaceHolderMain_ddlSupervisionCenter-container");
    private By BackBTN1 = By.id("ctl00_PlaceHolderMain_ibtnBack");


    //
//بيانات المدرسة مع المراحل التعليمية
    @Test
    public void schoolDataWithEducationalStages() {

        WebElement ReportsMainMenuLocatorWait=waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportsMainMenuLocator));
        ReportsMainMenuLocatorWait.click();

        WebElement SerachReportLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachLinkReportLocator));
        SerachReportLocatorWait.click();

        WebElement SerachTextReportLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachTextReportLocator));
        SerachTextReportLocatorWait.sendKeys("بيانات المدرسة مع المراحل التعليمية");

        WebElement ReportLOcatrWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportNameLocator1));
        ReportLOcatrWait.click();

        WebElement OfficeNameLOcaterWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(OfficeNameLOcater1));
        OfficeNameLOcaterWait.click();
        browserQA.findElement(SearchDDLOptionLocator).sendKeys("مكتب الخالدية الشمالية" , Keys.ENTER);
        try {
            WebElement SearchBTNLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchButtonLocator));
            SearchBTNLocatorWait.click();
        } catch (Exception e) {
            WebElement SearchBTNLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchButtonLocator));
            SearchBTNLocatorWait.click();
        }


        WebElement BackBTNWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(BackBTN1));
        BackBTNWait.click();

        System.out.println(browserQA.findElement(ReportNameLocator1).getText());
        Assert.assertEquals(browserQA.findElement(ReportNameLocator1).getText() , "بيانات المدرسة مع المراحل التعليمية" , "تم الروجع الى صفحة خاطئة");

    }

    private By TheReportNameLoactor2 = By.linkText("المدارس التي قامت بتعبئة الاستمارة ولم يتم اعتمادها من مدير المدرسة");
    private By drop_down_list_Locator2 = By.id("select2-ctl00_PlaceHolderMain_ddlFormName-container");

    //
//المدارس التي قامت بتعبئة الاستمارة ولم يتم اعتمادها من قائد المدرسة
    @Test
    public void schoolsThatHaveCompletedTheFormAndHaveNotBeenApprovedByTheSchoolLeader() throws InterruptedException {

        WebElement ReportsMainMenuLocatorWait=waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportsMainMenuLocator));
        ReportsMainMenuLocatorWait.click();

        WebElement SerachReportLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachLinkReportLocator));
        SerachReportLocatorWait.click();


        WebElement SerachTextReportLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachTextReportLocator));

        SerachTextReportLocatorWait.sendKeys("المدارس التي قامت بتعبئة الاستمارة ولم يتم اعتمادها");
        WebElement SchoolsThatHaveCompletedTheFormAndHaveNotBeenApprovedByTheSchoolLeader_link_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(TheReportNameLoactor2));
        SchoolsThatHaveCompletedTheFormAndHaveNotBeenApprovedByTheSchoolLeader_link_Locator_wait.click();
        WebElement drop_down_list_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(drop_down_list_Locator2));
        drop_down_list_Locator_wait.click();
        WebElement txt_field_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchDDLOptionLocator));
        txt_field_Locator_wait.sendKeys("Form12" , Keys.ENTER);
        Thread.sleep(300);
        WebElement btn_search_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchButtonLocator));
        btn_search_Locator_wait.click();
        String expected_result = "   المدارس التي قامت بتعبئة الاستمارة ولم يتم اعتمادها من قائد المدرسة   ";
        By acutal_result = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[5]/div/span/div/table/tbody/tr[4]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[5]/td[3]/table/tbody/tr/td/div/div/span");
        WebElement actual__reuslt = waitQA.until(ExpectedConditions.visibilityOfElementLocated(acutal_result));
        String actual___result = actual__reuslt.getText();
        System.out.println(actual___result);
        Assert.assertEquals(actual___result , expected_result , "التقرير المطلوب غير متوفر");


    }
    private By TheReportNameLocator3 = By.linkText("المدارس التي لم تقم بتعبئة الاستمارة");
    private By drop_down_list_Locator3 = By.id("select2-ctl00_PlaceHolderMain_ddlFormName-container");

    //
//المدارس التي لم تقم بتعبئة الاستمارة
    @Test
    public void schoolsThatHaveNotCompletedTheForm() throws InterruptedException { //المدارس التي لم تقم بتعبئة الاستمارة

        WebElement ReportsMainMenuLocatorWait=waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportsMainMenuLocator));
        ReportsMainMenuLocatorWait.click();


        WebElement SerachReportLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachLinkReportLocator));
        SerachReportLocatorWait.click();


        WebElement SerachTextReportLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachTextReportLocator));

        SerachTextReportLocatorWait.sendKeys("المدارس التي لم تقم بتعبئة الاستمارة");
        WebElement SchoolsThatHaveNotCompletedTheForm_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(TheReportNameLocator3));
        SchoolsThatHaveNotCompletedTheForm_Locator_wait.click();
        WebElement drop_down_list_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(drop_down_list_Locator3));
        drop_down_list_Locator_wait.click();
        WebElement txt_field_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchDDLOptionLocator));
        txt_field_Locator_wait.sendKeys("Form12" , Keys.ENTER);
        Thread.sleep(300);
        WebElement btn_search_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchButtonLocator));
        btn_search_Locator_wait.click();
        String expected_result = "المدارس التي لم تقم بتعبئة الاستمارة";
        By actual_result = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[5]/div/span/div/table/tbody/tr[4]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[4]/td[3]/table/tbody/tr/td/div/div/span");
        WebElement actual__result = waitQA.until(ExpectedConditions.visibilityOfElementLocated(actual_result));
        String actual___result = actual__result.getText();
        Assert.assertEquals(actual___result , expected_result , "التقرير المطلوب غير متوفر");

    }

    private By ReportLinkLocator4 = By.linkText("معلومات بطاقات المدارس");
    private By ddlSchoolLocator4 = By.id("select2-ctl00_PlaceHolderMain_ddlSchool-container");


    //
//معلومات بطاقات المدارس
    @Test
    public void assessmentRate() throws InterruptedException {


        WebElement ReportsMainMenuLocatorWait=waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportsMainMenuLocator));
        ReportsMainMenuLocatorWait.click();

        WebElement SerachReportLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachLinkReportLocator));
        SerachReportLocatorWait.click();


        WebElement SerachTextReportLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachTextReportLocator));

        SerachTextReportLocatorWait.sendKeys("معلومات بطاقات");
        browserQA.findElement(ReportLinkLocator4).click();

        By ddlSupervisionCenterLocator = By.id("select2-ctl00_PlaceHolderMain_ddlSupervisionCenter-container");

        WebElement ddlSupervisionCenterLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ddlSupervisionCenterLocator));
        ddlSupervisionCenterLocatorWait.click();
        browserQA.findElement(SearchDDLOptionLocator).sendKeys("مكتب الخالدية الشمالية", Keys.ENTER);
        Thread.sleep(1000);
        try {
            WebElement ddlSchoolLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ddlSchoolLocator4));
            ddlSchoolLocatorWait.click();
        } catch (Exception e) {
            WebElement ddlSchoolLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ddlSchoolLocator4));
            ddlSchoolLocatorWait.click();
        }
        browserQA.findElement(SearchDDLOptionLocator).sendKeys("مدرسة سعيد بن المسيب التانوية", Keys.ENTER);

        try {
            WebElement BTNSearchLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchButtonLocator));

            BTNSearchLocatorWait.click();
        } catch (Exception e) {
            WebElement BTNSearchLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchButtonLocator));

            BTNSearchLocatorWait.click();
        }

    }


    private By ReportLinkLocator5 = By.linkText("الأمن والسلامة - نسبة التقييم");
    private By DDLFormNameLocator5 = By.id("select2-ctl00_PlaceHolderMain_ddlFormName-container");


    //
//الأمن والسلامة - نسبة التقييم
    @Test
    public void securityAndSafetyAssessmentRateReport() {


        WebElement ReportsMainMenuLocatorWait=waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportsMainMenuLocator));
        ReportsMainMenuLocatorWait.click();

        try {
            WebElement SerachReportLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachLinkReportLocator));
            SerachReportLocatorWait.click();

        } catch (Exception e) {
            WebElement SerachReportLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachLinkReportLocator));
            SerachReportLocatorWait.click();

        }

        WebElement SerachTextReportLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachTextReportLocator));

        SerachTextReportLocatorWait.sendKeys("نسبة التقييم");

        WebElement ReportLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportLinkLocator5));
        ReportLinkLocatorWait.click();

        WebElement DDLFormNameLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DDLFormNameLocator5));
        DDLFormNameLocatorWait.click();
        browserQA.findElement(SearchDDLOptionLocator).sendKeys("Selenium Form Dont Delete" , Keys.ENTER);
        try {
            WebElement SearchButtonLOcatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchButtonLocator));
            SearchButtonLOcatorWait.click();
        } catch (Exception e) {
            WebElement SearchButtonLOcatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchButtonLocator));
            SearchButtonLOcatorWait.click();
        }

        By ReportTitleLoactr = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div/div[7]/div/span/div/table/tbody/tr[4]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/table/tbody/tr[7]/td[3]/table/tbody/tr/td/div/div/span");
        WebElement ReportTitleLoactrWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportTitleLoactr));
        String ReportTilte = browserQA.findElement(ReportTitleLoactr).getText();
        String NameOfTheReport = "الأمن والسلامة-نسب التقييم على مستوى الإدارة";

        Assert.assertEquals(ReportTilte , NameOfTheReport , "التقرير المطلوب غير متوفر");
    }

    private By ReportLinkLocator6 = By.linkText("الأمن والسلامة - نسبة الإدخال");
    private By DDlFormNameLocator6 = By.id("select2-ctl00_PlaceHolderMain_ddlFormName-container");


    //
//الأمن والسلامة - نسبة الإدخال
    @Test
    public void inputRatio() {


        WebElement ReportsMainMenuLocatorWait=waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportsMainMenuLocator));
        ReportsMainMenuLocatorWait.click();

        WebElement SerachReportLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachLinkReportLocator));
        SerachReportLocatorWait.click();


        WebElement SerachTextReportLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachTextReportLocator));

        SerachTextReportLocatorWait.sendKeys("نسبة الإدخال");
        browserQA.findElement(ReportLinkLocator6).click();

        WebElement DDlFormNameLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DDlFormNameLocator6));
        DDlFormNameLocatorWait.click();
        browserQA.findElement(SearchDDLOptionLocator).sendKeys("Form12", Keys.ENTER);

        try {
            WebElement SearchButtonLOcatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchButtonLocator));
            SearchButtonLOcatorWait.click();
        } catch (Exception e) {

            WebElement SearchButtonLOcatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchButtonLocator));
            SearchButtonLOcatorWait.click();
        }
        By ReportTitleLoactor = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div/div[7]/div/span/div/table/tbody/tr[4]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/table/tbody/tr[8]/td[3]/table/tbody/tr/td/div/div/span");
        WebElement ReportTitleLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportTitleLoactor));
        String ReportName = browserQA.findElement(ReportTitleLoactor).getText();
        String NameOfTheReport = "الأمن والسلامة-نسب الإدخال على مستوى الإدارة";

        Assert.assertEquals(ReportName, NameOfTheReport, "التقرير المطلوب غير متوفر");

    }


    //
//بيانات المستخدمين بالمدارس
    private By TheReportNameLocator7 = By.linkText("بيانات المستخدمين بالمدارس");

    @Test
    public void UserDataInSchools() {

        WebElement ReportsMainMenuLocatorWait=waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportsMainMenuLocator));
        ReportsMainMenuLocatorWait.click();


        WebElement SerachReportLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachLinkReportLocator));
        SerachReportLocatorWait.click();


        WebElement SerachTextReportLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachTextReportLocator));

        SerachTextReportLocatorWait.sendKeys("بيانات المستخدمين بالمدارس");
        WebElement UserDataInSchools_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(TheReportNameLocator7));
        UserDataInSchools_Locator_wait.click();
        WebElement btn_search_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchButtonLocator));
        btn_search_Locator_wait.click();
        String expected_result = "بيانات المستخدمين بالمدارس";
        By actual_result = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[4]/span/div/table/tbody/tr[4]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[6]/td[3]/table/tbody/tr/td/div/div[1]/span");
        WebElement actual_result_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(actual_result));
        String actual__result = actual_result_wait.getText();
        Assert.assertEquals(actual__result , expected_result , "البيانات غير صحيحة");
    }

    private By TheReportNameLocator9 = By.linkText("عدد الطلاب مع ملكية مبنى المدرسة");
    private By Drop_down_list_Locator9 = By.id("select2-ctl00_PlaceHolderMain_ddlSupervisionCenter-container");

    //
//عدد الطلاب مع ملكية مبنى المدرسة
    @Test
    public void numberOfStudentsWhoOwnTheSchoolBuilding() {
        WebElement ReportsMainMenuLocatorWait=waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportsMainMenuLocator));
        ReportsMainMenuLocatorWait.click();


        WebElement SerachReportLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachLinkReportLocator));
        SerachReportLocatorWait.click();


        WebElement SerachTextReportLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachTextReportLocator));

        SerachTextReportLocatorWait.sendKeys("عدد الطلاب مع ملكية مبنى المدرسة");
        WebElement NumberOfStudentsWhoOwnTheSchoolBuilding_link_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(TheReportNameLocator9));
        NumberOfStudentsWhoOwnTheSchoolBuilding_link_wait.click();
        WebElement drop_down_list_Locator_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(Drop_down_list_Locator9));
        drop_down_list_Locator_wait.click();
        WebElement txt_field_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchDDLOptionLocator));
        txt_field_wait.sendKeys("مكتب الخالدية الشمالية" , Keys.ENTER);

        try {
            WebElement btn_search_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchButtonLocator));
            btn_search_wait.click();
        } catch (Exception e) {
            WebElement btn_search_wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchButtonLocator));
            btn_search_wait.click();
        }

        String expected_result = " عدد الطلاب مع ملكية مبنى المدرسة";
        By actual_result = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[5]/div/span/div/table/tbody/tr[4]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[7]/td[3]/table/tbody/tr/td/div/div/span");
        WebElement actual__result = waitQA.until(ExpectedConditions.visibilityOfElementLocated(actual_result));
        String actual___result = actual__result.getText();
        Assert.assertEquals(expected_result , actual___result , "التقرير المطلوب غير متوفر");
    }
}
