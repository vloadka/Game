package com.example.game;

import java.util.ArrayList;
import java.util.Objects;

public class LogicGame {
    private int sizeField;
    private String[][] fieldOfNumbers;
    private String[][] trueFieldOfNumbers;
    private int[] mas;

    public LogicGame(int size) {
        sizeField = size;
        fieldOfNumbers = new String[sizeField + 2][sizeField +2];
        trueFieldOfNumbers = new String[sizeField + 2][sizeField + 2];
        mas = new int [sizeField*sizeField];
    }

    public void startLogic(){
        fillTheTrueFieldOfNumbers();
        boolean flag = false;
        do{
            fillTheFieldOfNumbers();
            if (solvabilityCheck()){
                flag = true;
            }
        } while (!flag);

    }

    public void fillTheTrueFieldOfNumbers(){

        for (int i = 0; i<trueFieldOfNumbers.length; i++) {
            for (int j = 0; j < trueFieldOfNumbers.length; j++){
                trueFieldOfNumbers[i][j] = "0";
            }
        }

        int number = 1;
        for (int i = 1; i < trueFieldOfNumbers.length - 1; i++) {
            for (int j = 1; j < trueFieldOfNumbers.length - 1; j++) {
                if(number == sizeField * sizeField) {
                    trueFieldOfNumbers[i][j] = " ";
                } else {
                    trueFieldOfNumbers[i][j] = String.valueOf(number);
                    number = number + 1;
                }
            }
        }
    }

    public void fillTheFieldOfNumbers(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        boolean flag;
        int rnd;
        int count = 0;

        for (int i = 0; i < fieldOfNumbers.length; i++) {
            for (int j = 0; j < fieldOfNumbers.length; j++){
                fieldOfNumbers[i][j] = "0";
            }
        }

        for (int i = 1; i < fieldOfNumbers.length - 1; i++){
            for (int j = 1; j < fieldOfNumbers.length - 1; j++) {
                flag = false;
                do {
                    rnd = (int)(Math.random() * (sizeField * sizeField)+1);
                    if (!list.contains(rnd)) {
                        list.add(rnd);
                        flag = true;
                        mas[count] = rnd;
                        count ++;
                        fieldOfNumbers[i][j] = String.valueOf(rnd);
                        if (rnd == sizeField * sizeField) {
                            mas[sizeField*sizeField -1] = 0;
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

    public boolean solvabilityCheck() {
        int inversions = 0;

        for (int i = 0; i < sizeField*sizeField; i++) {
            if (mas[i] != 0) {
                for (int j = 0; j < i; j++) {
                    if (mas[j] > mas[i]) {
                        inversions++;
                    }
                }
            }
        }
        for (int i = 0; i < sizeField*sizeField; i++) {
            if (mas[i] == 0) {
                inversions = inversions + 1 + i / sizeField ;
            }
        }
        if (inversions % 2 == 1) {
            return false;
        }
        return true;
    }
}
