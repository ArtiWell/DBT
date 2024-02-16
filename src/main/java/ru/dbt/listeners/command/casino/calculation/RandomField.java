package ru.dbt.listeners.command.casino.calculation;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RandomField {

    public int[][] createdFieldWithRandomNumbers(int columns, int rows) {
        int[][] array = new int[columns][rows];
        List<Integer> list = List.of(1,1,1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,3,3,3,3,3,3,4,4,4,4,5,5);
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                array[i][j] = list.get((int) (Math.random() * 30));
            }
        }
        return array;
    }
}
