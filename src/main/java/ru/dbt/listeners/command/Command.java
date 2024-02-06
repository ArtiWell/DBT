package ru.dbt.listeners.command;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import ru.dbt.listeners.command.role.Role;

import java.util.List;

public interface Command {

    void run(MessageReceivedEvent event);

    String getKey();

    String description();

    List<Role> getRoles();

}
