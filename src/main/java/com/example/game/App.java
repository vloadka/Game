package com.example.game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    public App(){
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        primaryStage.setTitle("Hello!");

        //не изменять размер окна
        primaryStage.setMinWidth(500);
        primaryStage.setMinHeight(400);
        primaryStage.setWidth(500);
        primaryStage.setHeight(400);
        primaryStage.setMaxWidth(500);
        primaryStage.setMaxHeight(400);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}