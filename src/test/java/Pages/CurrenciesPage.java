package Pages;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class CurrenciesPage {

    public CurrenciesPage openPage (){
        open("/finance/currencies");

        return this;
    }

    public CurrenciesPage clickReadMore(){
        $(byText("Читать ещё")).shouldBe(visible).click();

        return this;
    }

    public CurrenciesPage checkFullTextVisible(){
        $(withText("выбирайте оптимальный момент")).shouldBe(visible);

        return this;
    }

    public CurrenciesPage clickHide(){
        $(byText("Скрыть")).shouldBe(visible).click();

        return this;
    }

    public CurrenciesPage checkFullTextHidden(){
        $(withText("выбирайте оптимальный момент")).shouldBe(hidden);
        $(byText("Читать ещё")).shouldBe(visible);

        return this;
    }

    public CurrenciesPage checkCurrencyAmount(int value){
        $$(".Link.FinanceItemsCard").shouldHave(size(value));

        return this;
    }

    public CurrenciesPage clickShowMore(){
        $(".Button.Button_size_m.Button_view_default.Button_weight_normal" +
                ".Button_pin_circle-circle.FinanceItemsList-Button").click();

        return this;
    }

    public CurrenciesPage checkCurrencyAmountAfterClickShowMore1(int value){
        $$(".Link.FinanceItemsCard").shouldHave(size(value));

        return this;
    }

    public CurrenciesPage clickCurrencyName(String value){
        $(".FinanceItemsCard[href*='" + value + "_RUB']").click();

        return this;
    }

    public CurrenciesPage checkCurrencyNameOnThePage(String value){
        $(".ConverterSelect-TriggerText").shouldHave(text(value));

        return this;
    }



}
