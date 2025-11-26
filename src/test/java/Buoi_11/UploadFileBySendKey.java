package Buoi_11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadFileBySendKey {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://blueimp.github.io/jQuery-File-Upload/");
        Thread.sleep(2000);

        //Đường dẫn tuyệt đối
//        String filePath = "C:\\Users\\DELL\\Downloads\\img\\anime-8801333_1280.png";
        String filePath =
                "C:\\Users\\DELL\\Downloads\\img\\anime-8801333_1280.png\n" +
                        "C:\\Users\\DELL\\Downloads\\img\\OIP.webp";




        //Tìm input upload file
        WebElement uploadInput = driver.findElement(By.xpath("//input[@name='files[]']"));

        //Upload file = send key
        uploadInput.sendKeys(filePath);

        Thread.sleep(5000);



    }
}
