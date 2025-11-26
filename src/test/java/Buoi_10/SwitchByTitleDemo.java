package Buoi_10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class SwitchByTitleDemo {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(2000);

        // Lưu ID tab cha
        String parentID = driver.getWindowHandle();

        // Click mở tab mới
        driver.findElement(By.xpath("//a[@href='https://www.youtube.com/c/OrangeHRMInc']")).click();
        driver.findElement(By.xpath("//a[@href='https://www.facebook.com/OrangeHRM/']")).click();
        driver.findElement(By.xpath("//a[@href='https://www.linkedin.com/company/orangehrm/mycompany/']")).click();
        driver.findElement(By.xpath("//a[@href='https://twitter.com/orangehrm?lang=en']")).click();

        Thread.sleep(2000);

        // Title tab bạn muốn chuyển đến
        String expectTitle = "OrangeHRM Inc - YouTube";



        // Chuyển vào tab theo title
        switchToWindowByTitle(driver, expectTitle);
        System.out.println("Đã chuyển đến tab: " + driver.getTitle());

        Thread.sleep(2000);

        // Đóng tab đó theo title
        closeWindowByTitle(driver, expectTitle);
        System.out.println("Đã đóng tab: " + expectTitle);

        // Quay lại tab cha
        driver.switchTo().window(parentID);
        System.out.println("Đã quay lại tab cha: " + driver.getTitle());

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



    public static void switchToWindowByTitle(WebDriver driver, String expectedTitle) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String windowID : allWindows) {
            driver.switchTo().window(windowID);
            if (driver.getTitle().equals(expectedTitle)) {
                break;
            }
        }
    }

    public static void closeWindowByTitle(WebDriver driver, String expectedTitle) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String windowID : allWindows) {
            driver.switchTo().window(windowID);
            if (driver.getTitle().equals(expectedTitle)) {
                driver.close();
                break;
            }
        }
    }


}
