package com.example.game;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Stage2 {
    private int sizeField = 3; //размер поля
    private int stageWidth = 720;
    private int stageHeight = 480;
    private BorderPane secondaryLayout = new BorderPane();
    private LogicGame logicGame; //класс логики игры
    private Button buttonForCheck = new Button("Checking");
    private Stage newWindow = new Stage();
    private Button[][] listOfButtons;

    public void setFieldSize(int size){
        sizeField = size;
        logicGame = new LogicGame(sizeField);
        listOfButtons = new Button[sizeField][sizeField];
    }

    public void start() {
        Scene secondScene = new Scene(secondaryLayout, stageWidth, stageHeight);
        newWindow.setMinWidth(stageWidth);
        newWindow.setMinHeight(stageHeight);
        newWindow.setMaxWidth(stageWidth);
        newWindow.setMaxHeight(stageHeight);
        newWindow.setTitle("SecondScene");
        newWindow.show();

        logicGame.startLogic();
        drawField();
    }

    private void drawField(){
        int sizeOfButtons = 50; //размер одной кнопки
        int xForButtons = stageWidth/2 - sizeOfButtons * sizeField/2; //позиция начала отрисовки поля по ч чтобы поле было в центре
        int yForButtons = stageHeight/2 - sizeOfButtons * sizeField/2;
        Pane pane = new Pane();
        pane.getChildren().add(buttonForCheck);

        for (int i = 0; i < listOfButtons.length; i++) {
            for (int j = 0; j < listOfButtons.length; j++){
                Button button = new Button();
                pane.getChildren().add(button);
                listOfButtons[i][j] = button; //добавляем в двумерный массив кнопку
                button.setLayoutX(xForButtons*j*sizeOfButtons);
                button.setLayoutY(yForButtons*i*sizeOfButtons);
                button.setMinHeight(sizeOfButtons);
                button.setMinWidth(sizeOfButtons);
                button.setText(logicGame.getButtonNumber(i,j));
            }
        }
        secondaryLayout.setCenter(pane);
    }
}
