package com.example.cs202pz.view;

import com.example.cs202pz.controller.MainHubController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainHubView extends Stage {

    private static MainHubView mainHubView_instance = null;
    private Button openOther = new Button("Go to Login view");
    private Button openStorefront = new Button("Open one new storefront");
    private BorderPane bp = new BorderPane();
    private VBox storefrontButtons = new VBox(openStorefront);


    // Singleton init so that only one instance of the class runs
    // (and also one thread)
    public static synchronized MainHubView getInstance(){
        if (mainHubView_instance == null){
            mainHubView_instance = new MainHubView();
        }
        return mainHubView_instance;
    }

    private MainHubView(){
        bp.setTop(openOther);
        bp.setBottom(storefrontButtons);
        this.setScene(new Scene(bp, 300, 300));
        this.show();
        MainHubController mainHubController = new MainHubController(this);
        openOther.setId("open_loginView");
        openOther.setOnAction(mainHubController);
        openStorefront.setId("open_storefront");
        openStorefront.setOnAction(mainHubController);
    }

}
