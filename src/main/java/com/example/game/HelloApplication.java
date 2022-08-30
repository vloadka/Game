package com.example.game;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class HelloApplication extends Application {
    @Override
    public void start (Stage stage) {
        Button btn = new Button("Play");
        btn.setPrefWidth(80);//ширина кнопки
        int stageWidth = 720; //ширина
        int stageHeight = 480;//длина
        final Spinner <Integer> spinner = new Spinner<Integer>();
        SpinnerValueFactory <Integer> spinnerValueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(3,8,3);
        spinner.setValueFactory(spinnerValueFactory);
        Stage2 stage2 = new Stage2();

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage2.setFieldSize(spinner.getValue());//передаем выбранный размер поля
                stage2.start();
                stage.close();
            }

        });

        BorderPane borderPane = new BorderPane();//чтобы выбрать куда прижать элементы к стороне контейнера
        borderPane.setCenter(btn);//кнопка плэй
        borderPane.setTop(spinner);
        Scene scene = new Scene(borderPane, stageWidth,stageHeight);
        stage.setMinWidth(stageWidth);
        stage.setMinHeight(stageHeight);
        stage.setMaxWidth(stageWidth);
        stage.setMaxHeight(stageHeight);
        stage.setTitle("Пятнашки");
        stage.setScene(scene);//добавляем к оунц сцену с материалом
        stage.show();
    }

    public static void main(String[] args) {launch();}
}
