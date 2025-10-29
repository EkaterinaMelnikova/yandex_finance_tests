package com.kimo;

import Pages.FinancePage;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;


public class FinancePageTestsPOM_Steps extends TestBase {

    FinancePage financePage = new FinancePage();

    String pageName = "Курсы валют";


    @Test
    @Owner("e.melnikova")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка перехода в окно Курсы валют по кнопке Валюты > Показать все")
    void openCurrenciesPageTest() {

        step("Открыть страницу яндекс.финансы", () -> {
            financePage.openPage();
        });

        step("Кликнуть на Валюты", () -> {
            financePage.clickLinkCurrencies();
        });

        step("Кликнуть Показать все", () -> {
            financePage.clickLinkShowAll();
        });

        step("Проверить заголовок открывшейся страницы", () -> {
            financePage.checkPageName(pageName);
        });


    }

    @Test
    @Owner("e.melnikova")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка поиска Курсов валют через строку Поиска")
    void findCurrenciesPageViaSearchTest() {

        String searchText = "валют";

        step("Открыть страницу яндекс.финансы", () -> {
        financePage.openPage();
        });

        step("В строке поиска отправить запрос Курсы валют", () -> {
            financePage.enterSearchQuery(searchText);
        });

        step("Проверить заголовок открывшейся страницы", () -> {
            financePage.checkPageName(pageName);
        });

    }


    @Test
    @Owner("e.melnikova")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка открытия окна Курсы валют по ссылке Курсы валют в Популярных запросах")
    void scrollСurrencyRightTest() {

        String linkText = "Курсы валют";

        step("Открыть страницу яндекс.финансы", () -> {
            financePage.openPage();
        });

        step("Кликнуть на ссылку Курсы валют в разделе Популярные запросы", () -> {
        financePage.selectFromPopularQueries(linkText);
        });

        step("Проверить заголовок открывшейся страницы", () -> {
        financePage.checkPageName(pageName);
        });
    }


}
