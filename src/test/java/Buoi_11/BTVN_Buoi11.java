package Buoi_11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class BTVN_Buoi11 {
    public static void main(String[] args) throws InterruptedException, AWTException {
        WebDriverManager.chromedriver().setup();// tự động tải Driver về
        WebDriver driver = new ChromeDriver();// Mở trình duyệt chorme
        driver.manage().window().maximize();//Mở trình duyệt toàn màn hình


        //Mở trang web lên
        driver.get("https://anhitsolutions.com/login"); //Truy cập tranh web
        Thread.sleep(2000);
//Dùng Xpath nhập user & password
        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement pass = driver.findElement(By.xpath("//input[@name='password']"));
//        //Nhập dữ liệu
        userName.sendKeys("nguyenxuanthanh0807@gmail.com");
        pass.sendKeys("Xuanthanh0807");

        //Click Submit Button Login
        driver.findElement(By.xpath("//button[@class='btn btn-primary btn-block mt-20']")).click();
        Thread.sleep(2000);

        //Click Cài Đặt
        driver.findElement(By.xpath("//a[contains(@href,'/panel/setting')]")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(@href,'/panel/setting/step/2')]")).click();

        Thread.sleep(2000);




        //Tìm nút Upload
        WebElement uploadButton = driver.findElement(By.xpath("//button[@id='selectAvatarBtn']"));
        uploadButton.click();

        Thread.sleep(5000);
       // Đường dẫn tuyệt đối
        String filePath = "C:\\Users\\DELL\\Downloads\\img\\anime-8801333_1280.png";

        //Copy đường dẫn
        StringSelection ss = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        //Khoi dong robot
        Robot robot = new Robot();
        robot.setAutoDelay(500);

        //Nhan Ctrl + V để paste
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        robot.setAutoDelay(500);
        //Nhấn Enter
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        //Đợi xem thao tác
        Thread.sleep(2000);

        //Tìm nút xác nhận
        driver.findElement(By.xpath("//button[@id='storeAvatar']")).click();
        //Tìm nút save
        driver.findElement(By.xpath("//button[@id='saveData']")).click();





    }
}
