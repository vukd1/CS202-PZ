package com.example.cs202pz.main;

import com.example.cs202pz.controller.DatabaseLogic;
import com.example.cs202pz.controller.LoginController;
import com.example.cs202pz.view.LoginView;
import javafx.application.Application;
import javafx.stage.Stage;


public class MainApp extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        LoginView.getInstance();
        DatabaseLogic.initDB();
    }
}
