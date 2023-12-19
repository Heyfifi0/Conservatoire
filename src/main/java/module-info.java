module proj.conservatoire {
    requires javafx.controls;
    requires javafx.fxml;

    opens proj.conservatoire to javafx.fxml;
    exports proj.conservatoire;
}
