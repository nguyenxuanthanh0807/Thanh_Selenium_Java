package Buoi_13;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DemoJavacript {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();// tự động tải Driver về
        WebDriver driver = new ChromeDriver();// Mở trình duyệt chorme
        driver.manage().window().maximize();//Mở trình duyệt toàn màn hình

        // Explictip wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        //Mở trang web lên
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); //Truy cập tranh web




//Dùng Xpath nhập user & password
        WebElement userName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
        WebElement pass = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")));
        loginButton.click();
//        //Nhập dữ liệu
//        userName.sendKeys("Admin");
//        pass.sendKeys("admin123");


        //Khoi tao js
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Demo JS Ex
        //1.High light user name
        js.executeScript("arguments[0].style.border='3px solid red'", userName);

        //2.Nhap UserName
        js.executeScript("arguments[0].value='Admin'; arguments[0].dispatchEvent(new Event('input', { bubbles: true }));",
                             userName);

        //3.High light pass
        js.executeScript("arguments[0].style.border='3px solid red'", pass);

        //4.Nhap Pass
        js.executeScript("arguments[0].value='admin123'; arguments[0].dispatchEvent(new Event('input', { bubbles: true }));",pass);

        //5.Clicl Button Login
        js.executeScript("arguments[0].click();",loginButton);

        //6. Lay tieu de trang = js
        String TieuDe = js.executeScript("return document.title;").toString();
        System.out.println(TieuDe);

        //7. lay URL
        String url = js.executeScript("return document.URL;").toString();
        System.out.println(url);

    }
}
