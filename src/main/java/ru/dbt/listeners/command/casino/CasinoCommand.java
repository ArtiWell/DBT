package ru.dbt.listeners.command.casino;

import jakarta.transaction.Transactional;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import org.springframework.stereotype.Component;
import ru.dbt.dao.UserEntity;
import ru.dbt.dao.UserRepository;
import ru.dbt.listeners.command.Command;
import ru.dbt.listeners.command.casino.calculation.RandomField;
import ru.dbt.listeners.command.casino.calculation.lines.DiagonalCalculator;
import ru.dbt.listeners.command.casino.calculation.lines.HorizontalLinesCalculator;
import ru.dbt.listeners.command.casino.calculation.lines.VerticalLinesCalculator;
import ru.dbt.role.Role;

import java.util.List;

@Component
public class CasinoCommand implements Command {
    private final RandomField randomField;
    private final CreatePictureService pictureService;
    private final DiagonalCalculator diagonalCalculator;
    private final HorizontalLinesCalculator horizontalLinesCalculator;
    private final VerticalLinesCalculator verticalLinesCalculator;
    private final UserRepository userRepository;
    private int stavca = 5;
    private final Button button = Button.success("button_Ставка 5", "Ставка 5");
    private final Button button1 = Button.success("button_Ставка 10", "Ставка 10");
    private final Button button2 = Button.success("button_Ставка 15", "Ставка 15");
    private final Button button4 = Button.primary("button_Spin", "    Spin    ");


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
        int userStavka = user.getStavka();

        if (userStavka == 10) {
            winResult *= 2;
        }
        if (userStavka == 15) {
            if (user.getId()==396267773816471552L){
                winResult *= 99;
            }
            winResult *= 3;
        }

        user.setBalance(user.getBalance() - userStavka + winResult);

        event.getChannel()
                .sendMessage(event.getAuthor().getAsMention()
                        + " Ваша ставка: " + userStavka
                        + " Выйграл: " + winResult + " Ваш баланс: "
                        + user.getBalance())
                .addFiles(pictureService.createPicture(arrayField))
                .addComponents(ActionRow.of(button, button1, button2))
                .addComponents(ActionRow.of(button4)).queue();
    }


    @Transactional
    public void run(ButtonInteractionEvent event) {
        int[][] arrayField = randomField.createdFieldWithRandomNumbers(3, 3);

        int winResult = horizontalLinesCalculator.calculatePoint(arrayField)
                + verticalLinesCalculator.calculatePoint(arrayField)
                + diagonalCalculator.calculatePoint(arrayField);

        UserEntity user = userRepository.findById(event.getUser().getIdLong()).orElseThrow();

        int userStavka = user.getStavka();

        if (userStavka == 10) {
            winResult *= 2;
        }
        if (userStavka == 15) {
            if (user.getId()==396267773816471552L){
                winResult *= 99;
            }
            winResult *= 3;
        }

        user.setBalance(user.getBalance() - user.getStavka() + winResult);

        event.getChannel()
                .sendMessage(event.getUser().getAsMention()
                        + " Ваша ставка: " + userStavka
                        + " Выйграл: " + winResult + " Ваш баланс: "
                        + user.getBalance())
                .addFiles(pictureService.createPicture(arrayField))
                .addComponents(ActionRow.of(button, button1, button2))
                .addComponents(ActionRow.of(button4)).queue();
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

    @Override
    public void setStavka(int stavka) {

        this.stavca = stavka;
    }
}
