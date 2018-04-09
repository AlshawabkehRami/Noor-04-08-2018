/*
 * Created By Rami AlShawabkeh 4/1/18 3:49 PM
 */

package NoorProject.EduWaveSafeAndSecurity.A6SSInTheSchools.TheReport;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static NoorProject.Other.NoorLogin.waitQA;

public class UserDataInSchools {


    private By MainMenuReportsLocator = By.id("divMenuItem_321");
    private By UserDataInSchoolsLocator = By.partialLinkText("بيانات المستخدمين بالمدارس");
    private By BtnViewLocator = By.id("ctl00_PlaceHolderMain_ibtnSearch");
    private By TextFieldTitleLocator = By.id("ctl00_lblPageTitle");


    @Test
    public void UserDataInSchoolsReports() {
        WebElement MainMenuReportsLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(MainMenuReportsLocator));
        MainMenuReportsLocatorWait.click();
        WebElement UserDataInSchoolsLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(UserDataInSchoolsLocator));
        UserDataInSchoolsLocatorWait.click();
        WebElement BtnViewLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(BtnViewLocator));
        BtnViewLocatorWait.click();
        WebElement TextFieldTitleLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(TextFieldTitleLocator));
        String ExpectedResult = TextFieldTitleLocatorWait.getText();
        String ActualResult = "بيانات المستخدمين بالمدارس";
        Assert.assertEquals(ActualResult, ExpectedResult, "التقرير المطلوب غير متوفر");
    }

}

