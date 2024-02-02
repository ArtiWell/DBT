package ru.dbt.configuration;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.dbt.listeners.Listener;
import ru.dbt.listeners.command.Command;

import java.util.EnumSet;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

@Configuration
public class BeansConfiguration {

    @Bean
    public JDA getJDABean(Listener listener, @Value(value = "${bot.token}") String token) {
        return JDABuilder.createLight(token).addEventListeners(listener)
                .enableIntents(EnumSet.allOf(GatewayIntent.class).stream().toList())
                .setStatus(OnlineStatus.ONLINE)
                .setActivity(Activity.watching("Pron"))
                .build();
    }

    @Bean(name = "commands")
    public Map<String, Command> getCommands(List<Command> commands) {
        return commands.stream()
                .collect(toMap(Command::getKey, c -> c));
    }

}
