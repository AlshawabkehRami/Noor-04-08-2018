package NoorProject.EduWaveSafeAndSecurity.A1GeneralDirectorOfSchoolSecurityAndSafety.Forms.ExternalItems;

import NoorProject.EduWaveSafeAndSecurity.A1GeneralDirectorOfSchoolSecurityAndSafety.Forms.Forms.SafetyForms;
import NoorProject.EduWaveSafeAndSecurity.A1GeneralDirectorOfSchoolSecurityAndSafety.Forms.SectionsForm.SectionsForms;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static NoorProject.Other.NoorLogin.browserQA;
import static NoorProject.Other.NoorLogin.waitQA;

public class ExternalItems {

    private By SwitchProfileLocator = By.id("ctl00_oHeader_divSwitchUser");
    private By UserNameLabelLocator = By.linkText("مدير عام الأمن والسلامة المدرسية");
    private By FormMainMenuLoactor = By.id("divMenuItem_5968");
    private By FormStatusLocator = By.id("select2-ctl00_PlaceHolderMain_ddlFormStatus-container");
    private By FormStatusSearchLocator = By.xpath("/html/body/span/span/span[1]/input");
    private By SerachButtonLocator = By.id("ctl00_PlaceHolderMain_ibtnSearch");
    private By SectionsLinkLocator = By.id("ctl00_PlaceHolderMain_gvForms_ctl02_tdSections");


    @Test

    public void LoginUserAndSwitchProfileAdminEX() {

        browserQA.manage().window().maximize();
        browserQA.manage().timeouts().pageLoadTimeout(5 , TimeUnit.SECONDS);

        WebElement SwitchProfileLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SwitchProfileLocator));
        SwitchProfileLocatorWait.click();

        WebElement UserLabelLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(UserNameLabelLocator));
        UserLabelLocatorWait.click();


    }


    //مدير عام الامن والسلامة/ أضافة البنود الخارجية
    @Test
    public void addExternalItems() throws InterruptedException {

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
            AddSection.addSectionsToTheForm();
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
    public void viewExternalItems() throws InterruptedException {

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
    public void editExternalItems() throws InterruptedException {

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

        WebElement ExternalItemsLinkviewWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ExternalItemsLinkviewLocator));
        ExternalItemsLinkviewWait.click();


        WebElement EditExternalItemsLinkLocatoreWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(EditExternalItemsLinkLocatore));
        EditExternalItemsLinkLocatoreWait.click();

        By SectionDescLoactor = By.id("ctl00_PlaceHolderMain_gvItems_ctl02_tbFormItemDesc");
        Random Rand = new Random();
        int RandomNumber = Rand.nextInt(1000000);

        WebElement SectionDescLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SectionDescLoactor));
        SectionDescLoactorWait.clear();
        SectionDescLoactorWait.sendKeys("Rami" + RandomNumber);

        WebElement UpdateExternalItemsLinkLocatoreWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(UpdateExternalItemsLinkLocatore));
        UpdateExternalItemsLinkLocatoreWait.click();


        By MessgaeLocator = By.id("ctl00_PlaceHolderMain_lblOpertioanlResult");

        WebElement MessgaeLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(MessgaeLocator));

        String ActualResult = browserQA.findElement(MessgaeLocator).getText();
        String ExcpectedResult = "تم تعديل البند الخارجي بنجاح.";

        Assert.assertEquals(ActualResult , ExcpectedResult , "لم تتم عملية التعديل بنجاح");


    }


    @Test
    //مدير عام الامن والسلامة حذف البنود الخارجية


    public void deleteExternalItems() throws InterruptedException {
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

        WebElement ExternalItemsLinkviewWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ExternalItemsLinkviewLocator));
        ExternalItemsLinkviewWait.click();

        By DeleteExternalItemsLocator = By.id("ctl00_PlaceHolderMain_gvItems_ctl02_lbtnDelete");
        By YesConfrmationLocator = By.id("ctl00_ibtnYes");

        WebElement DeleteExternalItemsLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DeleteExternalItemsLocator));
        DeleteExternalItemsLocatorWait.click();

        WebElement YesConfrmationLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(YesConfrmationLocator));
        YesConfrmationLocatorWait.click();

        By MessageLocator = By.id("ctl00_PlaceHolderMain_lblOpertioanlResult");

        WebElement MessageLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(MessageLocator));

        String ActualResult = browserQA.findElement(MessageLocator).getText();
        String ExcpectedReeult = "تم حذف البند بنجاح.";
        if (ActualResult.equals("لا يمكن الحذف لان هناك بند داخلي مرتبط به.")) {

            System.out.println("لا يمكن الحذف لان هناك بند داخلي مرتبط به.");

        }
        if (ActualResult.equals(ExcpectedReeult)) {

            System.out.println("تمت عملية الحذف بنجاح");
        }
        if (!ActualResult.equals("لا يمكن الحذف لان هناك بند داخلي مرتبط به.") || !ActualResult.equals(ExcpectedReeult)) {

            Assert.fail("حدث خلل في عملية الحذف");
        }


    }


}
