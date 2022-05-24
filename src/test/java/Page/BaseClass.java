package Page;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    public static WebDriver driver;
    public static List<String> startPrices = new ArrayList<>();
    private static String URL = "https://www.rts-tender.ru/";

    static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    static Date dateNow = new Date(System.currentTimeMillis());


    public void setDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    public void navigateToHome() {
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();

    }

    public static void closeDriver() {
        driver.quit();
    }


}
