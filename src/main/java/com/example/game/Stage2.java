package com.example.game;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Stage2 {
    private int sizeField = 3; //размер поля
    private int stageWidth = 720;
    private int stageHeight = 550;
    private BorderPane secondaryLayout = new BorderPane();
    private LogicGame logicGame;
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
        newWindow.setScene(secondScene);
        newWindow.show();

        logicGame.startLogic();
        drawField();
        logicOfField();
    }

    private void drawField(){
        int sizeOfButtons = 50; //размер одной кнопки
        int xForButtons = stageWidth / 2 - sizeOfButtons * sizeField / 2; //позиция начала отрисовки поля по ч чтобы поле было в центре
        int yForButtons = stageHeight / 2 - sizeOfButtons * sizeField / 2;
        Pane pane = new Pane();
        buttonForCheck.setLayoutX(320);
        buttonForCheck.setLayoutY(480);
        pane.getChildren().add(buttonForCheck);

        for (int i = 0; i < listOfButtons.length; i++) {
            for (int j = 0; j < listOfButtons.length; j++){
                Button button = new Button();
                pane.getChildren().add(button);
                listOfButtons[i][j] = button;
                button.setLayoutX(xForButtons+j*sizeOfButtons);
                button.setLayoutY(yForButtons+i*sizeOfButtons);
                button.setMinHeight(sizeOfButtons);
                button.setMinWidth(sizeOfButtons);
                button.setText(logicGame.getButtonNumber(i,j));
            }
        }
        secondaryLayout.setCenter(pane);
    }

    private void logicOfField(){ //функция, в которой происходит обработка нажатий и логики при нажатии
        for (int i = 0; i < listOfButtons.length; i++){
            for (int j = 0; j < listOfButtons.length; j++){
                int ai = i;
                int aj = j;
                listOfButtons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {

                        if (logicGame.getButtonNumber(ai, aj+1) == " "){//если кнопка справа пустая
                            String s = logicGame.getButtonNumber(ai, aj);
                            logicGame.setButtonNumber(ai, aj+ 1, s);
                            logicGame.setButtonNumber(ai, aj, " ");
                            listOfButtons[ai][aj].setDisable(true);
                            listOfButtons[ai][aj+1].setDisable(false);
                        }
                        if(logicGame.getButtonNumber(ai, aj - 1) == " "){//если кнопка слева пустая
                            String s = logicGame.getButtonNumber(ai, aj);
                            logicGame.setButtonNumber(ai, aj - 1, s);
                            logicGame.setButtonNumber(ai, aj, " ");
                            listOfButtons[ai][aj].setDisable(true);
                            listOfButtons[ai][aj-1].setDisable(false);
                        }
                        if (logicGame.getButtonNumber(ai+1, aj) == " "){//если кнопка снизу пустая
                            String s = logicGame.getButtonNumber(ai, aj);
                            logicGame.setButtonNumber(ai+1, aj, s);
                            logicGame.setButtonNumber(ai, aj, " ");
                            listOfButtons[ai][aj].setDisable(true);
                            listOfButtons[ai+1][aj].setDisable(false);
                        }
                        if (logicGame.getButtonNumber(ai-1,aj) == " "){//если кнопка сверху пустая
                            String s = logicGame.getButtonNumber(ai, aj);
                            logicGame.setButtonNumber(ai-1, aj, s);
                            logicGame.setButtonNumber(ai, aj, " ");
                            listOfButtons[ai][aj].setDisable(true);
                            listOfButtons[ai-1][aj].setDisable(false);
                        }

                        repaint();

                        if (logicGame.fieldValidation()){
                            winFunction();
                        }
                    }
                });
            }
        }

        buttonForCheck.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                for (int i = 0; i < logicGame.getFieldOfNumbers().length-1; i++){
                    for (int j = 0; j < logicGame.getFieldOfNumbers().length-1; j++){
                        logicGame.setButtonNumber(i,j,logicGame.getTrueButtonNumber(i,j));//устанавливаем в общий массив правильную цифру из правильного массива
                    }
                }
                for (int i = 0; i < listOfButtons.length; i++){
                    for (int j =0; j < listOfButtons.length; j++){
                        listOfButtons[i][j].setText(logicGame.getButtonNumber(i,j));//перерисовываем поле и обновляем числа
                    }
                }
            }
        });
    }

    private void winFunction(){
        Stage winWindow = new Stage();
        BorderPane winLayout = new BorderPane();
        Text text = new Text("YOU WIN");
        Button button = new Button("Reset");//сброс
        Pane pane = new Pane();
        pane.getChildren().addAll(text, button);
        winLayout.setCenter(pane);
        Scene winScene = new Scene(winLayout, 200, 100);
        winWindow.setScene(winScene);
        winWindow.show();
        button.setLayoutX(80);
        button.setLayoutY(40);
        text.setLayoutX(75);
        text.setLayoutY(20);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                winWindow.close();
                logicGame.startLogic();
                drawField();
                logicOfField();
            }
        });
    }

    private void repaint(){ //перерисовка чисел в кнопках
        for (int i = 0; i < listOfButtons.length; i++){
            for (int j = 0; j < listOfButtons.length; j++){
                listOfButtons[i][j].setText(logicGame.getButtonNumber(i,j));
            }
        }
    }
}
