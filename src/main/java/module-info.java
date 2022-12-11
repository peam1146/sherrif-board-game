module com.progmeth.project.sheriff {
    requires javafx.controls;
    requires javafx.fxml;
    requires kryonet;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires com.almasb.fxgl.all;
    requires io.reactivex.rxjava3;

    opens com.progmeth.project.sheriff to javafx.fxml;
    exports com.progmeth.project.sheriff;
}