package com.example.game;

import java.util.ArrayList;
import java.util.Objects;

public class LogicGame {
    private int sizeField; // размер поля
    private String[][] fieldOfNumbers; // поле чисел
    private String[][] trueFieldOfNumbers; //истинное поле чисел

    public LogicGame(int size) {
        sizeField = size;//размер поля
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
                trueFieldOfNumbers[i][j] = "0";
            }
        }

        int number = 1; //счетчик чисел
        for (int i = 1; i < trueFieldOfNumbers.length - 1; i++) {
            for (int j = 1; j < trueFieldOfNumbers.length - 1; j++) {
                if(number == sizeField * sizeField) {
                    trueFieldOfNumbers[i][j] = " "; //последнее число оставляем пустым
                } else {
                    trueFieldOfNumbers[i][j] = String.valueOf(number);
                    number = number + 1;
                }
            }
        }
    }

    public void fillTheFieldOfNumbers(){
        ArrayList<Integer> list = new ArrayList<Integer>(); //лист, в который будут класться числа, чтобы они были неповторяющимися
        boolean flag;
        int rnd;

        for (int i = 0; i < fieldOfNumbers.length; i++) {
            for (int j = 0; j < fieldOfNumbers.length; j++){
                fieldOfNumbers[i][j] = "0";
            }
        }

        for (int i = 1; i < fieldOfNumbers.length - 1; i++){
            for (int j = 1; j < fieldOfNumbers.length - 1; j++) {
                flag = false;
                do { //повторяем до тех пор пока не попадется число, которого нет в листе для избежания повтор числе
                    rnd = (int)(Math.random() * (sizeField * sizeField)+1);
                    if (!list.contains(rnd)) {
                        list.add(rnd);
                        flag = true;
                        fieldOfNumbers[i][j] = String.valueOf(rnd);
                        if (rnd == sizeField * sizeField) {
                            fieldOfNumbers[i][j] = " ";
                        }
                    }
                } while (!flag);
            }
        }

    }

    public String getButtonNumber(int a, int b){
        return fieldOfNumbers[a+1][b+1];
    }

    public void setButtonNumber(int a, int b, String number){
        fieldOfNumbers[a+1][b+1] = number;
    }

    public Boolean fieldValidation() {
        int count = 0;
        for (int i = 1; i < trueFieldOfNumbers.length - 1; i++){
            for (int j = 1; j < trueFieldOfNumbers.length -1; j++){
                if (Objects.equals(fieldOfNumbers[i][j], trueFieldOfNumbers[i][j])){
                    count = count + 1;
                }
            }
        }
        if (count == (sizeField*sizeField)) {
            return true;
        }
        return false;
    }

    public String[][] getFieldOfNumbers(){return fieldOfNumbers;}
    public String[][] getTrueFieldOfNumbers() {return trueFieldOfNumbers;}
    public String getTrueButtonNumber(int a, int b){
        return trueFieldOfNumbers[a+1][b+1];
    }


}
