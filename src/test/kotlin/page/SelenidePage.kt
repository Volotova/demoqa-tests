package page

import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.SelenideElement
import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.open
import io.qameta.allure.Step

class SelenidePagekt {
    private val wiki: SelenideElement = `$`("#wiki-tab")
    private val wikiBody: SelenideElement = `$`("#wiki-body")
    private val softAssertions: SelenideElement = `$`("a[href='/selenide/selenide/wiki/SoftAssertions']")
    private val jUnit5: SelenideElement = `$`("#user-content-3-using-junit5-extend-test-class")

    @Step("Открытие страницы")
    fun openPage(): SelenidePagekt {
        open("https://github.com/selenide/selenide")
        return this
    }

    @Step("Нажатие на Wiki")
    fun clickButtonWiki(): SelenidePagekt {
        wiki.click()
        return this
    }

    @Step("Убедится, что в списке страниц есть страница SoftAssertions")
    fun checkSoftAssertionsOnPage(): SelenidePagekt {
        wikiBody.shouldHave(Condition.text("Soft assertions"))
        return this
    }

    @Step("Нажатие на ссылку Soft assertions")
    fun clickSoftAssertions(): SelenidePagekt {
        softAssertions.click()
        return this
    }

    @Step("Проверка есть ли на странице пример кода для JUnit5")
    fun checkJUnit5OnPage(): SelenidePagekt {
        jUnit5.parent().shouldHave(Condition.text("3. Using JUnit5 extend test class:"))
        return this
    }
}