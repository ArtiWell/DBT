package ru.dbt.listeners;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.dbt.listeners.command.Command;

import java.util.Map;

@Component
public class Listener extends ListenerAdapter {

    private final Map<String, Command> commands;
    private final String prefix;

    public Listener(@Qualifier("commands") Map<String, Command> commands,
                    @Value("${bot.prefix}") String prefix
    ) {
        this.commands = commands;
        this.prefix = prefix;
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot())
            return;
        var contentDisplay = event.getMessage().getContentDisplay();
        var commandName = contentDisplay.substring(prefix.length());
        if (contentDisplay.startsWith(prefix) && commands.containsKey(commandName)) {
            commands.get(commandName).run(event);
        }
    }
}
