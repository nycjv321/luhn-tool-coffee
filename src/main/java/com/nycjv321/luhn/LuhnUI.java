package com.nycjv321.luhn;

import com.nycjv321.utilities.FXUtilities;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * POC UI
 * Created by Javier on 10/6/2014.
 */
public class LuhnUI extends Application implements FXUtilities {
    private TextField inputTextField;
    private Label label;
    private Button validate;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(createValidatorView(), 325, 100);
        primaryStage.setTitle("Luhn Tool");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private GridPane createValidatorView() {
        GridPane grid = createGrid();
        inputTextField = new TextField();
        inputTextField.setAlignment(Pos.CENTER_RIGHT);
        inputTextField.setPrefWidth(200);
        validate = createButton("Validate", Pos.CENTER, 100, event -> {
            String inputText = inputTextField.getText();
            long value = 123;
            try {
                value = Long.valueOf(inputText);
            } catch (NumberFormatException e) {
                inputTextField.setText("False");
            }
            if (Luhn.isValid(value)) {
                inputTextField.setText("True");
            } else {
                inputTextField.setText("False");
            }
        });
        label = createLabel("Enter Account Number: ", 200, Pos.CENTER_LEFT, new Font(14));
        grid.add(label, 0, 0);
        grid.add(inputTextField, 1, 0);
        grid.add(validate, 1, 1, 2, 1);
        return grid;
    }
}
