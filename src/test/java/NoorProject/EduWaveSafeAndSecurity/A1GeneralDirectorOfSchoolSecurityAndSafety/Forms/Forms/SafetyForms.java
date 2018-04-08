/*
 * Created By Rami AlShawabkeh  4/5/18 3:12 PM
 */

package NoorProject.EduWaveSafeAndSecurity.A1GeneralDirectorOfSchoolSecurityAndSafety.Forms.Forms;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

import static NoorProject.Other.NoorLogin.browserQA;
import static NoorProject.Other.NoorLogin.waitQA;

public class SafetyForms {


    private By SwitchProfileLocator = By.id("ctl00_oHeader_divSwitchUser");
    private By UserNameLabelLocator = By.linkText("مدير عام الأمن والسلامة المدرسية");
    private By FormMainMenuLoactor = By.id("divMenuItem_5968");
    private By FromDayFooterLocator = By.xpath("/html/body/div/table/tbody/tr[4]/td[2]");
    private By ToDayFooterLocator = By.xpath("/html/body/div/table/tbody/tr[5]/td[1]");
    private By AddValidationMessageLoactor = By.id("ctl00_PlaceHolderMain_lblOpertioanlResult");


    @Test
    public void LoginUserAndSwitchProfileForms() {

        WebElement SwitchProfileLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SwitchProfileLocator));
        SwitchProfileLocatorWait.click();

        WebElement UserLabelLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(UserNameLabelLocator));
        UserLabelLocatorWait.click();


    }

    @Test
    public void addSafetyForms() throws InterruptedException {


        WebElement FormMainMenuLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(FormMainMenuLoactor));
        FormMainMenuLoactorWait.click();

        List<WebElement> Paging = browserQA.findElements(By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[3]/div[2]/div/div/table[1]/tbody/tr[23]/td/table/tbody/tr/td"));
        int PagingPrametre = Paging.size();

        System.out.println("NumberOfThePages::" + PagingPrametre);

        By Paginglink = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[3]/div[2]/div/div/table[1]/tbody/tr[23]/td/table/tbody/tr/td[" + PagingPrametre + "]/a");

        WebElement PaginglinkWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(Paginglink));
        PaginglinkWait.click();
        Thread.sleep(1000);

        List NumberOfRows = browserQA.findElements(By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[3]/div[2]/div/div/table[1]/tbody/tr/td[1]"));
        int TableSize = NumberOfRows.size();

        System.out.println("NumberOfRows::" + TableSize);

        String TableSizeParameterADD = String.format("%02d" , TableSize);

        System.out.println("NumberOfRowsAfterEditing::" + String.format("%02d" , TableSize));

        By AddFormDescLocator = By.id("ctl00_PlaceHolderMain_gvForms_ctl" + TableSizeParameterADD + "_tbAddFormDesc");

        Random Rand = new Random();
        int RandomNumber = Rand.nextInt(1000000);

        Thread.sleep(2000);
        WebElement AddFormDescLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddFormDescLocator));
        AddFormDescLocatorWait.sendKeys("Rami" + RandomNumber);

        By FromDateFooterLocator = By.id("ctl00_PlaceHolderMain_gvForms_ctl" + TableSizeParameterADD + "_clrFromDateFooter_ibtnOpenCalendar");
        WebElement FromDateFooterLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(FromDateFooterLocator));
        FromDateFooterLocatorWait.click();

        WebElement FromDayFooterLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(FromDayFooterLocator));
        FromDayFooterLocatorWait.click();

        By ToDateFooterLocator = By.id("ctl00_PlaceHolderMain_gvForms_ctl" + TableSizeParameterADD + "_clrToDateFooter_ibtnOpenCalendar");

        WebElement ToDateFooterLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ToDateFooterLocator));
        ToDateFooterLocatorWait.click();

        WebElement ToDayFooterLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ToDayFooterLocator));
        ToDayFooterLocatorWait.click();

        By AddLinkLOcator = By.id("ctl00_PlaceHolderMain_gvForms_ctl" + TableSizeParameterADD + "_lbtnAddFormDesc");
        WebElement AddLinkLOcatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddLinkLOcator));
        AddLinkLOcatorWait.click();

        WebElement AddValidationMessageLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(AddValidationMessageLoactor));

        String AddValidationMessageLoactorString = browserQA.findElement(AddValidationMessageLoactor).getText();
        String message = "تم إضافة النموذج بنجاح";

        Assert.assertEquals(message , AddValidationMessageLoactorString , "لم تتم الاضافة بنجاح");

    }

    private By FormStatusLocator = By.id("select2-ctl00_PlaceHolderMain_ddlFormStatus-container");
    private By FormStatusSearchLocator = By.xpath("/html/body/span/span/span[1]/input");
    private By GVForms = By.id("ctl00_PlaceHolderMain_gvForms_ctl02_lbtnView");
    private By BTNBack = By.id("ctl00_PlaceHolderMain_ibtnBack");
    private By SearchLoactor = By.id("ctl00_PlaceHolderMain_ibtnSearch");
    @Test
    public void ViewpublishedForm() throws InterruptedException {

        WebElement FormMainMenuLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(FormMainMenuLoactor));
        FormMainMenuLoactorWait.click();

        WebElement DDLFormStatusLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(FormStatusLocator));
        DDLFormStatusLoactorWait.click();

        WebElement TextFormStatusSearchLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(FormStatusSearchLocator));
        TextFormStatusSearchLoactorWait.sendKeys("منشور" , Keys.ENTER);


        Thread.sleep(1000);
        WebElement SearchLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchLoactor));
        SearchLoactorWait.click();
        browserQA.findElement(GVForms).click();
        browserQA.findElement(BTNBack).click();


    }


    @Test
    public void ViewUnpublishedForm() throws InterruptedException {

        WebElement FormMainMenuLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(FormMainMenuLoactor));
        FormMainMenuLoactorWait.click();

        WebElement DDLFormStatusLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(FormStatusLocator));
        DDLFormStatusLoactorWait.click();

        WebElement TextFormStatusSearchLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(FormStatusSearchLocator));
        TextFormStatusSearchLoactorWait.sendKeys("غير منشور" , Keys.ENTER);

        Thread.sleep(1000);
        WebElement SearchLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchLoactor));
        SearchLoactorWait.click();

        browserQA.findElement(GVForms).click();
        browserQA.findElement(BTNBack).click();


    }
    private By UnPublishingLinkLocator = By.id("ctl00_PlaceHolderMain_gvForms_ctl02_lbtnUnPublish");
    private By YesConfrmationLocator = By.id("ctl00_ibtnYes");
    @Test
    public void unPublishingForm() throws InterruptedException {


        WebElement FormMainMenuLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(FormMainMenuLoactor));
        FormMainMenuLoactorWait.click();

        WebElement FormStatusLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(FormStatusLocator));
        FormStatusLocatorWait.click();

        WebElement FormStatusSearchLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(FormStatusSearchLocator));
        FormStatusSearchLocatorWait.sendKeys("منشور" , Keys.ENTER);

        Thread.sleep(1000);
        WebElement SerachButtonLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchLoactor));
        SerachButtonLocatorWait.click();


        WebElement PublishingLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(UnPublishingLinkLocator));
        PublishingLinkLocatorWait.click();


        WebElement YesConfrmationLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(YesConfrmationLocator));
        YesConfrmationLocatorWait.click();

        By MessageLocator=By.id("ctl00_PlaceHolderMain_lblOpertioanlResult");

        WebElement MessageLocatorWait=waitQA.until(ExpectedConditions.visibilityOfElementLocated(MessageLocator));

        String ActualResult=browserQA.findElement(MessageLocator).getText();
        String ExcpectedResult="تم إلغاء النشر النموذج بنجاح.";

        Assert.assertEquals(ActualResult,ExcpectedResult,"لم تتم عملية الغاء النشر للنموذج");

    }
    private By PublishingLinkLocator = By.id("ctl00_PlaceHolderMain_gvForms_ctl02_lbtnPublish");

    @Test
    public void PublishingForm() throws InterruptedException {



        WebElement FormMainMenuLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(FormMainMenuLoactor));
        FormMainMenuLoactorWait.click();


        WebElement FormStatusLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(FormStatusLocator));
        FormStatusLocatorWait.click();

        WebElement FormStatusSearchLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(FormStatusSearchLocator));
        FormStatusSearchLocatorWait.sendKeys("غير منشور" , Keys.ENTER);

        Thread.sleep(1000);
        WebElement SerachButtonLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchLoactor));
        SerachButtonLocatorWait.click();


        WebElement PublishingLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(PublishingLinkLocator));
        PublishingLinkLocatorWait.click();


        WebElement YesConfrmationLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(YesConfrmationLocator));
        YesConfrmationLocatorWait.click();

        By MessageLocator=By.id("ctl00_PlaceHolderMain_lblOpertioanlResult");

        WebElement MessageLocatorWait=waitQA.until(ExpectedConditions.visibilityOfElementLocated(MessageLocator));

        String ActualResult=browserQA.findElement(MessageLocator).getText();
        String ExcpectedResult="تم نشر النموذج بنجاح.";

        Assert.assertEquals(ActualResult,ExcpectedResult,"يجب اضافة الاقسام والبنود الخارجية والبنود الداخلية");

    }
    private By FormDescriptionLocator1 = By.id("ctl00_PlaceHolderMain_gvForms_ctl02_tbFormDesc");
    private By UpdateLinkLocator = By.id("ctl00_PlaceHolderMain_gvForms_ctl02_lbtnUpdate");


    @Test

    public void EditUnpublishedSafetyForms() throws InterruptedException {

        WebElement FormMainMenuLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(FormMainMenuLoactor));
        FormMainMenuLoactorWait.click();

        WebElement FormStatusLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(FormStatusLocator));
        FormStatusLocatorWait.click();

        WebElement FormStatusSearchLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(FormStatusSearchLocator));
        FormStatusSearchLocatorWait.sendKeys("غير منشور" , Keys.ENTER);

        Thread.sleep(1000);
        WebElement BTNSearchLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchLoactor));
        BTNSearchLocatorWait.click();

        By EditLinkLocator = By.id("ctl00_PlaceHolderMain_gvForms_ctl02_lbtnEdit");

        WebElement EditLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(EditLinkLocator));
        EditLinkLocatorWait.click();

        Random rand = new Random();
        int random_numbers = rand.nextInt(1000);


        WebElement FormDescriptionLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(FormDescriptionLocator1));
        FormDescriptionLocatorWait.clear();
        FormDescriptionLocatorWait.sendKeys("Form" + random_numbers);

        Thread.sleep(1000);
        WebElement UpdateLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(UpdateLinkLocator));
        UpdateLinkLocatorWait.click();
        UpdateLinkLocatorWait.click();

        By UpadteMessageLOcator=By.id("ctl00_PlaceHolderMain_lblOpertioanlResult");

        WebElement UpadteMessageLOcatorWait=waitQA.until(ExpectedConditions.visibilityOfElementLocated(UpadteMessageLOcator));

        String ActualResult=browserQA.findElement(UpadteMessageLOcator).getText();
        String ExpectedResult="تمت عملية حفظ البيانات بنجاح.";

        Assert.assertEquals(ActualResult,ExpectedResult,"لم تتم عملية التعديل بنجاح");

    }


    @Test
    public void DeleteForms() throws InterruptedException {

        browserQA.manage().window().maximize();

        Random Rand = new Random();
        int RandomNumber = Rand.nextInt(1000000);


        WebElement FormMainMenuLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(FormMainMenuLoactor));
        FormMainMenuLoactorWait.click();


        List<WebElement> PagingDelete = browserQA.findElements(By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[3]/div[2]/div/div/table[1]/tbody/tr[23]/td/table/tbody/tr/td"));
        int PagingPrametreDelete = PagingDelete.size();

        By PaginglinkDelete = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[3]/div[2]/div/div/table[1]/tbody/tr[23]/td/table/tbody/tr/td[" + PagingPrametreDelete + "]/a");

        WebElement PaginglinkDeleteWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(PaginglinkDelete));
        PaginglinkDeleteWait.click();

        Thread.sleep(1000);

        List NumberOfRowsDelete = browserQA.findElements(By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[3]/div[2]/div/div/table[1]/tbody/tr/td[1]"));

        int TableSizeDelete = NumberOfRowsDelete.size();

        String TableSizeDeleteParameter = String.format("%02d" , TableSizeDelete);

        int PrametreDelete = Integer.parseInt(TableSizeDeleteParameter) - 1;

        String DeleteParmetreAfterConverte = String.format("%02d" , PrametreDelete);

        System.out.println("TableSizzzzze===="+TableSizeDelete);

        System.out.println("TableSizeDeleteParameter"+TableSizeDeleteParameter);

        System.out.println("PrametreDelete"+PrametreDelete);

        System.out.println("DeleteParmetreAfterConverte"+DeleteParmetreAfterConverte);


        By DeleteLinkLocator = By.id("ctl00_PlaceHolderMain_gvForms_ctl" + DeleteParmetreAfterConverte + "_lbtnDelete");

        WebElement DeleteLinkLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DeleteLinkLocator));
        DeleteLinkLocatorWait.click();

        By YesButtonLocator = By.id("ctl00_ibtnYes");

        WebElement YesButtonLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(YesButtonLocator));
        YesButtonLocatorWait.click();

        By DeleteValidationMessageLocator = By.id("ctl00_PlaceHolderMain_lblOpertioanlResult");
        WebElement DeleteValidationMessageLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DeleteValidationMessageLocator));

        String ActualResult = browserQA.findElement(DeleteValidationMessageLocator).getText();
        String ExpercteResult = "تم حذف النموذج بنجاح.";


        Assert.assertEquals(ActualResult , ExpercteResult , "يوجد مشكلة في الية الحذف");

    }

}
