package com.example.discordbot1.listeners.command;

import java.util.Random;

public class Flip implements Command{

    @Override
    public String command() {
        Random r = new Random();
        int chance = r.nextInt(2);
        if (chance == 1) {
            return "орёл";
        } else {
            return "решка";
        }
    }
}
