package Pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class FinancePage {

    public FinancePage openPage() {
        open("/finance");

        return this;
    }

    public FinancePage clickLinkCurrencies() {
        $(".FinanceDailyTrends-ListItem_item_currency").click();

        return this;
    }

    public FinancePage clickLinkShowAll() {
        $(".FinanceDailyTrends-Link").click();

        return this;
    }

    public FinancePage checkPageName(String value) {
        $(".FinancePageHeader-Title").shouldBe(visible);
        $(".FinancePageHeader-Title").shouldHave(text(value));

        return this;
    }

    public FinancePage enterSearchQuery(String value) {
        $("textarea[placeholder='Найти финансовый продукт']").click();
        $("textarea[placeholder='Найти финансовый продукт']").setValue(value);
        $("textarea[placeholder='Найти финансовый продукт']").pressEnter();

        return this;
    }

    public FinancePage selectFromPopularQueries(String value) {
        $$(".Link_theme_neoblueDark").findBy(text(value)).click();

        return this;
    }


}
