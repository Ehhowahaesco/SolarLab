package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.NoSuchElementException;

public class ResultSearchPage extends BaseClass {


    public static void addStartPrices(List<String> startPrices) {
        List<WebElement> prices = driver.findElements(By.xpath("//div[@class='card-item__properties-desc']"));

        for (int i = 0; i < prices.size(); i += 4) {

            startPrices.add(prices.get(i).getAttribute("content"));


        }


    }

    public static void writeFile(List<String> list) {
        File file = new File("testFile");
        try {


            PrintWriter pw = new PrintWriter(file);

            pw.println("Колличество закупок : " + list.size());

            for (int i = 0; i < list.size(); i++) {
                pw.println(i + 1 +") " +list.get(i));
            }
            pw.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void sumPrices(List<String> list){
        int sum = 0;
        for(int i = 0; i < list.size(); i++){
           sum += Integer.parseInt(list.get(i));
        }
        System.out.println(sum);
    }
}
