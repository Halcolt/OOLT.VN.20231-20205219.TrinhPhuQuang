package com.Controller;

import com.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.event.ActionEvent;

public class MainMenuController {
    @FXML
    private RadioButton ButtonManual;

    @FXML
    private RadioButton ButtonAutomatic;

    private ToggleGroup radioButtonGroup;

    @FXML
    public void initialize() {
        radioButtonGroup = new ToggleGroup();
        ButtonManual.setToggleGroup(radioButtonGroup);
        ButtonAutomatic.setToggleGroup(radioButtonGroup);
    }

    @FXML
    void handleButtonConfirm(ActionEvent event) {
        if (radioButtonGroup.getSelectedToggle() != null) {
            RadioButton selectedRadioButton = (RadioButton) radioButtonGroup.getSelectedToggle();
            if (selectedRadioButton == ButtonAutomatic) {
                MainApp.loadscene("ChoosingSortType.fxml");
            } else if (selectedRadioButton == ButtonManual) {
                MainApp.loadscene("Inputdata.fxml");
            }
        }
    }
}
