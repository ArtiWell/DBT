package ru.dbt.listeners.command.casino.calculation.lines;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.dbt.listeners.command.casino.calculation.CalculateWinPoint;
import ru.dbt.listeners.command.casino.calculation.NominalPicture;

@AllArgsConstructor
@Component
public class VerticalLinesCalculator implements CalculateWinPoint {
    private final NominalPicture nominalPicture;

    @Override
    public int calculatePoint(int[][] array) {
        int rez = 0;
        int i = 0;
        int j = 0;
        for (; j < array[i].length; j++) {
            boolean win = true;
            for (; i < array.length; i++) {
                if (array[0][j] != array[i][j]) {
                    win=false;
                    break;
                }
            }
            i=0;
            if (win)
            rez += nominalPicture.convertNominal(array[0][j]);
        }
        return rez;

    }
}
