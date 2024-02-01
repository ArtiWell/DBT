package com.example.discordbot1.listeners.command;

import java.util.Map;

public class CommandContainer {
    Map<String, String> map;


    public CommandContainer() {
        map = Map.ofEntries(
                Map.entry("$flip", new Flip().command()),
                Map.entry("$roll", new Roll().command())
        );
    }

    public String action(String command) {
        return map.getOrDefault(command,"Неверная команда.");
    }
}
