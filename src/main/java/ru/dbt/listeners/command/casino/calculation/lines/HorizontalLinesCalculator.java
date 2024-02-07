package ru.dbt.listeners.command.casino.calculation.lines;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.dbt.listeners.command.casino.calculation.CalculateWinPoint;
import ru.dbt.listeners.command.casino.calculation.NominalPicture;

@AllArgsConstructor
@Component
public class HorizontalLinesCalculator implements CalculateWinPoint {
    private final NominalPicture nominalPicture;

    @Override
    public int calculatePoint(int[][] array) {
        int rez = 0;

        for (int[] ints : array) {
            boolean win = true;
            for (int anInt : ints) {
                if (anInt != ints[0]) {
                    win = false;
                    break;
                }
            }
            if (win) {
                rez += nominalPicture.convertNominal(ints[0]);
            }
        }
        return rez;
    }
}
