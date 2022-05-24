package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class AdvancedSearchPage extends BaseClass {


    public static void goToSettings() {
        driver.findElement(By.xpath("//span[@class='filter__open-modal']")).click();
    }

    public static void chooseCheckBoxes() {
        driver.findElement(By.xpath("//label[contains(text(),'615-ПП РФ')]")).click();
        driver.findElement(By.xpath("//label[contains(text(),'Исключить совместные закупки')]")).click();
    }

    public static void setFiltersByDate() {
        driver.findElement(By.xpath("//div[contains(text(),'Фильтры по датам')]")).click();
        WebElement dateInput1 = driver.findElement(By.xpath("(//input[@type='text'])[4]"));
        dateInput1.click();
        dateInput1.sendKeys(formatter.format(dateNow));
        dateInput1.sendKeys(Keys.ENTER);

        WebElement dateInput2 = driver.findElement(By.xpath("(//input[@type='text'])[5]"));
        dateInput2.click();
        dateInput2.sendKeys(formatter.format(dateNow));
        dateInput2.sendKeys(Keys.ENTER);
    }

    public static void setDeliveryRegion() {
        driver.findElement(By.xpath("//div[contains(text(),'Регион поставки')]")).click();
        WebElement inputDeliveryRegion = driver.findElement(By.xpath("(//input[@placeholder='Регион поставки'])[1]"));

        inputDeliveryRegion.sendKeys("Алтайский край");
        driver.findElement(By.xpath("//a[@class='cstm-search__suggest']")).click();
        driver.findElement(By.xpath("//button[@class='search__btn bottomFilterSearch']")).click();
    }

}
