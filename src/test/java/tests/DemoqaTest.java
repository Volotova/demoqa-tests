package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DemoqaTest {
    @Test
    void fillFormTest() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Aleksander");
        $("#lastName").setValue("Belyaev");
        $("#userEmail").setValue("a.belyaeb@just-ai.com");
        $("#gender-radio-1").parent().click();
        $("#userNumber").setValue("0291282587");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1995");
        $(".react-datepicker__month-select").selectOption(8);
        $$(".react-datepicker__day")
                .findBy(text("19"))
                .click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbies-checkbox-1").parent().click();
        $("#uploadPicture").uploadFromClasspath("testfiles/img.png");
        $("#currentAddress").setValue("Some text");
        $("#state input").setValue("NCR").pressEnter();
        $("#city input").setValue("Delhi").pressEnter();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    }
}
