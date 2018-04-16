/*
 * Created By Rami AlShawabkeh  4/5/18 12:03 PM
 */

package NoorProject.EduWaveSafeAndSecurity.A1GeneralDirectorOfSchoolSecurityAndSafety.Settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static NoorProject.Other.NoorLogin.browserQA;
import static NoorProject.Other.NoorLogin.waitQA;

public class VisitsTypes {


    private By SwitchProfileLocator = By.id("ctl00_oHeader_divSwitchUser");
    private By UserNameLabelLocator = By.linkText("مدير عام الأمن والسلامة المدرسية");
    private By SettingsMenuLoactor = By.id("divMenuItem_5894");
    private By VisitsTypesLocator = By.linkText("أنواع الزيارات");

    @Test

    public void switchProfile() {
        browserQA.manage().window().maximize();
        browserQA.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

        WebElement SwitchProfileLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SwitchProfileLocator));
        SwitchProfileLocatorWait.click();

        WebElement UserNameLabelLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(UserNameLabelLocator));
        UserNameLabelLocatorWait.click();
    }


    Random Rand = new Random();
    int RandomNumber = Rand.nextInt(1000000);
    public String RandomString = "نوع زيارة رقم" + RandomNumber;

    @Test
//اضافة انواع الزيارات/مدير عام الامن والسلامة المدرسية
    public void addVisitsTypes() throws InterruptedException {

        browserQA.manage().window().maximize();
        browserQA.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        Thread.sleep(500);
        WebElement SettingsMenuLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SettingsMenuLoactor));
        SettingsMenuLoactorWait.click();


        WebElement VisitsTypesLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(VisitsTypesLocator));
        VisitsTypesLocatorWait.click();

        List VisitsTypesTableListAdd = browserQA.findElements(By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[1]/div[2]/div/div/table[1]/tbody/tr/td[1]"));

        int TableSzie = VisitsTypesTableListAdd.size();


        if (TableSzie <= 1) {


            int TableSizeAdd = VisitsTypesTableListAdd.size() + 2;
            String TableSizeAddFormat1 = String.format("%02d", TableSizeAdd);

            By VisitsTypesDescLocator = By.id("ctl00_PlaceHolderMain_gvVisitType_ctl" + TableSizeAddFormat1 + "_tbVisitTypeDesc");


            WebElement VisitsTypesDescLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(VisitsTypesDescLocator));
            VisitsTypesDescLocatorWait.sendKeys(RandomString);

            By AddLinkLocator = By.id("ctl00_PlaceHolderMain_gvVisitType_ctl" + TableSizeAddFormat1 + "_lbtnAdd");

            WebElement AddLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddLinkLocator));
            AddLinkLocatorWait.click();

            By MeassageAddLocator1 = By.id("ctl00_PlaceHolderMain_lblOperationResult");

            WebElement MeassageAddLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(MeassageAddLocator1));

            String ActualResult = browserQA.findElement(MeassageAddLocator1).getText();
            String ExpectedResult = "تمت عملية الحفظ بنجاح.";

            Assert.assertEquals(ActualResult, ExpectedResult, "لم تتم اضافة الزيارة بنجاح");

        }

        if (TableSzie >= 2 && TableSzie < 22) {

            int TableSizeAdd = VisitsTypesTableListAdd.size() + 1;
            String TableSizeAddFormat2 = String.format("%02d", TableSizeAdd);

            By VisitsTypesDescLocator = By.id("ctl00_PlaceHolderMain_gvVisitType_ctl" + TableSizeAddFormat2 + "_tbVisitTypeDesc");

            Random Rand = new Random();
            int RandomNumber = Rand.nextInt(1000000);

            WebElement VisitsTypesDescLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(VisitsTypesDescLocator));
            VisitsTypesDescLocatorWait.sendKeys(RandomString);

            By AddLinkLocator = By.id("ctl00_PlaceHolderMain_gvVisitType_ctl" + TableSizeAddFormat2 + "_lbtnAdd");

            WebElement AddLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddLinkLocator));
            AddLinkLocatorWait.click();

            By MeassageAddLocator2 = By.id("ctl00_PlaceHolderMain_lblOperationResult");

            WebElement MeassageAddLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(MeassageAddLocator2));

            String ActualResult = browserQA.findElement(MeassageAddLocator2).getText();
            String ExpectedResult = "تمت عملية الحفظ بنجاح.";

            Assert.assertEquals(ActualResult, ExpectedResult, "لم تتم اضافة الزيارة بنجاح");

        }

        if (TableSzie >= 22) {


            int TableSizeAdd = VisitsTypesTableListAdd.size();
            String TableSizeAddFormat3 = String.format("%02d", TableSizeAdd);

            By VisitsTypesDescLocator = By.id("ctl00_PlaceHolderMain_gvVisitType_ctl" + TableSizeAddFormat3 + "_tbVisitTypeDesc");

            Random Rand = new Random();
            int RandomNumber = Rand.nextInt(1000000);

            WebElement VisitsTypesDescLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(VisitsTypesDescLocator));
            VisitsTypesDescLocatorWait.sendKeys(RandomString);

            By AddLinkLocator = By.id("ctl00_PlaceHolderMain_gvVisitType_ctl" + TableSizeAddFormat3 + "_lbtnAdd");

            WebElement AddLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddLinkLocator));
            AddLinkLocatorWait.click();

            By MeassageAddLocator3 = By.id("ctl00_PlaceHolderMain_lblOperationResult");

            WebElement MeassageAddLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(MeassageAddLocator3));

            String ActualResult = browserQA.findElement(MeassageAddLocator3).getText();
            String ExpectedResult = "تمت عملية الحفظ بنجاح.";

            Assert.assertEquals(ActualResult, ExpectedResult, "لم تتم اضافة الزيارة بنجاح");


        }


    }

    private By EditLinkLocator = By.id("ctl00_PlaceHolderMain_gvVisitType_ctl02_lbtnEdit");
    private By VistDescLocator = By.id("ctl00_PlaceHolderMain_gvVisitType_ctl02_tbVisitTypeDesc");
    private By UpdateLinkLocator = By.id("ctl00_PlaceHolderMain_gvVisitType_ctl02_lbtnUpdate");

    @Test
