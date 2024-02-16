package ru.dbt.listeners;

import jakarta.validation.constraints.NotNull;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.dbt.dao.UserEntity;
import ru.dbt.dao.UserRepository;
import ru.dbt.listeners.command.Command;
import ru.dbt.listeners.command.casino.CasinoCommand;
import ru.dbt.role.CheckRole;

import java.util.Map;

@Component
public class Listener extends ListenerAdapter {
    private final CheckRole checkRole;
    private final Map<String, Command> commands;
    private final String prefix;
    private final UserRepository userRepository;


    public Listener(@Qualifier("commands") Map<String, Command> commands,
                    @Value("${bot.prefix}") String prefix
            , CheckRole checkRole
            , UserRepository userRepository) {
        this.checkRole = checkRole;
        this.commands = commands;
        this.prefix = prefix;
        this.userRepository = userRepository;
    }

    @Override
    public void onMessageReceived(@org.jetbrains.annotations.NotNull MessageReceivedEvent event) {
        User author = event.getAuthor();

        if (author.isBot()) {
            return;
        }

        var contentDisplay = event.getMessage().getContentDisplay();
        var commandName = contentDisplay.substring(prefix.length());

        if (contentDisplay.startsWith(prefix) && commands.containsKey(commandName)) {
            checkRole.checkRole(author.getIdLong(), commands.get(commandName));
            commands.get(commandName).run(event);
        }
    }

    @Override
    public void onButtonInteraction(@NotNull ButtonInteractionEvent event) {
        UserEntity user = userRepository.findById(event.getUser().getIdLong()).orElseThrow();
        if (event.getButton().getId().equals("button_Ставка 5")) {
            user.setStavka(5);
            userRepository.save(user);
            //подтверждение что кнопка нажата
            event.deferEdit().queue();
        }
        if (event.getButton().getId().equals("button_Ставка 10")) {
            user.setStavka(10);
            userRepository.save(user);
            //подтверждение что кнопка нажата
            event.deferEdit().queue();
        }
        if (event.getButton().getId().equals("button_Ставка 15")) {
            user.setStavka(15);
            userRepository.save(user);
            //подтверждение что кнопка нажата
            event.deferEdit().queue();
        }
        if (event.getButton().getId().equals("button_Spin")) {
            ((CasinoCommand) commands.get("casino")).run(event);
            //подтверждение что кнопка нажата
            event.deferEdit().queue();
        }
    }

}
