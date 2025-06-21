package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import page.SelenidePage;

public class SearchSelenideInGithubTest {

    SelenidePage selenidePage = new SelenidePage();

    @Test
    @DisplayName("Страница Selenide в Github")
    @Tag("Editor Team")
    void searchSoftAssertions(){
        selenidePage
                .openPage()
                .clickButtonWiki()
                .checkSoftAssertionsOnPage()
                .clickSoftAssertions()
                .checkJUnit5OnPage();
    }
}
