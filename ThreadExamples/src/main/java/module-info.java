module com.example.threadexamples {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.threadexamples to javafx.fxml;
    exports com.example.threadexamples;
}