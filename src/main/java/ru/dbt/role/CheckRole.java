package ru.dbt.role;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.dbt.dao.UserRepository;
import ru.dbt.listeners.command.Command;


@Component
@AllArgsConstructor
public class CheckRole {
    private final UserRepository userRepository;


    public void checkRole(Long userId, Command command) {
        if (command.getRoles().isEmpty()) {
            return;
        }
        if (!command.getRoles().contains(userRepository.findById(userId).orElseThrow().getRole())){
            throw new RuntimeException();
        }
    }
}
