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
}
