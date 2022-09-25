package com.example.game;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class HelloApplication extends Application {
    @Override
    public void start (Stage stage) {
        Button btn = new Button("Play");
        btn.setPrefWidth(200);
        int stageWidth = 720;
        int stageHeight = 480;
        final Spinner <Integer> spinner = new Spinner<Integer>();
        SpinnerValueFactory<Integer> spinnerValueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(3,8,3);
        spinner.setValueFactory(spinnerValueFactory);
        Stage2 stage2 = new Stage2();


        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage2.setFieldSize(spinner.getValue());
                stage2.start();
                stage.close();
            }

        });

        Pane pane = new Pane();

        Label label1 = new Label("Добро пожаловать в игру!");
        label1.setFont(new Font ("Arial", 45));
        label1.setLayoutX(80);
        label1.setLayoutY(0);

        Label label2 = new Label("""
             Для того, чтобы решить головоломку, необходимо расставить квадратики с цифрами по порядку,
             от меньшего к большего.А на последнем месте должен быть пустой квадратик.""");
        label2.setFont(new Font("Arial", 15));
        label2.setLayoutX(10);
        label2.setLayoutY(60);
        label2.setTextFill(Color.GREEN);

        Label label3 = new Label("Выберите размер поля ниже в спиннере:");
        label3.setFont(new Font("Arial",25));
        label3.setLayoutX(10);
        label3.setLayoutY(110);

        spinner.setLayoutX(10);
        spinner.setLayoutY(140);
        btn.setLayoutX(250);
        btn.setLayoutY(220);

        Label label4 = new Label("Удачи!");
        label4.setFont(new Font("Arial", 20));
        label4.setLayoutX(320);
        label4.setLayoutY(250);

        pane.getChildren().addAll(label1,label2, label3, spinner,btn,label4);

        Scene scene = new Scene(pane, stageWidth,stageHeight);
        stage.setResizable(false);
        stage.setTitle("Пятнашки");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {launch();}
}
