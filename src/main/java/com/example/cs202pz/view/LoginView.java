package com.example.cs202pz.view;

import com.example.cs202pz.controller.LoginController;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LoginView extends Stage {

    private static LoginView loginView_instance = null;
    private Label usernameLabel = new Label("Username:");
    private Label passwordLabel = new Label("Password:");
    private TextField username = new TextField();
    private PasswordField password = new PasswordField();
    private Button loginButton = new Button("Login");
    private Label welcomeLabel1 = new Label("Welcome");
    private Label welcomeLabel2 = new Label("Please fill in your credentials");
    private Label helpButton = new Label("Help");
    private VBox vBox1 = new VBox(welcomeLabel1, welcomeLabel2);
    private HBox hBox1 = new HBox(usernameLabel, username);
    private HBox hBox2 = new HBox(passwordLabel, password);
    private VBox vBox2 = new VBox(hBox1, hBox2, loginButton);
    private VBox vBox3 = new VBox(helpButton);
    private BorderPane centralBorderPane = new BorderPane();

    public static synchronized LoginView getInstance(){
        if (loginView_instance == null){
            loginView_instance = new LoginView();
        }
        return loginView_instance;
    }

    public Label getWelcomeLabel2() {
        return welcomeLabel2;
    }

    public void setWelcomeLabel2(Label welcomeLabel2) {
        this.welcomeLabel2 = welcomeLabel2;
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
        vBox1.setAlignment(Pos.CENTER);
        vBox1.setSpacing(5);
        vBox1.setPadding(new Insets(0, 0, 10, 0));
        welcomeLabel2.setAlignment(Pos.CENTER);
        welcomeLabel1.setFont(new Font(20));

        hBox1.setAlignment(Pos.CENTER);
        hBox1.setSpacing(25);
        hBox2.setAlignment(Pos.CENTER);
        hBox2.setSpacing(28); // Lazy fix
        vBox2.setSpacing(10);
        vBox2.setAlignment(Pos.CENTER);

        vBox3.setAlignment(Pos.BOTTOM_RIGHT);
        helpButton.setUnderline(true);
        vBox3.setPadding(new Insets(5));

        centralBorderPane.setTop(vBox1);
        centralBorderPane.setCenter(vBox2);
        centralBorderPane.setBottom(vBox3);


        username.setMaxWidth(150);
        username.setTooltip(new Tooltip("Enter your username"));
        password.setMaxWidth(150);
        password.setTooltip(new Tooltip("Enter your password"));
        this.setScene(new Scene(centralBorderPane, 360, 360));
        this.show();
        LoginController loginController = new LoginController(this);

        loginButton.setId("loginButton");
        loginButton.setOnAction(loginController);
        username.setId("loginField");
        password.setId("loginField");
        username.setOnAction(loginController);
        password.setOnAction(loginController);
    }
}
