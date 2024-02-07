package ru.dbt.listeners.command.casino.calculation.lines;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.dbt.listeners.command.casino.calculation.CalculateWinPoint;
import ru.dbt.listeners.command.casino.calculation.NominalPicture;

@AllArgsConstructor
@Component
public class DiagonalCalculator implements CalculateWinPoint {
    private final NominalPicture nominalPicture;

    @Override
    public int calculatePoint(int[][] array) {
        if (array.length != array[0].length) {
            return 0;
        }
        int resX = 1;
        int resY = 1;


        for (int i = 1, j = 1; j < array.length; j++, i++) {
            if (array[0][0] != array[i][j]) {
                resX = 0;
                break;
            }
        }

        for (int i = array.length - 1, j = array.length - 1; j >= 0; j--, i--) {
            if (array[array.length - 1][array.length - 1] != array[i - 1][j - 1]) {
                resY = 0;
                break;
            }
        }

        if (resX == 1)
            resY = array[0][0];
        if (resY == 1)
            resX = array[array.length - 1][array.length - 1];


        return nominalPicture.convertNominal(resX) +nominalPicture.convertNominal(resY);
    }
}
