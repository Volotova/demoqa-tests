package tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import page.DemoqaPage;

@DisplayName("Первый тест")
public class DemoqaTest {

    DemoqaPage demoqaPage = new DemoqaPage();

    @BeforeEach
    void openPage(){
        demoqaPage.openPage();
    }

    @Test
    @DisplayName("Заполнение формы")
    @Tag("Smoke")
    void fillFormTest() {
        demoqaPage
                .setFirstName("Aleksander")
                .setLastName("Belyaev")
                .setEmailInput("a.belyaeb@just-ai.com")
                .setGender("Male")
                .setUserNumberInput("0291282587")
                .setDateOfBirthday("19", "September", "1995")
                .setSubject("Maths")
                .setHobbies("Sports")
                .setFile("testfiles/img.png")
                .setCurentAdress("Some text")
                .setState("NCR")
                .setCity("Delhi")
                .submitButton()
                .checkModalVisible()
                .checkModalHaveCorrectName("Student Name", "Aleksander Belyaev");
    }

    @Disabled("ID бага")
    @Test
    @DisplayName("Флакающий тест")
    void flackTest(){
        throw new AssertionError("Падаем!");
    }

    @CsvSource(value = {
            "Aleksander, Belyaev",
            "Tatsiana, Belyaeva"
    })
    @ParameterizedTest(name = "Заполнение формы для имени {0} ")
    @Tag("Smoke")
    void parametrizedFillFormTest(String fillFirstName, String fillLastName) {
        demoqaPage
                .setFirstName(fillFirstName)
                .setLastName(fillLastName)
                .setEmailInput("a.belyaeb@just-ai.com")
                .setGender("Male")
                .setUserNumberInput("0291282587")
                .setDateOfBirthday("19", "September", "1995")
                .setSubject("Maths")
                .setHobbies("Sports")
                .setFile("testfiles/img.png")
                .setCurentAdress("Some text")
                .setState("NCR")
                .setCity("Delhi")
                .submitButton()
                .checkModalVisible()
                .checkModalHaveCorrectName("Student Name", fillFirstName + " " + fillLastName);
    }

}
