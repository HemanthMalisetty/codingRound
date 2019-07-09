package utility;

import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class DriverBase {

    public WebDriver driver;

    @BeforeTest
    public void setDriverPath(){
        if (PlatformUtil.isMac()){
            System.setProperty("webdriver.chrome.driver","chromedriver_mac");
        }
        if (PlatformUtil.isWindows()){
            System.setProperty("webdriver.chrome.driver","chromedriver.exe");
            ChromeOptions ops = new ChromeOptions();
            ops.addArguments("--disable-notifications");
            driver = new ChromeDriver(ops);
            driver.manage().window().maximize();
        }
        if (PlatformUtil.isLinux()){
            System.setProperty("webdriver.chrome.driver","chromedriver_linux");
        }
    }
    @AfterTest
    public void closeBrowser(){
        driver.close();
    }
}
