package NoorProject.EduWaveSafeAndSecurity.A1GeneralDirectorOfSchoolSecurityAndSafety.Forms.SectionsForm;

import NoorProject.EduWaveSafeAndSecurity.A1GeneralDirectorOfSchoolSecurityAndSafety.Forms.Forms.SafetyForms;
import com.sun.xml.internal.ws.api.model.ExceptionType;
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
import static NoorProject.Other.NoorLogin.loginFormLAbelLocator;
import static NoorProject.Other.NoorLogin.waitQA;

public class SectionsForms {


    private By SwitchProfileLocator = By.id("ctl00_oHeader_divSwitchUser");
    private By UserNameLabelLocator = By.linkText("مدير عام الأمن والسلامة المدرسية");
    private By FormMainMenuLoactor = By.id("divMenuItem_5968");
    private By FormStatusLocator = By.id("select2-ctl00_PlaceHolderMain_ddlFormStatus-container");
    private By FormStatusSearchLocator = By.xpath("/html/body/span/span/span[1]/input");
    private By SerachButtonLocator = By.id("ctl00_PlaceHolderMain_ibtnSearch");
    private By SectionsLinkLocator = By.id("ctl00_PlaceHolderMain_gvForms_ctl02_tdSections");


    @Test

    public void switchPrfile() {

        browserQA.manage().window().maximize();
        browserQA.manage().timeouts().pageLoadTimeout(5 , TimeUnit.SECONDS);

        WebElement SwitchProfileLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SwitchProfileLocator));
        SwitchProfileLocatorWait.click();

        WebElement UserLabelLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(UserNameLabelLocator));
        UserLabelLocatorWait.click();


    }


    //مدير عام الامن والسلامة/ أضافة الاقسام
    @Test
    public void addSections() throws InterruptedException {

        browserQA.manage().window().maximize();
        browserQA.manage().timeouts().pageLoadTimeout(5 , TimeUnit.SECONDS);

        WebElement FormMainMenuLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(FormMainMenuLoactor));
        FormMainMenuLoactorWait.click();

       /* WebElement FormStatusLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(FormStatusLocator));
        FormStatusLocatorWait.click();*/

        List FormTableSizeElse = browserQA.findElements(By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[3]/div[2]/div/div/table[1]/tbody/tr/td[1]"));
        int TableSizeNO1 = FormTableSizeElse.size();

        if (TableSizeNO1 <= 1) {

            System.out.println("No Data");
            SafetyForms AddNewForms = new SafetyForms();
            AddNewForms.addSafetyForms();

            WebElement FormStatusLocatorWaitg = waitQA.until(ExpectedConditions.visibilityOfElementLocated(FormStatusLocator));
            FormStatusLocatorWaitg.click();

            WebElement FormStatusSearchLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(FormStatusSearchLocator));
            FormStatusSearchLocatorWait.sendKeys("غير منشور" , Keys.ENTER);

            Thread.sleep(1000);
            WebElement SerachButtonLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachButtonLocator));
            SerachButtonLocatorWait.click();

            WebElement SectionsLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SectionsLinkLocator));
            SectionsLinkLocatorWait.click();
            List SectionTableList = browserQA.findElements(By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[1]/div[2]/div/div/table[1]/tbody/tr/td[1]"));

            int TableSize = SectionTableList.size();

            if (TableSize <= 1) {
                int TableSizeAdd = SectionTableList.size() + 2;
                String TableSizeAddFormat = String.format("%02d" , TableSizeAdd);
                System.out.println("TableSizeAdd::" + TableSizeAdd);
                System.out.println("TableSizeAddFormat::" + TableSizeAddFormat);

                By SectionDescrptionSplit = By.id("ctl00_PlaceHolderMain_gvSections_ctl" + TableSizeAddFormat + "_tbAddFormSectionDesc");
                Random Rand = new Random();
                int RandomNumber = Rand.nextInt(1000000);

                WebElement SectionDescrptionWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SectionDescrptionSplit));

                SectionDescrptionWait.sendKeys("Rami" + RandomNumber);

                By AddLinkSpilt = By.id("ctl00_PlaceHolderMain_gvSections_ctl" + TableSizeAddFormat + "_lbtnAddFormSectionDesc");

                WebElement AddLinkWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddLinkSpilt));
                AddLinkWait.click();

                By AddSectionsMessageLocator = By.id("ctl00_PlaceHolderMain_lblOpertioanlResult");

                WebElement AddSectionsMessageLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddSectionsMessageLocator));

                String ActualResult = browserQA.findElement(AddSectionsMessageLocator).getText();
                String ExcpectedResult = "تم إضافة القسم بنجاح.";

                Assert.assertEquals(ActualResult , ExcpectedResult , "لم تتم عملية اضافة القسم بنجاح");
            }
            if (TableSize >= 2 && TableSize < 22) {

                int TableSizeAdd = SectionTableList.size() + 1;
                String TableSizeAddFormat = String.format("%02d" , TableSizeAdd);
                System.out.println("TableSizeAdd::" + TableSizeAdd);
                System.out.println("TableSizeAddFormat::" + TableSizeAddFormat);

                By SectionDescrptionSplit = By.id("ctl00_PlaceHolderMain_gvSections_ctl" + TableSizeAddFormat + "_tbAddFormSectionDesc");

                Random Rand = new Random();
                int RandomNumber = Rand.nextInt(1000000);

                WebElement SectionDescrptionWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SectionDescrptionSplit));

                SectionDescrptionWait.sendKeys("Rami" + RandomNumber);

                By AddLinkSpilt = By.id("ctl00_PlaceHolderMain_gvSections_ctl" + TableSizeAddFormat + "_lbtnAddFormSectionDesc");

                WebElement AddLinkWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddLinkSpilt));
                AddLinkWait.click();

                By AddSectionsMessageLocator = By.id("ctl00_PlaceHolderMain_lblOpertioanlResult");

                WebElement AddSectionsMessageLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddSectionsMessageLocator));

                String ActualResult = browserQA.findElement(AddSectionsMessageLocator).getText();
                String ExcpectedResult = "تم إضافة القسم بنجاح.";

                Assert.assertEquals(ActualResult , ExcpectedResult , "لم تتم عملية اضافة القسم بنجاح");

            }
            if (TableSize >= 22) {

                int TableSizeAdd = SectionTableList.size();
                String TableSizeAddFormat = String.format("%02d" , TableSizeAdd);
                System.out.println("TableSizeAdd::" + TableSizeAdd);
                System.out.println("TableSizeAddFormat::" + TableSizeAddFormat);

                By SectionDescrptionSplit = By.id("ctl00_PlaceHolderMain_gvSections_ctl" + TableSizeAddFormat + "_tbAddFormSectionDesc");
                Random Rand = new Random();
                int RandomNumber = Rand.nextInt(1000000);

                WebElement SectionDescrptionWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SectionDescrptionSplit));

                SectionDescrptionWait.sendKeys("Rami" + RandomNumber);

                By AddLinkSpilt = By.id("ctl00_PlaceHolderMain_gvSections_ctl" + TableSizeAddFormat + "_lbtnAddFormSectionDesc");

                WebElement AddLinkWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddLinkSpilt));
                AddLinkWait.click();

                By AddSectionsMessageLocator = By.id("ctl00_PlaceHolderMain_lblOpertioanlResult");

                WebElement AddSectionsMessageLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddSectionsMessageLocator));

                String ActualResult = browserQA.findElement(AddSectionsMessageLocator).getText();
                String ExcpectedResult = "تم إضافة القسم بنجاح.";

                Assert.assertEquals(ActualResult , ExcpectedResult , "لم تتم عملية اضافة القسم بنجاح");

            }


        } else {
            System.out.println("Thers in Datra");

            WebElement FormStatusLocatorWaitg = waitQA.until(ExpectedConditions.visibilityOfElementLocated(FormStatusLocator));
            FormStatusLocatorWaitg.click();

            WebElement FormStatusSearchLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(FormStatusSearchLocator));
            FormStatusSearchLocatorWait.sendKeys("غير منشور" , Keys.ENTER);

            Thread.sleep(1000);
            WebElement SerachButtonLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachButtonLocator));
            SerachButtonLocatorWait.click();

            WebElement SectionsLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SectionsLinkLocator));
            SectionsLinkLocatorWait.click();
            List SectionTableList = browserQA.findElements(By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[1]/div[2]/div/div/table[1]/tbody/tr/td[1]"));

            int TableSize = SectionTableList.size();

            if (TableSize <= 1) {
                int TableSizeAdd = SectionTableList.size() + 2;
                String TableSizeAddFormat = String.format("%02d" , TableSizeAdd);
                System.out.println("TableSizeAdd::" + TableSizeAdd);
                System.out.println("TableSizeAddFormat::" + TableSizeAddFormat);

                By SectionDescrptionSplit = By.id("ctl00_PlaceHolderMain_gvSections_ctl" + TableSizeAddFormat + "_tbAddFormSectionDesc");
                Random Rand = new Random();
                int RandomNumber = Rand.nextInt(1000000);

                WebElement SectionDescrptionWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SectionDescrptionSplit));

                SectionDescrptionWait.sendKeys("Rami" + RandomNumber);

                By AddLinkSpilt = By.id("ctl00_PlaceHolderMain_gvSections_ctl" + TableSizeAddFormat + "_lbtnAddFormSectionDesc");

                WebElement AddLinkWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddLinkSpilt));
                AddLinkWait.click();

                By AddSectionsMessageLocator = By.id("ctl00_PlaceHolderMain_lblOpertioanlResult");

                WebElement AddSectionsMessageLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddSectionsMessageLocator));

                String ActualResult = browserQA.findElement(AddSectionsMessageLocator).getText();
                String ExcpectedResult = "تم إضافة القسم بنجاح.";

                Assert.assertEquals(ActualResult , ExcpectedResult , "لم تتم عملية اضافة القسم بنجاح");
            }
            if (TableSize >= 2 && TableSize < 22) {

                int TableSizeAdd = SectionTableList.size() + 1;
                String TableSizeAddFormat = String.format("%02d" , TableSizeAdd);
                System.out.println("TableSizeAdd::" + TableSizeAdd);
                System.out.println("TableSizeAddFormat::" + TableSizeAddFormat);

                By SectionDescrptionSplit = By.id("ctl00_PlaceHolderMain_gvSections_ctl" + TableSizeAddFormat + "_tbAddFormSectionDesc");

                Random Rand = new Random();
                int RandomNumber = Rand.nextInt(1000000);

                WebElement SectionDescrptionWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SectionDescrptionSplit));

                SectionDescrptionWait.sendKeys("Rami" + RandomNumber);

                By AddLinkSpilt = By.id("ctl00_PlaceHolderMain_gvSections_ctl" + TableSizeAddFormat + "_lbtnAddFormSectionDesc");

                WebElement AddLinkWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddLinkSpilt));
                AddLinkWait.click();

                By AddSectionsMessageLocator = By.id("ctl00_PlaceHolderMain_lblOpertioanlResult");

                WebElement AddSectionsMessageLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddSectionsMessageLocator));

                String ActualResult = browserQA.findElement(AddSectionsMessageLocator).getText();
                String ExcpectedResult = "تم إضافة القسم بنجاح.";

                Assert.assertEquals(ActualResult , ExcpectedResult , "لم تتم عملية اضافة القسم بنجاح");

            }
            if (TableSize >= 22) {

                int TableSizeAdd = SectionTableList.size();
                String TableSizeAddFormat = String.format("%02d" , TableSizeAdd);
                System.out.println("TableSizeAdd::" + TableSizeAdd);
                System.out.println("TableSizeAddFormat::" + TableSizeAddFormat);

                By SectionDescrptionSplit = By.id("ctl00_PlaceHolderMain_gvSections_ctl" + TableSizeAddFormat + "_tbAddFormSectionDesc");
                Random Rand = new Random();
                int RandomNumber = Rand.nextInt(1000000);

                WebElement SectionDescrptionWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SectionDescrptionSplit));

                SectionDescrptionWait.sendKeys("Rami" + RandomNumber);

                By AddLinkSpilt = By.id("ctl00_PlaceHolderMain_gvSections_ctl" + TableSizeAddFormat + "_lbtnAddFormSectionDesc");

                WebElement AddLinkWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddLinkSpilt));
                AddLinkWait.click();

                By AddSectionsMessageLocator = By.id("ctl00_PlaceHolderMain_lblOpertioanlResult");

                WebElement AddSectionsMessageLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddSectionsMessageLocator));

                String ActualResult = browserQA.findElement(AddSectionsMessageLocator).getText();
                String ExcpectedResult = "تم إضافة القسم بنجاح.";

                Assert.assertEquals(ActualResult , ExcpectedResult , "لم تتم عملية اضافة القسم بنجاح");
            }


        }
    }

    private By BTNBack = By.id("ctl00_PlaceHolderMain_ibtnBack");

    //مدير عام الامن والسلامة/ عرض الاقسام الاقسام
    @Test
    public void viewSections() throws InterruptedException {

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

        WebElement BTNBackWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(BTNBack));
        BTNBackWait.click();

    }


    private By EditLinkLocator = By.id("ctl00_PlaceHolderMain_gvSections_ctl02_lbtnEdit");
    private By SaveLinkLocator = By.id("ctl00_PlaceHolderMain_gvSections_ctl02_lbtnUpdate");

    //مدير عام الامن والسلامة/ تعديل الاقسام الاقسام
    @Test
    public void editSections() throws InterruptedException {

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

        WebElement EditLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(EditLinkLocator));
        EditLinkLocatorWait.click();

        By SectionDescLoactor = By.id("ctl00_PlaceHolderMain_gvSections_ctl02_tbFormSectionDesc");
        Random Rand = new Random();
        int RandomNumber = Rand.nextInt(1000000);

        WebElement SectionDescLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SectionDescLoactor));
        SectionDescLoactorWait.clear();
        SectionDescLoactorWait.sendKeys("Rami" + RandomNumber);


        WebElement SaveLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SaveLinkLocator));
        SaveLinkLocatorWait.click();

        By MessgaeLocator = By.id("ctl00_PlaceHolderMain_lblOpertioanlResult");

        WebElement MessgaeLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(MessgaeLocator));

        String ActualResult = browserQA.findElement(MessgaeLocator).getText();
        String ExcpectedResult = "تم تعديل القسم بنجاح.";

        Assert.assertEquals(ActualResult , ExcpectedResult , "لم تتم عملية التعديل بنجاح");


    }

    private By DeleteLinkLocator = By.id("ctl00_PlaceHolderMain_gvSections_ctl02_lbtnDelete");
    private By YesConfrmationLocator = By.id("ctl00_ibtnYes");

    //مدير عام الامن والسلامة حذف الاقسام
    @Test

    public void deleteSections() throws InterruptedException, IOException {


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

        List SectionTableSize = browserQA.findElements(By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[1]/div[2]/div/div/table[1]/tbody/tr/td[1]"));
        int TableSizeDotSize = SectionTableSize.size();


        if (TableSizeDotSize == (1)) {


            By SectionDescLocator = By.id("ctl00_PlaceHolderMain_gvSections_ctl03_tbAddFormSectionDesc");
            WebElement SectionDescLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SectionDescLocator));
            SectionDescLocatorWait.sendKeys("Rami");

            By AddLinkLocator = By.id("ctl00_PlaceHolderMain_gvSections_ctl03_lbtnAddFormSectionDesc");
            WebElement AddLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddLinkLocator));
            AddLinkLocatorWait.click();

            WebElement DeleteLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DeleteLinkLocator));
            DeleteLinkLocatorWait.click();

            WebElement YesConfrmationLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(YesConfrmationLocator));
            YesConfrmationLocatorWait.click();

            By MessageLocator = By.id("ctl00_PlaceHolderMain_lblOpertioanlResult");

            WebElement MessageLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(MessageLocator));

            String ActualResult = browserQA.findElement(MessageLocator).getText();
            String ExpectedResult = "تم حذف القسم بنجاح.";


            if (ActualResult.equals("لايمكن الحذف لارتباطه ببند خارجي.")) {

                System.out.println("لايمكن الحذف لارتباطه ببند خارجي.");
            }

            if (ActualResult.equals("تم حذف القسم بنجاح.")) {

                System.out.println("تم حذف القسم بنجاح.");

            }
            if (!ActualResult.equals("لايمكن الحذف لارتباطه ببند خارجي.") && !ActualResult.equals(ExpectedResult)) {

                TakesScreenshot Ts = (TakesScreenshot) browserQA;
                File Src = Ts.getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(Src , new File("src/test/resc/TakeScreenShot/DeleteSection.png"));

                Assert.fail("حدث خلل لعميلة الحذف");

            }


        } else {

            WebElement DeleteLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DeleteLinkLocator));
            DeleteLinkLocatorWait.click();

            WebElement YesConfrmationLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(YesConfrmationLocator));
            YesConfrmationLocatorWait.click();

            By MessageLocator = By.id("ctl00_PlaceHolderMain_lblOpertioanlResult");

            WebElement MessageLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(MessageLocator));

            String ActualResult = browserQA.findElement(MessageLocator).getText();
            String ExpectedResult = "تم حذف القسم بنجاح.";


            if (ActualResult.equals("لايمكن الحذف لارتباطه ببند خارجي.")) {

                System.out.println("لايمكن الحذف لارتباطه ببند خارجي.");
            }

            if (ActualResult.equals("تم حذف القسم بنجاح.")) {

                System.out.println("تم حذف القسم بنجاح.");

            }
            if (!ActualResult.equals("لايمكن الحذف لارتباطه ببند خارجي.")&& !ActualResult.equals(ExpectedResult)) {




                TakesScreenshot Ts = (TakesScreenshot) browserQA;
                File Src = Ts.getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(Src , new File("src/test/resc/TakeScreenShot/DeleteSection.png"));


                System.out.println("حدث خلل في عملية الحذف");
                System.out.println(ActualResult);



            }


        }


    }

}

