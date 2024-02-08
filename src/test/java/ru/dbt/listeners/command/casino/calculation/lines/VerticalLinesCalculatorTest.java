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
class VerticalLinesCalculatorTest {

    @Mock
    private NominalPicture nominalPicture;
    @InjectMocks
    private VerticalLinesCalculator verticalLinesCalculator;

    @Test
    void calculatePoint() {
        int[][] array = new int[3][3];
        array[0][0] = 3;
        array[0][1] = 2;
        array[0][2] = 2;
        array[1][0] = 3;
        array[1][1] = 2;
        array[1][2] = 2;
        array[2][0] = 3;
        array[2][1] = 2;
        array[2][2] = 1;
        Mockito.when(nominalPicture.convertNominal(3)).thenReturn(25);
        Mockito.when(nominalPicture.convertNominal(2)).thenReturn(10);
        Assertions.assertEquals(verticalLinesCalculator.calculatePoint(array),35);
    }
}