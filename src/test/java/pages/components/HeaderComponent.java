package pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HeaderComponent {
    SelenideElement headerWrapper = $(".header-wrapper[bis_skin_checked='1']"),
    burgerButton = $(".burger .burger-top"),
    title = $(".header-wrapper .header-top__logo"),
    linkForCorpSite = $(".header-wrapper [href='https://corp.magnum.kz/ru']"),
    inputSearch = $(".header [type='text']"),
    groupDropDownSearch = $(".header-wrapper .search-link-btn"),
    city = $(".header .header-top__address"),
    language = $(".header .header-top__language"),
    dropLanguageMenu = $(".header .header-top__language"),
    navigationElements = $(".header-nav .header-nav__list"),
    catalog = $(".header-nav .catalog-stocks-link"),
    stocks = $(".header-nav .stocks-link");

    public String[] navigationElementRU = {
            "Каталог скидок", "Акции", "Magnum Club",
            "Magnum Go", "Наши бренды", "Готовим с Magnum",
            "Магазины", "Контакты", "О компании"
    };

    String[] navigationElementKZ = {
            "Әлеуметтік желіліктер каталогы", "Науқандар", "Magnum Club",
            "Magnum Go", "Брендтеріміз", "Magnumмен дайындаймыз",
            "Дүкендер", "Байланыс", "Компания туралы"
    };


    public String langKZ = "Қазақша",
    catalogText = "Жеңілдіктер каталогы";

    @Step("Открыть страницу")
    public HeaderComponent openPage(){
        open("/?city=astana");
        return this;
    }


    @Step("Ввести продукт")
    public void productSearch(String value){
        inputSearch.setValue(value).submit();
    }


    @Step()
    public HeaderComponent selectLanguage(String value){
        language.click();
        dropLanguageMenu.$(byText(value)).click();
        return this;
    }

    @Step
    public HeaderComponent checkLanguageKZ(String value){
        catalog.shouldHave(Condition.text(value));
        return this;
    }

    @Step
    public HeaderComponent choiceStoresSection(String value){
        navigationElements.$(byText(value)).click();
        return this;
    }

    @Step
    public HeaderComponent clickBurgerButton() {
        burgerButton.click();
        return this;
    }
}

