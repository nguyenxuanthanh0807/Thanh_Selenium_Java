package Buoi_14;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Login_TestNG {
   WebDriver driver;
   WebDriverWait wait;

   //Khai báo before Method
    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); //Truy cập tranh web
    }

    //Viết Test Case cho demo
    @Test
    public void testLoginSuccess(){
        //Nhập user name
        WebElement userName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
        WebElement pass = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));

        //Nhập dữ liệu
        userName.sendKeys("Admin");
        pass.sendKeys("admin123");

        //Click Submit Button Login
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")));
        loginButton.click();

        //Chờ dashbord hiển thị
        WebElement dashbord = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Dashboard']")));

        //Assert thông tin
        Assert.assertTrue(dashbord.isDisplayed(), "Login thất bại, dashboard không hiển thị");
        System.out.println("Login Thành Công");

    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
