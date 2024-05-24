module org.example.school_manager2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;


    opens org.example.school_manager2 to javafx.fxml;
    exports org.example.school_manager2;

    opens org.example.school_manager2.controllers to javafx.fxml;
    exports org.example.school_manager2.controllers;

    opens org.example.school_manager2.models to javafx.base;
    exports org.example.school_manager2.models;

}