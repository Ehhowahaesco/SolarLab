package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.NoSuchElementException;

public class ResultSearchPage extends BaseClass {
    By nextButton = By.xpath("//a[contains(text(),'>')]");
    By priceLocator = By.xpath("//div[@class='card-item__properties-desc']");


    public  void addStartPrices(List<String> startPrices) throws NoSuchElementException, InterruptedException {
        List<WebElement> prices;
        boolean visibleElement;


        do {
            //1000


            visibleElement = driver.findElements(nextButton).size() > 0;

            prices = driver.findElements(priceLocator);

            for (int i = 0; i < prices.size(); i += 4) {

                startPrices.add(prices.get(i).getAttribute("content"));

            }

            if (visibleElement) {
                driver.findElement(nextButton).click();
            }

        } while (visibleElement);

    }


    public static void writeFile(List<String> list) {
        File file = new File("testFile");
        try {

            PrintWriter pw = new PrintWriter(file);

            pw.println("Колличество закупок : " + list.size());

            for (int i = 0; i < list.size(); i++) {
                pw.println(i + 1 + ")) " + list.get(i));
            }
            pw.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
