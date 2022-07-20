package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static java.lang.Thread.sleep;

public class GenerateEmail {
    WebDriver driver;
    public String pre_generateEmail() throws InterruptedException {
        driver.get("https://generator.email/");
        sleep(5000);
        String gen_email = driver.findElement(By.cssSelector("span#email_ch_text")).getText();
        return gen_email;
    }
    public String post_generateEmail(String gen_email, int list) throws InterruptedException {
        driver.get("https://generator.email/"+gen_email);
        sleep(5000);
        String text_verifyEmail = driver.findElement(By.cssSelector("div.mess_bodiyy>p")).getText();
        //Cắt chuỗi
        String[] url_mail = text_verifyEmail.split("\r?\n");
        return url_mail[list];
    }
}
