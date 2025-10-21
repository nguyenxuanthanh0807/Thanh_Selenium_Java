import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFox_Demo {

        public static void main(String[] args) {
            WebDriverManager.firefoxdriver().setup();// tự động tải Driver về
            WebDriver driver = new FirefoxDriver();// Mở trình duyệt chorme

            driver.get("https://anhitsolutions.com"); //Truy cập tranh web

            System.out.println("URL Trang: " + driver.getCurrentUrl());
//        driver.quit();

        }

}
