/*
 * Created By  Rami AlShawabkeh  4/11/18 3:58 PM
 */

/*
 * Created By  Rami AlShawabkeh  4/8/18 3:07 PM
 */

package NoorProject.EduWaveSafeAndSecurity.A2SSOfficerInMinstry.Forms.ExternalItems;

import NoorProject.EduWaveSafeAndSecurity.A1GeneralDirectorOfSchoolSecurityAndSafety.Forms.Forms.SafetyForms;
import NoorProject.EduWaveSafeAndSecurity.A1GeneralDirectorOfSchoolSecurityAndSafety.Forms.SectionsForm.SectionsForms;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static NoorProject.Other.NoorLogin.browserQA;
import static NoorProject.Other.NoorLogin.waitQA;

public class ExternalItems {


    private By SwitchProfileLocator = By.id("ctl00_oHeader_divSwitchUser");
    private By UserNameLabelLocator = By.linkText("موظف الأمن والسلامة المدرسية");
    private By FormMainMenuLoactor = By.id("divMenuItem_5968");
    private By FormStatusLocator = By.id("select2-ctl00_PlaceHolderMain_ddlFormStatus-container");
    private By FormStatusSearchLocator = By.xpath("/html/body/span/span/span[1]/input");
    private By SerachButtonLocator = By.id("ctl00_PlaceHolderMain_ibtnSearch");
    private By SectionsLinkLocator = By.id("ctl00_PlaceHolderMain_gvForms_ctl02_tdSections");


    @Test

