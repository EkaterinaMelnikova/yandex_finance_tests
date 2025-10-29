package com.kimo;

import Pages.CurrencyVisualizationPage;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class CurrencyVisualizationPageTestsPOM extends TestBase {


    CurrencyVisualizationPage currencyVisualizationPage = new CurrencyVisualizationPage();

    String currencyName = "USD";

    @Test
    @DisplayName("Проверка актуальности даты текущего курса")
    void checkCurrentDate() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        currencyVisualizationPage.openPage(currencyName)
                .pageDateShouldMatchCurrentDate();

    }

    @Test
    @DisplayName("Проверка отображения конвертируемой валюты после ее смены")
    void checkCurrencyChange() {

        currencyVisualizationPage.openPage(currencyName)
                .changeConvertCurrency(currencyName)
                .checkConvertCurrency();

    }

    @Test
    @DisplayName("Поверка отображения валют после нажатия кнопки Поменять местами значения")
    void chengeCurrencyPlaces() {

        currencyVisualizationPage.openPage(currencyName)
                .saveCurrentCurrencies()
                .swapCurrencies()
                .checkCurrenciesAfterSwap();
    }
}





