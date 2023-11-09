package tests;

import data.NameProductsRandom;
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
    @DisplayName("Поиск продукта")
    @Tag("smoke")
    public void fillSearchFormTest(){
        header.openPage(header.mainPage).
                productSearch(products.name);

        resultSearchPage.checkProduct(products.name);

    }

    @Test
    @Tag("regress")
    @DisplayName("Переключение языка на казахский")
    public void switchLanguageKzTest(){
        header.openPage(header.mainPage)
                .selectLanguage(header.langKZ);

        header.checkLanguageKZ(header.catalogName);
    }

    @Test
    @Tag("regress")
    @DisplayName("Проверка отображения элементов меню")
    public void checkBurgerMenuTest() {
        header.openPage(header.mainPage)
                .clickBurgerButton();

        burger.getBurgerMenu(burger.menu[0], burger.menu[1], burger.menu[2],
                burger.menu[3], burger.menu[4], burger.menu[5],
                burger.menu[6], burger.menu[7], burger.menu[8],
                burger.menu[9], burger.menu[10], burger.menu[11],
                burger.menu[12], burger.menu[13]);
    }
}