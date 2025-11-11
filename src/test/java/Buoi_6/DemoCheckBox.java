package Buoi_6;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class DemoCheckBox {
    public static void main(String[] args) throws InterruptedException {
        // Khởi tạo trình duyệt
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Mở trang login
        driver.get("https://demo.nopcommerce.com/register");

        // Wait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

  // Lâý phần tử check box
        WebElement newsletterCheckBox = driver.findElement(By.xpath("//input[@id='NewsLetterSubscriptions_0__IsActive']"));

        //Tick checkBox nếu chưa tick
        if (!newsletterCheckBox.isSelected()){
            newsletterCheckBox.click();
            System.out.println("Check Box đã được Click");
        }else {

            System.out.println("Check Box Đã được Tick sẵn");
            newsletterCheckBox.click();
        }





//Xác minh
        Assert.assertTrue(newsletterCheckBox.isSelected(), "Check Box Chưa Được chọn.");
System.out.println("Trạng Thái Check Box:" + newsletterCheckBox.isSelected());


    }
}
