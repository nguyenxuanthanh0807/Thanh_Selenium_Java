package Buoi_5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRMLogin {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();// tự động tải Driver về
        WebDriver driver = new ChromeDriver();// Mở trình duyệt chorme
        driver.manage().window().maximize();//Mở trình duyệt toàn màn hình


        //Mở trang web lên
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); //Truy cập tranh web
       Thread.sleep(2000);
//Dùng Xpath nhập user & password
        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement pass = driver.findElement(By.xpath("//input[@name='password']"));
        //Nhập dữ liệu
        userName.sendKeys("Admin");
        pass.sendKeys("admin123");

        //Click Submit Button Login
        driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).click();



    }
//

    }


