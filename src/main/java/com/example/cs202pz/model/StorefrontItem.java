package com.example.cs202pz.model;

import com.example.cs202pz.controller.StorefrontController;
import com.example.cs202pz.view.StorefrontView;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class StorefrontItem {
    private Label itemName = new Label();
    private Label itemPrice = new Label();
    private CheckBox checkBox = new CheckBox("Select item");

    public StorefrontItem(String itemName, String itemPrice) {
        this.itemName.setText(itemName);
        this.itemPrice.setText(itemPrice);
    }

    public Label getItemName() {
        return itemName;
    }

    public void setItemName(Label itemName) {
        this.itemName = itemName;
    }

    public Label getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Label itemPrice) {
        this.itemPrice = itemPrice;
    }

    public CheckBox getCheckBox() {
        return checkBox;
    }

    @Override
    public String toString() {
        return "StorefrontItem{" +
                "itemName=" + itemName +
                ", itemPrice=" + itemPrice +
                ", checkBox=" + checkBox +
                '}';
    }

    public void setCheckBox(CheckBox checkBox) {
        this.checkBox = checkBox;
    }

    public VBox returnVbox(){
        VBox vBox = new VBox(itemName, itemPrice, checkBox);
        vBox.setAlignment(Pos.CENTER);
        itemName.setFont(new Font(16));
        itemPrice.setFont(new Font(14));
        vBox.setSpacing(10);
        return vBox;
    }
}
