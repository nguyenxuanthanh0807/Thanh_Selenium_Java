package Buoi_6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomDropDown {
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

        //Click Admin
        Thread.sleep(3000);

        driver.findElement(By.xpath("//span[text()='Admin']")).click();

        Thread.sleep(3000);
        driver.findElement(By.xpath("//label[text()='User Role']/parent::div/following-sibling::div//i[contains(@class,'oxd-icon')]")).click();
        driver.findElement(By.xpath("//label[text()='User Role']/parent::div/following-sibling::div/div/div/following-sibling::div/div/span[text()='Admin']")).click();

        // Get text sau khi chọn
        WebElement selectedValue = driver.findElement(
                By.xpath("//label[text()='User Role']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']"));
        String actualValue = selectedValue.getText();
        Thread.sleep(3000);

        // So sánh kết quả
        String expectedValue = "Admin";
        if (actualValue.equals(expectedValue)) {
            System.out.println("✅ Test Passed: Dropdown value is " + actualValue);
        } else {
            System.out.println("❌ Test Failed: Expected '" + expectedValue + "' but got '" + actualValue + "'");
        }

        // Đóng trình duyệt
        driver.quit();
    }



    }

