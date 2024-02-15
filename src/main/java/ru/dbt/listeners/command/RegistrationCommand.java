package ru.dbt.listeners.command;

import lombok.AllArgsConstructor;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.springframework.stereotype.Component;
import ru.dbt.dao.UserEntity;
import ru.dbt.dao.UserRepository;
import ru.dbt.role.Role;

import java.awt.*;
import java.util.List;


@Component
@AllArgsConstructor
public class RegistrationCommand implements Command {
    private final UserRepository userRepository;

    @Override
    public void run(MessageReceivedEvent event) {
        EmbedBuilder author = new EmbedBuilder()
                .setColor(Color.MAGENTA)
                .setDescription("Пользователь "
                        + event.getAuthor().getAsMention()
                        + " зарегистрирован.")
                .setImage("https://avatars.mds.yandex.net/i?id=2838ddef5e32193cd83337c5c939c7bd-5232914-images-thumbs&n=13");


        Long id = event.getAuthor().getIdLong();
        UserEntity user = new UserEntity(id, Role.ORDINARY, 1000, 5);

        if (userRepository.findById(id).isEmpty()) {
            userRepository.save(user);
            event.getChannel().sendMessageEmbeds(author.build()).queue();
        }else {
            event.getChannel().sendMessage("Такой пользователь уже есть.").queue();
        }
    }

    @Override
    public String getKey() {
        return "reg";
    }

    @Override
    public String description() {
        return "Регистрирует пользовотеля";
    }

    @Override
    public List<Role> getRoles() {
        return List.of();
    }

    @Override
    public void setStavka(int stavka) {

    }
}