//تعديل انواع الزيارات/مدير عام الامن والسلامة المدرسية

    public void editVisitsTypes() throws InterruptedException {
        browserQA.manage().window().maximize();
        browserQA.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        Thread.sleep(500);
        WebElement SettingsMenuLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SettingsMenuLoactor));
        SettingsMenuLoactorWait.click();


        WebElement VisitsTypesLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(VisitsTypesLocator));
        VisitsTypesLocatorWait.click();


        List VisitsTypesTableListEdit = browserQA.findElements(By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[1]/div[2]/div/div/table[1]/tbody/tr/td[1]"));

        int TableSzieEdit = VisitsTypesTableListEdit.size();


        if (TableSzieEdit == 1) {

            VisitsTypes Add = new VisitsTypes();
            Add.addVisitsTypes();

            WebElement EditLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(EditLinkLocator));
            EditLinkLocatorWait.click();

            Random Rand = new Random();
            int RandomNumber = Rand.nextInt(1000000);

            WebElement VistDescLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(VistDescLocator));
            VistDescLocatorWait.clear();
            VistDescLocatorWait.sendKeys("Rami" + RandomNumber);

            WebElement UpdateLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(UpdateLinkLocator));
            UpdateLinkLocatorWait.click();

            By MessageLocator = By.id("ctl00_PlaceHolderMain_lblOperationResult");

            WebElement MessageLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(MessageLocator));

            String ActualResult = browserQA.findElement(MessageLocator).getText();
            String ExpectedResult = "تمت عملية التعديل بنجاح.";

            Assert.assertEquals(ActualResult, ExpectedResult, "لم تتم عملية التعديل بنجاح");


        } else {

            WebElement EditLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(EditLinkLocator));
            EditLinkLocatorWait.click();

            Random Rand = new Random();
            int RandomNumber = Rand.nextInt(1000000);

            WebElement VistDescLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(VistDescLocator));
            VistDescLocatorWait.clear();
            VistDescLocatorWait.sendKeys("Rami" + RandomNumber);

            WebElement UpdateLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(UpdateLinkLocator));
            UpdateLinkLocatorWait.click();

            By MessageLocator = By.id("ctl00_PlaceHolderMain_lblOperationResult");

            WebElement MessageLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(MessageLocator));

            String ActualResult = browserQA.findElement(MessageLocator).getText();
            String ExpectedResult = "تمت عملية التعديل بنجاح.";

            Assert.assertEquals(ActualResult, ExpectedResult, "لم تتم عملية التعديل بنجاح");
        }


    }


    private By DeletelinkLOcator = By.id("ctl00_PlaceHolderMain_gvVisitType_ctl02_lbtnDelete");
    private By YesDeleteLocator = By.id("ctl00_ibtnYes");

    @Test

    public void deleteVisitsTypes() throws InterruptedException {
        browserQA.manage().window().maximize();
        browserQA.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

        Thread.sleep(500);
        WebElement SettingsMenuLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SettingsMenuLoactor));
        SettingsMenuLoactorWait.click();


        WebElement VisitsTypesLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(VisitsTypesLocator));
        VisitsTypesLocatorWait.click();

        List VisitsTypesTableListDelete = browserQA.findElements(By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[1]/div[2]/div/div/table[1]/tbody/tr/td[1]"));

        int TableSzieDelete = VisitsTypesTableListDelete.size();

        if (TableSzieDelete == 1) {

            VisitsTypes Add = new VisitsTypes();
            Add.addVisitsTypes();

            WebElement DeletelinkLOcatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DeletelinkLOcator));
            DeletelinkLOcatorWait.click();

            WebElement YesDeleteLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(YesDeleteLocator));
            YesDeleteLocatorWait.click();

            By MessageLocatorDelete = By.id("ctl00_PlaceHolderMain_lblOperationResult");

            WebElement MessageLocatorWaiot = waitQA.until(ExpectedConditions.visibilityOfElementLocated(MessageLocatorDelete));

            String ActualResult = browserQA.findElement(MessageLocatorDelete).getText();
            String ExpectedResult = "تمت عملية الحذف بنجاح";

            Assert.assertEquals(ActualResult, ExpectedResult, "لم تتم عملية الحذف بنجاح");


        } else {
            WebElement DeletelinkLOcatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DeletelinkLOcator));
            DeletelinkLOcatorWait.click();

            WebElement YesDeleteLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(YesDeleteLocator));
            YesDeleteLocatorWait.click();

            By MessageLocatorDelete = By.id("ctl00_PlaceHolderMain_lblOperationResult");

            WebElement MessageLocatorWaiot = waitQA.until(ExpectedConditions.visibilityOfElementLocated(MessageLocatorDelete));

            String ActualResult = browserQA.findElement(MessageLocatorDelete).getText();
            String ExpectedResult = "تمت عملية الحذف بنجاح";


            if (ActualResult.equals("لا يمكن الحذف لارتباط نوع الزيارة ببطاقة مدرسة.")) {

                System.out.println("لا يمكن الحذف لارتباط نوع الزيارة ببطاقة مدرسة.");
            } else {
                Assert.fail("حدث خلل اثناء عملية الحفظ");
            }

        }


    }

}
