package com.kimo;

import org.junit.jupiter.api.BeforeAll;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.remote.tracing.EventAttribute.setValue;

public class FinancePageTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://yandex.ru";
    }

    @Test
    @DisplayName("Проверка перехода в окно Курсы валют по кнопке Валюты > Показать все")
    void openCurrenciesPageTest(){
        open ("/finance");
        $(".FinanceDailyTrends-ListItem_item_currency").click();
        $(".FinanceDailyTrends-Link").click();
        $(".FinancePageHeader-Title").shouldBe(visible);
        $(".FinancePageHeader-Title").shouldHave(text("Курсы валют"));
        sleep(5000);
    }

    @Test
    @DisplayName("Проверка поиска Курсов валют через строку Поиска")
    void findCurrenciesPageViaSearchTest(){
        open ("/finance");
        $("textarea[placeholder='Найти финансовый продукт']").click();
        $("textarea[placeholder='Найти финансовый продукт']").setValue("валют");
        $("textarea[placeholder='Найти финансовый продукт']").pressEnter();
        $(".FinancePageHeader-Title").shouldHave(text("Курсы валют"));
        sleep(5000);


    @Test
    @DisplayName("Проверка открытия окна Курсы валют по ссылке Курсы валют в Популярных запросах")
    void scrollСurrencyRightTest(){
        open ("/finance");
        $$(".Link_theme_neoblueDark").findBy(text("Курсы валют")).click();
        $(".FinancePageHeader-Title").shouldHave(text("Курсы валют"));
        sleep(5000);
    }
}