    public void switchProfile() {

        browserQA.manage().window().maximize();
        browserQA.manage().timeouts().pageLoadTimeout(5 , TimeUnit.SECONDS);

        WebElement SwitchProfileLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SwitchProfileLocator));
        SwitchProfileLocatorWait.click();

        WebElement UserLabelLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(UserNameLabelLocator));
        UserLabelLocatorWait.click();


    }


    //موظف الامن والسلامة/ أضافة البنود الخارجية
    @Test
    public void addExI() throws InterruptedException {

        browserQA.manage().window().maximize();
        browserQA.manage().timeouts().pageLoadTimeout(5 , TimeUnit.SECONDS);

        SafetyForms AddForm = new SafetyForms();
        AddForm.addSafetyForms();


        WebElement FormMainMenuLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(FormMainMenuLoactor));
        FormMainMenuLoactorWait.click();

        WebElement FormStatusLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(FormStatusLocator));
        FormStatusLocatorWait.click();

        WebElement FormStatusSearchLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(FormStatusSearchLocator));
        FormStatusSearchLocatorWait.sendKeys("غير منشور" , Keys.ENTER);

        Thread.sleep(1000);
        WebElement SerachButtonLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachButtonLocator));
        SerachButtonLocatorWait.click();

        WebElement SectionsLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SectionsLinkLocator));
        SectionsLinkLocatorWait.click();


        List SectionTableList = browserQA.findElements(By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[1]/div[2]/div/div/table[1]/tbody/tr/td[1]"));

        int TableSectionSizeForCheck = SectionTableList.size();

        if (TableSectionSizeForCheck <= 1) {

            SectionsForms AddSection = new SectionsForms();
            AddSection.addSections();
            List SectionsTableList = browserQA.findElements(By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[1]/div[2]/div/div/table[1]/tbody/tr/td[1]"));
            int SectionsTableListSize = SectionsTableList.size();


            System.out.println("Rami" + SectionsTableListSize);

            if (SectionsTableListSize >= 21) {
                By ExternalItemsLinkLocator = By.id("ctl00_PlaceHolderMain_gvSections_ctl20_lbtnItems");
                WebElement ExternalItemsLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ExternalItemsLinkLocator));
                ExternalItemsLinkLocatorWait.click();

                List ExternalItemsTableList = browserQA.findElements(By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[1]/div[2]/table/tbody/tr[2]/td/div/div/table[1]/tbody/tr/td[1]"));

                int TableSize = ExternalItemsTableList.size();

                System.out.println("TableSize::" + TableSize);

                if (TableSize <= 1) {
                    int TableSizeAdd = ExternalItemsTableList.size() + 2;
                    String TableSizeAddFormat = String.format("%02d" , TableSizeAdd);
                    System.out.println("TableSizeAdd::" + TableSizeAdd);
                    System.out.println("TableSizeAddFormat::" + TableSizeAddFormat);


                    By AddDescLink1 = By.id("ctl00_PlaceHolderMain_gvItems_ctl" + TableSizeAddFormat + "_tbAddFormItemDesc");
                    Random Rand = new Random();
                    int RandomNumber = Rand.nextInt(1000000);

                    WebElement AddDescLinkWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddDescLink1));
                    AddDescLinkWait.sendKeys("Rami" + RandomNumber);

                    By AddLinkLocator1 = By.id("ctl00_PlaceHolderMain_gvItems_ctl" + TableSizeAddFormat + "_lbtnAddFormItemDesc");

                    WebElement AddLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddLinkLocator1));
                    AddLinkLocatorWait.click();

                    By MeesageResultLocator = By.id("ctl00_PlaceHolderMain_lblOpertioanlResult");

                    WebElement MeesageResultLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(MeesageResultLocator));

                    String ActualResult = browserQA.findElement(MeesageResultLocator).getText();
                    String ExcpectedResult = "تم إضافة البند الخارجي بنجاح.";

                    Assert.assertEquals(ActualResult , ExcpectedResult , "لم تتم إضافة البند  الخارجي بنجاح.");


                }

                if (TableSize >= 2 && TableSize < 22) {

                    int TableSizeAdd = ExternalItemsTableList.size() + 1;
                    String TableSizeAddFormat = String.format("%02d" , TableSizeAdd);
                    System.out.println("TableSizeAdd::" + TableSizeAdd);
                    System.out.println("TableSizeAddFormat::" + TableSizeAddFormat);

                    By AddDescLink2 = By.id("ctl00_PlaceHolderMain_gvItems_ctl" + TableSizeAddFormat + "_tbAddFormItemDesc");
                    Random Rand = new Random();
                    int RandomNumber = Rand.nextInt(1000000);

                    WebElement AddDescLinkWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddDescLink2));
                    AddDescLinkWait.sendKeys("Rami" + RandomNumber);

                    By AddLinkLocator2 = By.id("ctl00_PlaceHolderMain_gvItems_ctl" + TableSizeAddFormat + "_lbtnAddFormItemDesc");

                    WebElement AddLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddLinkLocator2));
                    AddLinkLocatorWait.click();


                    By MeesageResultLocator2 = By.id("ctl00_PlaceHolderMain_lblOpertioanlResult");

                    WebElement MeesageResultLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(MeesageResultLocator2));

                    String ActualResult = browserQA.findElement(MeesageResultLocator2).getText();
                    String ExcpectedResult = "تم إضافة البند الخارجي بنجاح.";

                    Assert.assertEquals(ActualResult , ExcpectedResult , "لم تتم إضافة البند  الخارجي بنجاح.");


                }
                if (TableSize >= 22) {
                    int TableSizeAdd = ExternalItemsTableList.size();
                    String TableSizeAddFormat = String.format("%02d" , TableSizeAdd);
                    System.out.println("TableSizeAdd::" + TableSizeAdd);
                    System.out.println("TableSizeAddFormat::" + TableSizeAddFormat);

                    By AddDescLink2 = By.id("ctl00_PlaceHolderMain_gvItems_ctl" + TableSizeAddFormat + "_tbAddFormItemDesc");
                    Random Rand = new Random();
                    int RandomNumber = Rand.nextInt(1000000);

                    WebElement AddDescLinkWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddDescLink2));
                    AddDescLinkWait.sendKeys("Rami" + RandomNumber);

                    By AddLinkLocator2 = By.id("ctl00_PlaceHolderMain_gvItems_ctl" + TableSizeAddFormat + "_lbtnAddFormItemDesc");

                    WebElement AddLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddLinkLocator2));
                    AddLinkLocatorWait.click();


                    By MeesageResultLocator3 = By.id("ctl00_PlaceHolderMain_lblOpertioanlResult");

                    WebElement MeesageResultLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(MeesageResultLocator3));

                    String ActualResult = browserQA.findElement(MeesageResultLocator3).getText();
                    String ExcpectedResult = "تم إضافة البند الخارجي بنجاح.";

                    Assert.assertEquals(ActualResult , ExcpectedResult , "لم تتم إضافة البند  الخارجي بنجاح.");
                }


            } else {

                By ExternalItemsLinkLocator = By.id("ctl00_PlaceHolderMain_gvSections_ctl02_lbtnItems");
                WebElement ExternalItemsLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ExternalItemsLinkLocator));
                ExternalItemsLinkLocatorWait.click();

                List ExternalItemsTableList = browserQA.findElements(By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[1]/div[2]/table/tbody/tr[2]/td/div/div/table[1]/tbody/tr/td[1]"));

                int TableSize = ExternalItemsTableList.size();

                System.out.println("TableSize::" + TableSize);

                if (TableSize <= 1) {
                    int TableSizeAdd = ExternalItemsTableList.size() + 2;
                    String TableSizeAddFormat = String.format("%02d" , TableSizeAdd);
                    System.out.println("TableSizeAdd::" + TableSizeAdd);
                    System.out.println("TableSizeAddFormat::" + TableSizeAddFormat);


                    By AddDescLink1 = By.id("ctl00_PlaceHolderMain_gvItems_ctl" + TableSizeAddFormat + "_tbAddFormItemDesc");
                    Random Rand = new Random();
                    int RandomNumber = Rand.nextInt(1000000);

                    WebElement AddDescLinkWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddDescLink1));
                    AddDescLinkWait.sendKeys("Rami" + RandomNumber);

                    By AddLinkLocator1 = By.id("ctl00_PlaceHolderMain_gvItems_ctl" + TableSizeAddFormat + "_lbtnAddFormItemDesc");

                    WebElement AddLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddLinkLocator1));
                    AddLinkLocatorWait.click();

                    By MeesageResultLocator = By.id("ctl00_PlaceHolderMain_lblOpertioanlResult");

                    WebElement MeesageResultLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(MeesageResultLocator));

                    String ActualResult = browserQA.findElement(MeesageResultLocator).getText();
                    String ExcpectedResult = "تم إضافة البند الخارجي بنجاح.";

                    Assert.assertEquals(ActualResult , ExcpectedResult , "لم تتم إضافة البند  الخارجي بنجاح.");


                }

                if (TableSize >= 2 && TableSize < 22) {

                    int TableSizeAdd = ExternalItemsTableList.size() + 1;
                    String TableSizeAddFormat = String.format("%02d" , TableSizeAdd);
                    System.out.println("TableSizeAdd::" + TableSizeAdd);
                    System.out.println("TableSizeAddFormat::" + TableSizeAddFormat);

                    By AddDescLink2 = By.id("ctl00_PlaceHolderMain_gvItems_ctl" + TableSizeAddFormat + "_tbAddFormItemDesc");
                    Random Rand = new Random();
                    int RandomNumber = Rand.nextInt(1000000);

                    WebElement AddDescLinkWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddDescLink2));
                    AddDescLinkWait.sendKeys("Rami" + RandomNumber);

                    By AddLinkLocator2 = By.id("ctl00_PlaceHolderMain_gvItems_ctl" + TableSizeAddFormat + "_lbtnAddFormItemDesc");

                    WebElement AddLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddLinkLocator2));
                    AddLinkLocatorWait.click();


                    By MeesageResultLocator2 = By.id("ctl00_PlaceHolderMain_lblOpertioanlResult");

                    WebElement MeesageResultLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(MeesageResultLocator2));

                    String ActualResult = browserQA.findElement(MeesageResultLocator2).getText();
                    String ExcpectedResult = "تم إضافة البند الخارجي بنجاح.";

                    Assert.assertEquals(ActualResult , ExcpectedResult , "لم تتم إضافة البند  الخارجي بنجاح.");


                }
                if (TableSize >= 22) {
                    int TableSizeAdd = ExternalItemsTableList.size();
                    String TableSizeAddFormat = String.format("%02d" , TableSizeAdd);
                    System.out.println("TableSizeAdd::" + TableSizeAdd);
                    System.out.println("TableSizeAddFormat::" + TableSizeAddFormat);

                    By AddDescLink2 = By.id("ctl00_PlaceHolderMain_gvItems_ctl" + TableSizeAddFormat + "_tbAddFormItemDesc");
                    Random Rand = new Random();
                    int RandomNumber = Rand.nextInt(1000000);

                    WebElement AddDescLinkWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddDescLink2));
                    AddDescLinkWait.sendKeys("Rami" + RandomNumber);

                    By AddLinkLocator2 = By.id("ctl00_PlaceHolderMain_gvItems_ctl" + TableSizeAddFormat + "_lbtnAddFormItemDesc");

                    WebElement AddLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddLinkLocator2));
                    AddLinkLocatorWait.click();


                    By MeesageResultLocator3 = By.id("ctl00_PlaceHolderMain_lblOpertioanlResult");

                    WebElement MeesageResultLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(MeesageResultLocator3));

                    String ActualResult = browserQA.findElement(MeesageResultLocator3).getText();
                    String ExcpectedResult = "تم إضافة البند الخارجي بنجاح.";

                    Assert.assertEquals(ActualResult , ExcpectedResult , "لم تتم إضافة البند  الخارجي بنجاح.");
                }
            }
        } else {
            List SectionsTableList = browserQA.findElements(By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[1]/div[2]/div/div/table[1]/tbody/tr/td[1]"));
            int SectionsTableListSize = SectionsTableList.size();


            System.out.println("Rami" + SectionsTableListSize);

            if (SectionsTableListSize >= 21) {
                By ExternalItemsLinkLocator = By.id("ctl00_PlaceHolderMain_gvSections_ctl20_lbtnItems");
                WebElement ExternalItemsLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ExternalItemsLinkLocator));
                ExternalItemsLinkLocatorWait.click();

                List ExternalItemsTableList = browserQA.findElements(By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[1]/div[2]/table/tbody/tr[2]/td/div/div/table[1]/tbody/tr/td[1]"));

                int TableSize = ExternalItemsTableList.size();

                System.out.println("TableSize::" + TableSize);

                if (TableSize <= 1) {
                    int TableSizeAdd = ExternalItemsTableList.size() + 2;
                    String TableSizeAddFormat = String.format("%02d" , TableSizeAdd);
                    System.out.println("TableSizeAdd::" + TableSizeAdd);
                    System.out.println("TableSizeAddFormat::" + TableSizeAddFormat);


                    By AddDescLink1 = By.id("ctl00_PlaceHolderMain_gvItems_ctl" + TableSizeAddFormat + "_tbAddFormItemDesc");
                    Random Rand = new Random();
                    int RandomNumber = Rand.nextInt(1000000);

                    WebElement AddDescLinkWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddDescLink1));
                    AddDescLinkWait.sendKeys("Rami" + RandomNumber);

                    By AddLinkLocator1 = By.id("ctl00_PlaceHolderMain_gvItems_ctl" + TableSizeAddFormat + "_lbtnAddFormItemDesc");

                    WebElement AddLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddLinkLocator1));
                    AddLinkLocatorWait.click();

                    By MeesageResultLocator = By.id("ctl00_PlaceHolderMain_lblOpertioanlResult");

                    WebElement MeesageResultLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(MeesageResultLocator));

                    String ActualResult = browserQA.findElement(MeesageResultLocator).getText();
                    String ExcpectedResult = "تم إضافة البند الخارجي بنجاح.";

                    Assert.assertEquals(ActualResult , ExcpectedResult , "لم تتم إضافة البند  الخارجي بنجاح.");


                }

                if (TableSize >= 2 && TableSize < 22) {

                    int TableSizeAdd = ExternalItemsTableList.size() + 1;
                    String TableSizeAddFormat = String.format("%02d" , TableSizeAdd);
                    System.out.println("TableSizeAdd::" + TableSizeAdd);
                    System.out.println("TableSizeAddFormat::" + TableSizeAddFormat);

                    By AddDescLink2 = By.id("ctl00_PlaceHolderMain_gvItems_ctl" + TableSizeAddFormat + "_tbAddFormItemDesc");
                    Random Rand = new Random();
                    int RandomNumber = Rand.nextInt(1000000);

                    WebElement AddDescLinkWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddDescLink2));
                    AddDescLinkWait.sendKeys("Rami" + RandomNumber);

                    By AddLinkLocator2 = By.id("ctl00_PlaceHolderMain_gvItems_ctl" + TableSizeAddFormat + "_lbtnAddFormItemDesc");

                    WebElement AddLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddLinkLocator2));
                    AddLinkLocatorWait.click();


                    By MeesageResultLocator2 = By.id("ctl00_PlaceHolderMain_lblOpertioanlResult");

                    WebElement MeesageResultLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(MeesageResultLocator2));

                    String ActualResult = browserQA.findElement(MeesageResultLocator2).getText();
                    String ExcpectedResult = "تم إضافة البند الخارجي بنجاح.";

                    Assert.assertEquals(ActualResult , ExcpectedResult , "لم تتم إضافة البند  الخارجي بنجاح.");


                }
                if (TableSize >= 22) {
                    int TableSizeAdd = ExternalItemsTableList.size();
                    String TableSizeAddFormat = String.format("%02d" , TableSizeAdd);
                    System.out.println("TableSizeAdd::" + TableSizeAdd);
                    System.out.println("TableSizeAddFormat::" + TableSizeAddFormat);

                    By AddDescLink2 = By.id("ctl00_PlaceHolderMain_gvItems_ctl" + TableSizeAddFormat + "_tbAddFormItemDesc");
                    Random Rand = new Random();
                    int RandomNumber = Rand.nextInt(1000000);

                    WebElement AddDescLinkWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddDescLink2));
                    AddDescLinkWait.sendKeys("Rami" + RandomNumber);

                    By AddLinkLocator2 = By.id("ctl00_PlaceHolderMain_gvItems_ctl" + TableSizeAddFormat + "_lbtnAddFormItemDesc");

                    WebElement AddLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddLinkLocator2));
                    AddLinkLocatorWait.click();


                    By MeesageResultLocator3 = By.id("ctl00_PlaceHolderMain_lblOpertioanlResult");

                    WebElement MeesageResultLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(MeesageResultLocator3));

                    String ActualResult = browserQA.findElement(MeesageResultLocator3).getText();
                    String ExcpectedResult = "تم إضافة البند الخارجي بنجاح.";

                    Assert.assertEquals(ActualResult , ExcpectedResult , "لم تتم إضافة البند  الخارجي بنجاح.");
                }


            } else {

                By ExternalItemsLinkLocator = By.id("ctl00_PlaceHolderMain_gvSections_ctl02_lbtnItems");
                WebElement ExternalItemsLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ExternalItemsLinkLocator));
                ExternalItemsLinkLocatorWait.click();

                List ExternalItemsTableList = browserQA.findElements(By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[1]/div[2]/table/tbody/tr[2]/td/div/div/table[1]/tbody/tr/td[1]"));

                int TableSize = ExternalItemsTableList.size();

                System.out.println("TableSize::" + TableSize);

                if (TableSize <= 1) {
                    int TableSizeAdd = ExternalItemsTableList.size() + 2;
                    String TableSizeAddFormat = String.format("%02d" , TableSizeAdd);
                    System.out.println("TableSizeAdd::" + TableSizeAdd);
                    System.out.println("TableSizeAddFormat::" + TableSizeAddFormat);


                    By AddDescLink1 = By.id("ctl00_PlaceHolderMain_gvItems_ctl" + TableSizeAddFormat + "_tbAddFormItemDesc");
                    Random Rand = new Random();
                    int RandomNumber = Rand.nextInt(1000000);

                    WebElement AddDescLinkWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddDescLink1));
                    AddDescLinkWait.sendKeys("Rami" + RandomNumber);

                    By AddLinkLocator1 = By.id("ctl00_PlaceHolderMain_gvItems_ctl" + TableSizeAddFormat + "_lbtnAddFormItemDesc");

                    WebElement AddLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddLinkLocator1));
                    AddLinkLocatorWait.click();

                    By MeesageResultLocator = By.id("ctl00_PlaceHolderMain_lblOpertioanlResult");

                    WebElement MeesageResultLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(MeesageResultLocator));

                    String ActualResult = browserQA.findElement(MeesageResultLocator).getText();
                    String ExcpectedResult = "تم إضافة البند الخارجي بنجاح.";

                    Assert.assertEquals(ActualResult , ExcpectedResult , "لم تتم إضافة البند  الخارجي بنجاح.");


                }

                if (TableSize >= 2 && TableSize < 22) {

                    int TableSizeAdd = ExternalItemsTableList.size() + 1;
                    String TableSizeAddFormat = String.format("%02d" , TableSizeAdd);
                    System.out.println("TableSizeAdd::" + TableSizeAdd);
                    System.out.println("TableSizeAddFormat::" + TableSizeAddFormat);

                    By AddDescLink2 = By.id("ctl00_PlaceHolderMain_gvItems_ctl" + TableSizeAddFormat + "_tbAddFormItemDesc");
                    Random Rand = new Random();
                    int RandomNumber = Rand.nextInt(1000000);

                    WebElement AddDescLinkWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddDescLink2));
                    AddDescLinkWait.sendKeys("Rami" + RandomNumber);

                    By AddLinkLocator2 = By.id("ctl00_PlaceHolderMain_gvItems_ctl" + TableSizeAddFormat + "_lbtnAddFormItemDesc");

                    WebElement AddLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddLinkLocator2));
                    AddLinkLocatorWait.click();


                    By MeesageResultLocator2 = By.id("ctl00_PlaceHolderMain_lblOpertioanlResult");

                    WebElement MeesageResultLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(MeesageResultLocator2));

                    String ActualResult = browserQA.findElement(MeesageResultLocator2).getText();
                    String ExcpectedResult = "تم إضافة البند الخارجي بنجاح.";

                    Assert.assertEquals(ActualResult , ExcpectedResult , "لم تتم إضافة البند  الخارجي بنجاح.");


                }
                if (TableSize >= 22) {
                    int TableSizeAdd = ExternalItemsTableList.size();
                    String TableSizeAddFormat = String.format("%02d" , TableSizeAdd);
                    System.out.println("TableSizeAdd::" + TableSizeAdd);
                    System.out.println("TableSizeAddFormat::" + TableSizeAddFormat);

                    By AddDescLink2 = By.id("ctl00_PlaceHolderMain_gvItems_ctl" + TableSizeAddFormat + "_tbAddFormItemDesc");
                    Random Rand = new Random();
                    int RandomNumber = Rand.nextInt(1000000);

                    WebElement AddDescLinkWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddDescLink2));
                    AddDescLinkWait.sendKeys("Rami" + RandomNumber);

                    By AddLinkLocator2 = By.id("ctl00_PlaceHolderMain_gvItems_ctl" + TableSizeAddFormat + "_lbtnAddFormItemDesc");

                    WebElement AddLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddLinkLocator2));
                    AddLinkLocatorWait.click();


                    By MeesageResultLocator3 = By.id("ctl00_PlaceHolderMain_lblOpertioanlResult");

                    WebElement MeesageResultLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(MeesageResultLocator3));

                    String ActualResult = browserQA.findElement(MeesageResultLocator3).getText();
                    String ExcpectedResult = "تم إضافة البند الخارجي بنجاح.";

                    Assert.assertEquals(ActualResult , ExcpectedResult , "لم تتم إضافة البند  الخارجي بنجاح.");
                }
            }
        }
    }

    private By ExternalItemsLinkviewLocator = By.id("ctl00_PlaceHolderMain_gvSections_ctl02_lbtnItems");
    private By BTNBack1 = By.id("ctl00_PlaceHolderMain_ibtnBack");
    private By BTNBack2 = By.id("ctl00_PlaceHolderMain_ibtnBack");


    //مدير عام الامن والسلامة/ عرض البنود الخارجية
    @Test
    public void viewExI() throws InterruptedException {

        browserQA.manage().window().maximize();
        browserQA.manage().timeouts().pageLoadTimeout(5 , TimeUnit.SECONDS);

        WebElement FormMainMenuLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(FormMainMenuLoactor));
        FormMainMenuLoactorWait.click();

        WebElement FormStatusLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(FormStatusLocator));
        FormStatusLocatorWait.click();

        WebElement FormStatusSearchLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(FormStatusSearchLocator));
        FormStatusSearchLocatorWait.sendKeys("غير منشور" , Keys.ENTER);

        Thread.sleep(1000);

        Thread.sleep(1000);
        WebElement SearchLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachButtonLocator));
        SearchLoactorWait.click();

        WebElement BTNSectionsLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SectionsLinkLocator));
        BTNSectionsLocatorWait.click();

        WebElement ExternalItemsLinkviewWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ExternalItemsLinkviewLocator));
        ExternalItemsLinkviewWait.click();

        WebElement BTNBackWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(BTNBack1));
        BTNBackWait.click();

        WebElement BTNBack2Wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(BTNBack2));
        BTNBack2Wait.click();


    }

    private By EditExternalItemsLinkLocatore = By.id("ctl00_PlaceHolderMain_gvItems_ctl02_lbtnEdit");
    private By UpdateExternalItemsLinkLocatore = By.id("ctl00_PlaceHolderMain_gvItems_ctl02_lbtnUpdate");

    //مدير عام الامن والسلامة/ تعديل  البنود الخارجية
    @Test
    public void editExI() throws InterruptedException {

        browserQA.manage().window().maximize();
        browserQA.manage().timeouts().pageLoadTimeout(5 , TimeUnit.SECONDS);
        WebElement FormMainMenuLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(FormMainMenuLoactor));
        FormMainMenuLoactorWait.click();
        WebElement FormStatusLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(FormStatusLocator));
        FormStatusLocatorWait.click();
        WebElement FormStatusSearchLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(FormStatusSearchLocator));
        FormStatusSearchLocatorWait.sendKeys("غير منشور" , Keys.ENTER);
        Thread.sleep(1000);
        WebElement SerachButtonLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachButtonLocator));
        SerachButtonLocatorWait.click();
        WebElement SectionsLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SectionsLinkLocator));
        SectionsLinkLocatorWait.click();
        List SectionTableListDelet = browserQA.findElements(By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[1]/div[2]/div/div/table[1]/tbody/tr/td[1]"));

        int TableSizeForSections = SectionTableListDelet.size();

        if (TableSizeForSections <= 1) {

            By SectionDescLocator = By.id("ctl00_PlaceHolderMain_gvSections_ctl03_tbAddFormSectionDesc");
            WebElement SectionDescLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SectionDescLocator));
            SectionDescLocatorWait.sendKeys("Test");
            By AddLinkLocator = By.id("ctl00_PlaceHolderMain_gvSections_ctl03_lbtnAddFormSectionDesc");
            WebElement AddLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddLinkLocator));
            AddLinkLocatorWait.click();
            By ExternalLinkLocator = By.id("ctl00_PlaceHolderMain_gvSections_ctl02_lbtnItems");
            WebElement ExternalLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ExternalLinkLocator));
            ExternalLinkLocatorWait.click();

            By ExternalDescLocator = By.id("ctl00_PlaceHolderMain_gvItems_ctl03_tbAddFormItemDesc");
            WebElement ExternalDescLocatorWasit = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ExternalDescLocator));
            ExternalDescLocatorWasit.sendKeys("Test");

            By AddExternaLink = By.id("ctl00_PlaceHolderMain_gvItems_ctl03_lbtnAddFormItemDesc");
            WebElement AddExternaLinkWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddExternaLink));
            AddExternaLinkWait.click();


            By EditLink = By.id("ctl00_PlaceHolderMain_gvItems_ctl02_lbtnEdit");
            Thread.sleep(1000);

            WebElement EditLinkWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(EditLink));
            EditLinkWait.click();


            By UpdateLink = By.id("ctl00_PlaceHolderMain_gvItems_ctl02_lbtnUpdate");
            WebElement UpdateLinkWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(UpdateLink));
            UpdateLinkWait.click();


            By EditMessage = By.id("ctl00_PlaceHolderMain_lblOpertioanlResult");
            WebElement EditMessageWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(EditMessage));

            String EditActualREsult = browserQA.findElement(EditMessage).getText();
            String EditExcprctedResult = "تم تعديل البند الخارجي بنجاح.";

            if (EditActualREsult.equals("تم تعديل البند الخارجي بنجاح.")) {

                System.out.println("تم تعديل البند الخارجي بنجاح.");

            } else {
                Assert.assertEquals(EditActualREsult , EditExcprctedResult , "حدث خلل ");
            }
        } else {


            By ExternalLinkLocator = By.id("ctl00_PlaceHolderMain_gvSections_ctl02_lbtnItems");
            WebElement ExternalLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ExternalLinkLocator));
            ExternalLinkLocatorWait.click();

            List ExternalList = browserQA.findElements(By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[1]/div[2]/table/tbody/tr[2]/td/div/div/table[1]/tbody/tr/td[1]"));
            int ExternalListSize = ExternalList.size();

            if (ExternalListSize <= 1) {

                By ExternalDescLocator = By.id("ctl00_PlaceHolderMain_gvItems_ctl03_tbAddFormItemDesc");
                WebElement ExternalDescLocatorWasit = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ExternalDescLocator));
                ExternalDescLocatorWasit.sendKeys("Test");

                By AddExternaLink = By.id("ctl00_PlaceHolderMain_gvItems_ctl03_lbtnAddFormItemDesc");
                WebElement AddExternaLinkWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddExternaLink));
                AddExternaLinkWait.click();


                Thread.sleep(1000);

                By EditLink = By.id("ctl00_PlaceHolderMain_gvItems_ctl02_lbtnEdit");
                Thread.sleep(1000);

                WebElement EditLinkWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(EditLink));
                EditLinkWait.click();


                By UpdateLink = By.id("ctl00_PlaceHolderMain_gvItems_ctl02_lbtnUpdate");
                WebElement UpdateLinkWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(UpdateLink));
                UpdateLinkWait.click();


                By EditMessage = By.id("ctl00_PlaceHolderMain_lblOpertioanlResult");
                WebElement EditMessageWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(EditMessage));

                String EditActualREsult = browserQA.findElement(EditMessage).getText();
                String EditExcprctedResult = "تم تعديل البند الخارجي بنجاح.";

                if (EditActualREsult.equals("تم تعديل البند الخارجي بنجاح.")) {

                    System.out.println("تم تعديل البند الخارجي بنجاح.");

                } else {
                    Assert.assertEquals(EditActualREsult , EditExcprctedResult , "حدث خلل ");
                }


            } else {

                Thread.sleep(1000);

                By EditLink = By.id("ctl00_PlaceHolderMain_gvItems_ctl02_lbtnEdit");
                Thread.sleep(1000);

                WebElement EditLinkWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(EditLink));
                EditLinkWait.click();


                By UpdateLink = By.id("ctl00_PlaceHolderMain_gvItems_ctl02_lbtnUpdate");
                WebElement UpdateLinkWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(UpdateLink));
                UpdateLinkWait.click();


                By EditMessage = By.id("ctl00_PlaceHolderMain_lblOpertioanlResult");
                WebElement EditMessageWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(EditMessage));

                String EditActualREsult = browserQA.findElement(EditMessage).getText();
                String EditExcprctedResult = "تم تعديل البند الخارجي بنجاح.";

                if (EditActualREsult.equals("تم تعديل البند الخارجي بنجاح.")) {

                    System.out.println("تم تعديل البند الخارجي بنجاح.");

                } else {
                    Assert.assertEquals(EditActualREsult , EditExcprctedResult , "حدث خلل ");
                }


            }

        }
    }


    @Test
    //مدير عام الامن والسلامة حذف البنود الخارجية


    public void deleteExI() throws InterruptedException, IOException {

        browserQA.manage().window().maximize();
        browserQA.manage().timeouts().pageLoadTimeout(5 , TimeUnit.SECONDS);


        WebElement FormMainMenuLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(FormMainMenuLoactor));
        FormMainMenuLoactorWait.click();

        WebElement FormStatusLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(FormStatusLocator));
        FormStatusLocatorWait.click();

        WebElement FormStatusSearchLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(FormStatusSearchLocator));
        FormStatusSearchLocatorWait.sendKeys("غير منشور" , Keys.ENTER);

        Thread.sleep(1000);
        WebElement SerachButtonLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachButtonLocator));
        SerachButtonLocatorWait.click();

        WebElement SectionsLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SectionsLinkLocator));
        SectionsLinkLocatorWait.click();

        List SectionTableListDelet = browserQA.findElements(By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[1]/div[2]/div/div/table[1]/tbody/tr/td[1]"));

        int TableSizeForSections = SectionTableListDelet.size();

        if (TableSizeForSections <= 1) {

            By SectionDescLocator = By.id("ctl00_PlaceHolderMain_gvSections_ctl03_tbAddFormSectionDesc");
            WebElement SectionDescLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SectionDescLocator));
            SectionDescLocatorWait.sendKeys("Test");

            By AddLinkLocator = By.id("ctl00_PlaceHolderMain_gvSections_ctl03_lbtnAddFormSectionDesc");
            WebElement AddLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddLinkLocator));
            AddLinkLocatorWait.click();

            By ExternalLinkLocator = By.id("ctl00_PlaceHolderMain_gvSections_ctl02_lbtnItems");
            WebElement ExternalLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ExternalLinkLocator));
            ExternalLinkLocatorWait.click();

            By ExternalDescLocator = By.id("ctl00_PlaceHolderMain_gvItems_ctl03_tbAddFormItemDesc");
            WebElement ExternalDescLocatorWasit = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ExternalDescLocator));
            ExternalDescLocatorWasit.sendKeys("Test");

            By AddExternaLink = By.id("ctl00_PlaceHolderMain_gvItems_ctl03_lbtnAddFormItemDesc");
            WebElement AddExternaLinkWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddExternaLink));
            AddExternaLinkWait.click();


            By DeleteLink = By.id("ctl00_PlaceHolderMain_gvItems_ctl02_lbtnDelete");

            Thread.sleep(1000);

            WebElement DeleteLinkWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DeleteLink));
            DeleteLinkWait.click();

            By yes = By.id("ctl00_ibtnYes");
            WebElement yesWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(yes));
            yesWait.click();

            By DeleteMessage = By.id("ctl00_PlaceHolderMain_lblOpertioanlResult");
            WebElement DeleteMessageWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DeleteMessage));

            String DeleteActualREsult = browserQA.findElement(DeleteMessage).getText();
            String DeleteExcprctedResult = "تم حذف البند بنجاح.";

            if (DeleteActualREsult.equals("تم حذف البند بنجاح.")) {

                System.out.println("تم حذف البند بنجاح.");

            }
            if (DeleteActualREsult.equals("لا يمكن الحذف لان هناك بند داخلي مرتبط به.")) {
                System.out.println("لا يمكن الحذف لان هناك بند داخلي مرتبط به.");


            }

            if (DeleteActualREsult.equals("لا يمكن حذف البند  الخارجي لارتباطه بمحددات ادخال.")) {
                System.out.println("لا يمكن حذف البند  الخارجي لارتباطه بمحددات ادخال.");
            } else {
                Assert.assertEquals(DeleteActualREsult , DeleteExcprctedResult , "حدث خلل ");
            }
        } else {


            By ExternalLinkLocator = By.id("ctl00_PlaceHolderMain_gvSections_ctl02_lbtnItems");
            WebElement ExternalLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ExternalLinkLocator));
            ExternalLinkLocatorWait.click();

            List ExternalList = browserQA.findElements(By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[1]/div[2]/table/tbody/tr[2]/td/div/div/table[1]/tbody/tr/td[1]"));
            int ExternalListSize = ExternalList.size();

            if (ExternalListSize <= 1) {

                By ExternalDescLocator = By.id("ctl00_PlaceHolderMain_gvItems_ctl03_tbAddFormItemDesc");
                WebElement ExternalDescLocatorWasit = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ExternalDescLocator));
                ExternalDescLocatorWasit.sendKeys("Test");

                By AddExternaLink = By.id("ctl00_PlaceHolderMain_gvItems_ctl03_lbtnAddFormItemDesc");
                WebElement AddExternaLinkWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddExternaLink));
                AddExternaLinkWait.click();

                By DeleteLink = By.id("ctl00_PlaceHolderMain_gvItems_ctl02_lbtnDelete");

                Thread.sleep(1000);

                WebElement DeleteLinkWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DeleteLink));
                DeleteLinkWait.click();

                By yes = By.id("ctl00_ibtnYes");
                WebElement yesWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(yes));
                yesWait.click();

                By DeleteMessage = By.id("ctl00_PlaceHolderMain_lblOpertioanlResult");
                WebElement DeleteMessageWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DeleteMessage));

                String DeleteActualREsult = browserQA.findElement(DeleteMessage).getText();
                String DeleteExcprctedResult = "تم حذف البند بنجاح.";

                if (DeleteActualREsult.equals("تم حذف البند بنجاح.")) {

                    System.out.println("تم حذف البند بنجاح.");

                }
                if (DeleteActualREsult.equals("لا يمكن الحذف لان هناك بند داخلي مرتبط به.")) {
                    System.out.println("لا يمكن الحذف لان هناك بند داخلي مرتبط به.");


                }

                if (DeleteActualREsult.equals("لا يمكن حذف البند  الخارجي لارتباطه بمحددات ادخال.")) {
                    System.out.println("لا يمكن حذف البند  الخارجي لارتباطه بمحددات ادخال.");
                } else {
                    Assert.assertEquals(DeleteActualREsult , DeleteExcprctedResult , "حدث خلل ");
                }


            } else {
                By DeleteLink = By.id("ctl00_PlaceHolderMain_gvItems_ctl02_lbtnDelete");

                Thread.sleep(1000);

                WebElement DeleteLinkWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DeleteLink));
                DeleteLinkWait.click();

                By yes = By.id("ctl00_ibtnYes");
                WebElement yesWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(yes));
                yesWait.click();

                By DeleteMessage = By.id("ctl00_PlaceHolderMain_lblOpertioanlResult");
                WebElement DeleteMessageWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DeleteMessage));

                String DeleteActualREsult = browserQA.findElement(DeleteMessage).getText();
                String DeleteExcprctedResult = "تم حذف البند بنجاح.";

                if (DeleteActualREsult.equals("تم حذف البند بنجاح.")) {

                    System.out.println("تم حذف البند بنجاح.");

                } else if (DeleteActualREsult.equals("لا يمكن الحذف لان هناك بند داخلي مرتبط به.")) {
                    System.out.println("لا يمكن الحذف لان هناك بند داخلي مرتبط به.");


                } else if (DeleteActualREsult.equals("لا يمكن حذف البند  الخارجي لارتباطه بمحددات ادخال.")) {
                    System.out.println("لا يمكن حذف البند  الخارجي لارتباطه بمحددات ادخال.");
                } else {
                    Assert.assertEquals(DeleteActualREsult , DeleteExcprctedResult , "حدث خلل ");
                }


            }

        }
    }


}




