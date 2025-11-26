package Buoi_9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class IfameByWebElementDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();// tự động tải Driver về
        WebDriver driver = new ChromeDriver();// Mở trình duyệt chorme
        driver.manage().window().maximize();//Mở trình duyệt toàn màn hình


        //Mở trang web lên
        driver.get("https://anhitsolutions.com/contact"); //Truy cập tranh web
        Thread.sleep(2000);

        WebElement ifameElement = driver.findElement(By.xpath("//iframe[@title='YouTube video player']"));

        //Switch vào iframe bằng WebElement
        driver.switchTo().frame(ifameElement);

        //Tìm nút Play bằng Xpath
        WebElement playButton = driver.findElement(By.xpath("//button[contains(@class,'ytp-large-play-button')]"));


        //Click Play
        playButton.click();

        //Chờ cho video chạy 1 chút
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
        }

        //Quay lại trang chính
        driver.switchTo().defaultContent();

        //Click vào khóa học
        driver.findElement(By.xpath("//a[text()='Khoá học']")).click();
        Thread.sleep(3000);



    }
}
