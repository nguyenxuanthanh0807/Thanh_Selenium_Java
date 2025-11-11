package Buoi_6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class DefaulDropDown {
    public static void main(String[] args) throws InterruptedException {
        //1.Khởi tạo Webdriver
        WebDriverManager.chromedriver().setup();// tự động tải Driver về
        WebDriver driver = new ChromeDriver();// Mở trình duyệt chorme
        driver.manage().window().maximize();//Mở trình duyệt toàn màn hình


        //2. Mở trang web lên
        driver.get("https://egov.danang.gov.vn/reg"); //Truy cập tranh web
        Thread.sleep(2000);

        //3. Tìm DropDown Tỉnh Thành phố theo id
        WebElement dropdownElement = driver.findElement(By.xpath("//select[@id='thuongtru_tinhthanh']"));//Tìm Xpath của dropdown gắn vào biến dropdownElement
        Select selectcity = new Select(dropdownElement);//Tạo 1 đối tượng tên là selectcity chứa xpatch của dropdown tỉnh thành

        //4. In ra tất cả giá trị trong dropdown
        List<WebElement> listCity = selectcity.getOptions();//Khai báo 1 list tên là ListCity chứa toàn bộ option của dropdown
        System.out.println("Tổng số tỉnh/Thành: " + listCity.size());//In ra màn hình tổng số Options
        for (WebElement item : listCity) {//Dùng vòng lặp để duyệt qua từng item có trong list city sau in đến hết rôi dừng
            System.out.println(" " + item.getText());

            //

        }

        //5. Kiểm tra dropdown có phải Muti Selct không?
        Assert.assertFalse(selectcity.isMultiple(), "DropDown không được phép chọn nhiều giá trị");

        //6. Chọn giá trị theo visible text
        selectcity.selectByVisibleText("thành phố Hồ Chí Minh");

        //7. Đợi cho giao diện reload
        Thread.sleep(2000);

        //8. Kiểm tra giá trị đã chọn
        String selectedText = selectcity.getFirstSelectedOption().getText();
        System.out.println("Giá trị đã chọn: " + selectedText);
        Assert.assertEquals(selectedText, "Đà Đẵng");

    }
}

