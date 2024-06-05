package com.example.cs202pz.view;

import com.example.cs202pz.controller.LoginController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LoginView extends Stage {

    private static LoginView loginView_instance = null;
    private BorderPane bp = new BorderPane();
    private TextField username = new TextField();
    private PasswordField password = new PasswordField();
    private Button loginButton = new Button("Login");
    private VBox vBox1 = new VBox(username, password);
    private Label topLabel = new Label("Welcome, please log in");

    public static synchronized LoginView getInstance(){
        if (loginView_instance == null){
            loginView_instance = new LoginView();
        }
        return loginView_instance;
    }

    public TextField getUsername() {
        return username;
    }

    public void setUsername(TextField username) {
        this.username = username;
    }

    public PasswordField getPassword() {
        return password;
    }

    public void setPassword(PasswordField password) {
        this.password = password;
    }

    public Button getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(Button loginButton) {
        this.loginButton = loginButton;
    }

    private LoginView(){
        bp.setTop(topLabel);
        bp.setCenter(vBox1);
        bp.setBottom(loginButton);
        BorderPane.setAlignment(topLabel, Pos.CENTER);
        BorderPane.setAlignment(vBox1, Pos.CENTER);
        BorderPane.setAlignment(loginButton, Pos.CENTER);
        vBox1.setAlignment(Pos.CENTER);
        username.setMaxWidth(150);
        username.setTooltip(new Tooltip("Enter your username"));
        password.setMaxWidth(150);
        password.setTooltip(new Tooltip("Enter your password"));
        vBox1.setSpacing(15);
        this.setScene(new Scene(bp, 960, 540));
        this.show();
        LoginController loginController = new LoginController(this);
        loginButton.setId("loginButton");
        loginButton.setOnAction(loginController);
    }
}
