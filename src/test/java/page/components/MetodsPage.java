package page.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;


public class MetodsPage {
    private SelenideElement
            solutions = $(byText("Solutions")).parent(),
            enterprises = $("a[href='https://github.com/enterprise']");

    @Step("Открытие страницы")
    public MetodsPage openPage(){
        open("https://github.com/home");
        return this;
    }

    @Step("Наведение на Solutions")
    public MetodsPage hoverSolutions(){
        solutions.hover();
        return this;
    }

    @Step("Нажатие на Enterprises")
    public MetodsPage clickEnterprises(){
        enterprises.click();
        return this;
    }

    @Step("Проверка что мы перешли на страницу Enterprises")
    public MetodsPage checkEnterprisesPage(){
        webdriver().shouldHave(url("https://github.com/enterprise"));
        return this;
    }
}
