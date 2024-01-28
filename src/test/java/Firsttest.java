import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class Firsttest {
    @Test
    void firsttest() {
        open("https://www.foxtrot.com.ua/uk");
        $(".header-search__field").setValue("iphone").pressEnter();
//        webdriver().shouldHave(urlContaining("mobilnye_telefony_apple.html"));
        String productName = $(".listing__body .card__title").getText();
        $(".listing__body-wrap .card__image").shouldBe(Condition.visible).click();


        $(".page__title.overflow").shouldHave(Condition.text(productName));



        $(".button.product-box__main-buy__button").shouldBe(Condition.visible).click();
        $(".header-tooltip__cards-item__title").shouldHave(Condition.text(productName));

    }
}
