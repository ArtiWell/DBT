package com.example.discordbot1.listeners.command;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public interface Command {
    void command(MessageReceivedEvent event);
}
