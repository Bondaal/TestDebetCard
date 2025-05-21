package ru.netology;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class DebetCardTest {

    @Test
    public void shouldCreateNewForm() {
        open("http://localhost:9999");
        SelenideElement form = $("[data-test-id=callback-form]");
        $("[data-test-id='name'] input").setValue("Никита Спиридонов");
        $("[data-test-id='phone'] input").setValue("+79250561286");
        $("[data-test-id='agreement']").click();
        $("button.button").click();
        $("[data-test-id='order-success']").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}

