package ru.dbt.listeners.command;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public class HelpCommand implements Command{
    private final List<Command> listCommand;
    @Value("${bot.prefix}")
    private final String prefix;

    public HelpCommand(List<Command> listCommand,@Value("${bot.prefix}") String prefix
    ) {
        this.listCommand = listCommand;
        this.prefix = prefix;
    }

    @Override
    public void run(MessageReceivedEvent event) {
        List<String> listStr = listCommand.stream().map(m -> prefix + m.getKey() + " - " + m.description()).toList();
        event.getChannel().sendMessage(String.join("\n", listStr)).queue();
    }

    @Override
    public String getKey() {
        return "help";
    }

    @Override
    public String description() {
        return "$help выводит все комманды и описание этих команд.";
    }
}
