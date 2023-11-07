package tests;

import data.NameProductsRandom;
import io.qameta.allure.Description;
import org.junit.jupiter.api.*;
import pages.ResultSearchPage;
import pages.StoresPage;
import pages.SurveyPage;
import pages.components.BurgerModal;
import pages.components.HeaderComponent;
import pages.components.SurveyConfirmModal;

@Tag("Future158")
public class HeaderTests extends TestBase {

    HeaderComponent header = new HeaderComponent();
    ResultSearchPage resultSearchPage = new ResultSearchPage();
    NameProductsRandom products = new NameProductsRandom();
    StoresPage storesPage = new StoresPage();
    BurgerModal burgerModal = new BurgerModal();
    SurveyPage survey = new SurveyPage();
    SurveyConfirmModal surveyConfirm = new SurveyConfirmModal();


    @Test
    @DisplayName("Поиск продукта")
    @Tag("Smoke")
    public void fillSearchFormTest(){
        header.openPage().
                productSearch(products.product);

        resultSearchPage.checkProduct(products.product);

    }

    @Test
    @Tag("Regress")
    @DisplayName("Переключение языка на казахский")
    public void switchLanguageKzTest(){
        header.openPage()
                .selectLanguage(header.langKZ);

        header.checkLanguageKZ(header.catalogText);
    }

    @Test
    @Tag("Smoke")
    @DisplayName("Поиск магазина")
    public void searchStoreTest() {
        header.openPage()
                .choiceStoresSection(header.navigationElementRU[6]);
        storesPage.inputStore(storesPage.storeName);

        storesPage.checkInputStoreName(storesPage.storeName);
    }

    @Test
    @Tag("Regress")
    @DisplayName("Проверка отображения элементов меню")
    public void checkBurgerMenuTest() {
        header.openPage();
        header.clickBurgerButton();

        burgerModal.getBurgerMenu(burgerModal.menuItems[0],burgerModal.menuItems[1],burgerModal.menuItems[2],
                burgerModal.menuItems[3],burgerModal.menuItems[4],burgerModal.menuItems[5],
                burgerModal.menuItems[6],burgerModal.menuItems[7],burgerModal.menuItems[8],
                burgerModal.menuItems[9],burgerModal.menuItems[10],burgerModal.menuItems[11],
                burgerModal.menuItems[12],burgerModal.menuItems[13]);
    }


    @Test
    @Disabled ///Задизейблено, чтобы не спамить письмами в БД
    @Tag("Smoke")
    @DisplayName("Отправка обратной связи по недостоющему товару")
    public void fillSurveyFormTest(){
        survey.openPage();
        survey.setCity(survey.city);
        survey.chooseStoreAddress();
        survey.setProduct(survey.product1, survey.product2);
        survey.setOther(survey.other);
        survey.setPhoneNumber(survey.phoneNumber);
        survey.setEmail(survey.email);
        survey.sendAnswerForSurvey();

        surveyConfirm.successfulConfirm(surveyConfirm.confirmText);

    }
}
