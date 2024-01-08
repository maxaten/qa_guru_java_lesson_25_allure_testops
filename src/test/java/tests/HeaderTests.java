package tests;

import data.NameProductsRandom;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;
import pages.ResultSearchPage;
import pages.components.BurgerModal;
import pages.components.HeaderComponent;



@Tag("header")
public class HeaderTests extends TestBase {

    HeaderComponent header = new HeaderComponent();
    ResultSearchPage resultSearchPage = new ResultSearchPage();
    NameProductsRandom products = new NameProductsRandom();
    BurgerModal burger = new BurgerModal();



    @Test
    @Owner("Maksim A")
    @DisplayName("Поиск продукта")
    @Tags({@Tag("regress"), @Tag("ui")})
    public void fillSearchFormTest(){
        header.openPage(header.mainPage).
                productSearch(products.name);

        resultSearchPage.checkProduct(products.name);

    }

    @Test
    @Owner("Maksim A")
    @Tags({@Tag("regress"), @Tag("ui")})
    @DisplayName("Переключение языка на казахский")
    public void switchLanguageKzTest(){
        header.openPage(header.mainPage)
                .selectLanguage(header.langKZ);

        header.checkLanguageKZ(header.catalogName);
    }

    @Test
    @Owner("Maksim A")
    @Tags({@Tag("regress"), @Tag("ui")})
    @DisplayName("Проверка отображения элементов меню")
    public void checkBurgerMenuTest() {
        header.openPage(header.mainPage)
                .clickBurgerButton();

        burger.getBurgerMenu(burger.menu);
    }
}