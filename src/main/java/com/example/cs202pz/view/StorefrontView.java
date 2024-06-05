package com.example.cs202pz.view;

import com.example.cs202pz.controller.StorefrontController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Stack;

public class StorefrontView extends Stage {
    private Label bodyText = new Label("Storefront text");
    private Button testButton = new Button("Do something!");
    private BorderPane borderPane = new BorderPane();

    public StorefrontView(){
        borderPane.setBottom(testButton);
        borderPane.setTop(bodyText);
        this.setScene(new Scene(borderPane, 300, 300));
        this.show();
        StorefrontController storefrontController = new StorefrontController(this);
        testButton.setId("test_button");
        testButton.setOnAction(storefrontController);
    }


    public Label getBodyText() {
        return bodyText;
    }

    public void setBodyText(Label bodyText) {
        this.bodyText = bodyText;
    }
}
