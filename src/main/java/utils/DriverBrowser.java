package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.io.File;

public class DriverBrowser {
    private WebDriver driver;

    public WebDriver getDriverBrowser(String browser, boolean headless){
        if(driver == null){
            switch (browser){
                case "edge" ->{
                    WebDriverManager.edgedriver().setup();
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.setHeadless(headless);
                    edgeOptions.addExtensions(new File("C:\\1_Local_Data\\Working\\Extension\\AdBlock — best ad blocker - Cửa hàng Chrome trực tuyến 4.46.2.0.crx"));
                    //
                    driver = new EdgeDriver(edgeOptions);
                }
                default -> {
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.setHeadless(headless);
                    chromeOptions.addExtensions(new File("C:\\1_Local_Data\\Working\\Extension\\AdBlock — best ad blocker - Cửa hàng Chrome trực tuyến 4.46.2.0.crx"));
                    //
                    driver = new ChromeDriver(chromeOptions);
                }
            }
        }
        driver.manage().window().maximize();
        return driver;
    }
}

