package ru.dbt.listeners.command;


import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.springframework.stereotype.Component;

@Component
public class RollCommand implements Command {


    @Override
    public void run(MessageReceivedEvent event) {
         event.getChannel().sendMessage(event.getAuthor().getAsMention()
                + "\n"
                + (int)(Math.random()*100)).queue();
    }

    @Override
    public String getKey() {
        return "roll";
    }
}