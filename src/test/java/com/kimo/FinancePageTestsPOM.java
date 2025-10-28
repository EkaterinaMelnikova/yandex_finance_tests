package com.kimo;

import Pages.FinancePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class FinancePageTestsPOM extends TestBase {

    FinancePage financePage = new FinancePage();

    String pageName = "Курсы валют";


    @Test
    @DisplayName("Проверка перехода в окно Курсы валют по кнопке Валюты > Показать все")
    void openCurrenciesPageTest() {

        financePage.openPage()
                .clickLinkCurrencies()
                .clickLinkShowAll()
                .checkPageName(pageName);
    }

    @Test
    @DisplayName("Проверка поиска Курсов валют через строку Поиска")
    void findCurrenciesPageViaSearchTest() {

        String searchText = "валют";

        financePage.openPage()
                .enterSearchQuery(searchText)
                .checkPageName(pageName);
    }


    @Test
    @DisplayName("Проверка открытия окна Курсы валют по ссылке Курсы валют в Популярных запросах")
    void scrollСurrencyRightTest() {

        String linkText = "Курсы валют";

        financePage.openPage()
                .selectFromPopularQueries(linkText)
                .checkPageName(pageName);
    }


}
