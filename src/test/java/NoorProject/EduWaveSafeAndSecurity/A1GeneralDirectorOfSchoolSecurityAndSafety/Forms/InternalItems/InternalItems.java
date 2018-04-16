/*
 * Created By  Rami AlShawabkeh  4/8/18 11:16 AM
 */

package NoorProject.EduWaveSafeAndSecurity.A1GeneralDirectorOfSchoolSecurityAndSafety.Forms.InternalItems;

import NoorProject.EduWaveSafeAndSecurity.A1GeneralDirectorOfSchoolSecurityAndSafety.Forms.ExternalItems.ExternalItems;
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

public class InternalItems {


    private By SwitchProfileLocator = By.id("ctl00_oHeader_divSwitchUser");
    private By UserNameLabelLocator = By.linkText("مدير عام الأمن والسلامة المدرسية");
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


    @Test
    public void addInternalItems() throws InterruptedException {

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

        List SectionTableList = browserQA.findElements(By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[1]/div[2]/div/div/table[1]/tbody/tr/td[1]"));

        int TableSizeForSections = SectionTableList.size();

        if (TableSizeForSections <= 1) {

            SectionsForms AddSections = new SectionsForms();
            AddSections.addSections();
        }
        By ExternalItemsLocator = By.id("ctl00_PlaceHolderMain_gvSections_ctl02_lbtnItems");

        WebElement ExternalItemsWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ExternalItemsLocator));
        ExternalItemsWait.click();

        List ExternalItemsTableList = browserQA.findElements(By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[1]/div[2]/table/tbody/tr[2]/td/div/div/table[1]/tbody/tr/td[1]"));

        int ExternalItemsTableSize = ExternalItemsTableList.size();
        if (ExternalItemsTableSize <= 1) {

            ExternalItems AddExternalItems = new ExternalItems();
            AddExternalItems.addExI();
        }

        By InternalItemsLocator = By.id("ctl00_PlaceHolderMain_gvItems_ctl02_lbtnInternalItems");

        WebElement InternalItemsLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(InternalItemsLocator));
        InternalItemsLocatorWait.click();

