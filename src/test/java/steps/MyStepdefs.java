package steps;

import Page.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;


import java.text.SimpleDateFormat;

import java.util.Date;


public class MyStepdefs extends BaseClass {

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    Date date = new Date(System.currentTimeMillis());


    @Before
    public void start() {
        setDriver();

    }


    @Given("I go to main page")
    public void iGoToHttpsWwwRtsTenderRu() {
        navigateToHome();
    }

    @When("I select Поставщикам in 223-ФЗ")
    public void iSelectInФЗ() {
        MainPage.goProvidersPage();
    }

    @And("I select Расширенный поиск")
    public void iSelectРасширенныйПоиск() {
        ProviderPage.goAdvancedSearchPage();
    }

    @Then("Настроить выбираем 615 - ПП ФР")
    public void настроитьВыбираемППФР() {
        AdvancedSearchPage.goToSettings();
        AdvancedSearchPage.chooseCheckBoxes();
    }

    @And("Исключить совместные закупки")
    public void исключитьСовместныеЗакупки() {
    }

    @And("Фильтры по датам. Подача заявок с, по \\(сегодня)")
    public void фильтрыПоДатамПодачаЗаявокСПоСегодня() {
        AdvancedSearchPage.setFiltersByDate();
    }

    @And("Регион поставки - Алтайский край")
    public void регионПоставкиАлтайскийКрай() {
        AdvancedSearchPage.setDeliveryRegion();
    }

    @And("Проходишь по всем закупкам и собираешь начальная цена и кол-во закупок")
    public void проходишьПоВсемЗакупкамИСобираешьНачальнаяЦенаИКолВоЗакупок() {

        waitWebElement(purchasePage1);
        ResultSearchPage.addStartPrices(startPrices);
        driver.findElement(By.xpath("//a[contains(text(),'>')]")).click();
        waitWebElement(purchasePage2);
        ResultSearchPage.addStartPrices(startPrices);
        driver.findElement(By.xpath("//a[contains(text(),'>')]")).click();
        waitWebElement(purchasePage3);
        ResultSearchPage.addStartPrices(startPrices);

        for (int i = 0; i < startPrices.size(); i++) {
            System.out.println(startPrices.get(i));
        }
        System.out.println(startPrices.size());

    }

    @And("Данные аккумулируем в файле, общие суммы выводим в лог")
    public void данныеАккумулируемВФайлеОбщиеСуммыВыводимВЛог() {
        ResultSearchPage.writeFile(startPrices);
    }

    @After
    public void tearDown() {

        closeDriver();
    }
}
