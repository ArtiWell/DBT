package ru.dbt.listeners.command.casino;


public class VerticalLinesCalculator implements CalculateWinPoint {
    @Override
    public int calculatePoint(int[][] array) {
        int rez = 0;
        int i = 0;
        int j = 0;
        for (; i < array.length; j++) {
            for (; j < array[i].length; i++) {
                if (array[0][j]!=array[i][j]){
                    break;
                }
            }
            rez+=array[0][j];
        }
        return rez;

    }
}
