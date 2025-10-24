import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo_ID {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();// tự động tải Driver về
        WebDriver driver = new ChromeDriver();// Mở trình duyệt chorme


        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        driver.get("https://live.techpanda.org/index.php/customer/account/login"); //Truy cập tranh web
//Tìm kiếm Element email theo id sau đó nhập tên email vào text box
       driver.findElement(By.id("email")).sendKeys("Testdemo@gamil.com");

//Tìm kiếm Element password theo name sau đó nhập mật khẩu
        driver.findElement(By.name("login[password]")).sendKeys("123456789");
    }
}
