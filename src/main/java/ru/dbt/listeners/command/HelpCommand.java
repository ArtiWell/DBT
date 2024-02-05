package ru.dbt.listeners.command;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.List;

import static java.util.stream.Collectors.joining;

@Component
public class HelpCommand implements Command {
    private final List<Command> listCommand;
    @Value("${bot.prefix}")
    private final String prefix;

    public HelpCommand(List<Command> listCommand, @Value("${bot.prefix}") String prefix
    ) {
        this.listCommand = listCommand;
        this.prefix = prefix;
    }

    @Override
    public void run(MessageReceivedEvent event) {
        EmbedBuilder header = new EmbedBuilder();
        header.setColor(Color.pink);
        header.setAuthor("RoyalBoeing & CO");
        header.setTitle("Команды бота :gear:");
//        header.addField(new MessageEmbed.Field("\u200b", "\u200b", false));
        header.setDescription(
                listCommand.stream()
                        .map(m -> "**" + prefix + m.getKey() + "** " + m.description())
                        .collect(joining("\n"))
        );
        event.getChannel().sendMessageEmbeds(header.build()).queue();
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
