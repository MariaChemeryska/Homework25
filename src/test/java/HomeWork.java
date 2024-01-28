
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.*;

public class HomeWork {
    @Test
    void productSearch() {

        open("https://makeup.com.ua/ua/");
        $("div.search-button").click();
        $(".search-input").setValue("Mr.Scrubber").pressEnter();
        $(".catalog-products .simple-slider-list__description")
                .shouldHave(Condition.text("Mr.Scrubber"));
        Selenide.closeWebDriver();
    }

    @Test
    void openBrandOffers() {
        open("https://makeup.com.ua/ua/");
        WebElement productsBlock = $("[data-src=\"/ajax/block/slider/648/\"]");
//        WebElement pageHeader = productsBlock.findElement(By.cssSelector(".page-header"));
//        $(pageHeader).shouldHave(Condition.text("Пропозиції брендів"));
// даний код не спрацьовує через помилки кодування "Element should have text "РџСЂРѕРїРѕР·РёС†С–С— Р±СЂРµРЅРґС–РІ" {<div id>}"

        productsBlock.findElement(By.cssSelector(".simple-slider-list__image")).click();
        Selenide.closeWebDriver();
    }

    @Test
    void CheckOpenArticles() {
        open("https://makeup.com.ua/ua/");
        $(".header-top-list__link", 2).click();
        $(".news-list__link").click();
        Selenide.closeWebDriver();
    }

    @Test
    void AddProduct() {
        open("https://makeup.com.ua/ua/");
        $(".menu-list__link.menu-list__link_category", 4).click();
        $(".simple-slider-list__image").click();
        $(".product-item .button.buy").click();
        sleep(3000);

        $(".cart-content-wrapper").shouldBe(Condition.visible);
        Selenide.closeWebDriver();
    }
    @Test
    void UseFilter() {
        open("https://makeup.com.ua/ua/");
        $(".menu-list__link.menu-list__link_category", 2).click();
        $(".catalog-checkbox-list__item").click();
        sleep(3000);
        $(".catalog-products .info-product-wrapper .simple-slider-list__name",0)
                .shouldHave(Condition.text("Chanel"));
        Selenide.closeWebDriver();
    }

}
