package com.example.cs202pz.main;

import com.example.cs202pz.controller.LoginController;
import com.example.cs202pz.view.LoginView;
import javafx.application.Application;
import javafx.stage.Stage;


public class MainApp extends Application {
    // Maybe a dedicated method that launches multiple processes
    // But then why have main ????

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        LoginView loginView = LoginView.getInstance();
        //LoginController loginController = new LoginController(loginView);
    }
}
