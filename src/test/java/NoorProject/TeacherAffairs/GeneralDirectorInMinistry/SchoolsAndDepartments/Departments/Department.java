/*
 * Created By Rami Alshawabkeh  3/18/18 3:15 PM
 */

package NoorProject.TeacherAffairs.GeneralDirectorInMinistry.SchoolsAndDepartments.Departments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.Random;

import static NoorProject.Other.NoorLogin.browserQA;
import static NoorProject.Other.NoorLogin.waitQA;

public class Department {


    private By SchooleAndDeptsMainMenuLocator = By.id("divMenuItem_6543");
    private By DeptsLoactor = By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div/div[2]/div[3]/div[1]/div/div/div[3]/a");
    private By drop_down_list_level_Locator = By.id("select2-ctl00_PlaceHolderMain_ddlLevel-container");
    private By txt_field_Locator = By.xpath("/html/body/span/span/span[1]/input");
    private By btn_search_Locator = By.id("ctl00_PlaceHolderMain_ibtnSearch");
    private By txt_field_2_Locator = By.id("ctl00_PlaceHolderMain_gvTeacherDepartment_ctl22_tbTeacherDepartmentFooter");
    private By check_box_ministry_Locator = By.id("ctl00_PlaceHolderMain_gvTeacherDepartment_ctl22_cbMinistryFooter");
    private By check_box_management_Locator = By.id("ctl00_PlaceHolderMain_gvTeacherDepartment_ctl22_cbDistrictFooter");
    private By check_box_office_Locator = By.id("ctl00_PlaceHolderMain_gvTeacherDepartment_ctl22_cbSupervisionFooter");
    private By btn_add_Locator = By.id("ctl00_PlaceHolderMain_gvTeacherDepartment_ctl22_lbtnAdd");


    @Test
    public void AddModeratorUser() throws InterruptedException {

        for ( int i=0;i<50;i++) {
            WebElement SchooleAndDeptsMainMenuLocatorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(SchooleAndDeptsMainMenuLocator));
            SchooleAndDeptsMainMenuLocatorWait.click();

            WebElement DeptsLoactorWait = waitQA.until(ExpectedConditions.visibilityOfElementLocated(DeptsLoactor));
            DeptsLoactorWait.click();

            Thread.sleep(1000);

            waitQA.until(ExpectedConditions.visibilityOfElementLocated(drop_down_list_level_Locator)).click();
            waitQA.until(ExpectedConditions.visibilityOfElementLocated(txt_field_Locator)).sendKeys("وزار" , Keys.ENTER);
            Thread.sleep(1000);
            waitQA.until(ExpectedConditions.visibilityOfElementLocated(btn_search_Locator)).click();
            Random rand = new Random();
            int random_numbers = rand.nextInt();
            waitQA.until(ExpectedConditions.visibilityOfElementLocated(txt_field_2_Locator)).sendKeys("Test" + random_numbers);
            waitQA.until(ExpectedConditions.visibilityOfElementLocated(check_box_ministry_Locator)).click();
            waitQA.until(ExpectedConditions.visibilityOfElementLocated(check_box_management_Locator)).click();
            waitQA.until(ExpectedConditions.visibilityOfElementLocated(check_box_office_Locator)).click();
            waitQA.until(ExpectedConditions.visibilityOfElementLocated(btn_add_Locator)).click();
        }
    }
}