        List InternalItemsList = browserQA.findElements(By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[1]/div[2]/table/tbody/tr[2]/td/div/div/table[1]/tbody/tr/td[1]"));

        int InternalItemsListSize = InternalItemsList.size();

        if (InternalItemsListSize <= 1) {

            int InternalItemsListSizeAdd1 = InternalItemsList.size() + 2;
            String InternalItemsListSizeAdd1Format = String.format("%02d" , InternalItemsListSizeAdd1);


            By InternalItemsDesc1 = By.id("ctl00_PlaceHolderMain_gvInternalItems_ctl" + InternalItemsListSizeAdd1Format + "_tbAddFormInternalItemDesc");
            Random Rand = new Random();
            int RandomNumber = Rand.nextInt(1000000);

            WebElement InternalItemsDesc1Wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(InternalItemsDesc1));
            InternalItemsDesc1Wait.sendKeys("بند داخلي" + RandomNumber);

            By AddEvaluationWeightLocator = By.id("ctl00_PlaceHolderMain_gvInternalItems_ctl" + InternalItemsListSizeAdd1Format + "_tbAddEvaluationWeight");

            WebElement AddEvaluationWeightLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddEvaluationWeightLocator));
            AddEvaluationWeightLocatorWait.sendKeys("10");

            By AddLink = By.id("ctl00_PlaceHolderMain_gvInternalItems_ctl" + InternalItemsListSizeAdd1Format + "_lbtnAddFormInternalItem");

            WebElement AddLinkWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddLink));
            AddLinkWait.click();

            By AddValidationMessageLocator = By.id("ctl00_PlaceHolderMain_lblOpertioanlResult");

            WebElement AddValidationMessageLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddValidationMessageLocator));

            String ActualResultAdd1 = browserQA.findElement(AddValidationMessageLocator).getText();
            String ExcpectedResultAdd1 = "تم إضافة البند الداخلي بنجاح.";

            Assert.assertEquals(ActualResultAdd1 , ExcpectedResultAdd1 , "لم تتم عملية اضافة البند الداخلي بنجاح");


        }
        if (InternalItemsListSize >= 2 && InternalItemsListSize < 22) {


            int InternalItemsListSizeAdd2 = InternalItemsList.size() + 1;
            String InternalItemsListSizeAdd1Format = String.format("%02d" , InternalItemsListSizeAdd2);


            By InternalItemsDesc2 = By.id("ctl00_PlaceHolderMain_gvInternalItems_ctl" + InternalItemsListSizeAdd1Format + "_tbAddFormInternalItemDesc");
            Random Rand = new Random();
            int RandomNumber = Rand.nextInt(1000000);

            WebElement InternalItemsDesc2Wait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(InternalItemsDesc2));
            InternalItemsDesc2Wait.sendKeys("بند داخلي" + RandomNumber);

            By AddEvaluationWeightLocator2 = By.id("ctl00_PlaceHolderMain_gvInternalItems_ctl" + InternalItemsListSizeAdd1Format + "_tbAddEvaluationWeight");

            WebElement AddEvaluationWeightLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddEvaluationWeightLocator2));
            AddEvaluationWeightLocatorWait.sendKeys("10");

            By AddLink2 = By.id("ctl00_PlaceHolderMain_gvInternalItems_ctl" + InternalItemsListSizeAdd1Format + "_lbtnAddFormInternalItem");

            WebElement AddLinkWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddLink2));
            AddLinkWait.click();

            By AddValidationMessageLocator2 = By.id("ctl00_PlaceHolderMain_lblOpertioanlResult");

            WebElement AddValidationMessageLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddValidationMessageLocator2));

            String ActualResultAdd1 = browserQA.findElement(AddValidationMessageLocator2).getText();
            String ExcpectedResultAdd1 = "تم إضافة البند الداخلي بنجاح.";

            Assert.assertEquals(ActualResultAdd1 , ExcpectedResultAdd1 , "لم تتم عملية اضافة البند الداخلي بنجاح");


        }


        if (InternalItemsListSize >= 22) {


            int InternalItemsListSizeAdd3 = InternalItemsList.size();
            String InternalItemsListSizeAdd1Format3 = String.format("%02d" , InternalItemsListSizeAdd3);


            By InternalItemsDesc2 = By.id("ctl00_PlaceHolderMain_gvInternalItems_ctl" + InternalItemsListSizeAdd1Format3 + "_tbAddFormInternalItemDesc");
            Random Rand = new Random();
            int RandomNumber = Rand.nextInt(1000000);

            WebElement InternalItemsDesc2Wait3 = waitQA.until(ExpectedConditions.visibilityOfElementLocated(InternalItemsDesc2));
            InternalItemsDesc2Wait3.sendKeys("بند داخلي" + RandomNumber);

            By AddEvaluationWeightLocator23 = By.id("ctl00_PlaceHolderMain_gvInternalItems_ctl" + InternalItemsListSizeAdd1Format3 + "_tbAddEvaluationWeight");

            WebElement AddEvaluationWeightLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddEvaluationWeightLocator23));
            AddEvaluationWeightLocatorWait.sendKeys("10");

            By AddLink23 = By.id("ctl00_PlaceHolderMain_gvInternalItems_ctl" + InternalItemsListSizeAdd1Format3 + "_lbtnAddFormInternalItem");

            WebElement AddLinkWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddLink23));
            AddLinkWait.click();

            By AddValidationMessageLocator23 = By.id("ctl00_PlaceHolderMain_lblOpertioanlResult");

            WebElement AddValidationMessageLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddValidationMessageLocator23));

            String ActualResultAdd1 = browserQA.findElement(AddValidationMessageLocator23).getText();
            String ExcpectedResultAdd1 = "تم إضافة البند الداخلي بنجاح.";

            Assert.assertEquals(ActualResultAdd1 , ExcpectedResultAdd1 , "لم تتم عملية اضافة البند الداخلي بنجاح");


        }
        //}
    }


    @Test

    public void deleteInternalItems() throws InterruptedException {
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

//-----------------------------------------------------------------------------------------------
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

            By InternalLink = By.id("ctl00_PlaceHolderMain_gvItems_ctl02_lbtnInternalItems");

            WebElement InternalLinkWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(InternalLink));
            InternalLinkWait.click();

            By AddFormInternalItemDesc = By.id("ctl00_PlaceHolderMain_gvInternalItems_ctl03_tbAddFormInternalItemDesc");
            By AddEvaluationWeight = By.id("ctl00_PlaceHolderMain_gvInternalItems_ctl03_tbAddEvaluationWeight");
            By AddFormInternalItem = By.id("ctl00_PlaceHolderMain_gvInternalItems_ctl03_lbtnAddFormInternalItem");
            By lbtnDelete = By.id("ctl00_PlaceHolderMain_gvInternalItems_ctl02_lbtnDelete");

            Thread.sleep(1000);

            WebElement AddFormInternalItemDescWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddFormInternalItemDesc));
            AddFormInternalItemDescWait.sendKeys("Test");
            WebElement AddEvaluationWeightWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddEvaluationWeight));
            AddEvaluationWeightWait.sendKeys("10");
            WebElement AddFormInternalItemWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddFormInternalItem));
            AddFormInternalItemWait.click();
            WebElement lbtnDeleteWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(lbtnDelete));
            lbtnDeleteWait.click();

            By yes = By.id("ctl00_ibtnYes");
            WebElement yesWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(yes));
            yesWait.click();

            By DeleteMessage = By.id("ctl00_PlaceHolderMain_lblOpertioanlResult");
            WebElement DeleteMessageWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DeleteMessage));

            String DeleteActualREsult = browserQA.findElement(DeleteMessage).getText();
            String DeleteExcprctedResult = "تم حذف البند الداخلي بنجاح.";


            if (DeleteActualREsult.equals(DeleteExcprctedResult)) {

                System.out.println("تم حذف البند الداخلي بنجاح.");
            }

            if (!DeleteActualREsult.equals(DeleteExcprctedResult)) {

                Assert.fail();

            }

        }
        //-----------------------------------------------------------------------------------------------

