package com.kimo;

import Pages.CurrenciesPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class CurrenciesPageTestsPOM extends TestBase {

    CurrenciesPage currenciesPage = new CurrenciesPage();


    @Test
    @DisplayName("Проверка отображения/скрытия полного текста по нажатию Читать еще/Скрыть")
    void openReadMoreTest() {

        currenciesPage.openPage()
                .clickReadMore()
                .checkFullTextVisible()
                .clickHide()
                .checkFullTextHidden();
    }

    @Test
    @DisplayName("Проверка увеличения количества отображаемых валют по нажатию Показать еще")
    void expandCurrencyListOnShowMoreClick() {

        int currencyAmount = 7;
        int currencyAmount1 = 17;

        currenciesPage.openPage()
                .checkCurrencyAmount(currencyAmount)
                .clickShowMore()
                .checkCurrencyAmountAfterClickShowMore1(currencyAmount1);
    }

    @Test
    @DisplayName("Проверка открытия  детальной информации о валюте по нажатию на ее название")
    void clickOnSpecificCurrency() {

        String currencyName = "USD";

        currenciesPage.openPage()
                .clickCurrencyName(currencyName)
                .checkCurrencyNameOnThePage(currencyName);
    }



}





