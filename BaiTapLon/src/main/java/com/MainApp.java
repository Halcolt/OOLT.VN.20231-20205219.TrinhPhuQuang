package com;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class MainApp extends Application {

    public static int[] data = {10, 20, 3, 4, 50, 6, 70, 8, 9, 1}; // Demo data
    private static Stage primaryStage;
    
    @Override
    public void start(Stage primaryStage) {
        MainApp.primaryStage = primaryStage;
        Utilities.loadScene(primaryStage, "MainMenu.fxml");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
