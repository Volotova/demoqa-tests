package page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenidePage {
    private SelenideElement
            wiki = $("#wiki-tab"),
            wikiBody = $("#wiki-body"),
            softAssertions = $("a[href='/selenide/selenide/wiki/SoftAssertions']"),
            JUnit5 = $("#user-content-3-using-junit5-extend-test-class");

    @Step("Открытие страницы")
    public SelenidePage openPage(){
        open("https://github.com/selenide/selenide");
        return this;
    }

    @Step("Нажатие на Wiki")
    public SelenidePage clickButtonWiki(){
        wiki.click();
        return this;
    };

    @Step("Убедится, что в списке страниц есть страница SoftAssertions")
    public SelenidePage checkSoftAssertionsOnPage(){
        wikiBody.shouldHave(text("Soft assertions"));
        return this;
    }

    @Step("Нажатие на ссылку Soft assertions")
    public SelenidePage clickSoftAssertions(){
        softAssertions.click();
        return this;
    }

    @Step("Проверка есть ли на странице пример кода для JUnit5")
    public SelenidePage checkJUnit5OnPage(){
        JUnit5.parent().shouldHave(text("3. Using JUnit5 extend test class:"));
        return this;
    }
}
