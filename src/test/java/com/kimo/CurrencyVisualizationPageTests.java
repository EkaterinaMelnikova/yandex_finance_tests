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
import static com.codeborne.selenide.files.DownloadActions.click;

public class CurrencyVisualizationPageTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://yandex.ru";

    }

    @Test
    @DisplayName("Проверка актуальности даты текущего курса")
    void checkCurrentDate() {
        open("/finance/currencies/USD_RUB");
        String currentDate = LocalDate.now()
                .format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $(".ConverterFooter-Time")
                .shouldHave(text("Обновлено " + currentDate));
        sleep(5000);
        // TODO: Добавить if для проверки в выходной день

    }

    @Test
    @DisplayName("Проверка отображения конвертируемой валюты после ее смены")
    void checkCurrencyChange() {
        open("/finance/currencies/USD_RUB");
        $("button[aria-label='Валюта: USD']").click();
        $(byText("Австралийский доллар")).click();
        sleep(1000);
        $("button[aria-describedby='«R4j»']").shouldHave(text("AUD"));
    }

    @Test
    @DisplayName("Поверка отображения валют после нажатия кнопки Поменять местами значения")
    void chengeCurrencyPlaces() {
        open("/finance/currencies/USD_RUB");
        String currency1 = $("button[aria-describedby='«R4j»']").getText();
        System.out.println(currency1);
        String currency2 = $("button[aria-describedby='«R5j»']").getText();
        System.out.println(currency2);
        $("[aria-label=\"Поменять местами значения\"]").click();
        $("button[aria-describedby='«R4j»']").shouldHave(text(currency2));
        $("button[aria-describedby='«R5j»']").shouldHave(text(currency1));

    }
}





