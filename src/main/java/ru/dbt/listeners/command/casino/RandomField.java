package ru.dbt.listeners.command.casino;

import org.springframework.stereotype.Component;

@Component
public class RandomField {


    public int[][] randomArray(int a, int b){
        int[][] array = new int[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                array[i][j] = (int) (Math.random()*5);
            }
        }
        return array;
    }
}
