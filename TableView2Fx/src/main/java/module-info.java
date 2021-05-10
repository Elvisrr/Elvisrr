module ni.edu.uni.fcys.programacion2.tableview2fx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens ni.edu.uni.fcys.programacion2.tableview2fx to javafx.fxml;
    exports ni.edu.uni.fcys.programacion2.tableview2fx;
    exports ni.edu.uni.fcys.programacion2.tableview2fx.controller;
}
