package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestsCheckInfoOnPageSoftAssertions {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void checkInfoOnPageSoftAssertions () {

        open("https://github.com/");
        $("[name = q]").setValue("Selenide").pressEnter();
        $(".repo-list a").click();
        $(byText("Wiki")).click();
        $("[data-filterable-for]").shouldHave(text("SoftAssertions"));
        $(byText("SoftAssertions")).click();
        $("[start = '3']").shouldHave(text("Using JUnit5 extend test class:"));
    }
}
