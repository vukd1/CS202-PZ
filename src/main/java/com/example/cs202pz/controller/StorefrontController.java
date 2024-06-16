package com.example.cs202pz.controller;

import com.example.cs202pz.model.StorefrontItem;
import com.example.cs202pz.view.StorefrontView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;

import java.util.ArrayList;

public class StorefrontController implements EventHandler<ActionEvent> {
    private StorefrontView storefrontView;

    public StorefrontController(StorefrontView storefrontView) {
        this.storefrontView = storefrontView;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String id = ((Node) actionEvent.getSource()).getId();

        switch (id){
            case "calculateCartTotal":
                int total = 0;
                for (StorefrontItem si : storefrontView.getStorefrontItems()){
                    if (si.getCheckBox().isSelected()){
                        total += Integer.parseInt(si.getItemPrice().getText());
                    }
                }
                System.out.println(total);
                storefrontView.getCartTotalMenuItem().setText("Total: " + total);
                break;
        }
    }

    @Override
    public String toString() {
        return "StorefrontController{" +
                "storefrontView=" + storefrontView +
                '}';
    }

    public StorefrontView getStorefrontView() {
        return storefrontView;
    }

    public void setStorefrontView(StorefrontView storefrontView) {
        this.storefrontView = storefrontView;
    }
}
