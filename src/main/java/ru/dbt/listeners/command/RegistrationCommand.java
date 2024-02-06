package ru.dbt.listeners.command;

import lombok.AllArgsConstructor;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.springframework.stereotype.Component;
import ru.dbt.dao.UserEntity;
import ru.dbt.dao.UserRepository;
import ru.dbt.listeners.command.role.Role;

import java.util.List;

@Component
@AllArgsConstructor
public class RegistrationCommand implements Command{
    private final UserRepository userRepository;




    @Override
    public void run(MessageReceivedEvent event) {
       Long id = event.getAuthor().getIdLong();
       UserEntity user = new UserEntity(id,Role.ORDINARY);
       userRepository.save(user);
       if (userRepository.findById(id).isPresent()) {
           event.getChannel().sendMessage("Пользователь зарегистрирован.").queue();
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
}
