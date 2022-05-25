package steps;

import Page.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.NoSuchElementException;


public class MyStepdefs extends BaseClass {
    MainPage mainPage = new MainPage();
    ProviderPage providerPage = new ProviderPage();
    AdvancedSearchPage advancedSearchPage = new AdvancedSearchPage();
    ResultSearchPage resultSearchPage = new ResultSearchPage();

    @Before
    public void start() {
        setDriver();

    }


    @Given("Открываю главную страницу")
    public void iGoToHttpsWwwRtsTenderRu() {

        navigateToHome();
    }

    @When("Перехожу в раздел Поставщикам в 223-ФЗ")
    public void iSelectInFZ() {

        mainPage.goProvidersPage();
    }

    @And("Я выбираю Расширенный поиск")
    public void iSelectРасширенныйПоиск() {
        providerPage.goAdvancedSearchPage();
    }

    @Then("Перехоржу в раздел Настроить выбираю \"615 - ПП ФР\" и \"Исключить совестные закупки\"")
    public void настроитьВыбираемППФР() {
        advancedSearchPage.goToSettings();
        advancedSearchPage.chooseCheckBoxes();
    }


    @And("Фильтры по датам. Подача заявок с \"сегодня\" по 28")
    public void фильтрыПоДатамПодачаЗаявокСПоСегодня() {

        advancedSearchPage.setFiltersByDate();
    }

    @And("Регион поставки - Алтайский край.")
    public void регионПоставкиАлтайскийКрай() {
        advancedSearchPage.setDeliveryRegion();
    }

    @And("Прохожу по всем закупкам и собираю 'начальная цена' и 'кол-во закупок'")
    public void проходишьПоВсемЗакупкамИСобираешьНачальнаяЦенаИКолВоЗакупок() {

        try {
            //1000
            Thread.sleep(1000);

            resultSearchPage.addStartPrices(startPrices);

        } catch (NoSuchElementException | InterruptedException e) {
            e.printStackTrace();
        }


    }

    @And("Данные аккумулирую в файле, общие суммы вывожу в лог")
    public void данныеАккумулируемВФайлеОбщиеСуммыВыводимВЛог() {

        resultSearchPage.writeFile(startPrices);


    }

    @After
    public void tearDown() {

        closeDriver();
    }

}
