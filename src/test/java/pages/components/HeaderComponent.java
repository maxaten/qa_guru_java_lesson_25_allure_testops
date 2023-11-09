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



    public String langKZ = "Қазақша",
    catalogName = "Жеңілдіктер каталогы",
            mainPage = "/?city=astana";


    @Step("Открытие страницы {value} ")
    public HeaderComponent openPage(String value){
        open(value);

        return this;
    }

    @Step("Ввод продукта: {value}")
    public void productSearch(String value){
        inputSearch.setValue(value).submit();
    }


    @Step("Выбор казахского языка")
    public void selectLanguage(String value){
        language.click();
        dropLanguageMenu.$(byText(value)).click();
    }

    @Step("Проверка смена названия каталога на: {value}")
    public void checkLanguageKZ(String value){
        catalog.shouldHave(Condition.text(value));
    }

    @Step("Открытие бургер-меню")
    public void clickBurgerButton() {
        burgerButton.click();
    }
}