package com.example.game;

import java.util.ArrayList;

public class LogicGame {
    private int sizeField; // размер поля
    private String[][] fieldOfNumbers; // поле чисел
    private String[][] trueFieldOfNumbers; //истинное поле чисел

    public LogicGame(int size) {
        sizeField = size;
        fieldOfNumbers = new String[sizeField + 2][sizeField +2];
        trueFieldOfNumbers = new String[sizeField + 2][sizeField + 2];
    }

    public void startLogic(){
        fillTheTrueFieldOfNumbers();
        fillTheFieldOfNumbers();
    }

    public void fillTheTrueFieldOfNumbers(){

        for (int i = 0; i<trueFieldOfNumbers.length; i++) {
            for (int j = 0; j < trueFieldOfNumbers.length; j++){
                trueFieldOfNumbers[i][j] = "0";//заполняем все нулями сперва
            }
        }

        int number = 1; //счетчик чисел
        for (int i = 0; i < trueFieldOfNumbers.length; i++) {
            for (int j = 0; j < trueFieldOfNumbers.length; j++) {
                if(number == sizeField * sizeField) {
                    trueFieldOfNumbers[j][i] = " "; //последнее число оставляем пустым
                } else {
                    trueFieldOfNumbers[i][j] = String.valueOf(number);
                    number = number + 1;
                }
            }
        }
    }

    public void fillTheFieldOfNumbers(){
        ArrayList<Integer> list = new ArrayList<Integer>(); //лист, в который будут класться числа, чтобы они были неповторяющимися
        Boolean flag;
        int rnd;

        for (int i = 0; i < fieldOfNumbers.length; i++) {
            for (int j = 0; j < fieldOfNumbers.length; j++){
                fieldOfNumbers[i][j] = "0"; // заполним все нулями сперва
            }
        }

        for (int i = 0; i < fieldOfNumbers.length - 1; i++){
            for (int j = 0; j < fieldOfNumbers.length - 1; j++) {
                flag = false;
                do { //повторяем до тех пор пока не попадется число, которого нет в листе для избежания повтор числе
                    rnd = (int)(Math.random() * (sizeField * sizeField)-1); // от 1 до размер поля -1
                    if (!list.contains(rnd)) {
                        list.add(rnd);
                        flag = true;
                        fieldOfNumbers[i][j] = String.valueOf(rnd);
                        if (rnd == sizeField * sizeField) {
                            fieldOfNumbers[i][j] = " "; //кнопка с последним числом пустая
                        }
                    }
                } while (!flag);
            }
        }

    }

    public String getButtonNumber(int a, int b){
        return fieldOfNumbers[a+1][b+1];
    }
}