package page.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate(String day, String month, String year) {
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        String formattedDay = String.format("%03d", Integer.parseInt(day));
        $(".react-datepicker__day--" + formattedDay + ":not(.react-datepicker__day--outside-month)").click();
    }
}
