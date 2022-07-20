import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.io.File;
import java.time.Duration;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class test_login {

    WebDriver driver;
    Actions action;

    @Test
    public void signup_page() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        //https://stackoverflow.com/questions/34222412/load-chrome-extension-using-selenium - using extension
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("C:\\1_Local_Data\\Working\\Extension\\AdBlock — best ad blocker - Cửa hàng Chrome trực tuyến 4.46.2.0.crx"));
        //
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://generator.email/");
        String gen_email = driver.findElement(By.cssSelector("span#email_ch_text")).getText();
        sleep(5000);
        //https://stackoverflow.com/questions/17547473/how-to-open-a-new-tab-using-selenium-webdriver-in-java
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

        System.out.println(tabs);
        driver.switchTo().window(tabs.get(1));
        driver.close();
        driver.switchTo().window(tabs.get(0));
        //((JavascriptExecutor) driver).executeScript("window.open()");
        driver.get("https://ndt.demo-web.asia/dang-ky/");
        System.out.println(gen_email);
        sleep(3000);
        driver.findElement(By.cssSelector("input[type='email']")).sendKeys(gen_email);
        WebElement checkbox = driver.findElement(By.cssSelector("input[type='checkbox']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        sleep(5000);
        driver.switchTo().window(tabs.get(0));
        sleep(3000);
        driver.get("https://generator.email/"+gen_email);
        sleep(5000);
        String text_verifyEmail = driver.findElement(By.cssSelector("div.mess_bodiyy>p")).getText();
        //Cắt chuỗi
        String[] url_mail = text_verifyEmail.split("\r?\n");
        System.out.println(url_mail[1]);
        //
        driver.get(url_mail[1]);

        driver.findElement(By.cssSelector("input[name='display_name']")).sendKeys(RandomString.make(10));
        WebElement checkbox1= driver.findElement(By.cssSelector("input#diseaseName1"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.cssSelector("button[type = 'submit']")));
        sleep(3000);
        String success = driver.findElement(By.cssSelector("p.pt30.tt-1")).getText();
        Assert.assertEquals(success,"Đăng ký tài khoản thành công!");
    }
}
