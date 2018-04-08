package NoorProject.EduWaveSafeAndSecurity.StaffSAndSInDistrict.Cards;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.List;

import static NoorProject.Other.NoorLogin.browserQA;
import static NoorProject.Other.NoorLogin.waitQA;

public class SchoolCards {

    private By SwitchProfileLocator = By.id("ctl00_oHeader_divSwitchUser");
    private By UserNameLabelLocator = By.partialLinkText("موظف بإدارة الأمن والسلامة بإدارة التعليم");
    private By SchoolCardsMenuLOcator = By.id("divMenuItem_5988");
    private By DDLSupervisionCenterLocator = By.id("select2-ctl00_PlaceHolderMain_ddlSupervisionCenter-container");
    private By DDLSupervisionCenterSearchLocator = By.xpath("/html/body/span/span/span[1]/input");
    private By BTNBSearchLoactor = By.id("ctl00_PlaceHolderMain_ibtnSearch");
    private By TDSchoolCardLOcator = By.id("ctl00_PlaceHolderMain_gvSchools_ctl02_tdSchoolCard");


    @Test
    public void AddSchoolCards() {

        WebElement SwitchProfileLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SwitchProfileLocator));
        SwitchProfileLocatorWait.click();

        WebElement UserNameLabelLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(UserNameLabelLocator));
        UserNameLabelLocatorWait.click();

        WebElement SchoolCardsMenuLOcatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SchoolCardsMenuLOcator));
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

        int NumberOfRowsForAdd = ListRowsXpath.size() + 1;
        int NumberOfRowsForAddParameter = NumberOfRowsForAdd;

        System.out.println("" + NumberOfRowsForAddParameter);

        By DDLVisitTypeLoactor = By.id("select2-ctl00_PlaceHolderMain_gvSchoolCard_ctl0" + NumberOfRowsForAddParameter + "_ddlVisitType-container");


        WebElement DDLVisitTypeLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DDLVisitTypeLoactor));
        DDLVisitTypeLoactorWait.click();

        By DDLVisitTypeSrachLoactor = By.xpath("/html/body/span/span/span[1]/input");

        WebElement DDLVisitTypeSrachLoactorWait= waitQA.until(ExpectedConditions.visibilityOfElementLocated(DDLVisitTypeSrachLoactor));
        DDLVisitTypeSrachLoactorWait.sendKeys("زيارتي" , Keys.ENTER);

        By VisitGoalLOcator = By.id("ctl00_PlaceHolderMain_gvSchoolCard_ctl0" + NumberOfRowsForAddParameter + "_tbVisitGoal");
        WebElement VisitGoalLOcatorWait= waitQA.until(ExpectedConditions.visibilityOfElementLocated(VisitGoalLOcator));
        VisitGoalLOcatorWait.sendKeys(" هدف عام " , Keys.TAB);

        By DateOfVistLoactor = By.id("ctl00_PlaceHolderMain_gvSchoolCard_ctl0" + NumberOfRowsForAddParameter + "_clrVisitDate_ibtnOpenCalendar");
        WebElement DateOfVistLoactorWait= waitQA.until(ExpectedConditions.visibilityOfElementLocated(DateOfVistLoactor));
        DateOfVistLoactorWait.click();

        By DayOfVistLocator = By.xpath("/html/body/div/table/tbody/tr[2]/td[4]");
        WebElement DayOfVistLocatorWait= waitQA.until(ExpectedConditions.visibilityOfElementLocated(DayOfVistLocator));
        DayOfVistLocatorWait.click();

        By VisitRequestFromLocator = By.id("ctl00_PlaceHolderMain_gvSchoolCard_ctl0" + NumberOfRowsForAddParameter + "_tbVisitRequestFrom");
        WebElement VisitRequestFromLocatorWait= waitQA.until(ExpectedConditions.visibilityOfElementLocated(VisitRequestFromLocator));
        VisitRequestFromLocatorWait.sendKeys("NO");


        By NotesLoactor = By.id("ctl00_PlaceHolderMain_gvSchoolCard_ctl0" + NumberOfRowsForAddParameter + "_tbNote");
        WebElement NotesLoactorWait= waitQA.until(ExpectedConditions.visibilityOfElementLocated(NotesLoactor));
        NotesLoactorWait.sendKeys("Notes");

        By AddLinkLocator = By.id("ctl00_PlaceHolderMain_gvSchoolCard_ctl0" + NumberOfRowsForAddParameter + "_lbtnAdd");
        WebElement AddLinkLocatorWait= waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddLinkLocator));
        AddLinkLocatorWait.click();


        By ValidatinMeaage = By.id("ctl00_PlaceHolderMain_lblOperationResult");

        WebElement ValidatinMeaageWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ValidatinMeaage));

        String ValidatinMeaageString = ValidatinMeaageWait.getText();


    }

    @Test
    public void EditSchoolCards() {
        List ListRowsXpath = browserQA.findElements(By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[2]/div[2]/div/div/table[1]/tbody/tr/td[1]"));
        int NunOfRowDelete = ListRowsXpath.size();
        int EditParameter = NunOfRowDelete;

        By EditLinkLocator = By.id("ctl00_PlaceHolderMain_gvSchoolCard_ctl0" + EditParameter + "_lbtnEdit");

        WebElement EditLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(EditLinkLocator));
        EditLinkLocatorWait.click();
        By UpDateLoactor = By.id("ctl00_PlaceHolderMain_gvSchoolCard_ctl0" + EditParameter + "_lbtnUpdate");

        WebElement UpDateLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(UpDateLoactor));
        UpDateLoactorWait.click();


    }

    @Test
    public void DeleteSchoolCards() {

        List ListRowsXpath = browserQA.findElements(By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[2]/div[2]/div/div/table[1]/tbody/tr/td[1]"));
        int NunOfRowDelete = ListRowsXpath.size();
        int DeleteParameter = NunOfRowDelete;

        By DeleteLinkLocator = By.id("ctl00_PlaceHolderMain_gvSchoolCard_ctl0" + DeleteParameter + "_lbtnDelete");
        WebElement DeleteLinkLocatorWait= waitQA.until(ExpectedConditions.visibilityOfElementLocated(DeleteLinkLocator));
        DeleteLinkLocatorWait.click();

        By YesLinkConfrmation = By.id("ctl00_ibtnYes");
        WebElement YesLinkConfrmationWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(YesLinkConfrmation));
        YesLinkConfrmationWait.click();
    }

}
