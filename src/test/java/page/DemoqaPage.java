package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoqaPage {
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            gender = $("#gender-radio-1"),
            userNumberInput = $("#userNumber"),
            dateOfBirthday = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbies-checkbox-1"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            state = $("#state input"),
            city = $("#city input"),
            submitButton = $("#submit"),
            modal = $("#example-modal-sizes-title-lg");

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
    public DemoqaPage setGender() {
        gender.parent().click();
        return this;
    }
    //@Step ("Ввод номера телефона")
    public DemoqaPage setUserNumberInput(String value) {
        userNumberInput.setValue(value);
        return this;
    }
    //@Step ("Выбор года, даты и дня рождения в календаре")
    public DemoqaPage setDateOfBirthday() {
        dateOfBirthday.click();
        $(".react-datepicker__year-select").selectOption("1995");
        $(".react-datepicker__month-select").selectOption(8);
        $$(".react-datepicker__day:not(.react-datepicker__day--outside-month)")
                .findBy(text("19"))
                .click();
        return this;
    }
    //@Step ("Выбор предмета")
    public DemoqaPage setSubject(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }
    //@Step ("Выбор хобби")
    public DemoqaPage setHobbies() {
        hobbiesInput.parent().click();
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
    public DemoqaPage setSubmitButton() {
        submitButton.click();
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
