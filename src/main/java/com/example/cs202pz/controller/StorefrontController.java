package com.example.cs202pz.controller;

import com.example.cs202pz.view.StorefrontView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class StorefrontController implements EventHandler<ActionEvent> {
    private StorefrontView storefrontView;

    public StorefrontController(StorefrontView storefrontView) {
        this.storefrontView = storefrontView;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String id = ((Node) actionEvent.getSource()).getId();

        switch (id){
            case "test_button":
                storefrontView.getBodyText().setText("Lmaoo");
        }
    }
}
