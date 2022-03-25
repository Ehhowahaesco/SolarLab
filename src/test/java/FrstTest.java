import io.cucumber.java.it.Ma;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class FrstTest {
    WebDriver driver;
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    Date date = new Date(System.currentTimeMillis());
    @Before
    public void start(){
        WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
         driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);



    }



    @Test
    public void mainPage(){
        try {
        driver.manage().window().maximize();
        driver.get("https://www.rts-tender.ru/");
        driver.findElement(By.xpath("(//a[contains(text(),'Поставщикам')])")).click();
        driver.findElement(By.xpath("//h2[contains(text(),'Расширенный поиск')]")).click();
        driver.findElement(By.xpath("//span[@class='filter__open-modal']")).click();
        driver.findElement(By.xpath("//label[contains(text(),'615-ПП РФ')]")).click();
        driver.findElement(By.xpath("//label[contains(text(),'Исключить совместные закупки')]")).click();
        driver.findElement(By.xpath("//div[contains(text(),'Фильтры по датам')]")).click();
       WebElement b = driver.findElement(By.xpath("(//input[@type='text'])[4]"));
               b.click();
       b.sendKeys(formatter.format(date));
       b.sendKeys(Keys.ENTER);

      WebElement a =  driver.findElement(By.xpath("(//input[@type='text'])[5]"));
      a.click();
      a.sendKeys("28-03-2022");
      a.sendKeys(Keys.ENTER);

      driver.findElement(By.xpath("//div[contains(text(),'Регион поставки')]")).click();
     WebElement c = driver.findElement(By.xpath("(//input[@placeholder='Регион поставки'])[1]"));

     c.sendKeys("Алтайский край");
     driver.findElement(By.xpath("//a[@class='cstm-search__suggest']")).click();
     driver.findElement(By.xpath("//button[@class='search__btn bottomFilterSearch']")).click();




            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    @After
    public void tearDown(){
        driver.quit();
    }

}
