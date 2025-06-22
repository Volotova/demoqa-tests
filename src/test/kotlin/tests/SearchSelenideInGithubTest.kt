package tests

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import page.SelenidePagekt

class SearchSelenideInGithubKtTest {
    private val selenidePage = SelenidePagekt()

    @Test
    @DisplayName("Страница Selenide в Github")
    @Tag("Editor Team")
    fun searchSoftAssertions() {
        selenidePage
            .openPage()
            .clickButtonWiki()
            .checkSoftAssertionsOnPage()
            .clickSoftAssertions()
            .checkJUnit5OnPage()
    }
}