module proj.conservatoire {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.base;

    opens proj.conservatoire to javafx.fxml;
    exports proj.conservatoire;
}
