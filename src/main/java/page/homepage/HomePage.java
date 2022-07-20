package page.homepage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    String ULR = "http://ndt.demo-web.asia/";

    WebDriver driver;

    WebDriverWait wait;

    Homepage_elm element;

    public HomePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        element = new Homepage_elm(driver);
    }

    public HomePage navigate_Homepage(){
        driver.get(ULR);
        return this;
    }

}
