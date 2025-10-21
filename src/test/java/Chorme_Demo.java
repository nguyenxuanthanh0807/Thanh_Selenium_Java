import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chorme_Demo {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();// tự động tải Driver về
        WebDriver driver = new ChromeDriver();// Mở trình duyệt chorme

        driver.get("https://anhitsolutions.com"); //Truy cập tranh web

        System.out.println("Tiêu Đề Trang: " + driver.getTitle());
//        driver.quit();

    }
}
