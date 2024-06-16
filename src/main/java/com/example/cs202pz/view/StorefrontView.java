package com.example.cs202pz.view;

import com.example.cs202pz.controller.StorefrontController;
import com.example.cs202pz.model.StorefrontItem;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

public class StorefrontView extends Stage {
    private MenuBar menuBar = new MenuBar();
    private Menu actionsMenu = new Menu("Menu");
    private Menu itemsMenu = new Menu("Items");
    private Menu filtersMenu = new Menu("Filters");
    private Menu cartMenu = new Menu("Cart");
    private MenuItem cartTotalMenuItem = new MenuItem("Total: ");
    private BorderPane borderPane = new BorderPane();
    private GridPane centerGridPane = new GridPane();
    private VBox centerVbox = new VBox(menuBar, centerGridPane);
    private BorderPane centerBorderPane = new BorderPane();
    private static int storefrontCounter = 1;
    private Label cartTotal = new Label("Total");
    private Button calculateCartTotal = new Button("Calculate cart total");
    private ArrayList<StorefrontItem> storefrontItems = new ArrayList<>();

    public StorefrontView(){
        menuBar.getMenus().addAll(actionsMenu, itemsMenu, filtersMenu, cartMenu);
        menuBar.setBackground(new Background(new BackgroundFill(Color.web("#96C9DC"), new CornerRadii(0), new Insets(0))));
        menuBar.setStyle("-fx-text-fill: white; -fx-font-size: 16px");
        cartMenu.getItems().add(cartTotalMenuItem);
        for (int i = 0; i < 6; i++){
            for (int j = 0; j < 3; j++){
                Random random = new Random();
                StorefrontItem item = new StorefrontItem("Apple", Integer.toString(random.nextInt(100) + 1));
                storefrontItems.add(item);
                centerGridPane.add(item.returnVbox(), i, j);
            }
        }
        centerGridPane.setVgap(50);
        centerGridPane.setHgap(20);
        centerGridPane.setAlignment(Pos.CENTER);
        calculateCartTotal.setMinWidth(50);
        calculateCartTotal.setMinHeight(20);
        calculateCartTotal.setFont(new Font(14));

        centerBorderPane.setTop(menuBar);
        centerBorderPane.setCenter(centerGridPane);
        centerBorderPane.setBottom(calculateCartTotal);
        BorderPane.setAlignment(calculateCartTotal, Pos.CENTER);

        this.setScene(new Scene(centerBorderPane, 960, 540));
        this.show();

        StorefrontController storefrontController = new StorefrontController(this);
        this.setTitle("Storefront " + storefrontCounter++);

        calculateCartTotal.setId("calculateCartTotal");
        calculateCartTotal.setOnAction(storefrontController);
    }

    @Override
    public String toString() {
        return "StorefrontView{" +
                "menuBar=" + menuBar +
                ", actionsMenu=" + actionsMenu +
                ", itemsMenu=" + itemsMenu +
                ", filtersMenu=" + filtersMenu +
                ", cartMenu=" + cartMenu +
                ", cartTotalMenuItem=" + cartTotalMenuItem +
                ", borderPane=" + borderPane +
                ", centerGridPane=" + centerGridPane +
                ", centerVbox=" + centerVbox +
                ", centerBorderPane=" + centerBorderPane +
                ", cartTotal=" + cartTotal +
                ", calculateCartTotal=" + calculateCartTotal +
                ", storefrontItems=" + storefrontItems +
                '}';
    }

    public static int getStorefrontCounter() {
        return storefrontCounter;
    }

    public static void setStorefrontCounter(int storefrontCounter) {
        StorefrontView.storefrontCounter = storefrontCounter;
    }

    public MenuBar getMenuBar() {
        return menuBar;
    }

    public void setMenuBar(MenuBar menuBar) {
        this.menuBar = menuBar;
    }

    public Menu getActionsMenu() {
        return actionsMenu;
    }

    public void setActionsMenu(Menu actionsMenu) {
        this.actionsMenu = actionsMenu;
    }

    public Menu getItemsMenu() {
        return itemsMenu;
    }

    public void setItemsMenu(Menu itemsMenu) {
        this.itemsMenu = itemsMenu;
    }

    public Menu getFiltersMenu() {
        return filtersMenu;
    }

    public void setFiltersMenu(Menu filtersMenu) {
        this.filtersMenu = filtersMenu;
    }

    public Menu getCartMenu() {
        return cartMenu;
    }

    public void setCartMenu(Menu cartMenu) {
        this.cartMenu = cartMenu;
    }

    public BorderPane getBorderPane() {
        return borderPane;
    }

    public void setBorderPane(BorderPane borderPane) {
        this.borderPane = borderPane;
    }

    public GridPane getCenterGridPane() {
        return centerGridPane;
    }

    public void setCenterGridPane(GridPane centerGridPane) {
        this.centerGridPane = centerGridPane;
    }

    public VBox getCenterVbox() {
        return centerVbox;
    }

    public void setCenterVbox(VBox centerVbox) {
        this.centerVbox = centerVbox;
    }

    public BorderPane getCenterBorderPane() {
        return centerBorderPane;
    }

    public void setCenterBorderPane(BorderPane centerBorderPane) {
        this.centerBorderPane = centerBorderPane;
    }

    public Label getCartTotal() {
        return cartTotal;
    }

    public void setCartTotal(Label cartTotal) {
        this.cartTotal = cartTotal;
    }

    public Button getCalculateCartTotal() {
        return calculateCartTotal;
    }

    public void setCalculateCartTotal(Button calculateCartTotal) {
        this.calculateCartTotal = calculateCartTotal;
    }

    public ArrayList<StorefrontItem> getStorefrontItems() {
        return storefrontItems;
    }

    public void setStorefrontItems(ArrayList<StorefrontItem> storefrontItems) {
        this.storefrontItems = storefrontItems;
    }

    public MenuItem getCartTotalMenuItem() {
        return cartTotalMenuItem;
    }

    public void setCartTotalMenuItem(MenuItem cartTotalMenuItem) {
        this.cartTotalMenuItem = cartTotalMenuItem;
    }
}
