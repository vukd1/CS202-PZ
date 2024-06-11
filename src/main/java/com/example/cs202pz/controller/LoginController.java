package com.example.cs202pz.controller;

import com.example.cs202pz.view.LoginView;
import com.example.cs202pz.view.MainHubView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.Objects;

public class LoginController implements EventHandler<ActionEvent> {
    private LoginView loginView;
    public LoginController(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String id = ((Node) actionEvent.getSource()).getId();

        switch (id){
            case "lvErrorButton":
                loginView.close();
            case "loginButton":
                if (DatabaseLogic.verifyCredentials(loginView.getUsername().getText(), loginView.getPassword().getText())){
                    MainHubView.getInstance().show();
                    loginView.getUsername().setText("");
                    loginView.getPassword().setText("");
                    loginView.hide();
                    break;
                }
                else loginView.getWelcomeLabel2().setText("Credentials are incorrect!\nPlease try again");
            case "loginField":
                loginView.getUsername().setOnKeyPressed(keyEvent -> {
                    if (keyEvent.getCode().equals(KeyCode.ENTER))
                        loginView.getLoginButton().fire();
                });
                loginView.getPassword().setOnKeyPressed(keyEvent -> {
                    if (keyEvent.getCode().equals(KeyCode.ENTER))
                        loginView.getLoginButton().fire();
                });
                break;
        }
    }
}
