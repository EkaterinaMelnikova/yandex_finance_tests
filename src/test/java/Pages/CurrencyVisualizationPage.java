package Pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CurrencyVisualizationPage  {


      private String currency1;
      private String currency2;


    public CurrencyVisualizationPage openPage (String value){
        open("/finance/currencies/" + value + "_RUB");

        return this;
    }

    public CurrencyVisualizationPage pageDateShouldMatchCurrentDate (){

        String currentDate = LocalDate.now()
                .format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        $(".ConverterFooter-Time")
                .shouldHave(text("Обновлено " + currentDate));

        return this;

        // TODO: Добавить if для проверки в выходной день
    }


    public CurrencyVisualizationPage changeConvertCurrency (String value){
        $("button[aria-label='Валюта: " + value + "']").click();
        $(byText("Австралийский доллар")).click();

        return this;

        //TODO: сделать метод универсальным
    }


    public CurrencyVisualizationPage checkConvertCurrency (){
        sleep(1000);
        $("button[aria-describedby='«R4j»']").shouldHave(text("AUD"));

        return this;

        //TODO: сделать метод универсальным
    }


    public CurrencyVisualizationPage swapCurrencies() {
        $("[aria-label=\"Поменять местами значения\"]").click();

        return this;
    }


    public CurrencyVisualizationPage checkCurrenciesAfterSwap (){
        $("button[aria-describedby='«R4j»']").shouldHave(text(currency2));
        $("button[aria-describedby='«R5j»']").shouldHave(text(currency1));

        return this;
    }

    public CurrencyVisualizationPage saveCurrentCurrencies() {
        this.currency1 = $("button[aria-describedby='«R4j»']").getText();
        this.currency2 = $("button[aria-describedby='«R5j»']").getText();
        return this;
    }




}
