package steps;

import Page.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.NoSuchElementException;


public class MyStepdefs extends BaseClass {

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
        MainPage.goProvidersPage();
    }

    @And("Я выбираю Расширенный поиск")
    public void iSelectРасширенныйПоиск() {
        ProviderPage.goAdvancedSearchPage();
    }

    @Then("Перехоржу в раздел Настроить выбираю \"615 - ПП ФР\" и \"Исключить совестные закупки\"")
    public void настроитьВыбираемППФР() {
        AdvancedSearchPage.goToSettings();
        AdvancedSearchPage.chooseCheckBoxes();
    }


    @And("Фильтры по датам. Подача заявок с \"сегодня\" по 28")
    public void фильтрыПоДатамПодачаЗаявокСПоСегодня() {
        AdvancedSearchPage.setFiltersByDate();
    }

    @And("Регион поставки - Алтайский край.")
    public void регионПоставкиАлтайскийКрай() {
        AdvancedSearchPage.setDeliveryRegion();
    }

    @And("Прохожу по всем закупкам и собираю 'начальная цена' и 'кол-во закупок'")
    public void проходишьПоВсемЗакупкамИСобираешьНачальнаяЦенаИКолВоЗакупок() {

        try {
            //1000

            ResultSearchPage.addStartPrices(startPrices);

        } catch (NoSuchElementException | InterruptedException e) {
            e.printStackTrace();
        }


    }

    @And("Данные аккумулирую в файле, общие суммы вывожу в лог")
    public void данныеАккумулируемВФайлеОбщиеСуммыВыводимВЛог() {

        ResultSearchPage.writeFile(startPrices);


    }

    @After
    public void tearDown() {

        closeDriver();
    }

}
