package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BaseClass {


    private static WebElement provider = driver.findElement(By.xpath("(//a[contains(text(),'Поставщикам')])"));

    public static void goProvidersPage() {
        provider.click();
    }
}
