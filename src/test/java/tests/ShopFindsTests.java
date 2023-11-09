package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.ShopsPage;



@Tag("shops")
public class ShopFindsTests extends TestBase{

    ShopsPage shops = new ShopsPage();


    @Test
    @Tag("smoke")
    @DisplayName("Поиск магазина")
    public void searchStoreTest() {
        shops.openPage()
                .inputStore(shops.shopsName);

        shops.checkInputStoreName(shops.shopsName);
    }

    @Test
    @Tag("smoke")
    @DisplayName("Проверка описания магазина")
    public void descriptionShop() {
        shops.openPage()
                .inputStore(shops.shopsName)
                .choiceShop();

        shops.checkSummaryShop(shops.summary);
    }
}
