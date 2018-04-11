/*
 * Created By  Rami AlShawabkeh  4/11/18 3:58 PM
 */

/*
 * Created By  Rami AlShawabkeh  4/8/18 3:08 PM
 */

package NoorProject.EduWaveSafeAndSecurity.A2SSOfficerInMinstry.Forms.InternalItems;

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
        private By UserNameLabelLocator = By.linkText("موظف الأمن والسلامة المدرسية");
        private By FormMainMenuLoactor = By.id("divMenuItem_5968");
        private By FormStatusLocator = By.id("select2-ctl00_PlaceHolderMain_ddlFormStatus-container");
        private By FormStatusSearchLocator = By.xpath("/html/body/span/span/span[1]/input");
        private By SerachButtonLocator = By.id("ctl00_PlaceHolderMain_ibtnSearch");
        private By SectionsLinkLocator = By.id("ctl00_PlaceHolderMain_gvForms_ctl02_tdSections");


        @Test

        public void LoginToTheUserII() {

            WebElement SwitchProfileLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SwitchProfileLocator));
            SwitchProfileLocatorWait.click();

            WebElement UserLabelLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(UserNameLabelLocator));
            UserLabelLocatorWait.click();
        }


        @Test
        public void addInternalItems() throws InterruptedException {


            browserQA.manage().window().maximize();
            browserQA.manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS);


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
                AddSections.addSectionsToTheForm();
            }
            By ExternalItemsLocator = By.id("ctl00_PlaceHolderMain_gvSections_ctl02_lbtnItems");

            WebElement ExternalItemsWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ExternalItemsLocator));
            ExternalItemsWait.click();

            List ExternalItemsTableList = browserQA.findElements(By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[1]/div[2]/table/tbody/tr[2]/td/div/div/table[1]/tbody/tr/td[1]"));

            int ExternalItemsTableSize = ExternalItemsTableList.size();
            if (ExternalItemsTableSize <= 1) {

                ExternalItems AddExternalItems = new ExternalItems();
                AddExternalItems.addExternalItems();
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
        }


        @Test

        public void deleteInternalItems() throws InterruptedException {


            browserQA.manage().window().maximize();
            browserQA.manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS);


            List SectionTableListDelet = browserQA.findElements(By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[1]/div[2]/div/div/table[1]/tbody/tr/td[1]"));

            int TableSizeForSections = SectionTableListDelet.size();

            if (TableSizeForSections <= 1) {
                NoorProject.EduWaveSafeAndSecurity.A1GeneralDirectorOfSchoolSecurityAndSafety.Forms.InternalItems.InternalItems AddedDelete = new NoorProject.EduWaveSafeAndSecurity.A1GeneralDirectorOfSchoolSecurityAndSafety.Forms.InternalItems.InternalItems();
                AddedDelete.addInternalItems();
            }


            By DeleteLink = By.id("ctl00_PlaceHolderMain_gvInternalItems_ctl02_lbtnDelete");

            WebElement DeleteLinkWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DeleteLink));
            DeleteLinkWait.click();

            By YesLocator = By.id("ctl00_ibtnYes");

            WebElement YesLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(YesLocator));
            YesLocatorWait.click();

            By DeleteMessage=By.id("ctl00_PlaceHolderMain_lblOpertioanlResult");

            WebElement DeleteMessageWait=waitQA.until(ExpectedConditions.visibilityOfElementLocated(DeleteMessage));

            String DeleteActualResult=browserQA.findElement(DeleteMessage).getText();
            String DeleteExcpectedResult="تم حذف البند الداخلي بنجاح.";

            Assert.assertEquals(DeleteActualResult,DeleteExcpectedResult,"لم تتم عملية الحذف بنجاح ");

        }

        @Test

        public void editInternalItems() throws InterruptedException {
            browserQA.manage().window().maximize();
            browserQA.manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS);

            List SectionTableListDelet = browserQA.findElements(By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[1]/div[2]/div/div/table[1]/tbody/tr/td[1]"));

            int TableSizeForSections = SectionTableListDelet.size();

            if (TableSizeForSections <= 1) {
                NoorProject.EduWaveSafeAndSecurity.A1GeneralDirectorOfSchoolSecurityAndSafety.Forms.InternalItems.InternalItems Added = new NoorProject.EduWaveSafeAndSecurity.A1GeneralDirectorOfSchoolSecurityAndSafety.Forms.InternalItems.InternalItems();
                Added.addInternalItems();

            }

            By Editlink=By.id("ctl00_PlaceHolderMain_gvInternalItems_ctl02_lbtnEdit");

            WebElement EditlinkWait=waitQA.until(ExpectedConditions.visibilityOfElementLocated(Editlink));
            EditlinkWait.click();

            By UpadteLinkLocator=By.id("ctl00_PlaceHolderMain_gvInternalItems_ctl02_lbtnUpdate");

            WebElement UpadteLinkLocatorWait=waitQA.until(ExpectedConditions.visibilityOfElementLocated(UpadteLinkLocator));
            UpadteLinkLocatorWait.click();

            By UpdateMeassage=By.id("ctl00_PlaceHolderMain_lblOpertioanlResult");

            WebElement UpdateMeassageWait=waitQA.until(ExpectedConditions.visibilityOfElementLocated(UpdateMeassage));

            String ActualResultUpdate=browserQA.findElement(UpdateMeassage).getText();
            String ExcpectedResultUpdate="تم تعديل البند الداخلي بنجاح.";

            Assert.assertEquals(ActualResultUpdate,ExcpectedResultUpdate,"لم تتم عملية التعديل بنجاح ");

        }

    }
