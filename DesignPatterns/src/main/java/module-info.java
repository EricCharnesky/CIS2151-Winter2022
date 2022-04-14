module com.example.designpatterns {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.designpatterns to javafx.fxml;
    exports com.example.designpatterns;
}