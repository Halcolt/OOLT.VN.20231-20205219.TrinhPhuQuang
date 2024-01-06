package com.Controller;

import com.MainApp;
import com.SwapUtil;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.Duration;
import com.SortType.BubbleSort;

public class SortingAlgorithmDemoController extends SwapUtil {

    @FXML
    private Label square1;
    @FXML
    private Label square2;
    @FXML
    private Label square3;
    @FXML
    private Label square4;
    @FXML
    private Label square5;
    @FXML
    private Label square6;
    @FXML
    private Label square7;
    @FXML
    private Label square8;
    @FXML
    private Label square9;
    @FXML
    private Label square10;

    private int[] data;

    public void initialize() {
        data = MainApp.data;
        SetData();
        SortWithAnimation(data,0,0);
    }

    public void SetData() {
        square1.setText(String.valueOf(data[0]));
        square2.setText(String.valueOf(data[1]));
        square3.setText(String.valueOf(data[2]));
        square4.setText(String.valueOf(data[3]));
        square5.setText(String.valueOf(data[4]));
        square6.setText(String.valueOf(data[5]));
        square7.setText(String.valueOf(data[6]));
        square8.setText(String.valueOf(data[7]));
        square9.setText(String.valueOf(data[8]));
        square10.setText(String.valueOf(data[9]));
    }

    public void SortWithAnimation(int[] arr, int i, int j) {
        PauseTransition pause = new PauseTransition(Duration.seconds(1));
        if (i >= 0 && j >= 0) {
            swap(data, i, j);
            SetData();
        }

        // Continue sorting with the next pair of elements
        int[] positions = BubbleSort.bubbleSortWithPositions(arr);
        if (positions != null) {
            i = positions[0];
            j = positions[1];
            int finalI = i;
            int finalJ = j;
            pause.setOnFinished(event -> SortWithAnimation(arr, finalI, finalJ));
            pause.play();
        }
    }
}
