/*
 * Created By  Rami AlShawabkeh  4/10/18 12:15 PM
 */

package NoorProject.EduWaveSafeAndSecurity.A4SSStaffInDistrict;

import NoorProject.EduWaveSafeAndSecurity.A1GeneralDirectorOfSchoolSecurityAndSafety.Settings.VisitsTypes;
import NoorProject.Other.NoorLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static NoorProject.Other.NoorLogin.browserQA;
import static NoorProject.Other.NoorLogin.waitQA;

public class SchoolCards {

    private By SwitchProfileLocator = By.id("ctl00_oHeader_divSwitchUser");
    private By UserNameLabelLocator = By.partialLinkText("موظف بإدارة الأمن والسلامة بإدارة التعليم");

    @Test

    public void SwitchUser() {

        WebElement SwitchProfileLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SwitchProfileLocator));
        SwitchProfileLocatorWait.click();

        WebElement UserNameLabelLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(UserNameLabelLocator));
        UserNameLabelLocatorWait.click();
    }


    private By SchoolCardsMenuLocator = By.id("divMenuItem_5988");
    private By DDLSupervisionCenterLocator = By.id("select2-ctl00_PlaceHolderMain_ddlSupervisionCenter-container");
    private By DDLSupervisionCenterSearchLocator = By.xpath("/html/body/span/span/span[1]/input");
    private By BTNBSearchLoactor = By.id("ctl00_PlaceHolderMain_ibtnSearch");
    private By TDSchoolCardLOcator = By.id("ctl00_PlaceHolderMain_gvSchools_ctl02_tdSchoolCard");

    @Test
    public void addSchoolCards() throws InterruptedException {

        browserQA.close();

        NoorLogin Login = new NoorLogin();
        Login.GeneralDirectorOfSchoolSecurityAndSafety();

        VisitsTypes switchProfileUserAdmin = new VisitsTypes();
        switchProfileUserAdmin.switchProfile();

        VisitsTypes addVisitsTypes = new VisitsTypes();
        addVisitsTypes.addVisitsTypes();

        String CardDescrption = addVisitsTypes.RandomString;
        browserQA.close();

        NoorLogin LoginAgin = new NoorLogin();
        LoginAgin.StaffSAndSInDistrictLogin();
        SchoolCards SwitchProfile = new SchoolCards();
        SwitchProfile.SwitchUser();


        WebElement SchoolCardsMenuLOcatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SchoolCardsMenuLocator));
        SchoolCardsMenuLOcatorWait.click();

        WebElement ddlSupervisionCenterLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DDLSupervisionCenterLocator));
        ddlSupervisionCenterLocatorWait.click();

        WebElement DDLSupervisionCenterSearchLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DDLSupervisionCenterSearchLocator));
        DDLSupervisionCenterSearchLocatorWait.sendKeys("مكتب الخالدية الشمالية" , Keys.ENTER);

        try {
            WebElement BTNBSearchLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(BTNBSearchLoactor));
            BTNBSearchLoactorWait.click();
        } catch (Exception e) {
            WebElement BTNBSearchLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(BTNBSearchLoactor));
            BTNBSearchLoactorWait.click();
        }

        WebElement TDSchoolCardLOcatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(TDSchoolCardLOcator));
        TDSchoolCardLOcatorWait.click();


        List ListRowsXpath = browserQA.findElements(By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[2]/div[2]/div/div/table[1]/tbody/tr/td[1]"));

        int SchoolCardTableSize = ListRowsXpath.size();

        System.out.println(SchoolCardTableSize);

        if (SchoolCardTableSize <= 1) {

            int SchoolCardTableSize1 = ListRowsXpath.size() + 2;
            String TableSizeAddFormat1 = String.format("%02d" , SchoolCardTableSize1);

            By VisitType1 = By.id("select2-ctl00_PlaceHolderMain_gvSchoolCard_ctl" + TableSizeAddFormat1 + "_ddlVisitType-container");
            By VisitTypeSearch1 = By.xpath("/html/body/span/span/span[1]/input");

            WebElement VisitType1Wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(VisitType1));
            VisitType1Wait.click();

            WebElement VisitTypeSearch1Wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(VisitTypeSearch1));
            VisitTypeSearch1Wait.sendKeys(CardDescrption , Keys.ENTER);

            By VisitGoalLocator = By.id("ctl00_PlaceHolderMain_gvSchoolCard_ctl" + TableSizeAddFormat1 + "_tbVisitGoal");

            WebElement VisitGoalLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(VisitGoalLocator));
            VisitGoalLocatorWait.sendKeys("Test");

            By ClickCalLocator = By.id("ctl00_PlaceHolderMain_gvSchoolCard_ctl" + TableSizeAddFormat1 + "_clrVisitDate_ibtnOpenCalendar");


            WebElement ClickCalLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ClickCalLocator));
            ClickCalLocatorWait.click();

            By SelectDayLocator = By.xpath("/html/body/div/table/tbody/tr[3]/td[2]");
            WebElement SelectDayLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SelectDayLocator));
            SelectDayLocatorWait.click();

            By VisitRequestFrom = By.id("ctl00_PlaceHolderMain_gvSchoolCard_ctl" + TableSizeAddFormat1 + "_tbVisitRequestFrom");

            WebElement VisitRequestFromWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(VisitRequestFrom));
            VisitRequestFromWait.sendKeys("تم طلب الزيارة من قبلتم طلب الزيارة من قبلتم طلب الزيارة من قبلتم طلب الزيارة من قبلتم طلب الزيارة م");

            By AddLinkLocator = By.id("ctl00_PlaceHolderMain_gvSchoolCard_ctl" + TableSizeAddFormat1 + "_lbtnAdd");

            WebElement AddLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddLinkLocator));
            AddLinkLocatorWait.click();

            By AddMeassageResultLocator = By.id("ctl00_PlaceHolderMain_lblOperationResult");

            WebElement AddMeassageResultLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddMeassageResultLocator));

            String ActualResult = browserQA.findElement(AddMeassageResultLocator).getText();
            String ExcpectedReslut = "تمت عملية الاضافة بنجاح.";

            Assert.assertEquals(ActualResult , ExcpectedReslut , "لم تتم عملية الاضافة بنجاح");


        }

        if (SchoolCardTableSize >= 2 && SchoolCardTableSize < 22) {


            int SchoolCardTableSize2 = ListRowsXpath.size() + 1;
            String TableSizeAddFormat2 = String.format("%02d" , SchoolCardTableSize2);

            By VisitType2 = By.id("select2-ctl00_PlaceHolderMain_gvSchoolCard_ctl" + TableSizeAddFormat2 + "_ddlVisitType-container");
            By VisitTypeSearch2 = By.xpath("/html/body/span/span/span[1]/input");

            WebElement VisitType1Wait2 = waitQA.until(ExpectedConditions.visibilityOfElementLocated(VisitType2));
            VisitType1Wait2.click();

            WebElement VisitTypeSearch1Wait2 = waitQA.until(ExpectedConditions.visibilityOfElementLocated(VisitTypeSearch2));
            VisitTypeSearch1Wait2.sendKeys(CardDescrption , Keys.ENTER);

            By VisitGoalLocator2 = By.id("ctl00_PlaceHolderMain_gvSchoolCard_ctl" + TableSizeAddFormat2 + "_tbVisitGoal");

            WebElement VisitGoalLocatorWait2 = waitQA.until(ExpectedConditions.visibilityOfElementLocated(VisitGoalLocator2));
            VisitGoalLocatorWait2.sendKeys("Test");

            By ClickCalLocator2 = By.id("ctl00_PlaceHolderMain_gvSchoolCard_ctl" + TableSizeAddFormat2 + "_clrVisitDate_ibtnOpenCalendar");


            WebElement ClickCalLocatorWait2 = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ClickCalLocator2));
            ClickCalLocatorWait2.click();

            By SelectDayLocator2 = By.xpath("/html/body/div/table/tbody/tr[3]/td[2]");
            WebElement SelectDayLocatorWait2 = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SelectDayLocator2));
            SelectDayLocatorWait2.click();

            By VisitRequestFrom2 = By.id("ctl00_PlaceHolderMain_gvSchoolCard_ctl" + TableSizeAddFormat2 + "_tbVisitRequestFrom");

            WebElement VisitRequestFromWait2 = waitQA.until(ExpectedConditions.visibilityOfElementLocated(VisitRequestFrom2));
            VisitRequestFromWait2.sendKeys("تم طلب الزيارة من قبلتم طلب الزيارة من قبلتم طلب الزيارة من قبلتم طلب الزيارة من قبلتم طلب الزيارة م");

            By AddLinkLocator2 = By.id("ctl00_PlaceHolderMain_gvSchoolCard_ctl" + TableSizeAddFormat2 + "_lbtnAdd");

            WebElement AddLinkLocatorWait2 = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddLinkLocator2));
            AddLinkLocatorWait2.click();

            By AddMeassageResultLocator2 = By.id("ctl00_PlaceHolderMain_lblOperationResult");

            WebElement AddMeassageResultLocatorWait2 = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddMeassageResultLocator2));

            String ActualResult2 = browserQA.findElement(AddMeassageResultLocator2).getText();
            String ExcpectedReslut2 = "تمت عملية الاضافة بنجاح.";

            Assert.assertEquals(ActualResult2 , ExcpectedReslut2 , "لم تتم عملية الاضافة بنجاح");


        }
        if (SchoolCardTableSize >= 22) {


            int SchoolCardTableSize3 = ListRowsXpath.size();
            String TableSizeAddFormat3 = String.format("%02d" , SchoolCardTableSize3);

            By VisitType23 = By.id("select2-ctl00_PlaceHolderMain_gvSchoolCard_ctl" + TableSizeAddFormat3 + "_ddlVisitType-container");
            By VisitTypeSearch23 = By.xpath("/html/body/span/span/span[1]/input");

            WebElement VisitType1Wait23 = waitQA.until(ExpectedConditions.visibilityOfElementLocated(VisitType23));
            VisitType1Wait23.click();

            WebElement VisitTypeSearch1Wait23 = waitQA.until(ExpectedConditions.visibilityOfElementLocated(VisitTypeSearch23));
            VisitTypeSearch1Wait23.sendKeys(CardDescrption , Keys.ENTER);

            By VisitGoalLocator23 = By.id("ctl00_PlaceHolderMain_gvSchoolCard_ctl" + TableSizeAddFormat3 + "_tbVisitGoal");

            WebElement VisitGoalLocatorWait23 = waitQA.until(ExpectedConditions.visibilityOfElementLocated(VisitGoalLocator23));
            VisitGoalLocatorWait23.sendKeys("Test");

            By ClickCalLocator23 = By.id("ctl00_PlaceHolderMain_gvSchoolCard_ctl" + TableSizeAddFormat3 + "_clrVisitDate_ibtnOpenCalendar");


            WebElement ClickCalLocatorWait23 = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ClickCalLocator23));
            ClickCalLocatorWait23.click();

            By SelectDayLocator23 = By.xpath("/html/body/div/table/tbody/tr[3]/td[2]");
            WebElement SelectDayLocatorWait23 = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SelectDayLocator23));
            SelectDayLocatorWait23.click();

            By VisitRequestFrom23 = By.id("ctl00_PlaceHolderMain_gvSchoolCard_ctl" + TableSizeAddFormat3 + "_tbVisitRequestFrom");

            WebElement VisitRequestFromWait23 = waitQA.until(ExpectedConditions.visibilityOfElementLocated(VisitRequestFrom23));
            VisitRequestFromWait23.sendKeys("تم طلب الزيارة من قبلتم طلب الزيارة من قبلتم طلب الزيارة من قبلتم طلب الزيارة من قبلتم طلب الزيارة م");

            By AddLinkLocator23 = By.id("ctl00_PlaceHolderMain_gvSchoolCard_ctl" + TableSizeAddFormat3 + "_lbtnAdd");

            WebElement AddLinkLocatorWait23 = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddLinkLocator23));
            AddLinkLocatorWait23.click();

            By AddMeassageResultLocator23 = By.id("ctl00_PlaceHolderMain_lblOperationResult");

            WebElement AddMeassageResultLocatorWait2 = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddMeassageResultLocator23));

            String ActualResult23 = browserQA.findElement(AddMeassageResultLocator23).getText();
            String ExcpectedReslut23 = "تمت عملية الاضافة بنجاح.";

            Assert.assertEquals(ActualResult23 , ExcpectedReslut23 , "لم تتم عملية الاضافة بنجاح");


        }


    }

    @Test
    public void editSchoolCards() {


        WebElement SchoolCardsMenuLOcatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SchoolCardsMenuLocator));
        SchoolCardsMenuLOcatorWait.click();

        WebElement ddlSupervisionCenterLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DDLSupervisionCenterLocator));
        ddlSupervisionCenterLocatorWait.click();

        WebElement DDLSupervisionCenterSearchLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DDLSupervisionCenterSearchLocator));
        DDLSupervisionCenterSearchLocatorWait.sendKeys("مكتب الخالدية الشمالية" , Keys.ENTER);

        try {
            WebElement BTNBSearchLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(BTNBSearchLoactor));
            BTNBSearchLoactorWait.click();
        } catch (Exception e) {
            WebElement BTNBSearchLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(BTNBSearchLoactor));
            BTNBSearchLoactorWait.click();
        }

        WebElement TDSchoolCardLOcatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(TDSchoolCardLOcator));
        TDSchoolCardLOcatorWait.click();


        By EditLinkLocator = By.id("ctl00_PlaceHolderMain_gvSchoolCard_ctl02_lbtnEdit");

        WebElement EditLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(EditLinkLocator));
        EditLinkLocatorWait.click();

        By UpDateLoactor = By.id("ctl00_PlaceHolderMain_gvSchoolCard_ctl02_lbtnUpdate");

        WebElement UpDateLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(UpDateLoactor));
        UpDateLoactorWait.click();

        By EditMessageResult=By.id("ctl00_PlaceHolderMain_lblOperationResult");

        WebElement EditMessageResultWait=waitQA.until(ExpectedConditions.visibilityOfElementLocated(EditMessageResult));

        String ActualResult=browserQA.findElement(EditMessageResult).getText();
        String ExcpectedResult="تمت عملية التعديل بنجاح.";

        Assert.assertEquals(ActualResult,ExcpectedResult,"لم تتم عملية التعديل بنجاح");



    }

    @Test
    public void deleteSchoolCards() {

        WebElement SchoolCardsMenuLOcatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SchoolCardsMenuLocator));
        SchoolCardsMenuLOcatorWait.click();

        WebElement ddlSupervisionCenterLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DDLSupervisionCenterLocator));
        ddlSupervisionCenterLocatorWait.click();

        WebElement DDLSupervisionCenterSearchLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DDLSupervisionCenterSearchLocator));
        DDLSupervisionCenterSearchLocatorWait.sendKeys("مكتب الخالدية الشمالية" , Keys.ENTER);

        try {
            WebElement BTNBSearchLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(BTNBSearchLoactor));
            BTNBSearchLoactorWait.click();
        } catch (Exception e) {
            WebElement BTNBSearchLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(BTNBSearchLoactor));
            BTNBSearchLoactorWait.click();
        }

        WebElement TDSchoolCardLOcatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(TDSchoolCardLOcator));
        TDSchoolCardLOcatorWait.click();



        By DeleteLinkLocator = By.id("ctl00_PlaceHolderMain_gvSchoolCard_ctl02_lbtnDelete");
        WebElement DeleteLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DeleteLinkLocator));
        DeleteLinkLocatorWait.click();

        By YesLinkConfrmation = By.id("ctl00_ibtnYes");
        WebElement YesLinkConfrmationWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(YesLinkConfrmation));
        YesLinkConfrmationWait.click();

        By DeleteMessageResult=By.id("ctl00_PlaceHolderMain_lblOperationResult");

        WebElement DeleteMessageResultWait=waitQA.until(ExpectedConditions.visibilityOfElementLocated(DeleteMessageResult));

        String ActualResult=browserQA.findElement(DeleteMessageResult).getText();
        String ExcpectedReslut="تمت عملية الحذف بنجاح.";

        Assert.assertEquals(ActualResult,ExcpectedReslut,"لم تتم عملية الحذف بنجاح");
    }

}
