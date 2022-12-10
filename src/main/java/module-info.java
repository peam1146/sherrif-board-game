module com.progmeth.project.sheriff {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires com.almasb.fxgl.all;

    opens com.progmeth.project.sheriff to javafx.fxml;
    exports com.progmeth.project.sheriff;
}