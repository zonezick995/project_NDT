package page.homepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage_elm {
    WebDriver driver;

    public Homepage_elm(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "button.mt-10")
    WebElement BENH_NHAN_BTN;

    @FindBy(css = "a.my-30")
    WebElement DANG_NHAP_BTN;
}
