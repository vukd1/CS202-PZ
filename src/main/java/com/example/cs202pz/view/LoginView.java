package com.example.cs202pz.view;

import com.example.cs202pz.controller.DatabaseLogic;
import com.example.cs202pz.controller.LoginController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class LoginView extends Stage {

    private LoginController loginController = new LoginController(this);
    private static LoginView loginView_instance = null;

    // JavaFX elements
    private Label usernameLabel = new Label("Username:");
    private Label passwordLabel = new Label("Password:");
    private TextField username = new TextField();
    private PasswordField password = new PasswordField();
    private Button loginButton = new Button("Login");
    private Button createAccountButton = new Button("Create account");
    private Label welcomeLabel1 = new Label("Welcome");
    private Text welcomeText = new Text("Please fill in your credentials");
    private Label helpButton = new Label("Help");
    private VBox vBox1 = new VBox(welcomeLabel1, welcomeText);
    private HBox hBox1 = new HBox(usernameLabel, username);
    private HBox hBox2 = new HBox(passwordLabel, password);
    private HBox hBox3 = new HBox(loginButton, createAccountButton);
    private VBox vBox2 = new VBox(hBox1, hBox2, hBox3);
    private VBox vBox3 = new VBox(helpButton);
    private BorderPane centralBorderPane = new BorderPane();
    private BorderPane errorBorderPane = new BorderPane();
    private Label errorLabel = new Label("Database connection error!");
    private Text errorText = new Text("Error text.");
    private Button errorButton = new Button("Quit");
    private VBox errorVbox = new VBox(errorText, errorButton);
    // JavaFX elements

    public static synchronized LoginView getInstance(){
        if (loginView_instance == null){
            loginView_instance = new LoginView();
        }
        return loginView_instance;
    }

    @Override
    public String toString() {
        return "LoginView{" +
                "loginController=" + loginController +
                ", usernameLabel=" + usernameLabel +
                ", passwordLabel=" + passwordLabel +
                ", username=" + username +
                ", password=" + password +
                ", loginButton=" + loginButton +
                ", createAccountButton=" + createAccountButton +
                ", welcomeLabel1=" + welcomeLabel1 +
                ", welcomeText=" + welcomeText +
                ", helpButton=" + helpButton +
                ", vBox1=" + vBox1 +
                ", hBox1=" + hBox1 +
                ", hBox2=" + hBox2 +
                ", hBox3=" + hBox3 +
                ", vBox2=" + vBox2 +
                ", vBox3=" + vBox3 +
                ", centralBorderPane=" + centralBorderPane +
                ", errorBorderPane=" + errorBorderPane +
                ", errorLabel=" + errorLabel +
                ", errorText=" + errorText +
                ", errorButton=" + errorButton +
                ", errorVbox=" + errorVbox +
                '}';
    }

    public LoginController getLoginController() {
        return loginController;
    }

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }

    public static LoginView getLoginView_instance() {
        return loginView_instance;
    }

    public static void setLoginView_instance(LoginView loginView_instance) {
        LoginView.loginView_instance = loginView_instance;
    }

    public Label getUsernameLabel() {
        return usernameLabel;
    }

    public void setUsernameLabel(Label usernameLabel) {
        this.usernameLabel = usernameLabel;
    }

    public Label getPasswordLabel() {
        return passwordLabel;
    }

    public void setPasswordLabel(Label passwordLabel) {
        this.passwordLabel = passwordLabel;
    }

    public Button getCreateAccountButton() {
        return createAccountButton;
    }

    public void setCreateAccountButton(Button createAccountButton) {
        this.createAccountButton = createAccountButton;
    }

    public Label getWelcomeLabel1() {
        return welcomeLabel1;
    }

    public void setWelcomeLabel1(Label welcomeLabel1) {
        this.welcomeLabel1 = welcomeLabel1;
    }

    public Label getHelpButton() {
        return helpButton;
    }

    public void setHelpButton(Label helpButton) {
        this.helpButton = helpButton;
    }

    public VBox getvBox1() {
        return vBox1;
    }

    public void setvBox1(VBox vBox1) {
        this.vBox1 = vBox1;
    }

    public HBox gethBox1() {
        return hBox1;
    }

    public void sethBox1(HBox hBox1) {
        this.hBox1 = hBox1;
    }

    public HBox gethBox2() {
        return hBox2;
    }

    public void sethBox2(HBox hBox2) {
        this.hBox2 = hBox2;
    }

    public HBox gethBox3() {
        return hBox3;
    }

    public void sethBox3(HBox hBox3) {
        this.hBox3 = hBox3;
    }

    public VBox getvBox2() {
        return vBox2;
    }

    public void setvBox2(VBox vBox2) {
        this.vBox2 = vBox2;
    }

    public VBox getvBox3() {
        return vBox3;
    }

    public void setvBox3(VBox vBox3) {
        this.vBox3 = vBox3;
    }

    public BorderPane getCentralBorderPane() {
        return centralBorderPane;
    }

    public void setCentralBorderPane(BorderPane centralBorderPane) {
        this.centralBorderPane = centralBorderPane;
    }

    public BorderPane getErrorBorderPane() {
        return errorBorderPane;
    }

    public void setErrorBorderPane(BorderPane errorBorderPane) {
        this.errorBorderPane = errorBorderPane;
    }

    public Label getErrorLabel() {
        return errorLabel;
    }

    public void setErrorLabel(Label errorLabel) {
        this.errorLabel = errorLabel;
    }

    public Button getErrorButton() {
        return errorButton;
    }

    public void setErrorButton(Button errorButton) {
        this.errorButton = errorButton;
    }

    public VBox getErrorVbox() {
        return errorVbox;
    }

    public void setErrorVbox(VBox errorVbox) {
        this.errorVbox = errorVbox;
    }

    public Text getWelcomeText() {
        return welcomeText;
    }

    public void setWelcomeText(Text welcomeText) {
        this.welcomeText = welcomeText;
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

    public Text getErrorText() {
        return errorText;
    }

    public void setErrorText(Text errorText) {
        this.errorText = errorText;
    }

    private LoginView(){
        vBox1.setAlignment(Pos.CENTER);
        vBox1.setSpacing(5);
        vBox1.setPadding(new Insets(0, 0, 10, 0));
        welcomeText.setTextAlignment(TextAlignment.CENTER);
        welcomeLabel1.setFont(new Font(20));

        hBox1.setAlignment(Pos.CENTER);
        hBox1.setSpacing(25);
        hBox2.setAlignment(Pos.CENTER);
        hBox2.setSpacing(28); // Lazy fix
        hBox3.setAlignment(Pos.CENTER);
        hBox3.setSpacing(25);
        hBox3.setPadding(new Insets(30,0,0,0));
        vBox2.setSpacing(20);
        vBox2.setAlignment(Pos.CENTER);
        loginButton.setMinWidth(95);
        createAccountButton.setMinWidth(95);

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

        loginButton.setId("loginButton");
        loginButton.setOnAction(loginController);
        username.setId("loginField");
        password.setId("loginField");
        username.setOnAction(loginController);
        password.setOnAction(loginController);

        createAccountButton.setId("createAccountButton");
        createAccountButton.setOnAction(loginController);
    }

    public void dbInitErrorView(String errorText2){
        errorBorderPane.setTop(errorLabel);
        errorBorderPane.setCenter(errorVbox);
        errorLabel.setFont(new Font(20));
        errorLabel.setAlignment(Pos.CENTER);
        errorText.setTextAlignment(TextAlignment.CENTER);
        BorderPane.setAlignment(errorLabel, Pos.CENTER);
        BorderPane.setAlignment(errorVbox, Pos.CENTER);
        errorVbox.setAlignment(Pos.CENTER);
        errorVbox.setSpacing(30);
        errorButton.setId("lvErrorButton");
        errorButton.setOnAction(loginController);
        errorText.setText(errorText2);
        errorText.setWrappingWidth(320);
        this.setScene(new Scene(errorBorderPane, 360, 360));
    }
}
