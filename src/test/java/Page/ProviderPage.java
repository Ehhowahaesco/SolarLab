package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProviderPage extends BaseClass {


    public static void goAdvancedSearchPage() {
        driver.findElement(By.xpath("//h2[contains(text(),'Расширенный поиск')]")).click();
    }
}
