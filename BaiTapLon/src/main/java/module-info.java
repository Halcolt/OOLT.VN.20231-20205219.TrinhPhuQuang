module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com to javafx.fxml;
    exports com;
    exports com.Controller;
    opens com.Controller to javafx.fxml;
}