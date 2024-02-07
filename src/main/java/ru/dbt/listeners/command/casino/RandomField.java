package ru.dbt.listeners.command.casino;

import org.springframework.stereotype.Component;

@Component
public class RandomField {

    public int[][] createdFieldWithRandomNumbers(int columns, int rows){
        int[][] array = new int[columns][rows];
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                array[i][j] = (int) (Math.random()*5) + 1;
            }
        }
        return array;
    }
}
