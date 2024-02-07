package ru.dbt.listeners.command.casino.calculation.lines;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.dbt.listeners.command.casino.calculation.NominalPicture;


@ExtendWith(MockitoExtension.class)
class HorizontalLinesCalculatorTest {

    @Mock
    private NominalPicture nominalPicture;
    @InjectMocks
    private HorizontalLinesCalculator horizontalLinesCalculator;

    @Test
    void calculatePoint() {
        int[][] array = new int[3][3];
        array[0][0] = 1;
        array[0][1] = 1;
        array[0][2] = 1;
        array[1][0] = 2;
        array[1][1] = 2;
        array[1][2] = 2;
        array[2][0] = 1;
        array[2][1] = 4;
        array[2][2] = 5;
        Mockito.when(nominalPicture.convertNominal(1)).thenReturn(5);
        Mockito.when(nominalPicture.convertNominal(2)).thenReturn(10);
        Assertions.assertEquals(horizontalLinesCalculator.calculatePoint(array),15);
    }
}