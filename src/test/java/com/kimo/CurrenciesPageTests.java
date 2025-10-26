package com.kimo;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class CurrenciesPageTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://yandex.ru";
    }

    @Test
    @DisplayName("Проверка отображения/скрытия полного текста по нажатию Читать еще/Скрыть")
    void openReadMoreTest() {
        open("/finance/currencies");
        $(byText("Читать ещё")).shouldBe(visible).click();
        $(withText("выбирайте оптимальный момент")).shouldBe(visible);
        $(byText("Скрыть")).shouldBe(visible).click();
        $(withText("выбирайте оптимальный момент")).shouldBe(hidden);
        $(byText("Читать ещё")).shouldBe(visible);
        sleep(5000);
    }

    @Test
    @DisplayName("Проверка увеличения количества отображаемых валют по нажатию Показать еще")
    void expandCurrencyListOnShowMoreClick() {
        open("/finance/currencies");

        $$(".Link.FinanceItemsCard").shouldHave(size(7));
        $(".Button.Button_size_m.Button_view_default.Button_weight_normal" +
                ".Button_pin_circle-circle.FinanceItemsList-Button").click();
        $$(".Link.FinanceItemsCard").shouldHave(size(17));
        sleep(5000);
    }

    @Test
    @DisplayName("Проверка открытия окна с детальной информацией о валюте по нажатию на ее название")
    void clickOnSpecificCurrency() {
        open("/finance/currencies");
        $(".FinanceItemsCard[href*='USD_RUB']").click();
        $(".ConverterSelect-TriggerText").shouldHave(text("USD"));
        sleep(5000);

    }


}





