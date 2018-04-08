package NoorProject.EduWaveSafeAndSecurity.SchoolAdmin.TheReport;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static NoorProject.Other.NoorLogin.waitQA;

public class UserDataInSchools {


    private By ReportsMenuLocator = By.id("divMenuItem_321");
    private By SearchFieldLocator = By.id("lisearch_list");
    private By TextFieldLocator = By.id("myInput");
    private By TheReportLocator = By.linkText("بيانات المستخدمين بالمدارس");
    private By BtnSearchLocator = By.id("ctl00_PlaceHolderMain_ibtnSearch");
    private By TextFieldTitleLocator = By.id("ctl00_lblPageTitle");
    private By TextFieldTableLocator = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[4]/span/div/table/tbody/tr[4]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[6]/td[3]/table/tbody/tr/td/div/div[1]/span");

//مدير مدرسة تقرير بيانات المستخدمين بالمدارس
    @Test
    public void UserDataInSchoolsView() throws InterruptedException {

        //for (int i=0;i<5;i++) {

            WebElement ReportsMenuLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportsMenuLocator));
            ReportsMenuLocatorWait.click();

            WebElement SchoolSecurityAndSafetyReportsLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchFieldLocator));
            SchoolSecurityAndSafetyReportsLocatorWait.click();

            WebElement SchoolDataLinkLocatorElementWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(TextFieldLocator));
            SchoolDataLinkLocatorElementWait.sendKeys("بيانات المستخدمين بالمدارس");

            try {
                WebElement UserDataInSchoolsLinkLocatorElement = waitQA.until(ExpectedConditions.visibilityOfElementLocated(TheReportLocator));
                UserDataInSchoolsLinkLocatorElement.click();
            } catch (Exception e) {
                WebElement UserDataInSchoolsLinkLocatorElement = waitQA.until(ExpectedConditions.visibilityOfElementLocated(TheReportLocator));
                UserDataInSchoolsLinkLocatorElement.click();
            }


          /*  WebElement DropDownListElement = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DropDownListLocator));
            DropDownListElement.click();
            WebElement TextField2LocatorElement = waitQA.until(ExpectedConditions.visibilityOfElementLocated(TextField2Locator));
            TextField2LocatorElement.sendKeys("خادم" , Keys.ENTER);
            Thread.sleep(300);*/
            WebElement BtnSearchLocatorElement = waitQA.until(ExpectedConditions.visibilityOfElementLocated(BtnSearchLocator));
            BtnSearchLocatorElement.click();
            WebElement TextFieldTitleLocatorElement = waitQA.until(ExpectedConditions.visibilityOfElementLocated(TextFieldTitleLocator));
            String ExpectedResult = TextFieldTitleLocatorElement.getText();

            Thread.sleep(1000);
            WebElement TextFieldTableLocatorElement = waitQA.until(ExpectedConditions.visibilityOfElementLocated(TextFieldTableLocator));
            String ActualResult = TextFieldTableLocatorElement.getText();
            System.out.println(ExpectedResult);
            System.out.println(ActualResult);
            Assert.assertEquals(ActualResult , ExpectedResult , "التقرير المطلوب غير متوفر");

     //   }


    }
}
