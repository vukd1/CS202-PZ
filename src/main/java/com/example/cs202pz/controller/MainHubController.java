package com.example.cs202pz.controller;

import com.example.cs202pz.view.LoginView;
import com.example.cs202pz.view.MainHubView;
import com.example.cs202pz.view.StorefrontView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Window;

import java.util.ArrayList;

public class MainHubController implements EventHandler<ActionEvent> {
    private MainHubView mainHubView;
    public MainHubController(MainHubView mainHubView) {
        this.mainHubView = mainHubView;
    }
    private ArrayList<StorefrontView> storefrontViews = new ArrayList<>();

    @Override
    public void handle(ActionEvent actionEvent) {
        String id = ((Node) actionEvent.getSource()).getId();

        switch (id){
            case "open_loginView":
                LoginView.getInstance().show();
                LoginView.getInstance().getWelcomeText().setText("Please fill in your credentials");
                for (StorefrontView sv : storefrontViews){
                    sv.close();
                }
                StorefrontView.setStorefrontCounter(0);
                mainHubView.close();
                break;
            case "open_storefront":
                storefrontViews.add(new StorefrontView());
                break;
        }
    }

    @Override
    public String toString() {
        return "MainHubController{" +
                "mainHubView=" + mainHubView +
                ", storefrontViews=" + storefrontViews +
                '}';
    }

    public MainHubView getMainHubView() {
        return mainHubView;
    }

    public void setMainHubView(MainHubView mainHubView) {
        this.mainHubView = mainHubView;
    }

    public ArrayList<StorefrontView> getStorefrontViews() {
        return storefrontViews;
    }

    public void setStorefrontViews(ArrayList<StorefrontView> storefrontViews) {
        this.storefrontViews = storefrontViews;
    }
}
