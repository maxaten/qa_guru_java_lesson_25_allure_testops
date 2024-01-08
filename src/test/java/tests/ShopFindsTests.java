package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.ShopsPage;



@Tag("shops")
public class ShopFindsTests extends TestBase{

    ShopsPage shops = new ShopsPage();


    @Test
    @Owner("Maksim A")
    @Tags({@Tag("smoke"), @Tag("ui")})
    @DisplayName("Поиск магазина")
    public void searchStoreTest() {
        shops.openPage(shops.uri)
                .inputStore(shops.shopName);

        shops.checkInputStoreName(shops.shopName);
    }

    @Test
    @Owner("Maksim A")
    @Tags({@Tag("smoke"), @Tag("ui")})
    @DisplayName("Проверка описания магазина")
    public void descriptionShop() {
        shops.openPage(shops.uri)
                .inputStore(shops.shopName)
                .choiceShop();

        shops.checkSummaryShop(shops.summary);
    }
}