package ru.dbt.listeners.command;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public interface Command {

    void run(MessageReceivedEvent event);

    String getKey();

    String description();

    Boolean checkRole();
    }
}
