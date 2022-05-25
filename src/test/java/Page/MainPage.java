package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BaseClass {

    By providersButton = By.xpath("(//a[@class='link'][contains(text(),'Поставщикам')])[2]");

    public void goProvidersPage() {

        driver.findElement(providersButton).click();
    }
}
