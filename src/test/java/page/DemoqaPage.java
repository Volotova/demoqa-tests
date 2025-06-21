package page;

import com.codeborne.selenide.SelenideElement;
import page.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoqaPage {
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            gender = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            dateOfBirthday = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            state = $("#state input"),
            city = $("#city input"),
            submitClick = $("#submit"),
            modal = $("#example-modal-sizes-title-lg");


    CalendarComponent calendarComponent = new CalendarComponent();

    //@Step ("Открытие страницы")
    public DemoqaPage openPage(){
        open("https://demoqa.com/automation-practice-form");
        return this;
    }
    //@Step ("Ввод имени")
    public DemoqaPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }
    //@Step ("Ввод фамилии")
    public DemoqaPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }
    //@Step ("Ввод email")
    public DemoqaPage setEmailInput(String value) {
        emailInput.setValue(value);
        return this;
    }
    //@Step ("Выбор гендера")
    public DemoqaPage setGender(String value) {
        submitClick.scrollIntoView(true);
        gender.$(byText(value)).click();
        return this;
    }
    //@Step ("Ввод номера телефона")
    public DemoqaPage setUserNumberInput(String value) {
        userNumberInput.setValue(value);
        return this;
    }
    //@Step ("Выбор года, даты и дня рождения в календаре")
    public DemoqaPage setDateOfBirthday(String day, String month, String year) {
        submitClick.scrollIntoView(true);
        dateOfBirthday.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }
    //@Step ("Выбор предмета")
    public DemoqaPage setSubject(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }
    //@Step ("Выбор хобби")
    public DemoqaPage setHobbies(String value) {
        hobbiesInput.$(byText(value)).click();
        return this;
    }
    //@Step ("Загрузка файла")
    public DemoqaPage setFile(String value) {
        uploadPicture.uploadFromClasspath(value);
        return this;
    }
    //@Step ("Ввод текущего адреса")
    public DemoqaPage setCurentAdress(String value) {
        currentAddress.setValue(value);
        return this;
    }
    //@Step ("Выбор штата")
    public DemoqaPage setState(String value) {
        state.setValue(value).pressEnter();
        return this;
    }
    //@Step ("Выбор города")
    public DemoqaPage setCity(String value) {
        city.setValue(value).pressEnter();
        return this;
    }
    //@Step ("Нажать на кнопку "Submit"")
    public DemoqaPage submitButton() {
        submitClick.scrollIntoView(true);
        submitClick.click();
        return this;
    }
    //@Step ("Проверка открылась ли модалка после заполнения и отправки формы")
    public DemoqaPage checkModalVisible() {
        modal.shouldHave(text("Thanks for submitting the form"));
        return this;
    }
    //@Step ("Проверка корректного заполнение имени")
    public DemoqaPage checkModalHaveCorrectName(String key, String value) {
        $(".table-responsive").$(byText(key)).parent().
                shouldHave(text(value));
        return this;
    }
}
