module com.progmeth.project.sheriff {
    requires javafx.controls;
    requires javafx.fxml;
    requires kryonet;
    requires kryo;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires com.almasb.fxgl.all;
    requires io.reactivex.rxjava3;

    opens com.progmeth.project.sheriff to javafx.fxml;
    exports com.progmeth.project.sheriff;
    exports com.progmeth.project.sheriff.data.game.server.models.request;
    exports com.progmeth.project.sheriff.data.game.server.models.response;
    exports com.progmeth.project.sheriff.data.game.server.models.type;
    exports com.progmeth.project.sheriff.data.game.server.models.DTO;
}
