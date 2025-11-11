package Buoi_6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomDropDownStatus {
    public static void main(String[] args) throws InterruptedException {
        // Khởi tạo trình duyệt
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Mở trang login
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Wait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Đăng nhập
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Mở menu Admin
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Admin']"))).click();

        // Click mở dropdown Status
        WebElement dropdownStatus = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//label[text()='Status']/parent::div/following-sibling::div//i[contains(@class,'oxd-icon')]")));
        dropdownStatus.click();

// Chọn giá trị “Enabled”
        WebElement optionEnabled = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@role='listbox']//span[text()='Enabled']")));
        optionEnabled.click();

// Get text sau khi chọn
        WebElement selectedStatus = driver.findElement(
                By.xpath("//label[text()='Status']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']"));
        String actualStatus = selectedStatus.getText();

// So sánh kết quả
        String expectedStatus = "Enabled";
        if (actualStatus.equals(expectedStatus)) {
            System.out.println("✅ Test Passed: Status dropdown value is " + actualStatus);
        } else {
            System.out.println("❌ Test Failed: Expected '" + expectedStatus + "' but got '" + actualStatus + "'");
        }
    }
}
