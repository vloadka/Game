package com.example.game;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class HelloApplication extends Application {
    @Override
    public void start (Stage stage) {
        Button btn = new Button("Play");
        btn.setPrefWidth(80);//ширина кнопки
        int stageWidth = 720; //ширина
        int stageHeight = 480;//длина
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

    BorderPane borderPane = new BorderPane();

       // borderPane.setCenter(btn);
        //borderPane.setTop(spinner);

        VBox vBox = new VBox();
        Label label1 = new Label("      Добро пожаловать в игру!");
        label1.setFont(new Font("Arial", 45));
        vBox.getChildren().add(label1);
        Label label2 = new Label("Для того чтобы решить головоломку, необходимо расставить квадратики с\n" +
                "                   цифрами по порядку, от меньшего к большему");
        label2.setFont(new Font("Arial", 20));
        label2.setTextFill(Color.GREEN);
        vBox.getChildren().add(label2);

        Label label4 = new Label("Выберите размер поля ниже в спиннере:");
        label4.setFont(new Font("Arial", 26));
        vBox.getChildren().add(label4);
        vBox.getChildren().addAll(spinner, btn);
        Label label3 = new Label("Удачи!");
        label3.setFont(new Font("Arial", 20));
        vBox.getChildren().add(label3);
        borderPane.setCenter(vBox);

        //vBox.setLayoutX(360);
       // vBox.setLayoutY(240);

        Scene scene = new Scene(borderPane, stageWidth,stageHeight);
        stage.setMinWidth(stageWidth);
        stage.setMinHeight(stageHeight);
        stage.setMaxWidth(stageWidth);
        stage.setMaxHeight(stageHeight);
        stage.setTitle("Пятнашки");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {launch();}
}
