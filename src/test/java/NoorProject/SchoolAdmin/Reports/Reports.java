/*
 * Created By  Rami AlShawabkeh  4/15/18 2:05 PM
 */

package NoorProject.SchoolAdmin.Reports;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static NoorProject.Other.NoorLogin.browserQA;
import static NoorProject.Other.NoorLogin.waitQA;

public class Reports {
    private By SwitchProfileLocator = By.id("ctl00_oHeader_divSwitchUser");
    private By ReportMenuLocator = By.id("divMenuItem_321");
    private By SerachLinkLoactor = By.id("lisearch_list");
    private By SearchButonLocator = By.id("ctl00_PlaceHolderMain_ibtnSearch");

    @Test
    public void loginAndSwitch() throws InterruptedException {
        browserQA.manage().window().maximize();
        WebElement SwitchProfileLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SwitchProfileLocator));
        SwitchProfileLocatorWait.click();
        JavascriptExecutor je = (JavascriptExecutor) browserQA;
        WebElement element = browserQA.findElement(By.xpath("/html/body/form/div[4]/div[2]/div[1]/div[2]/div/div/div/div[1]/div/ul/li[11]/a"));
        je.executeScript("arguments[0].scrollIntoView(true);" , element);
        element.click();


    }

    private By HealthRegistryReportLocator = By.linkText("السجل الصحي");

    @Test
//السجل الصحي
    public void healthRegistry() {

        WebElement ReportMenuLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportMenuLocator));
        ReportMenuLocatorWait.click();

        WebElement SerachLinkLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachLinkLoactor));
        SerachLinkLoactorWait.click();
        WebElement HealthRegistryReportLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(HealthRegistryReportLocator));
        HealthRegistryReportLocatorWait.click();


        WebElement SearchButonLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchButonLocator));
        SearchButonLocatorWait.click();

        By ReportTitleLocator = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div[5]/div/span/div/table/tbody/tr[4]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/table/tbody/tr[11]/td[3]/table/tbody/tr/td/div");

        WebElement ReportTitleLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportTitleLocator));

        String ActualResult = browserQA.findElement(ReportTitleLocator).getText();
        String ExcpectedReslut = "السجل الصحي";
        Assert.assertEquals(ActualResult , ExcpectedReslut , "التقرير المطلوب غير موجود");

    }

    By userTypesPermissionsLocator = By.linkText("صلاحيات أنواع المستخدمين");

    @Test
    public void userTypesPermissions() throws InterruptedException {

        WebElement ReportMenuLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportMenuLocator));
        ReportMenuLocatorWait.click();

        WebElement SerachLinkLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachLinkLoactor));
        SerachLinkLoactorWait.click();

        WebElement userTypesPermissionsLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(userTypesPermissionsLocator));
        userTypesPermissionsLocatorWait.click();

        WebElement SearchButonLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SearchButonLocator));
        SearchButonLocatorWait.click();

    }

    @Test
    public void myPrivilege() {

        WebElement ReportMenuLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(ReportMenuLocator));
        ReportMenuLocatorWait.click();

        WebElement SerachLinkLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SerachLinkLoactor));
        SerachLinkLoactorWait.click();

        By myPrivilegeLocator = By.linkText("صلاحياتي");

        WebElement myPrivilegeLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(myPrivilegeLocator));
        myPrivilegeLocatorWait.click();


    }
}
