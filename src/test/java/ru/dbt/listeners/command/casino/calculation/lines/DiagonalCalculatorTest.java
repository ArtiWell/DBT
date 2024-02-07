package ru.dbt.listeners.command.casino.calculation.lines;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.dbt.listeners.command.casino.calculation.NominalPicture;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DiagonalCalculatorTest {

    @Mock
    private NominalPicture nominalPicture;
    @InjectMocks
    private DiagonalCalculator diagonalCalculator;

    @Test
    void calculatePoint() {
        int[][] array = new int[3][3];
        array[0][0] = 1;
        array[0][1] = 1;
        array[0][2] = 3;
        array[1][0] = 1;
        array[1][1] = 3;
        array[1][2] = 2;
        array[2][0] = 3;
        array[2][1] = 4;
        array[2][2] = 3;
        Mockito.when(nominalPicture.convertNominal(3)).thenReturn(25);
        Mockito.when(nominalPicture.convertNominal(0)).thenReturn(0);
        Assertions.assertEquals(diagonalCalculator.calculatePoint(array),25);
    }
}