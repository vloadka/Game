package com.example.game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class AppController {
    public AppController() throws FileNotFoundException {
    }

    @FXML
    private Button button;

    public Scene2 scene2= new Scene2();
//
//    @FXML
//    void onHelloButtonClick(ActionEvent event) {
//        button.setOnAction(
//                button.getScene().getWindow().hide();
//                Stage stage = new Stage();
//                scene2.start(stage);
//        )
//    }

    @FXML
    void initialize() {
        button.setOnAction(event -> {
            button.getScene().getWindow().hide();
            Stage stage = new Stage();
            try {
                scene2.start(stage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
    }
}
