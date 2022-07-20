import common.GenerateEmail;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.homepage.HomePage;
import page.homepage.Homepage_elm;
import utils.DriverBrowser;

public class basetest {

    WebDriver driver;

    HomePage homePageBeforeLogin;
    GenerateEmail preEmail;

    @BeforeMethod
    public void setup(){
        driver = new DriverBrowser().getDriverBrowser("chrome", false);
        homePageBeforeLogin = new HomePage(driver);

    }

    @AfterMethod
    public void tearDown(){

    }
}
