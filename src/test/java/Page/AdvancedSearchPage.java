package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class AdvancedSearchPage extends BaseClass {
    By settingsButton = By.xpath("//span[@class='filter__open-modal']");
    By ppRFCheckBox = By.xpath("//label[contains(text(),'615-ПП РФ')]");
    By excludeJointPurchasesCheckBox = By.xpath("//label[contains(text(),'Исключить совместные закупки')]");
    By dateFilters = By.xpath("//div[contains(text(),'Фильтры по датам')]");
    By dateInputFirst = By.xpath("(//input[@type='text'])[4]");
    By dateInputLast = By.xpath("(//input[@type='text'])[5]");
    By deliveryRegionOption = By.xpath("//div[contains(text(),'Регион поставки')]");
    By deliveryRegionPlaceHolder = By.xpath("(//input[@placeholder='Регион поставки'])[1]");
    By searchSuggest = By.xpath("//a[@class='cstm-search__suggest']");
    By searchButton = By.xpath("//button[@class='search__btn bottomFilterSearch']");


    public  void goToSettings() {
        driver.findElement(settingsButton).click();
    }

    public  void chooseCheckBoxes() {
        driver.findElement(ppRFCheckBox).click();
        driver.findElement(excludeJointPurchasesCheckBox).click();
    }

    public  void setFiltersByDate() {
        driver.findElement(dateFilters).click();
        WebElement firstDate = driver.findElement(dateInputFirst);
        firstDate.click();
        firstDate.sendKeys(formatter.format(dateNow));
        firstDate.sendKeys(Keys.ENTER);

        WebElement lastDate = driver.findElement(dateInputLast);
        lastDate.click();
        lastDate.sendKeys(formatter.format(dateNow));
        lastDate.sendKeys(Keys.ENTER);



    }

    public  void setDeliveryRegion() {
        driver.findElement(deliveryRegionOption).click();
        WebElement inputDeliveryRegion = driver.findElement(deliveryRegionPlaceHolder);

        inputDeliveryRegion.sendKeys("Алтайский край");
        driver.findElement(searchSuggest).click();
        driver.findElement(searchButton).click();
    }

}
