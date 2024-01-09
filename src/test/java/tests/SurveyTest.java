package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import pages.SurveyPage;
import pages.components.SurveyConfirmModal;


@Tag("survey")
@Owner("Maksim A")
@Feature("Email")
public class SurveyTest extends TestBase{

    SurveyPage survey = new SurveyPage();
    SurveyConfirmModal confirm = new SurveyConfirmModal();


    @Test
    @Story("Survey")
    @Disabled("Задизейблено, чтобы не спамить письмами в БД")
    @Tags({@Tag("smoke"), @Tag("web")})
    @DisplayName("Отправка обратной связи по недостающему товару")
    public void fillSurveyFormTest() {
        survey.openPage(survey.uri)
                .setCity(survey.city)
                .chooseStoreAddress()
                .setProduct(survey.product1, survey.product2)
                .setOther(survey.other)
                .sendAnswerForSurvey();

        confirm.successfulConfirm(confirm.confirmText);
    }
}