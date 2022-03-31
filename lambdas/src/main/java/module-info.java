module com.example.lambdas {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lambdas to javafx.fxml;
    exports com.example.lambdas;
}