package ru.dbt.listeners.command.casino;

import jakarta.transaction.Transactional;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.springframework.stereotype.Component;
import ru.dbt.dao.UserEntity;
import ru.dbt.dao.UserRepository;
import ru.dbt.listeners.command.Command;
import ru.dbt.listeners.command.casino.calculation.RandomField;
import ru.dbt.listeners.command.casino.calculation.lines.DiagonalCalculator;
import ru.dbt.listeners.command.casino.calculation.lines.HorizontalLinesCalculator;
import ru.dbt.listeners.command.casino.calculation.lines.VerticalLinesCalculator;
import ru.dbt.listeners.command.role.Role;

import java.util.List;

@Component
public class CasinoCommand implements Command {
    private final RandomField randomField;
    private final CreatePictureService pictureService;
    private final DiagonalCalculator diagonalCalculator;
    private final HorizontalLinesCalculator horizontalLinesCalculator;
    private final VerticalLinesCalculator verticalLinesCalculator;
    private final UserRepository userRepository;

    public CasinoCommand(RandomField randomField
            , CreatePictureService pictureService
            , DiagonalCalculator diagonalCalculator
            , HorizontalLinesCalculator horizontalLinesCalculator
            , VerticalLinesCalculator verticalLinesCalculator
            , UserRepository userRepository
    ) {
        this.diagonalCalculator = diagonalCalculator;
        this.horizontalLinesCalculator = horizontalLinesCalculator;
        this.verticalLinesCalculator = verticalLinesCalculator;
        this.randomField = randomField;
        this.pictureService = pictureService;
        this.userRepository = userRepository;
    }


    @Override
    @Transactional
    public void run(MessageReceivedEvent event) {
        int[][] arrayField = randomField.createdFieldWithRandomNumbers(3, 3);

        int winResult = horizontalLinesCalculator.calculatePoint(arrayField)
                + verticalLinesCalculator.calculatePoint(arrayField)
                + diagonalCalculator.calculatePoint(arrayField);

        UserEntity user = userRepository.findById(event.getAuthor().getIdLong()).orElseThrow();

        user.setBalance(user.getBalance() - 10 + winResult);

        event.getChannel().sendFiles(
                pictureService.createPicture(arrayField)).queue();

        event.getChannel().sendMessage("Ваш вы́игрыш: " + winResult + " Ваш баланс: " + user.getBalance()).queue();
    }


    @Override
    public String getKey() {
        return "casino";
    }

    @Override
    public String description() {
        return "Запускает однорукого бандита.";
    }

    @Override
    public List<Role> getRoles() {
        return List.of(Role.ADMIN, Role.VIP, Role.ORDINARY);
    }
}
