package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ShopsPage {
    SelenideElement storesTitle = $(".our-stores .title"),
    oursStores = $(".is-active.our-stores__link"),
    filterStores = $(".map-card.skeleton-wrapper"),
    storesSearchInput = $("input.map-card__search-input"),
    firstStoreOnTheList = $(".map-card .map-address"),
    textSummary = $("div.address-card__descr"),
    shopList = $("div.map-address__descr");


    public String shopsName = "Назарбаев";
    public  String summary = "Daily\n" +
            "Magnum - НАЗАРБАЕВ УНИВЕРСИТЕТ\n" +
            "г. Астана, Кабанбай Батыра 53\n" +
            "Режим работы:09:00 - 23:00";

    @Step("Открытие страницы")
    public ShopsPage openPage(){
        open("/shops?city=astana");
        return this;
    }


    @Step("Ввод {value} в поле 'адрес магазина'")
    public ShopsPage inputStore(String value) {
        storesSearchInput.setValue(value);
        return this;
    }

    @Step("Проверка отображения магазина в списке с адресом: {value}")
    public void checkInputStoreName(String value){
        firstStoreOnTheList.shouldHave(Condition.text(value));
    }

    @Step("Выбор магазина в списке")
    public ShopsPage choiceShop() {
        shopList.$("div", 1).click();
        return this;
    }

    @Step("Проверка описания магазина")
    public void checkSummaryShop(String value){
        textSummary.shouldHave(Condition.text(value));
    }




}
