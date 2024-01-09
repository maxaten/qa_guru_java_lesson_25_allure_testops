package tests;

import data.NameProductsRandom;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import pages.ResultSearchPage;
import pages.components.BurgerModal;
import pages.components.HeaderComponent;



@Tag("header")
@Owner("Maksim A")
@Feature("Issues")
public class HeaderTests extends TestBase {

    HeaderComponent header = new HeaderComponent();
    ResultSearchPage resultSearchPage = new ResultSearchPage();
    NameProductsRandom products = new NameProductsRandom();
    BurgerModal burger = new BurgerModal();



    @Test
    @Story("Header")
    @Tags({@Tag("regress"), @Tag("web")})
    @DisplayName("Поиск продукта")
    public void fillSearchFormTest(){
        header.openPage(header.mainPage).
                productSearch(products.name);

        resultSearchPage.checkProduct(products.name);

    }

    @Test
    @Story("Header")
    @Tags({@Tag("regress"), @Tag("web")})
    @DisplayName("Переключение языка на казахский")
    public void switchLanguageKzTest(){
        header.openPage(header.mainPage)
                .selectLanguage(header.langKZ);

        header.checkLanguageKZ(header.catalogName);
    }

    @Test
    @Story("Header")
    @Tags({@Tag("regress"), @Tag("web")})
    @DisplayName("Проверка отображения элементов меню")
    public void checkBurgerMenuTest() {
        header.openPage(header.mainPage)
                .clickBurgerButton();

        burger.getBurgerMenu(burger.menu);
    }
}