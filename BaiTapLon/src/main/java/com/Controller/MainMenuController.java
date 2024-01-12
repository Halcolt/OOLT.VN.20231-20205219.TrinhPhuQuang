package com.Controller;

import com.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class MainMenuController extends MainApp {
    @FXML
    private RadioButton ButtonBubbleSort;

    @FXML
    private RadioButton ButtonHeapSort;

    @FXML
    private RadioButton ButtonShellSort;

    private ToggleGroup toggleGroup;

    @FXML
    public void initialize() {
        toggleGroup = new ToggleGroup();
        ButtonBubbleSort.setToggleGroup(toggleGroup);
        ButtonHeapSort.setToggleGroup(toggleGroup);
        ButtonShellSort.setToggleGroup(toggleGroup);
    }

    public static String SortType;
    @FXML
    void handleButtonConfirm(ActionEvent event) {
        if (toggleGroup.getSelectedToggle() != null) {
            RadioButton selectedRadioButton = (RadioButton) toggleGroup.getSelectedToggle();
            if (selectedRadioButton == ButtonBubbleSort) {
                MainMenuController.SortType = "BubbleSort";
            } else if (selectedRadioButton == ButtonHeapSort) {
                MainMenuController.SortType = "HeapSort";
            } else if (selectedRadioButton == ButtonShellSort) {
                MainMenuController.SortType = "ShellSort";
            }
            loadScene("SortingAlgorithmDemo.fxml");
        }
    }

    @FXML
    void handleButtonExit(ActionEvent event) {
        System.exit(0);
    }
}
