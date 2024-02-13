package ru.dbt.listeners.command;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.springframework.stereotype.Component;
import ru.dbt.role.Role;

import java.util.List;

@Component
public class FlipCommand implements Command {

    @Override
    public void run(MessageReceivedEvent event) {
        int chance = (int) (Math.random() * 2);
        String asMention = event.getAuthor().getAsMention();
        if (chance == 1) {
            asMention += "\nорёл";
        } else {
            asMention += "\nрешка";
        }
        event.getChannel().sendMessage(event.getAuthor().getId()).queue();
    }

    @Override
    public String getKey() {
        return "flip";
    }

    @Override
    public String description() {
        return "Подбрасывает монетку.";
    }

    @Override
    public List<Role> getRoles() {
        return List.of(Role.ADMIN, Role.VIP, Role.ORDINARY);
    }
}
