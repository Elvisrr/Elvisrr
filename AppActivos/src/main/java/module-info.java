module ni.edu.uni.fcys.programacion2.appactivos {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens ni.edu.uni.fcys.programacion2.appactivos to javafx.fxml;
    exports ni.edu.uni.fcys.programacion2.appactivos;
    exports ni.edu.uni.fcys.programacion2.appactivos.controller;
    
}
