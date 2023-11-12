package pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

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


    @Step("Отображаются элементы меню")
    public void getBurgerMenu(String... values) {
        for (String value : values) {
            burgerModal.shouldHave(Condition.text(value));
        }
    }
}