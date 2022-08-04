package com.example.game;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class Scene2 extends Application {
    private Stage stage;
    private Group root = new Group();
    public Scene2() throws FileNotFoundException{

    }
    public void start (Stage primaryStage) throws FileNotFoundException{
        this.stage = primaryStage;
        stage.setMinHeight(400);
        stage.setMinWidth(500);
        stage.setMaxHeight(400);
        stage.setMaxWidth(500);

        Scene scene = new Scene(root, 500, 400, Color.WHITE);
        primaryStage.setTitle("Fifteen");

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
