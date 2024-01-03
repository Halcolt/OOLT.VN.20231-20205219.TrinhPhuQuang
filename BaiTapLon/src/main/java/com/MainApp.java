package com;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class MainApp extends Application {

    private static Stage primaryStage;
    public static int[] data = {10, 20, 3, 4, 50, 6, 70, 8, 9, 10}; // Sample data

    public static void loadScene(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource(fxmlFile));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) {
        MainApp.primaryStage = primaryStage;
        loadScene("SortingAlgorithmDemo.fxml");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
