package Buoi_5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginAnhIT {
    public static void main(String[] args) throws InterruptedException {
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

        //Check email
        Thread.sleep(2000);
        try {
            WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
            String actualEmail = email.getAttribute("value");
            System.out.println("Email value: " + actualEmail);
            String expectEmail = "Nguyenxuanthanh0807@gmail.com";

            if (actualEmail.equals(expectEmail)) {
                System.out.println("✅ TC Pass: " + actualEmail);
            } else {
                System.out.println("❌ TC Failed: " + actualEmail);
            }

            //Check UserName
            WebElement username = driver.findElement(By.xpath("//input[@name='full_name']"));
            String actualUserName = username.getAttribute("value");
            System.out.println("UserName value: " + actualUserName);
            String expectUserName = "Nguyễn Xuân Thành";

            if (actualUserName.equals(expectUserName)) {
                System.out.println("✅ TC Pass: " + actualUserName);
            } else {
                System.out.println("❌ TC Failed: " + actualUserName);
            }

            //Check PhoneNumber
            WebElement phone = driver.findElement(By.xpath("//input[@name='mobile']"));
            String actualPhone = phone.getAttribute("value");
            System.out.println("Phone value: " + actualPhone);
            String expectPhone = "0778880807";

            if (actualPhone.equals(expectPhone)) {
                System.out.println("✅ TC Pass: " + actualPhone);
            } else {
                System.out.println("❌ TC Failed: " + actualPhone);
            }

        } catch (Exception e) {
            System.out.println("❌ TC Failed - Không tìm thấy phần tử username");
            e.printStackTrace();
        }
//Click Giới thiệu
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(@href,'/panel/setting/step/3')]")).click();


        //Check Tiểu Sử
        Thread.sleep(2000);
        try {
            WebElement Biography = driver.findElement(By.xpath("//textarea[@name='about']"));
            String actualBiography = Biography.getAttribute("value");
            System.out.println("Biography value: " + actualBiography);
            String expectBiography = "Kiểm thử và đảm bảo chất lượng";

            if (actualBiography.equals(expectBiography)) {
                System.out.println("✅ TC Pass: " + actualBiography);
            } else {
                System.out.println("❌ TC Failed: " + actualBiography);
            }

            //Check Tiêu đề
            WebElement Bio = driver.findElement(By.xpath("//textarea[@name='bio']"));
            String actualBio = Bio.getAttribute("value");
            System.out.println("Bio value: " + actualBio);
            String expectUserName = "QA/QC Engineer";

            if (actualBio.equals(expectUserName)) {
                System.out.println("✅ TC Pass: " + actualBio);
            } else {
                System.out.println("❌ TC Failed: " + actualBio);
            }



        } catch (Exception e) {
            System.out.println("❌ TC Failed - Không tìm thấy phần tử username");
            e.printStackTrace();
        }


    }
}
