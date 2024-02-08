package ru.dbt.listeners.command;


import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.springframework.stereotype.Component;
import ru.dbt.listeners.command.role.Role;

import java.util.List;

@Component
public class RollCommand implements Command {


    @Override
    public void run(MessageReceivedEvent event) {
         event.getChannel().sendMessage(event.getAuthor().getAsMention()
                + "\n"
                + (int)(Math.random()*100+1)).queue();
    }

    @Override
    public String getKey() {
        return "roll";
    }

    @Override
    public String description() {
        return "Выдаёт случайное число от 1 до 100.";
    }

    @Override
    public List<Role> getRoles() {
        return List.of(Role.ADMIN, Role.VIP, Role.ORDINARY);
    }

}