package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import page.MetodsPage;

public class HoverDraganddropTest {

    MetodsPage metodsPage = new MetodsPage();

    @Test
    @DisplayName("Проверка метдотов: Hover, DragAndDrop")
    @Tag("Editore")
    void metods(){
        metodsPage
                .openPage()
                .hoverSolutions()
                .clickEnterprises();
    }
}
