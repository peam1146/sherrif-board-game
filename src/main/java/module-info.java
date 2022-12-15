/**
 * java module
 */
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
    exports com.progmeth.project.sheriff.core.controllers.main;
    exports com.progmeth.project.sheriff.core.controllers.main.states;
    exports com.progmeth.project.sheriff.core.controllers.router;
    exports com.progmeth.project.sheriff.core.controllers.router.states;
    exports com.progmeth.project.sheriff.core.utils.view.controllers;
    exports com.progmeth.project.sheriff.data.game.models.base;
    exports com.progmeth.project.sheriff.data.game.models.derive.deck;
    exports com.progmeth.project.sheriff.data.game.models.derive.hand;
    exports com.progmeth.project.sheriff.data.game.models.derive.illegal;
    exports com.progmeth.project.sheriff.data.game.models.derive.legal;
    exports com.progmeth.project.sheriff.data.game.models.derive.market;
    exports com.progmeth.project.sheriff.data.game.server.controller;
    exports com.progmeth.project.sheriff.data.game.server.models.DTO;
    exports com.progmeth.project.sheriff.data.game.server.models.request;
    exports com.progmeth.project.sheriff.data.game.server.models.response;
    exports com.progmeth.project.sheriff.data.game.server.models.type;
    exports com.progmeth.project.sheriff.data.game.server.network;
    exports com.progmeth.project.sheriff.data.game.server.repositories;
    exports com.progmeth.project.sheriff.domain.game.entity;
    exports com.progmeth.project.sheriff.domain.game.repositories;
    exports com.progmeth.project.sheriff.presentors.common;
    exports com.progmeth.project.sheriff.presentors.common.components;
    exports com.progmeth.project.sheriff.presentors.demo.controllers;
    exports com.progmeth.project.sheriff.presentors.demo.views;
    exports com.progmeth.project.sheriff.presentors.game.controllers;
    exports com.progmeth.project.sheriff.presentors.game.controllers.states;
    exports com.progmeth.project.sheriff.presentors.game.views;
    exports com.progmeth.project.sheriff.presentors.game.views.components;
    exports com.progmeth.project.sheriff.presentors.home.controllers;
    exports com.progmeth.project.sheriff.presentors.home.controllers.states;
    exports com.progmeth.project.sheriff.presentors.home.views;
    exports com.progmeth.project.sheriff.presentors.louge.controllers;
    exports com.progmeth.project.sheriff.presentors.louge.controllers.states;
    exports com.progmeth.project.sheriff.presentors.louge.views;
    exports com.progmeth.project.sheriff.presentors.player.controllers;
    exports com.progmeth.project.sheriff.presentors.player.controllers.states;
    exports com.progmeth.project.sheriff.presentors.player.views;
    exports com.progmeth.project.sheriff.presentors.player.views.components;
    exports com.progmeth.project.sheriff.presentors.sheriff.controllers;
    exports com.progmeth.project.sheriff.presentors.sheriff.controllers.states;
    exports com.progmeth.project.sheriff.presentors.sheriff.views;
    exports com.progmeth.project.sheriff.presentors.sheriff.views.components;
}
