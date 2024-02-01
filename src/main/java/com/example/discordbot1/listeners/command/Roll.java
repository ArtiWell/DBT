package com.example.discordbot1.listeners.command;


import java.util.Random;

public class Roll implements Command {


    @Override
    public String command() {
        return String.valueOf(new Random().nextInt(100) + 1);
    }
}