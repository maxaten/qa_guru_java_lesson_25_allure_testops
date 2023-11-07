package pages;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SurveyPage {

    Faker faker = new Faker();

    SelenideElement cityField = $(".interview__form .interview__select-value"),
    cityList = $(".interview .interview__select-list"),
    storeInput = $("[placeholder='Выберите магазин или введите его адрес']"),
    storeList = $(".active.interview__select-dropdown"),
    productInput = $("[placeholder='Укажите товары']"),
    checkboxProduct = $("[for='other']"),
    otherInput = $("[placeholder='Напишите другой вариант']"),
    phoneInput = $("[placeholder='Укажите номер']"),
    emailInput = $("[placeholder='Укажите e-mail']"),
    submitButton = $(".interview__btn").$(byText("Отправить"));

    public String city = getRandomCity(),
    product1 = getRandomProduct(),
    product2 = getRandomProduct(),
    phoneNumber = getRandomNumberPhone(),
    email = getRandomEmail(),
    other = "Другое";



    public void openPage(){
        open("interview");
    }

    private String getRandomCity(){
        String[] city = {"Астана", "Алматы", "Караганда", "Петропавловск", "Москва"};

        return faker.options().option(city);
    }


    public void setCity(String value){
        cityField.click();
        cityList.$(byText(value)).click();
    }

    public void chooseStoreAddress(){
        storeInput.click();
        storeList.$("li",2).click();

    }

    private String getRandomProduct(){
        String[] product = {"Сахар 2кг", "Молоко 2л", "Сок 3л", "Мука 3кг"};

        return faker.options().option(product);
    }

    public void setProduct(String value, String value2){
        productInput.setValue(value).setValue(value2);
    }

    public void setOther(String value){
        checkboxProduct.click();
        otherInput.setValue(value);
    }

    private String getRandomNumberPhone(){
        return "7707" + faker.phoneNumber().subscriberNumber(7);
    }

    public void setPhoneNumber(String value){
        phoneInput.setValue(value);
    }

    private String getRandomEmail(){
        return faker.internet().emailAddress();
    }

    public void setEmail(String value){
        emailInput.setValue(value);
    }

    public void sendAnswerForSurvey(){
        submitButton.click();
    }


}



