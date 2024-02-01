package com.example.discordbot1.listeners.command;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.Map;

public class CommandContainer {
    private final Map<String, Command> map;


    public CommandContainer() {
        map = Map.ofEntries(
                Map.entry("$flip", new Flip()),
                Map.entry("$roll", new Roll())
        );
    }

    public void action(MessageReceivedEvent event) {
         map.getOrDefault(event.getMessage().getContentDisplay(),e -> {})
                .command(event);
    }
}
