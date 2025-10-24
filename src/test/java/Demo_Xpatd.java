import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo_Xpatd {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();// tự động tải Driver về
        WebDriver driver = new ChromeDriver();// Mở trình duyệt chorme


        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); //Truy cập tranh web
//Dùng Xpath nhập user & password
        sleep(2000);
        driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");

    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);

        }catch (InterruptedException e ){
            e.printStackTrace();
        }
    }
}
