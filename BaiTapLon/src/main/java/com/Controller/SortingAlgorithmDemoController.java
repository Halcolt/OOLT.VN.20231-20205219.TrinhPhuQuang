package com.Controller;

import com.MainApp;
import com.SortType.HeapSort;
import com.SortType.ShellSort;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.util.Duration;
import com.SortType.BubbleSort;

import java.util.Random;

public class SortingAlgorithmDemoController  {
    @FXML
    private TextField TextField0;
    @FXML
    private TextField TextField1;
    @FXML
    private TextField TextField2;
    @FXML
    private TextField TextField3;
    @FXML
    private TextField TextField4;
    @FXML
    private TextField TextField5;
    @FXML
    private TextField TextField6;
    @FXML
    private TextField TextField7;
    @FXML
    private TextField TextField8;
    @FXML
    private TextField TextField9;
    @FXML
    private RadioButton ButtonManual;
    @FXML
    private RadioButton ButtonAutomatic;
    private ToggleGroup dataInputToggleGroup;

    private int[] arr = {9,10,8,7,6,5,2,4,1,3};
    private int i = 0;
    private int j = 0;
    private int currentHeapIndex;

    public void initialize() {
        dataInputToggleGroup = new ToggleGroup();

        ButtonManual.setToggleGroup(dataInputToggleGroup);
        ButtonAutomatic.setToggleGroup(dataInputToggleGroup);
        Setarr();
    }

    private void generateRandomArray() {
        Random rand = new Random();
        for (int k = 0; k < 10; k++) {
            arr[k] = rand.nextInt(100); // Giả sử giá trị từ 0 đến 99
        }
    }

    // Phương thức mới để đọc mảng từ TextField
    private void readArrayFromTextFields() {
        TextField[] textFields = {
                TextField0, TextField1, TextField2, TextField3, TextField4,
                TextField5, TextField6, TextField7, TextField8, TextField9
        };

        for (int k = 0; k < 10; k++) {
            try {
                arr[k] = Integer.parseInt(textFields[k].getText());
            } catch (NumberFormatException e) {
                arr[k] = 0;  // Đặt giá trị mặc định nếu không đọc được số
            }
        }
    }

    public void handleButtonConfirm() {
        if (ButtonAutomatic.isSelected()) {
            generateRandomArray(); // Tạo mảng ngẫu nhiên
        } else if (ButtonManual.isSelected()) {
            readArrayFromTextFields(); // Đọc mảng từ TextField
        }
        SortWithAnimation(arr); // Bắt đầu sắp xếp với mảng đã chọn hoặc nhập
    }

    public void Setarr() {
        TextField[] textFields = {
                TextField0, TextField1, TextField2, TextField3, TextField4,
                TextField5, TextField6, TextField7, TextField8, TextField9
        };

        for (int k = 0; k < 10; k++) {
            textFields[k].setText(String.valueOf(arr[k]));
        }
    }

    public void SortWithAnimation(int[] arr) {
        int[] positions;

        switch (MainMenuController.SortType) {
            case "BubbleSort":
                positions = BubbleSort.bubbleSortWithPositions(arr, this.i, this.j);
                break;
            case "HeapSort":
                positions = HeapSort.heapSortWithPositions(arr, this.currentHeapIndex);
                break;
            case "ShellSort":
                positions = ShellSort.shellSortWithPositions(arr, this.i, this.j);
                break;
            default:
                positions = null;
                break;
        }

        if (positions == null) {
            this.i = 0; // Reset i for BubbleSort and ShellSort
            this.j = 0; // Reset j for BubbleSort and ShellSort
//            this.currentHeapIndex = arr.length;
        } else {
            processSorting(arr, positions);
        }
    }

    private void processSorting(int[] arr, int[] positions) {
        if(positions[0] != -1){ //hightlight element
            highlightTextField(positions[0]);
            highlightTextField(positions[1]);
            unhighlightTextField(positions[0]);
            unhighlightTextField(positions[1]);
        }
        Setarr();

        // position lần gọi kế
        this.i = positions[2];
        this.j = positions[3];
//        if (MainMenuController.SortType.equals("HeapSort")) {
//            this.currentHeapIndex = positions[2];
//        }

        PauseTransition pause = new PauseTransition(Duration.seconds(1));
        pause.setOnFinished(event -> SortWithAnimation(arr));
        pause.play();
    }

    private TextField getTextFieldByIndex(int index) {
        switch (index) {
            case 0:
                return TextField0;
            case 1:
                return TextField1;
            case 2:
                return TextField2;
            case 3:
                return TextField3;
            case 4:
                return TextField4;
            case 5:
                return TextField5;
            case 6:
                return TextField6;
            case 7:
                return TextField7;
            case 8:
                return TextField8;
            case 9:
                return TextField9;
            default:
                return null;
        }
    }

    private void highlightTextField(int index) {
        TextField textField = getTextFieldByIndex(index);
        if (textField != null) {
            textField.setStyle("-fx-background-color: lightblue;");
        }
    }

    private void unhighlightTextField(int index) {
        PauseTransition pause = new PauseTransition(Duration.seconds(1));
        pause.setOnFinished(event -> {
            TextField textField = getTextFieldByIndex(index);

            if (textField != null) {
                textField.setStyle("-fx-background-color: white;");
            }
        });
        pause.play();
    }
}
