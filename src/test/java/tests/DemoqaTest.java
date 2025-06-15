package tests;

import org.junit.jupiter.api.Test;
import page.DemoqaPage;

public class DemoqaTest {
    DemoqaPage demoqaPage = new DemoqaPage();
    @Test
    void fillFormTest() {
        demoqaPage.openPage()
                .setFirstName("Aleksander")
                .setLastName("Belyaev")
                .setEmailInput("a.belyaeb@just-ai.com")
                .setGender()
                .setUserNumberInput("0291282587")
                .setDateOfBirthday()
                .setSubject("Maths")
                .setHobbies()
                .setFile("testfiles/img.png")
                .setCurentAdress("Some text")
                .setState("NCR")
                .setCity("Delhi")
                .setSubmitButton()
                .checkModalVisible()
                .checkModalHaveCorrectName("Student Name", "Aleksander Belyaev");
    }
}
