package com.example.cs202pz.view;

import com.example.cs202pz.controller.MainHubController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainHubView extends Stage {

    private static MainHubView mainHubView_instance = null;
    private Button logOutButton = new Button("Log out");
    private Label topLabel = new Label("Hello, " + LoginView.getInstance().getUsername().getText());
    private Button openStorefrontButton = new Button("Launch a storefront");
    private Button viewAllStorefrontsButton = new Button("View active storefronts");
    private Button statisticsButton = new Button("View data and statistics");
    private TextArea quickStatsPreview = new TextArea();
    private BorderPane bp = new BorderPane();
    HBox topHbox = new HBox(topLabel);
    VBox vBox1 = new VBox(quickStatsPreview);
    VBox vBox2 = new VBox(openStorefrontButton, viewAllStorefrontsButton, statisticsButton);
    HBox lowerHbox = new HBox(logOutButton);
    HBox centerHbox = new HBox(vBox1, vBox2);


    // Singleton init so that only one instance of the class runs
    // (and also one thread)
    public static synchronized MainHubView getInstance(){
        if (mainHubView_instance == null){
            mainHubView_instance = new MainHubView();
        }
        return mainHubView_instance;
    }

    private MainHubView(){
        topHbox.setSpacing(20);
        centerHbox.setSpacing(20);
        lowerHbox.setSpacing(20);
        vBox1.setAlignment(Pos.CENTER_LEFT);
        vBox2.setAlignment(Pos.CENTER_LEFT);
        vBox2.setSpacing(20);
        topLabel.setFont(new Font(20));
        topHbox.setPadding(new Insets(10, 0, 0, 15));
        lowerHbox.setPadding(new Insets(0, 0, 10, 15));
        quickStatsPreview.setMaxWidth(400);
        centerHbox.setPadding(new Insets(0, 0, 0, 15));
        openStorefrontButton.setMinWidth(150);
        viewAllStorefrontsButton.setMinWidth(150);
        statisticsButton.setMinWidth(150);
        centerHbox.setAlignment(Pos.CENTER_LEFT);
        BorderPane.setAlignment(centerHbox, Pos.CENTER_LEFT);

        bp.setTop(topHbox);
        bp.setCenter(centerHbox);
        bp.setBottom(lowerHbox);

        this.setScene(new Scene(bp, 640, 300));
        this.show();

        MainHubController mainHubController = new MainHubController(this);
        logOutButton.setId("open_loginView");
        logOutButton.setOnAction(mainHubController);
        openStorefrontButton.setId("open_storefront");
        openStorefrontButton.setOnAction(mainHubController);
    }

}
