package ru.netology.web;

import org.junit.jupiter.api.Test;
import java.time.Duration;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static org.openqa.selenium.By.cssSelector;


    class TestWithFaker {

        @Test
        void shouldGenerateCardDeliveryData(){
            String name = DataGenerator.generateName();
            String phone = DataGenerator.generatePhone();
            String city = DataGenerator.generateCity();

            open ("http://localhost:9999/");
            $("[data-test-id=city] input").setValue(city);
            $("[data-test-id=date] input").doubleClick().sendKeys(DataGenerator.generateDate(5));
            $(cssSelector("[name='name']")).setValue(name);
            $(cssSelector("[name='phone']")).setValue(phone);
            $("[data-test-id=agreement]").click();
            $(byClassName("button__text")).click();
            $(".notification_status_ok").shouldBe(visible);
            $("[data-test-id='success-notification'] .notification__content").shouldHave(exactText
                    ("Встреча успешно запланирована на " + DataGenerator.generateDate(5)));
            $("[data-test-id=date] input").doubleClick().sendKeys(DataGenerator.generateDate(8));
            $(byClassName("button__text")).click();
            $("[data-test-id=replan-notification]").shouldBe((appear), Duration.ofSeconds(15));
            $(withText("Перепланировать")).click();
            $(".notification_status_ok").shouldBe(visible);
            $(".notification__content").shouldHave(exactText
                    ("Встреча успешно запланирована на " + DataGenerator.generateDate(8)));
        }
    }






