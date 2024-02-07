package ru.dbt.listeners.command.casino.calculation;

import org.springframework.stereotype.Component;

@Component
public class NominalPicture {
    public int convertNominal(int point) {

        return switch (point) {
                  case 1 -> 5;
                  case 2 -> 10;
                  case 3 -> 25;
                  case 4 -> 50;
                  case 5 -> 100;
                  default -> 0;
        };
    }
}
