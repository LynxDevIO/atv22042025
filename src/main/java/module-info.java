module puc.poobd.atv22042025 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens puc.poobd.atv22042025 to javafx.fxml;
    exports puc.poobd.atv22042025;
    exports puc.poobd.atv22042025.db;
    opens puc.poobd.atv22042025.db to javafx.fxml;
    exports puc.poobd.atv22042025.dto;
    opens puc.poobd.atv22042025.dto to javafx.fxml;
    exports puc.poobd.atv22042025.model;
    opens puc.poobd.atv22042025.model to javafx.fxml;
    exports puc.poobd.atv22042025.view;
    opens puc.poobd.atv22042025.view to javafx.fxml;
    exports puc.poobd.atv22042025.controller;
    opens puc.poobd.atv22042025.controller to javafx.fxml;
}