//yes
        else {

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

                By InternalLink = By.id("ctl00_PlaceHolderMain_gvItems_ctl02_lbtnInternalItems");

                WebElement InternalLinkWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(InternalLink));
                InternalLinkWait.click();
                By AddFormInternalItemDesc = By.id("ctl00_PlaceHolderMain_gvInternalItems_ctl03_tbAddFormInternalItemDesc");
                By AddEvaluationWeight = By.id("ctl00_PlaceHolderMain_gvInternalItems_ctl03_tbAddEvaluationWeight");
                By AddFormInternalItem = By.id("ctl00_PlaceHolderMain_gvInternalItems_ctl03_lbtnAddFormInternalItem");
                By lbtnDelete = By.id("ctl00_PlaceHolderMain_gvInternalItems_ctl02_lbtnDelete");

                Thread.sleep(1000);

                WebElement AddFormInternalItemDescWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddFormInternalItemDesc));
                AddFormInternalItemDescWait.sendKeys("Test");
                WebElement AddEvaluationWeightWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddEvaluationWeight));
                AddEvaluationWeightWait.sendKeys("10");
                WebElement AddFormInternalItemWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddFormInternalItem));
                AddFormInternalItemWait.click();
                WebElement lbtnDeleteWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(lbtnDelete));
                lbtnDeleteWait.click();

                By yes = By.id("ctl00_ibtnYes");
                WebElement yesWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(yes));
                yesWait.click();

                By DeleteMessage = By.id("ctl00_PlaceHolderMain_lblOpertioanlResult");
                WebElement DeleteMessageWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DeleteMessage));

                String DeleteActualREsult = browserQA.findElement(DeleteMessage).getText();
                String DeleteExcprctedResult = "تم حذف البند الداخلي بنجاح.";


                if (DeleteActualREsult.equals(DeleteExcprctedResult)) {

                    System.out.println("تم حذف البند الداخلي بنجاح.");
                }

                if (!DeleteActualREsult.equals(DeleteExcprctedResult)) {

                    Assert.fail();

                }


            }
