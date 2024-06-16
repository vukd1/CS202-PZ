package com.example.cs202pz.controller;

import com.example.cs202pz.view.LoginView;
import com.example.cs202pz.view.MainHubView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;

public class LoginController implements EventHandler<ActionEvent> {
    private LoginView loginView;
    public LoginController(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String id = ((Node) actionEvent.getSource()).getId();

        switch (id){
            case "createAccountButton":
                DatabaseLogic.getInstance().writeAccountToDB(loginView.getUsername().getText(), loginView.getPassword().getText());
                break;
            case "lvErrorButton":
                loginView.close();
                break;
            case "loginButton":
                DatabaseLogic.getInstance().checkHashTemp(loginView.getPassword().getText());
                break;
//                if (DatabaseLogic.verifyCredentials(loginView.getUsername().getText(), loginView.getPassword().getText())){
//                    MainHubView.getInstance().show();
//                    loginView.getUsername().setText("");
//                    loginView.getPassword().setText("");
//                    loginView.close();
//                    break;
//                }
//                else loginView.getWelcomeText().setText("Credentials are incorrect!\nPlease try again");
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
