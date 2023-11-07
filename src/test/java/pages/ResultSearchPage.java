package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ResultSearchPage {

    SelenideElement foundProducts = $(".default-wrapper .search");


    public void checkProduct(String value){
        foundProducts.shouldHave(Condition.text(value));
    }
}
