package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class StoresPage {
    SelenideElement storesTitle = $(".our-stores .title"),
    oursStores = $(".is-active.our-stores__link"),
    filterStores = $(".map-card.skeleton-wrapper"),
    storesSearchInput = $("input.map-card__search-input"),
    firstStoreOnTheList = $(".map-card .map-address");


    public String storeName = "Назарбаев";

    public void inputStore(String value) {
        storesSearchInput.setValue(value);
    }

    public void checkInputStoreName(String value){
        firstStoreOnTheList.shouldHave(Condition.text(value));
    }


}
