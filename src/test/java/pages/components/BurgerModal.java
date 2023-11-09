package pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class BurgerModal {

    SelenideElement burgerModal = $(".header-menu .header-menu__content");

    public String[] menu = {
            "Акции",
            "Каталог скидок",
            "Программа лояльности",
            "Готовим с Magnum",
            "Заказ с доставкой",
            "Магазины",
            "Magnum Corp.",
            "Контакты",
            "О компании",
            "Работа в Magnum",
            "Наши бренды",
            "Magnum News",
            "Служба Комплаенс",
            "Опрос по ассортименту"
    };


    public void getBurgerMenu(String value0, String value1, String value2, String value3, String value4,
                              String value5, String value6, String value7, String value8, String value9,
                              String value10, String value11, String value12 , String value13) {
        for (String menuItem : menu) {
            burgerModal.shouldHave(Condition.text(menuItem));
        }
    }
}
