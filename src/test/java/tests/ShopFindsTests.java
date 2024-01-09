package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.ShopsPage;



@Tag("shops")
@Owner("Maksim A")
@Feature("Issues")
public class ShopFindsTests extends TestBase{

    ShopsPage shops = new ShopsPage();


    @Test
    @Story("Promo site")
    @Tags({@Tag("smoke"), @Tag("web")})
    @DisplayName("Поиск магазина")
    public void searchStoreTest() {
        shops.openPage(shops.uri)
                .inputStore(shops.shopName);

        shops.checkInputStoreName(shops.shopName);
    }

    @Test
    @Story("Promo site")
    @Tags({@Tag("smoke"), @Tag("web")})
    @DisplayName("Проверка описания магазина")
    public void descriptionShop() {
        shops.openPage(shops.uri)
                .inputStore(shops.shopName)
                .choiceShop();

        shops.checkSummaryShop(shops.summary);
    }
}