//yes
            else {


                By InternalLink = By.id("ctl00_PlaceHolderMain_gvItems_ctl02_lbtnInternalItems");

                WebElement InternalLinkWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(InternalLink));
                InternalLinkWait.click();


                List InternalList = browserQA.findElements(By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[1]/div[2]/table/tbody/tr[2]/td/div/div/table[1]/tbody/tr/td[1]"));
                int InternalListSize = InternalList.size();

                if (InternalListSize <= 1) {
                    By AddFormInternalItemDesc = By.id("ctl00_PlaceHolderMain_gvInternalItems_ctl03_tbAddFormInternalItemDesc");
                    By AddEvaluationWeight = By.id("ctl00_PlaceHolderMain_gvInternalItems_ctl03_tbAddEvaluationWeight");
                    By AddFormInternalItem = By.id("ctl00_PlaceHolderMain_gvInternalItems_ctl03_lbtnAddFormInternalItem");
                    By lbtnDelete = By.id("ctl00_PlaceHolderMain_gvInternalItems_ctl02_lbtnDelete");

                    Thread.sleep(1000);

                    WebElement AddFormInternalItemDescWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddFormInternalItemDesc));
                    AddFormInternalItemDescWait.sendKeys("Test");
                    WebElement AddEvaluationWeightWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddEvaluationWeight));
                    AddEvaluationWeightWait.sendKeys("10");
                    WebElement AddFormInternalItemWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddFormInternalItem));
                    AddFormInternalItemWait.click();
                    WebElement lbtnDeleteWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(lbtnDelete));
                    lbtnDeleteWait.click();

                    By yes = By.id("ctl00_ibtnYes");
                    WebElement yesWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(yes));
                    yesWait.click();

                    By DeleteMessage = By.id("ctl00_PlaceHolderMain_lblOpertioanlResult");
                    WebElement DeleteMessageWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DeleteMessage));

                    String DeleteActualREsult = browserQA.findElement(DeleteMessage).getText();
                    String DeleteExcprctedResult = "تم حذف البند الداخلي بنجاح.";


                    if (DeleteActualREsult.equals(DeleteExcprctedResult)) {

                        System.out.println("تم حذف البند الداخلي بنجاح.");
                    }

                    if (!DeleteActualREsult.equals(DeleteExcprctedResult)) {

                        Assert.fail();

                    }

                } else {
                    By lbtnDelete = By.id("ctl00_PlaceHolderMain_gvInternalItems_ctl02_lbtnDelete");

                    WebElement lbtnDeleteWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(lbtnDelete));
                    lbtnDeleteWait.click();

                    By yes = By.id("ctl00_ibtnYes");
                    WebElement yesWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(yes));
                    yesWait.click();

                    By DeleteMessage = By.id("ctl00_PlaceHolderMain_lblOpertioanlResult");
                    WebElement DeleteMessageWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DeleteMessage));

                    String DeleteActualREsult = browserQA.findElement(DeleteMessage).getText();
                    String DeleteExcprctedResult = "تم حذف البند الداخلي بنجاح.";


                    if (DeleteActualREsult.equals(DeleteExcprctedResult)) {

                        System.out.println("تم حذف البند الداخلي بنجاح.");
                    }

                    if (!DeleteActualREsult.equals(DeleteExcprctedResult)) {

                        Assert.fail();

                    }
                }
            }
        }

    }


    @Test

    public void editInternalItems() throws InterruptedException {


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
//-----------------------------------------------------------------------------------------------
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
//*******************************************************************
            By InternalLink = By.id("ctl00_PlaceHolderMain_gvItems_ctl02_lbtnInternalItems");

            WebElement InternalLinkWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(InternalLink));
            InternalLinkWait.click();


            Thread.sleep(1000);
            By AddFormInternalItemDesc = By.id("ctl00_PlaceHolderMain_gvInternalItems_ctl03_tbAddFormInternalItemDesc");
            WebElement AddFormInternalItemDescWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddFormInternalItemDesc));
            AddFormInternalItemDescWait.sendKeys("Test");

            By AddEvaluationWeight = By.id("ctl00_PlaceHolderMain_gvInternalItems_ctl03_tbAddEvaluationWeight");
            WebElement AddEvaluationWeightWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddEvaluationWeight));
            AddEvaluationWeightWait.sendKeys("10");

            By AddFormInternalItem = By.id("ctl00_PlaceHolderMain_gvInternalItems_ctl03_lbtnAddFormInternalItem");
            WebElement AddFormInternalItemWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddFormInternalItem));
            AddFormInternalItemWait.click();


