package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyStepdefs {
    @Given("I go to main page")
    public void iGoToHttpsWwwRtsTenderRu() {

    }

    @When("I select Поставщикам in 223-ФЗ")
    public void iSelectInФЗ(String arg0, int arg1) {
    }

    @And("I select Расширенный поиск")
    public void iSelectРасширенныйПоиск() {
    }

    @Then("Настроить выбираем 615 - ПП ФР")
    public void настроитьВыбираемППФР(int arg0) {
    }

    @And("Исключить совместные закупки")
    public void исключитьСовместныеЗакупки() {
    }

    @And("Фильтры по датам. Подача заявок с, по \\(сегодня)")
    public void фильтрыПоДатамПодачаЗаявокСПоСегодня() {
    }

    @And("Регион поставки - Алтайский край")
    public void регионПоставкиАлтайскийКрай() {
    }

    @And("Проходишь по всем закупкам и собираешь начальная цена и кол-во закупок")
    public void проходишьПоВсемЗакупкамИСобираешьНачальнаяЦенаИКолВоЗакупок() {
    }

    @And("Данные аккумулируем в файле, общие суммы выводим в лог")
    public void данныеАккумулируемВФайлеОбщиеСуммыВыводимВЛог() {
    }
}
