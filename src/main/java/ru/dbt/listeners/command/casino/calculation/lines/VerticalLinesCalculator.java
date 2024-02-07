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
        for (int i = 0, j = 0; i < array.length-1;j++) {
            for ( ;j < array[i].length-1; i++) {
                if (array[0][j] != array[i][j]) {
                    break;
                }
            }
            rez += array[i][i];
        }
        return nominalPicture.convertNominal(rez);

    }
}
