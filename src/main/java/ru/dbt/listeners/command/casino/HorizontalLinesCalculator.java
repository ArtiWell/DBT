package ru.dbt.listeners.command.casino;

public class HorizontalLinesCalculator implements CalculateWinPoint{

    @Override
    public int calculatePoint(int[][] array) {
        int rez = 0;
        for (int[] ints : array) {
            for (int anInt : ints) {
                if (anInt != ints[0]) {
                    break;
                }
            }
            rez+=ints[0];
        }
        return rez;
    }
}
