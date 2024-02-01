package com.example.discordbot1.listeners;

import com.example.discordbot1.listeners.command.CommandContainer;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Listener extends ListenerAdapter {
    private final CommandContainer commandContainer = new CommandContainer();

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String message = event.getMessage().getContentDisplay();
        if (event.getAuthor().isBot())
            return;
        if (message.startsWith("$"))
            commandContainer.action(event);
    }
}