//**********************************************************
            By EditLinkLoactor = By.id("ctl00_PlaceHolderMain_gvInternalItems_ctl02_lbtnEdit");

            WebElement EditLinkLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(EditLinkLoactor));
            EditLinkLoactorWait.click();

            By UpdateLink = By.id("ctl00_PlaceHolderMain_gvInternalItems_ctl02_lbtnUpdate");
            WebElement UpdateLinkWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(UpdateLink));
            UpdateLinkWait.click();

            By UpdateMessage = By.id("ctl00_PlaceHolderMain_lblOpertioanlResult");
            WebElement UpdateMessageWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(UpdateMessage));

            String UpdateActualREsult = browserQA.findElement(UpdateMessage).getText();
            String UpdateExcprctedResult = "تم تعديل البند الداخلي بنجاح.";


            if (UpdateActualREsult.equals(UpdateExcprctedResult)) {

                System.out.println("تم تعديل البند الداخلي بنجاح.");
            }

            if (!UpdateActualREsult.equals(UpdateExcprctedResult)) {

                Assert.fail();

            }

        }
        //-----------------------------------------------------------------------------------------------

//yes
        else {

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

                By InternalLink = By.id("ctl00_PlaceHolderMain_gvItems_ctl02_lbtnInternalItems");

                WebElement InternalLinkWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(InternalLink));
                InternalLinkWait.click();
                By AddFormInternalItemDesc = By.id("ctl00_PlaceHolderMain_gvInternalItems_ctl03_tbAddFormInternalItemDesc");
                By AddEvaluationWeight = By.id("ctl00_PlaceHolderMain_gvInternalItems_ctl03_tbAddEvaluationWeight");
                By AddFormInternalItem = By.id("ctl00_PlaceHolderMain_gvInternalItems_ctl03_lbtnAddFormInternalItem");

                Thread.sleep(1000);

                WebElement AddFormInternalItemDescWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddFormInternalItemDesc));
                AddFormInternalItemDescWait.sendKeys("Test");
                WebElement AddEvaluationWeightWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddEvaluationWeight));
                AddEvaluationWeightWait.sendKeys("10");
                WebElement AddFormInternalItemWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddFormInternalItem));
                AddFormInternalItemWait.click();
                By EditLinkLoactor = By.id("ctl00_PlaceHolderMain_gvInternalItems_ctl02_lbtnEdit");

                WebElement EditLinkLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(EditLinkLoactor));
                EditLinkLoactorWait.click();

                By UpdateLink = By.id("ctl00_PlaceHolderMain_gvInternalItems_ctl02_lbtnUpdate");
                WebElement UpdateLinkWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(UpdateLink));
                UpdateLinkWait.click();

                By UpdateMessage = By.id("ctl00_PlaceHolderMain_lblOpertioanlResult");
                WebElement UpdateMessageWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(UpdateMessage));

                String UpdateActualREsult = browserQA.findElement(UpdateMessage).getText();
                String UpdateExcprctedResult = "تم تعديل البند الداخلي بنجاح.";


                if (UpdateActualREsult.equals(UpdateExcprctedResult)) {

                    System.out.println("تم تعديل البند الداخلي بنجاح.");
                }

                if (!UpdateActualREsult.equals(UpdateExcprctedResult)) {

                    Assert.fail();

                }

            }
