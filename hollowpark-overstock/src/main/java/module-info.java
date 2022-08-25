module main.hollowparkoverstock {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens main.hollowParkOnline to javafx.fxml;
    exports main.hollowParkOnline;
}