package Page;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    public static WebDriver driver;

    public static String purchasePage1 = "//a[contains(text(),'Закупка №0139200000122002527 в ЕИС')]";
    public static String purchasePage2 = "//a[contains(text(),'Закупка №0317100017522000001 в ЕИС')]";
    public static String purchasePage3 = "//a[contains(text(),'Закупка №0217100000122000068 в ЕИС')]";
    public static List<String> startPrices = new ArrayList<>();
    public static final Logger logger = LogManager.getLogger();
    private static String URL = "https://www.rts-tender.ru/";

    static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    static Date date = new Date(System.currentTimeMillis());


    public void setDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    public void navigateToHome() {
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();

    }

    public static void closeDriver() {
        driver.quit();
    }

    public static void waitWebElement(String element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
    }
}
