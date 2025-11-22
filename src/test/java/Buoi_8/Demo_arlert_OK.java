package Buoi_8;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class Demo_arlert_OK {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();// tự động tải Driver về
        WebDriver driver = new ChromeDriver();// Mở trình duyệt chorme
        driver.manage().window().maximize();//Mở trình duyệt toàn màn hình


        //Mở trang web lên
        driver.get("https://anhit-basicform.surge.sh/"); //Truy cập tranh web
        Thread.sleep(2000);

        WebElement element = driver.findElement(By.xpath("//legend[text()='Submit and Reset form']"));

        //Scroll Page
        Actions action = new Actions(driver);
        action.moveToElement(element);
        action.perform();

        // Click button Alert thông báo OK
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        Thread.sleep(2000);
        alert.accept();
        Thread.sleep(1000);
        // Get text sau khi chọn
        WebElement result = driver.findElement(By.xpath("//*[@id=\"result\"]"));

        String actualValue = result.getText();

        // So sánh kết quả
        String expectedValue = "You clicked an alert successfully";
        if (actualValue.equals(expectedValue)) {
            System.out.println("✅ Test Passed: Result: " + actualValue);
        } else {
            System.out.println("❌ Test Failed: Expected '" + expectedValue + "' but got '" + actualValue + "'");
        }
    }
}
