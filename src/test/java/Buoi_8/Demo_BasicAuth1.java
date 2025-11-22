package Buoi_8;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Demo_BasicAuth1 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();// Mở trình duyệt chorme
        driver.manage().window().maximize();//Mở trình duyệt toàn màn hình


        //Mở trang web lên
        Thread.sleep(2000);
        driver.get("http://anhit-user:anhit@2025@anhitsolutions.cloud/"); //Truy cập tranh web
        Thread.sleep(2000);




    }
}
