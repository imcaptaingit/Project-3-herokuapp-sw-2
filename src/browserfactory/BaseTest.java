package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    //set up base url
    String baseUrl = "http://the-internet.herokuapp.com/login";
    //set up browser
    public static WebDriver driver;

    //set up open browser
    public void openBrowser(String baseUrl) {
        //  Setup Browser
        driver = new ChromeDriver();
        //Open the url
        driver.get(baseUrl);
        //Maximize browser
        driver.manage().window().maximize();
        //Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void closeBrowser() {
        driver.close();
    }
}
