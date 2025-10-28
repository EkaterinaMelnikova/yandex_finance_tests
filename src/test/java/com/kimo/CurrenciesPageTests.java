package com.kimo;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class CurrenciesPageTests extends TestBase {

    int currencyAmount1 = 7;
    int currencyAmount2 = 17;
    String currencyName = "USD";


    @Test
    @DisplayName("Проверка отображения/скрытия полного текста по нажатию Читать еще/Скрыть")
    void openReadMoreTest() {
        open("/finance/currencies");
        $(byText("Читать ещё")).shouldBe(visible).click();
        $(withText("выбирайте оптимальный момент")).shouldBe(visible);
        $(byText("Скрыть")).shouldBe(visible).click();
        $(withText("выбирайте оптимальный момент")).shouldBe(hidden);
        $(byText("Читать ещё")).shouldBe(visible);
    }

    @Test
    @DisplayName("Проверка увеличения количества отображаемых валют по нажатию Показать еще")
    void expandCurrencyListOnShowMoreClick() {
        open("/finance/currencies");

        $$(".Link.FinanceItemsCard").shouldHave(size(currencyAmount1 ));
        $(".Button.Button_size_m.Button_view_default.Button_weight_normal" +
                ".Button_pin_circle-circle.FinanceItemsList-Button").click();
        $$(".Link.FinanceItemsCard").shouldHave(size(currencyAmount2 ));
    }

    @Test
    @DisplayName("Проверка открытия  детальной информации о валюте по нажатию на ее название")
    void clickOnSpecificCurrency() {
        open("/finance/currencies");
        $(".FinanceItemsCard[href*='" + currencyName + "_RUB']").click();
        $(".ConverterSelect-TriggerText").shouldHave(text(currencyName));


    }


}