//yes
            else {


                By InternalLink = By.id("ctl00_PlaceHolderMain_gvItems_ctl02_lbtnInternalItems");

                WebElement InternalLinkWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(InternalLink));
                InternalLinkWait.click();


                List InternalList = browserQA.findElements(By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[1]/div[2]/table/tbody/tr[2]/td/div/div/table[1]/tbody/tr/td[1]"));
                int InternalListSize = InternalList.size();

                if (InternalListSize <= 1) {
                    By AddFormInternalItemDesc = By.id("ctl00_PlaceHolderMain_gvInternalItems_ctl03_tbAddFormInternalItemDesc");
                    By AddEvaluationWeight = By.id("ctl00_PlaceHolderMain_gvInternalItems_ctl03_tbAddEvaluationWeight");
                    By AddFormInternalItem = By.id("ctl00_PlaceHolderMain_gvInternalItems_ctl03_lbtnAddFormInternalItem");

                    Thread.sleep(1000);

                    WebElement AddFormInternalItemDescWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddFormInternalItemDesc));
                    AddFormInternalItemDescWait.sendKeys("Test");
                    WebElement AddEvaluationWeightWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddEvaluationWeight));
                    AddEvaluationWeightWait.sendKeys("10");
                    WebElement AddFormInternalItemWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddFormInternalItem));
                    AddFormInternalItemWait.click();
                    By EditLinkLoactor = By.id("ctl00_PlaceHolderMain_gvInternalItems_ctl02_lbtnEdit");

                    WebElement EditLinkLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(EditLinkLoactor));
                    EditLinkLoactorWait.click();

                    By UpdateLink = By.id("ctl00_PlaceHolderMain_gvInternalItems_ctl02_lbtnUpdate");
                    WebElement UpdateLinkWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(UpdateLink));
                    UpdateLinkWait.click();

                    By UpdateMessage = By.id("ctl00_PlaceHolderMain_lblOpertioanlResult");
                    WebElement UpdateMessageWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(UpdateMessage));

                    String UpdateActualREsult = browserQA.findElement(UpdateMessage).getText();
                    String UpdateExcprctedResult = "تم تعديل البند الداخلي بنجاح.";


                    if (UpdateActualREsult.equals(UpdateExcprctedResult)) {

                        System.out.println("تم تعديل البند الداخلي بنجاح.");
                    }

                    if (!UpdateActualREsult.equals(UpdateExcprctedResult)) {

                        Assert.fail();

                    }


                } else {

                    By EditLinkLoactor = By.id("ctl00_PlaceHolderMain_gvInternalItems_ctl02_lbtnEdit");

                    WebElement EditLinkLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(EditLinkLoactor));
                    EditLinkLoactorWait.click();

                    By UpdateLink = By.id("ctl00_PlaceHolderMain_gvInternalItems_ctl02_lbtnUpdate");
                    WebElement UpdateLinkWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(UpdateLink));
                    UpdateLinkWait.click();

                    By UpdateMessage = By.id("ctl00_PlaceHolderMain_lblOpertioanlResult");
                    WebElement UpdateMessageWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(UpdateMessage));

                    String UpdateActualREsult = browserQA.findElement(UpdateMessage).getText();
                    String UpdateExcprctedResult = "تم تعديل البند الداخلي بنجاح.";


                    if (UpdateActualREsult.equals(UpdateExcprctedResult)) {

                        System.out.println("تم تعديل البند الداخلي بنجاح.");
                    }

                    if (!UpdateActualREsult.equals(UpdateExcprctedResult)) {

                        Assert.fail();

                    }

                }
            }
        }
    }


}

